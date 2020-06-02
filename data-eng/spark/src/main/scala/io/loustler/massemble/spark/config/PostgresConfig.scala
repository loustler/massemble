package io.loustler.massemble.spark.config

import java.util.Properties

import com.typesafe.config.Config
import pureconfig.ConfigSource
import pureconfig.generic.auto._

final case class PostgresConfig(
  host: String,
  port: Int,
  db: String,
  username: String,
  password: String
) {
  def url = s"jdbc:postgresql://$host:$port/$db"

  def properties: Properties = {
    val prop = new Properties()

    prop.setProperty("user", username)
    prop.setProperty("password", password)
    prop.setProperty("Driver", "org.postgresql.Driver")

    prop
  }
}

object PostgresConfig {

  def unsafeLoad(config: Config): PostgresConfig =
    ConfigSource.fromConfig(config).at("postgres").loadOrThrow[PostgresConfig]
}
