package io.loustler.massemble.spark.dataset.rdb

import io.loustler.massemble.spark.builder.SparkSessionBuilder
import io.loustler.massemble.spark.config.{ PostgresConfig, loadConfig }
import io.loustler.massemble.spark.dataset.model.ElectricChargepoints2017

object PostgresDataset {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("PostgresDataset")
      .getOrCreate()

    val config = loadConfig

    val postgresConfig = PostgresConfig.unsafeLoad(config)

    val table = "eletric_chargepoints_2017"

    val dataset = spark.read
      .jdbc(
        url = postgresConfig.url,
        table = table,
        properties = postgresConfig.properties
      )
      .as[ElectricChargepoints2017]
      .cache()

    // See execution plan
    dataset.explain()

    dataset.show(numRows = 1000)

//    dataset.groupBy(dataset.apply(""))

    dataset.unpersist()
  }
}
