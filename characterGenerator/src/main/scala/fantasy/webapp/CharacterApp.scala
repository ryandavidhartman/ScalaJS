package fantasy.webapp

import fantasy.Roller.getSixScores
import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.JSExportTopLevel

object CharacterApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  // DOM Objects
  val str_select = document.getElementById("character_strength_select").asInstanceOf[html.Select]
  val dex_select = document.getElementById("character_dexterity_select").asInstanceOf[html.Select]
  val con_select = document.getElementById("character_constitution_select").asInstanceOf[html.Select]
  val int_select = document.getElementById("character_intelligence_select").asInstanceOf[html.Select]
  val wis_select = document.getElementById("character_wisdom_select").asInstanceOf[html.Select]
  val chr_select = document.getElementById("character_charisma_select").asInstanceOf[html.Select]

  val character_select =  document.getElementById("character_class_select").asInstanceOf[html.Select]
  val rollButton = document.getElementById("roll_ability_scores").asInstanceOf[html.Button]

  def setupUI(): Unit = {
    rollButton.addEventListener("click", { (e: dom.MouseEvent) =>
      getRandomAbilityScores()
    })
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("addRollHandler")
  def getRandomAbilityScores(): Unit = {
    val scores = getSixScores()

    val attributes: Seq[html.Select] = character_select.value match {
      case "Cleric" => Seq(wis_select, str_select, con_select, int_select,  chr_select, dex_select)
      case "Fighter" => Seq(str_select, con_select, dex_select, chr_select,  wis_select, int_select)
      case "Thief" =>   Seq(dex_select, chr_select, con_select, str_select,  int_select, wis_select)
      case "Magic-User" => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case "Fighter/Magic-User" =>  Seq(int_select, str_select, con_select, dex_select, wis_select, chr_select)
      case "Magic-User/Thief" => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
    }
    
    (0 to 5).foreach(i => attributes(i).selectedIndex = scores(i))
  }
}
