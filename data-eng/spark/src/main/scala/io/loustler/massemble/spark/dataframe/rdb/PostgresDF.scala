package io.loustler.massemble.spark.dataframe.rdb

import io.loustler.massemble.spark.builder.SparkSessionBuilder
import io.loustler.massemble.spark.config._
import org.apache.spark.sql.functions.{ avg, max, round }

object PostgresDF {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("PostgresDF")
      .getOrCreate()

    val config = loadConfig

    val postgresConfig = PostgresConfig.unsafeLoad(config)

    val table = "eletric_chargepoints_2017"

    val df = spark.read
      .jdbc(
        url = postgresConfig.url,
        table = table,
        properties = postgresConfig.properties
      )
      .persist()

    df.explain()

    val aggDf = df
      .groupBy(df.apply("chargepoint_id"))
      .agg(
        round(max(df("plugin_duration"))).alias("max_duration"),
        round(avg(df.apply("plugin_duration"))).alias("avg_duration")
      )

    aggDf.show(numRows = 1000)

    aggDf.unpersist()
  }
}
