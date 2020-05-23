package io.loustler.massemble.spark.csv

import io.loustler.massemble.spark.builder.SparkContextBuilder

object ElectricChargePoints2017CsvSC {

  def main(args: Array[String]): Unit = {
    val sc = SparkContextBuilder.default("ElectricChargePoints2017CsvSC")

    sc.textFile("")
  }
}
