name := "flinkExampleApp"

version := "0.1"

scalaVersion := "2.11.6"

val flinkVersion = "1.6.0"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "confluent" at "http://packages.confluent.io/maven/"

val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
  //"org.apache.flink" %% "flink-connector-filesystem" % flinkVersion % "provided",
  //"org.apache.flink" %% "flink-clients" % flinkVersion % "provided"
)

//libraryDependencies += "org.apache.flink" %% "flink-connector-kafka-0.11" % flinkVersion
//libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "3.3.0"
//libraryDependencies += "org.apache.kafka" %% "kafka" % "0.11.0.2"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
//libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
//libraryDependencies += "org.mockito" % "mockito-core" % "1.9.5" % "test"
//libraryDependencies += "io.flinkspector" % "flinkspector-datastream_2.11"  % "0.8.3" % "test"
//libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3" % "test"

//libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "1.8.1"

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= flinkDependencies
  )

mainClass in assembly := Some("main.scala.AppMain")


// make run command include the provided dependencies
run in Compile := Defaults.runTask(fullClasspath in Compile,
  mainClass in(Compile, run),
  runner in(Compile, run)
).evaluated

// exclude Scala library from assembly
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

