package io.loustler.massemble.spark.dataset.model

import org.apache.spark.sql.{ Encoder, Encoders }

final case class ElectricChargepoints2017(
) extends Serializable

object ElectricChargepoints2017 {

  implicit val SparkEncoderForElectricChargepoints2017: Encoder[ElectricChargepoints2017] =
    Encoders.kryo[ElectricChargepoints2017]
}
