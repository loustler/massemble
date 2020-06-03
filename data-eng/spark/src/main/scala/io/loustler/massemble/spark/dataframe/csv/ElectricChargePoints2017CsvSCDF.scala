package io.loustler.massemble.spark.dataframe.csv

import io.loustler.massemble.spark.builder.SparkContextBuilder

object ElectricChargePoints2017CsvSCDF {

  def main(args: Array[String]): Unit = {
    val sc = SparkContextBuilder.default("ElectricChargePoints2017CsvSCDF")

    sc.textFile("")
  }
}
