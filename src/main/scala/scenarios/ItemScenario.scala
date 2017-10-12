package scenarios

import core.Config
import io.gatling.core.CoreDsl
import io.gatling.core.config.GatlingConfiguration
import io.gatling.http.HttpDsl

object ItemScenario extends CoreDsl with HttpDsl{

  private val itemsEndpoint = Config.baseUrl + "/items"
  val create = exec(http("create item").post(itemsEndpoint).formParam("item", "my item")
    .check(bodyString.saveAs("itemId")))

  val getItems = exec(http("get items").delete(itemsEndpoint + "/${itemId}")
    //.check(bodyString.validate()
  )

  override implicit def configuration: GatlingConfiguration = GatlingConfiguration.load()
}
