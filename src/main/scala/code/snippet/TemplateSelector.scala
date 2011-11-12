package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import scala.util.Random

class TemplateSelector extends StatefulSnippet {

  def dispatch = {
    case "select" => select
  }
    
  def select = {
    "#main [class]" #> someLogicForSelectingTemplate()
  }
  
  /*Demonstrating with random selection */
  def someLogicForSelectingTemplate() = {
    if(Random.nextBoolean()){
      "lift:surround?with=mobile;at=main"
    }else{
      "lift:surround?with=full;at=main"
    }
  }
}