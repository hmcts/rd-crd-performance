package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.{ASBHelper, Environment}
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment._

object OrgRoleMappingScenario {

  val url = "sb://rd-servicebus-perftest.servicebus.windows.net"
  val keyName = "SendAndListenSharedAccessKey"
  //PerfTest
  val keyValue = ""

  private def sasToken(): String = String.valueOf(ASBHelper.getSaSToken(url, keyName, keyValue))

val OrgRoleMappingScenario = scenario("Organisation Role Mapping Scenario")
  .exec(_.setAll(
    ("sasToken",sasToken())
  ))


  .exec(http(requestName="ORM_010_publishCaseworkers")
    .post("/messages")
    .headers(Environment.headers_asb_auth)
    .headers(Environment.headers_json)
    .body(ElFileBody("caseworker_ids.json"))
    .check(status.is(201)))

}