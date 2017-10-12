package simulations

import core.Config
import io.gatling.core.Predef._
import scenarios.ItemScenario


class E2ESimulation extends Simulation{

  val scn = scenario(getClass.getSimpleName).exec(ItemScenario.create)


  setUp(scn.inject(atOnceUsers(Config.nrOfUsers))).maxDuration(Config.maxDurationMinutes)

}
