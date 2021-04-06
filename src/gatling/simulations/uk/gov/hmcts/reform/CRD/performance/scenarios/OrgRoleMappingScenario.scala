package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment._

object OrgRoleMappingScenario {

  private def sasToken(): String = String.valueOf(ASBHelper.getSaSToken(servicebusUrl, keyName, keyValue))

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