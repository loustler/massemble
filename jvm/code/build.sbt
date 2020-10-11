inThisBuild(
  Seq(
    organization := "io.loustler",
    scalaVersion := "2.13.3",
    version := "0.1.0"
  )
)

lazy val commonSetting = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xlint",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  ),
  scalafmtOnCompile := false,
  addDependencyTreePlugin
)

lazy val root = (project in file("."))
  .settings(commonSetting)
  .settings(
    name := "jvm-example",
  )

