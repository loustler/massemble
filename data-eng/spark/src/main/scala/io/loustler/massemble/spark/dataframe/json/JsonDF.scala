package io.loustler.massemble.spark.dataframe.json

import io.loustler.massemble.spark.builder.SparkSessionBuilder

object JsonDF {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("JsonDF")
      .getOrCreate()

    val df = spark.read.json("")
  }
}
