package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment._

object CaseworkerReferenceDataScenario {

  val CaseworkerReferenceScenario = scenario("Caseworker Reference Data Scenario")

/*
  // Uploads caseworkers to CRD database
  .group("CRD_010_UploadCaseworkers") {
    exec(http(requestName = "CRD_010_010_UploadCaseworkers1")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - Mixed 2 new.xlsx")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_020_UploadCaseworkers2")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - Mixed 3 new.xlsx")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_030_UploadCaseworkers3")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - Mixed 4 new.xlsx")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_040_UploadCaseworkers4")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - Mixed 5 new.xlsx")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_050_UploadCaseworkers5")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - Mixed 6 new.xlsx")
      .check(status.is(200)))
  }

  .pause(thinkTime)

  // Uploads role mappings to CRD database
  .group("CRD_020_UploadRoleMappings") {
    exec(http(requestName = "CRD_020_010_UploadRoleMappings")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Service to IDAM Role Mapping-6.xlsx")
      .check(status.is(200)))
  }

  .pause(thinkTime)
*/

  // Fetches caseworkers from CRD database
  .group("CRD_030_FetchCaseworkers") {
    exec(http(requestName = "CRD_030_FetchCaseworkers")
      .post("/refdata/case-worker/users/fetchUsersById")
      .headers(Environment.headers_auth)
      .headers(Environment.headers_json)
      .body(RawFileBody("caseworker_ids.json"))
      .check(status.is(200)))
  }

  .pause(thinkTime)

}
