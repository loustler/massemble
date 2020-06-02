package io.loustler.massemble.spark

import com.typesafe.config.{ Config, ConfigFactory }

package object config {
  def loadConfig: Config = ConfigFactory.load("reference")
}
