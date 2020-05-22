package io.loustler.massemble.spark.builder

import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {

  /**
    * Default local session
    *
    * @return
    * @see [[DefaultMaster]]
    */
  def local: SparkSession.Builder = SparkSession.builder.master(DefaultMaster)
}
