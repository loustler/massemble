inThisBuild(
  Seq(
    organization := "io.loustler",
    crossScalaVersions := Seq("2.12.10", "2.13.2"),
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
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Ypartial-unification"
  ),
  scalafmtOnCompile := false,
  test / fork := true
)

lazy val root = (project in file("."))
  .settings(commonSetting)
  .settings(
    name := "data-structure",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % V.scalaTest % Test
    )
  )
