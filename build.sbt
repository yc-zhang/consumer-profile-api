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

lazy val sangriaDependencies = Seq(
  "org.sangria-graphql" %% "sangria" % "1.4.2",
  "org.sangria-graphql" %% "sangria-circe" % "1.2.1")

lazy val root = (project in file("."))
  .settings(
    name := "consumer-profile-api",
    libraryDependencies ++= sangriaDependencies
  )
