package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import scala.util.Random

class TemplateSelector extends StatefulSnippet {

  def dispatch = {
    case "selector" => selector
  }
    
  def selector = {
    "#main [class]" #> someLogicForSelectingTemplate()
  }
  
  def someLogicForSelectingTemplate() = {
    if(Random.nextBoolean()){
      "lift:surround?with=mobile;at=main"
    }else{
      "lift:surround?with=full;at=main"
    }
  }
}