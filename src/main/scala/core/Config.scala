package core

import com.typesafe.config.ConfigFactory
import scala.concurrent.duration.FiniteDuration

object Config  {
  val config = ConfigFactory.load()
  val baseUrl = config.getString("env.baseUrl")
  val username = config.getString("env.username")
  val password = config.getString("env.password")
  val nrOfUsers = config.getInt("env.nrOfUsers")
  val testClass = sys.props.get("testClass") getOrElse config.getString("env.testClass")
  val maxDurationMinutes = FiniteDuration(config.getInt("env.maxDurationMinutes"), java.util.concurrent.TimeUnit.MINUTES)
}
