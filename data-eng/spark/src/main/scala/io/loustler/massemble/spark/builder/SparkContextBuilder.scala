package io.loustler.massemble.spark.builder

import org.apache.spark.{ SparkConf, SparkContext }

object SparkContextBuilder {

  /**
    *
    *
    * @param appName
    */
  def default(appName: String): SparkContext = {
    val conf = new SparkConf().setMaster(DefaultMaster).setAppName(appName)

    new SparkContext(conf)
  }
}
