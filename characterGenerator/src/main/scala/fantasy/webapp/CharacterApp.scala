package fantasy.webapp

import fantasy.utilities.Roller.getSixScores
import fantasy.utilities.BasicFantasy._
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

  val character_class_select = document.getElementById("character_class_select").asInstanceOf[html.Select]
  val character_level_select = document.getElementById("character_level_select").asInstanceOf[html.Select]
  val rollButton = document.getElementById("roll_ability_scores").asInstanceOf[html.Button]
  val updateButton = document.getElementById("update_characteristics").asInstanceOf[html.Button]

  val base_attack_bonus = document.getElementById("base_attack_bonus").asInstanceOf[html.Span]
  val melee_attack_bonus = document.getElementById("melee_attack_bonus").asInstanceOf[html.Span]
  val ranged_attack_bonus = document.getElementById("ranged_attack_bonus").asInstanceOf[html.Span]
  val ac_bonus = document.getElementById("ac_bonus").asInstanceOf[html.Span]
  val hit_points = document.getElementById("hit_points").asInstanceOf[html.Span]

  def setupUI(): Unit = {
    rollButton.addEventListener("click", { (e: dom.MouseEvent) =>
      getRandomAbilityScores()
      updateAllModifiers()
    })

    character_class_select.addEventListener("change", { (e: dom.MouseEvent) =>
      updateAllModifiers()
    })

    character_level_select.addEventListener("change", { (e: dom.MouseEvent) =>
      updateAllModifiers()
    })

  }

  def updateAllModifiers(): Unit = {
    setBaseAttackBonusHandler()
    setMeleeAttackBonusHandler()
    setRangeAttackBonusHandler()
    setACBonusHandler()
    setHitPointsHandler()
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("addRollHandler")
  def getRandomAbilityScores(): Unit = {
    val scores = getSixScores()

    val attributes: Seq[html.Select] = character_class_select.value match {
      case "Cleric" => Seq(wis_select, str_select, con_select, int_select,  chr_select, dex_select)
      case "Fighter" => Seq(str_select, con_select, dex_select, chr_select,  wis_select, int_select)
      case "Thief" =>   Seq(dex_select, chr_select, con_select, str_select,  int_select, wis_select)
      case "Magic-User" => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case "Fighter/Magic-User" =>  Seq(int_select, str_select, con_select, dex_select, wis_select, chr_select)
      case "Magic-User/Thief" => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
    }

    (0 to 5).foreach(i => attributes(i).selectedIndex = scores(i))
  }

  @JSExportTopLevel("setBaseAttackBonusHandler")
  def setBaseAttackBonusHandler(): Unit = {

    val characterClass: String = character_class_select.value
    val level: Int = character_level_select.value.toInt

    base_attack_bonus.textContent = calcBaseAttackModifier(characterClass, level)
  }

  @JSExportTopLevel("setMeleeAttackBonusHandler")
  def setMeleeAttackBonusHandler(): Unit = {

    val strength: Int = str_select.value.toInt
    val baseAttackBonus: Int = base_attack_bonus.textContent.toInt

    melee_attack_bonus.textContent = calcMeleeAttackModifier(strength, baseAttackBonus)
  }

  @JSExportTopLevel("setRangeAttackBonusHandler")
  def setRangeAttackBonusHandler(): Unit = {

    val dexterity: Int = dex_select.value.toInt
    val baseAttackBonus: Int = base_attack_bonus.textContent.toInt

    ranged_attack_bonus.textContent = calcRangeAttackModifier(dexterity, baseAttackBonus)
  }

  @JSExportTopLevel("setACBonusHandler")
  def setACBonusHandler(): Unit = {

    val dexterity: Int = dex_select.value.toInt

    ac_bonus.textContent = calcACModifier(dexterity)
  }

  @JSExportTopLevel("setHitPointsHandler")
  def setHitPointsHandler(): Unit = {

    val constitution: Int = con_select.value.toInt
    val characterClass: String = character_class_select.value
    val level: Int = character_level_select.value.toInt

    hit_points.textContent = calcHitPoints(characterClass, level, constitution).toString
  }

}
