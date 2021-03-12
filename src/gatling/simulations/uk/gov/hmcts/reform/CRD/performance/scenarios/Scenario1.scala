package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment._

object Scenario1 {

  // Posts caseworkers to CRD database
  val Scenario1 = scenario("Scenario 1")
    .exec(http(requestName="CRD_010_UploadFile1")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) (10).xlsx")
      .check(status.is(200)))
    .pause(thinkTime)

    // Posts role mappings to CRD database
    .exec(http(requestName="CRD_020_UploadFile2")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Service to IDAM Role Mapping-2.xlsx")
      .check(status.is(200)))
    .pause(thinkTime)

    // Retrieves caseworkers from CRD database
    .exec(http(requestName="CRD_030_FetchUsers")
      .post("/refdata/case-worker/users/fetchUsersById")
      .headers(Environment.headers_auth)
      .headers(Environment.headers_json)
      .body(RawFileBody("user_ids.json"))
      .check(status.is(200)))
    .pause(thinkTime)

}
