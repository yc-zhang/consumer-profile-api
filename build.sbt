import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val unfilteredVersion = "0.10.0-M4"

lazy val unfilteredDependencies = Seq(
  "ws.unfiltered" %% "unfiltered-filter" % unfilteredVersion,
  "ws.unfiltered" %% "unfiltered-jetty" % unfilteredVersion
)

lazy val root = (project in file("."))
  .settings(
    name := "consumer-profile-api",
    libraryDependencies ++= unfilteredDependencies,
    libraryDependencies += scalaTest % Test
  )
