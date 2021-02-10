package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment

object PostScenario {

  val PostScenario = scenario("PostScenario")
    .exec(http(requestName="CRD_010_UploadFile1")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_1)
      .formUpload("file", "Staff Data Upload Template V1.0.1 (6).xlsx")
      .check(status.is(200)))
    .pause(2)

    .exec(http(requestName="CRD_020_UploadFile2")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_1)
      .formUpload("file", "Service to IDAM Role Mapping-2.xlsx")
      .check(status.is(200)))
    .pause(2)

    .exec(http(requestName="CRD_030_FetchUsers")
      .post("/refdata/case-worker/users/fetchUsersById")
      .headers(Environment.headers_1)
      .headers(Environment.headers_2)
      .body(RawFileBody("user_ids.json"))
      .check(status.is(200)))
    .pause(2)

}
