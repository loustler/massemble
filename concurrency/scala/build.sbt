inThisBuild(
  Seq(
    organization := "io.loustler.massemble",
    scalaVersion := "2.13.3",
  )
)

lazy val settings = Seq(
  scalacOptions ++= Seq(
    "-encoding",
    "UTF-8",
  ),
  scalafmtOnCompile := false,
  Test / run / fork := true,
  addDependencyTreePlugin
)

lazy val concurrency = project
.in(file("concurrency"))
.settings(settings)
.settings(
  name := "massemble-concurrency"
)