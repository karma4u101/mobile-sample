package code
package snippet

import xml._

import com.handinteractive.mobile.UAgentInfo
import net.liftweb._
import http._

object Mobile {

  private def getUAgentInfo = {
    val userAgent:String = S.request.flatMap(_.userAgent).openOr("")
    val accepts:String = S.request.flatMap(_.accepts).openOr("")
    new UAgentInfo(userAgent, accepts)
  }

  def mobile_?(f:(() => Boolean)) = f()

  def mobile(in:NodeSeq):NodeSeq = {
    val info = getUAgentInfo
    if(mobile_?(info.detectMobileLong)) in else NodeSeq.Empty
  }

  def full(in:NodeSeq):NodeSeq = {
    val info = getUAgentInfo
    if(!mobile_?(info.detectMobileLong)) in else NodeSeq.Empty
  }

}
