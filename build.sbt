name := "studyscalasbt"

version := "1.0"

scalaVersion := "2.11.5"

// Repositories
resolvers ++= Seq(
  "fluent-logger Maven Repository" at "http://fluentd.org/maven2/"
)

libraryDependencies ++= Seq(
   "org.scala-lang.modules" %% "scala-xml" %  "1.0.3",
   "com.treasuredata" % "td-logger" % "0.2.2",
   "joda-time" % "joda-time" % "2.7"
 )