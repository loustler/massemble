inThisBuild(
  Seq(
    organization := "io.loustler.massemble",
    scalaVersion := "2.13.1",
  )
)

lazy val settings = Seq(
  scalacOptions ++= Seq(
    "-encoding",
    "UTF-8",
  ),
  scalafmtOnCompile := false,
  Test / run / fork := true
)

lazy val concurrency = project
.in(file("concurrency"))
.settings(settings)
.settings(
  name := "massemble-concurrency"
)