package uk.gov.hmcts.reform.CRD.performance.scenarios.utils

import com.typesafe.config.ConfigFactory

object Environment {

  val env = "perftest"
  val baseURL = "http://rd-caseworker-ref-api-" + env + ".service.core-compute-" + env + ".internal"
  val idamURL = "https://idam-api." + env + ".platform.hmcts.net"
  val idamRedirectURL = "https://rd-location-ref-api-" + env + ".service.core-compute-" + env + ".internal/oauth2redirect"
  val idamClient = "rd-caseworker-ref-api"
  val idamSecret = ""
  val idamScope = "openid profile roles manage-user create-user search-user"
  val idamUsername = "amogh-performance-tester@mailinator.com"
  val idamPassword = "Testing1234"
  val s2sURL = "http://rpe-service-auth-provider-" + env + ".service.core-compute-" + env + ".internal/testing-support"
  val s2sService = "rd_caseworker_ref_api"
  val s2sSecret = ""

  //ASB API
  val asbUrl = "https://rd-servicebus-perftest.servicebus.windows.net/rd-caseworker-topic-perftest"
  val servicebusUrl = "sb://rd-servicebus-perftest.servicebus.windows.net"
  val keyName = "SendAndListenSharedAccessKey"
  val keyValue = ""

  val headers_auth = Map(
   "Authorization" -> "Bearer ${accessToken}",
   "serviceAuthorization" -> "${s2sToken}"
  )

  val headers_asb_auth = Map(
   "Authorization" -> "${sasToken}"
  )

  val headers_json = Map(
    "Content-Type" -> "application/json"
  )

  val thinkTime = 10

}
