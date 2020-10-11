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
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  addDependencyTreePlugin
)

lazy val zio = (project in file("."))
  .settings(commonSetting)
  .settings(
    name := "zio",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % V.zio,
      "dev.zio" %% "zio-stacktracer" % V.zio,
      "dev.zio" %% "zio-streams" % V.zio,
      "dev.zio" %% "zio-nio" % V.`zio-nio`,
      "dev.zio" %% "zio-logging" % V.`zio-logging`,
      "dev.zio" %% "zio-config" % V.`zio-config`,
      "dev.zio" %% "zio-config-typesafe" % V.`zio-config`,
      "dev.zio" %% "zio-config-magnolia" % V.`zio-config`,
      "dev.zio" %% "zio-interop-cats" % V.`zio-interop-cats`,
      "dev.zio" %% "zio-test" % V.zio % Test,
      "dev.zio" %% "zio-test-sbt" % V.zio % Test,
      "dev.zio" %% "zio-test-magnolia" % V.zio % Test,
    )
  )