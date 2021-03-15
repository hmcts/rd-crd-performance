package uk.gov.hmcts.reform.CRD.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.CRD.performance.scenarios.utils.Environment._

object Scenario1 {

  val Scenario1 = scenario("Scenario 1")

  // Uploads caseworkers to CRD database
  .group("CRD_010_UploadCaseworkers") {
    exec(http(requestName = "CRD_010_010_UploadCaseworkers1")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 1-10")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_020_UploadCaseworkers2")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 11-20")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_030_UploadCaseworkers3")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 21-30")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_040_UploadCaseworkers4")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 31-40")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_050_UploadCaseworkers5")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 41-50")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_060_UploadCaseworkers6")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 51-60")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_070_UploadCaseworkers7")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 61-70")
      .check(status.is(200)))

    .exec(http(requestName = "CRD_010_080_UploadCaseworkers8")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Staff Data Upload Template V1.0.2-Amog (1) - 71-80")
      .check(status.is(200)))

  }

  .pause(thinkTime)

  // Uploads role mappings to CRD database
  .group("CRD_020_UploadRoleMappings") {
    exec(http(requestName = "CRD_020_010_UploadRoleMappings")
      .post("/refdata/case-worker/upload-file")
      .headers(Environment.headers_auth)
      .formUpload("file", "Service to IDAM Role Mapping IAC.xlsx")
      .check(status.is(200)))
  }

  .pause(thinkTime)

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
