package io.loustler.massemble.spark

import org.apache.spark.sql.types._

package object csv {
  val ElectricCheckPoint2017Csv = "/data/csv/electric-chargepoints-2017.csv"

  val ElectricCheckPoint2017CsvFullPath = s"${ProjectRoot}${ElectricCheckPoint2017Csv}"

  val ElectricCheckPoint2017CsvSchema: StructType = StructType(
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
}
