package io.loustler.massemble.designpattern.builder

sealed trait GPSNavigator extends Product with Serializable

object GPSNavigator {
  case object INavi     extends GPSNavigator
  case object TMap      extends GPSNavigator
  case object KakaoNavi extends GPSNavigator
  case object NaverMap  extends GPSNavigator
  case object Hyundai   extends GPSNavigator
}
