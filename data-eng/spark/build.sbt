inThisBuild(
  Seq(
    organization := "io.loustler",
    scalaVersion := "2.12.11",
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
  test / fork := true,
  addDependencyTreePlugin
)

lazy val root = (project in file("."))
  .settings(commonSetting)
  .settings(
    name := "spark",
    libraryDependencies ++= Seq(
      "org.scalatest"         %% "scalatest"  % V.scalaTest % Test,
      "org.apache.spark"      %% "spark-core" % V.spark,
      "org.apache.spark"      %% "spark-sql"  % V.spark,
      "com.typesafe"           % "config"     % "1.4.0",
      "com.github.pureconfig" %% "pureconfig" % "0.12.3",
      "org.postgresql"         % "postgresql" % "42.2.12"
    )
  )
