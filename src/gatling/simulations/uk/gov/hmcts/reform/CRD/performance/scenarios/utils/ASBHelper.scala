package uk.gov.hmcts.reform.CRD.performance.scenarios.utils


import javax.crypto.Mac

import javax.crypto.spec.SecretKeySpec

import java.io.InputStream

import java.net.URLEncoder

import java.nio.charset.StandardCharsets

import java.util.Base64

import java.util.List

//remove if not needed
import scala.collection.JavaConversions._

object ASBHelper {

  def getSaSToken(resourceUri: String, keyName: String, key: String): String = {
    val epoch: Long = System.currentTimeMillis() / 1000L
    val week: Int = 60 * 60 * 24 * 7
    val expiry: String = java.lang.Long.toString(epoch + week)
    val stringToSign: String = URLEncoder.encode(resourceUri,
                                                 java.nio.charset.StandardCharsets.UTF_8.toString()) +
        "\n" +
        expiry
    val signature: String = getHmac256(key, stringToSign)
    "SharedAccessSignature sr=" +
      URLEncoder.encode(resourceUri, java.nio.charset.StandardCharsets.UTF_8.toString()) +
      "&sig=" +
      URLEncoder.encode(signature, java.nio.charset.StandardCharsets.UTF_8.toString()) +
      "&se=" +
      expiry +
      "&skn=" +
      keyName
  }

  def getHmac256(key: String, input: String): String = {
    val sha256Hmac: Mac = Mac.getInstance("HmacSHA256")
    val secretKey: SecretKeySpec =
      new SecretKeySpec(key.getBytes, "HmacSHA256")
    sha256Hmac.init(secretKey)
    val encoder: Base64.Encoder = Base64.getEncoder
    new String(
      encoder.encode(
        sha256Hmac.doFinal(input.getBytes(StandardCharsets.UTF_8))))
  }


}