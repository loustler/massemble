package io.loustler.massemble.spark
package dataframe

import io.loustler.massemble.spark.file.{ FileFormat, FilePath }
import org.apache.spark.sql.types._

package object csv {
  val ElectricCheckPoint2017CsvFullPath: String = FilePath.path(FileFormat.CSV, "electric-chargepoints-2017.csv")

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
