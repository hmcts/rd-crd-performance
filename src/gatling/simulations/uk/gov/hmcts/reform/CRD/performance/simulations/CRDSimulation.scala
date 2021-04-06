package uk.gov.hmcts.reform.CRD.performance.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils._
import uk.gov.hmcts.reform.CRD.performance.scenarios._

import scala.concurrent.duration.DurationInt

class CRDSimulation extends Simulation{

  val rampUpDurationMins = 2
  val rampDownDurationMins = 2
  val testDurationMins = 60
  val HourlyTarget:Double = 83
  val RatePerSec = HourlyTarget / 3600

  val httpProtocol = http
    //.proxy(Proxy("proxyout.reform.hmcts.net", 8080).httpsPort(8080))
    .baseUrl(Environment.baseURL)

  val httpProtocolAsb = http
    .baseUrl(Environment.asbUrl)

  val CRDScenario = scenario("CRDScenario").repeat(1)
    {
        exec(IDAMHelper.getIdamToken)
        .exec(S2SHelper.S2SAuthToken)
        .exec(CaseworkerReferenceDataScenario.CaseworkerReferenceScenario)
    }

  val ASBScenario = scenario("ASBScenario").repeat(1)
    {
      exec(OrgRoleMappingScenario.OrgRoleMappingScenario)
    }

  setUp(ASBScenario.inject(rampUsers(10) during(60))).protocols(httpProtocolAsb)
  /*setUp(CRDScenario.inject(rampUsersPerSec(0.00) to (RatePerSec) during (rampUpDurationMins minutes),
    constantUsersPerSec(RatePerSec) during (testDurationMins minutes),
    rampUsersPerSec(RatePerSec) to (0.00) during (rampDownDurationMins minutes)))
  .protocols(httpProtocol)*/

}
