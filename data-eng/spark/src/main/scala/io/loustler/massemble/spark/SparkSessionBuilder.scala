package io.loustler.massemble.spark

import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {
  def local: SparkSession.Builder = SparkSession.builder.master("local[2]")
}
