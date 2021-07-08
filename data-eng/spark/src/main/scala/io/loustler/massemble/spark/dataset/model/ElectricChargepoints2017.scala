package io.loustler.massemble.spark.dataset.model

import java.time.{ LocalDate, LocalTime }

import org.apache.spark.sql.{ Encoder, Encoders }

final case class ElectricChargepoints2017(
  id: String,
  event: Int,
  startDate: LocalDate,
  startTime: LocalTime,
  endDate: LocalDate,
  endTime: LocalTime,
  energy: Float,
  pluginDuration: Double
) extends Serializable

object ElectricChargepoints2017 {

  implicit val SparkEncoderForElectricChargepoints2017: Encoder[ElectricChargepoints2017] =
    Encoders.kryo[ElectricChargepoints2017]
}
