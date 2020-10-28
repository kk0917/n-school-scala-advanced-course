name := "scala-advanced-course"

version := "0.1"

scalaVersion := "2.13.3"

scalacOptions in Global += "-language:experimental.macros"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value