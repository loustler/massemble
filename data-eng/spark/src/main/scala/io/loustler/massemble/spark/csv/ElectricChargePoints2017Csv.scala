package io.loustler.massemble.spark.csv

import io.loustler.massemble.spark.builder.SparkSessionBuilder
import org.apache.spark.sql.functions.{ avg, max, round }
import org.apache.spark.storage.StorageLevel

object ElectricChargePoints2017Csv {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("ElectricChargePoints2017Csv")
      .getOrCreate()

    val df = spark.read
      .option("header", true)
      .schema(ElectricCheckPoint2017CsvSchema)
      .csv(ElectricCheckPoint2017CsvFullPath)
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
