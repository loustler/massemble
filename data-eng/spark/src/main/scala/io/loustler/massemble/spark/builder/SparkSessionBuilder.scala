package io.loustler.massemble.spark.builder

import org.apache.spark.sql.SparkSession

/**
  * SparkSession is driver program and entry point for dataframe and dataset.
  */
object SparkSessionBuilder {

  /**
    * Default local session
    *
    * @return
    * @see [[DefaultMaster]]
    */
  def local: SparkSession.Builder = SparkSession.builder.master(DefaultMaster)
}
