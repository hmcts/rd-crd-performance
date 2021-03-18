package uk.gov.hmcts.reform.CRD.performance.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils._
import uk.gov.hmcts.reform.CRD.performance.scenarios._

class CRDSimulation extends Simulation{

  val httpProtocol = http
    //.proxy(Proxy("proxyout.reform.hmcts.net", 8080).httpsPort(8080))
    .baseUrl(Environment.baseURL)

  val CRDScenario = scenario("CRDScenario").repeat(1)
    {
        exec(IDAMHelper.getIdamToken)
        .exec(S2SHelper.S2SAuthToken)
        .exec(Scenario1.Scenario1)
    }

  setUp(CRDScenario.inject(rampUsers(1) during(10))).protocols(httpProtocol)
  .assertions(global.successfulRequests.percent.is(100))
}
