package uk.gov.hmcts.reform.CRD.performance.scenarios.utils

import com.typesafe.config.ConfigFactory

object Environment {

  val env = "aat"
  val baseURL = "http://rd-caseworker-ref-api-" + env + ".service.core-compute-" + env + ".internal"
  val idamURL = "https://idam-api." + env + ".platform.hmcts.net"
  val idamRedirectURL = "https://rd-location-ref-api-" + env + ".service.core-compute-" + env + ".internal/oauth2redirect"
  val idamClient = "rd-caseworker-ref-api"
  val idamSecret = ConfigFactory.load.getString("auth.clientSecret")
  val idamScope = "openid profile roles manage-user create-user search-user"
  val idamUsername = "CWR-func-test-user-mtest53@justice.gov.uk"
  val idamPassword = "Testing1234"
  val s2sURL = "http://rpe-service-auth-provider-" + env + ".service.core-compute-" + env + ".internal/testing-support"
  val s2sService = "rd_caseworker_ref_api"
  val s2sSecret = ConfigFactory.load.getString("aat_service.pass")

  val headers_1 = Map(
   "Authorization" -> "Bearer ${accessToken}",
   "serviceAuthorization" -> "${s2sToken}"
  )

  val headers_2 = Map(
    "Content-Type" -> "application/json"
  )

  val thinkTime = 10

}
