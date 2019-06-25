ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.yuchen"
ThisBuild / organizationName := "yuchen"

maintainer := "yuchen"

scalastyleFailOnWarning := true
scalastyleFailOnError := true

coverageEnabled := true
coverageMinimum := 100
coverageFailOnMinimum := true
coverageExcludedPackages := "<empty>;Main"

enablePlugins(JavaAppPackaging)
mainClass in Compile := Some("Main")
discoveredMainClasses in Compile := Seq()

val unfilteredVersion = "0.10.0-M4"

lazy val unfilteredDependencies = Seq("filter", "jetty", "specs2")
    .map(c => "ws.unfiltered" %% s"unfiltered-$c" % unfilteredVersion)

lazy val root = (project in file("."))
  .settings(
    name := "consumer-profile-api",
    libraryDependencies ++= unfilteredDependencies
  )
