package io.loustler.massemble.spark.dataframe.json

import io.loustler.massemble.spark.builder.SparkSessionBuilder
import io.loustler.massemble.spark.file.{ FileFormat, FilePath }

object JsonDF {

  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.local
      .appName("JsonDF")
      .getOrCreate()

    val df = spark.read
      .option("multiline", "true")
      .json(FilePath.path(FileFormat.JSON, "dummy.json"))
      .cache()

    df.show()

    df.unpersist()
  }
}
