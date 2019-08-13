publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra :=
  Helpers.generatePomExtra("https://github.com/yamory/sbt-dependency-graph",
                           "scm:git@github.com:yamory/sbt-dependency-graph.git",
                           "jrudolph", "Johannes Rudolph")

useGpg := true
