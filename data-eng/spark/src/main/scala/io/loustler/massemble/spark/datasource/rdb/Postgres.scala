package io.loustler.massemble.spark.datasource.rdb

import io.loustler.massemble.spark.builder.SparkSessionBuilder
import io.loustler.massemble.spark.config._

object Postgres {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("Postgres")
      .getOrCreate()

    val config = loadConfig

    val postgresConfig = PostgresConfig.unsafeLoad(config)

    val table = "eletric_chargepoints_2017"

    spark.read
      .jdbc(
        url = postgresConfig.url,
        table = table,
        properties = postgresConfig.properties
      )
      .show()
  }
}
