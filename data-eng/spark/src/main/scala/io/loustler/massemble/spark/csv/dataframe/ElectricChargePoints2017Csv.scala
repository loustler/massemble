package io.loustler.massemble.spark.csv.dataframe

import io.loustler.massemble.spark.ProjectRoot
import io.loustler.massemble.spark.csv.ElectricCheckPoint2017Csv
import io.loustler.massemble.spark.SparkSessionBuilder
import org.apache.spark.sql.types._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.functions._

object ElectricChargePoints2017Csv {

  object ColumnNames {
    val ChargingEvent = "chargingEvent"

    val CheckPointId = "checkPointId"

    val StartDate = "startDate"

    val StartTime = "startTime"

    val EndDate = "endDate"

    val EndTime = "endTime"

    val Energy = "energy"

    val Duration = "duration"
  }

  def main(args: Array[String]): Unit = {
    val projectRoot = ProjectRoot

    val csvPath = s"${projectRoot}${ElectricCheckPoint2017Csv}"

    val spark = SparkSessionBuilder.local
      .appName("ElectricChargePoints2017")
      .getOrCreate()

    val schema: StructType = StructType(
      Seq(
        StructField(
          name = ColumnNames.ChargingEvent,
          dataType = IntegerType,
          nullable = false,
          metadata = Metadata.empty
        ),
        StructField(
          name = ColumnNames.CheckPointId,
          dataType = StringType,
          nullable = false,
          metadata = Metadata.empty
        ),
        StructField(
          name = ColumnNames.StartDate,
          dataType = DateType,
          nullable = false
        ),
        StructField(
          name = ColumnNames.StartTime,
          dataType = StringType,
          nullable = false
        ),
        StructField(
          name = ColumnNames.EndDate,
          dataType = DateType,
          nullable = false
        ),
        StructField(
          name = ColumnNames.EndTime,
          dataType = StringType,
          nullable = false
        ),
        StructField(
          name = ColumnNames.Energy,
          dataType = FloatType,
          nullable = false
        ),
        StructField(
          name = ColumnNames.Duration,
          dataType = DoubleType,
          nullable = false
        )
      )
    )

    val df = spark.read
      .option("header", true)
      .schema(schema)
      .csv(csvPath)
      .persist(StorageLevel.MEMORY_ONLY)

    df.show()

    val aggDf = df
      .groupBy(df(ColumnNames.CheckPointId).alias("check_point_id"))
      .agg(
        round(max(df(ColumnNames.Duration)), scale = 2).alias("max_duration"),
        round(avg(df(ColumnNames.Duration)), scale = 2).alias("avg_duration")
      )

    aggDf.show(numRows = 1000)

    aggDf.unpersist()
  }
}
