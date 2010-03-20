import sbt._

class Scover(info: ProjectInfo) extends DefaultProject(info) {
  val scalatools = "ScalaTest Repository" at "http://www.scala-tools.org/repo-releases/"

  val junit = "junit" % "junit" % "4.4"
  val scalatest = "org.scalatest" % "scalatest" % "1.0"
  val specs = "org.scala-tools.testing" %  "specs" % "1.4.4"
  val mockito = "org.mockito" % "mockito-core" % "1.7"
}
