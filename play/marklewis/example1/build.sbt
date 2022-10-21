ThisBuild / organization := "com.example"
ThisBuild / version      := "1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .aggregate(server)

lazy val server = (project in file("server")).settings(
  name := """ServerExample""",
  libraryDependencies += guice,
  libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

  // Adds additional packages into Twirl
  //TwirlKeys.templateImports += "com.example.controllers._"

  // Adds additional packages into conf/routes
  // play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
).enablePlugins(PlayScala)



