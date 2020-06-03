package io.loustler.massemble.spark.dataframe.hive

import io.loustler.massemble.spark.builder.{ SparkContextBuilder, SparkSessionBuilder }
import org.apache.spark.sql._

object HiveDF {

  def main(args: Array[String]): Unit = {
    // HiveContext deprecated since 2.0.0
    // Example see https://spark.apache.org/docs/latest/sql-data-sources-hive-tables.html
    val spark = SparkSessionBuilder.local
      .appName("HiveDF")
      .config("spark.sql.warehouse.dir", "spark-warehouse-path")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    spark.sql("SELECT * FROM table").show()
  }
}
