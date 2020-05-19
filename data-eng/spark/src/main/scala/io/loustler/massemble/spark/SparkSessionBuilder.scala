package io.loustler.massemble.spark

import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {

  /**
    * With 2 core in Local
    *
    * @return
    */
  def local: SparkSession.Builder = SparkSession.builder.master("local[2]")
}
