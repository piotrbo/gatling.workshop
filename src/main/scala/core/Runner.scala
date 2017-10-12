package core


import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Runner extends App {

  val props = new GatlingPropertiesBuilder
  props.simulationClass(Config.testClass)
  props.sourcesDirectory("./src/main/scala")
  props.binariesDirectory("./target/scala-2.11/classes")
  props.runDescription("performance tests")
  props.resultsDirectory("build/results")

  Gatling.fromMap(props.build)
}