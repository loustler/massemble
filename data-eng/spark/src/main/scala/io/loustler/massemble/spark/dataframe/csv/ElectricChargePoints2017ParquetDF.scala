package io.loustler.massemble.spark.dataframe.csv

import io.loustler.massemble.spark.ProjectRoot
import io.loustler.massemble.spark.file.FileSize._
import io.loustler.massemble.spark.builder.SparkSessionBuilder
import org.apache.spark.sql.functions.{ avg, max, round }
import org.apache.spark.storage.StorageLevel

object ElectricChargePoints2017ParquetDF {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("ElectricChargePoints2017Parquet")
      .getOrCreate()

    val df = spark.read
      .option("header", true)
      .schema(ElectricCheckPoint2017CsvSchema)
      .csv(ElectricCheckPoint2017CsvFullPath)
      .persist(StorageLevel.MEMORY_ONLY)

    df.show()

    // save as parquet format
    val aggDf = df
      .groupBy(df(ColumnNames.CheckPointId).alias("check_point_id"))
      .agg(
        round(max(df(ColumnNames.Duration)), scale = 2).alias("max_duration"),
        round(avg(df(ColumnNames.Duration)), scale = 2).alias("avg_duration")
      )

    aggDf.show(numRows = 1000)

//    val parquetPathWithDefaultOpt = "/data/parquet/electric_charge_points_2017_parquet_no-opt"

//    aggDf.write.parquet(s"${ProjectRoot}${parquetPathWithDefaultOpt}")

    val parquetWithOpts = "/data/parquet/electric_charge_points_2017_parquet_opt"

    // Option
    // See http://engineering.vcnc.co.kr/2018/05/parquet-and-spark/
    aggDf.write
      .options(
        Map(
          "compression"                  -> "gzip",
          "parquet.enable.dictionary"    -> "true",
          "parquet.block.size"           -> 32.kb.toString,
          "parquet.page.size"            -> 2.kb.toString,
          "parquet.dictionary.page.size" -> 8.kb.toString
        )
      )
      .parquet(s"${ProjectRoot}${parquetWithOpts}")
  }
}
