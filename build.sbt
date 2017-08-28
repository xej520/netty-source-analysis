name := "Scala_Wiki_00000"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
	"maven Repository" at "http://mvnrepository.com/",
	"repo" at "http://repo.typesafe.com/typesafe/releases/",
	"Spray Repository" at "http://repo.spray.io",
	"Spray Nightlies" at "http://nightlies.spray.io/"
)

libraryDependencies ++= {
	val akkaVersion = "2.3.4"
	val sprayVersion = "1.3.1"
	Seq(
		"com.typesafe.akka" %% "akka-actor" % "2.4.17",
		"com.typesafe.akka" %% "akka-slf4j" % "2.4.17",
		"com.typesafe.akka" %% "akka-testkit" % "2.4.17",
		"org.apache.spark" % "spark-core_2.10" % "2.1.0"
	)
}


