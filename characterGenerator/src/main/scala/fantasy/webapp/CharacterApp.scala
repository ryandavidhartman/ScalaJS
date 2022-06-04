package fantasy.webapp

import fantasy.utilities.Roller.getSixScores
import fantasy.utilities.BasicFantasy._
import fantasy.utilities.NameGenerator
import fantasy.webapp.CharacterApp.rollButton
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
  val character_name_input = document.getElementById("character_name_input").asInstanceOf[html.Input]
  val character_gender_select = document.getElementById("character_gender_select").asInstanceOf[html.Select]


  val str_select = document.getElementById("character_strength_select").asInstanceOf[html.Select]
  val dex_select = document.getElementById("character_dexterity_select").asInstanceOf[html.Select]
  val con_select = document.getElementById("character_constitution_select").asInstanceOf[html.Select]
  val int_select = document.getElementById("character_intelligence_select").asInstanceOf[html.Select]
  val wis_select = document.getElementById("character_wisdom_select").asInstanceOf[html.Select]
  val chr_select = document.getElementById("character_charisma_select").asInstanceOf[html.Select]

  val character_race_select = document.getElementById("character_race_select").asInstanceOf[html.Select]
  val character_class_select = document.getElementById("character_class_select").asInstanceOf[html.Select]
  val character_level_select = document.getElementById("character_level_select").asInstanceOf[html.Select]
  val rollButton = document.getElementById("roll_ability_scores").asInstanceOf[html.Button]
  val rollNameButton = document.getElementById("roll_character_name").asInstanceOf[html.Button]

  val base_attack_bonus = document.getElementById("base_attack_bonus").asInstanceOf[html.Span]
  val melee_attack_bonus = document.getElementById("melee_attack_bonus").asInstanceOf[html.Span]
  val ranged_attack_bonus = document.getElementById("ranged_attack_bonus").asInstanceOf[html.Span]
  val ac_bonus = document.getElementById("ac_bonus").asInstanceOf[html.Span]
  val hit_points = document.getElementById("hit_points").asInstanceOf[html.Span]
  val special_abilities = document.getElementById("special_abilities").asInstanceOf[html.Div]

  def setupUI(): Unit = {
    rollButton.addEventListener("click", { (e: dom.MouseEvent) =>
      getRandomAbilityScores()
      updateAllModifiers()
    })

    rollNameButton.addEventListener("click", { (e: dom.MouseEvent) =>
     rollNameHandler()
    })

    character_race_select.addEventListener("change", { (e: dom.MouseEvent) =>
      updateAllModifiers()
      setSpecialAbilities()
    })

    character_class_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkClass()
      updateAllModifiers()
    })

    character_level_select.addEventListener("change", { (e: dom.MouseEvent) =>
      updateAllModifiers()
    })

    str_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxStr()
      setMeleeAttackBonusHandler()
    })

    int_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxInt()
    })

    dex_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxDex()
      setRangeAttackBonusHandler()
      setACBonusHandler()
    })

    con_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxCon()
      setHitPointsHandler()
    })

    chr_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxChr()
    })

  }

  def updateAllModifiers(): Unit = {
    checkClass()
    checkMaxStr()
    checkMaxDex()
    checkMaxCon()
    checkMaxInt()
    checkMaxChr()
    setBaseAttackBonusHandler()
    setMeleeAttackBonusHandler()
    setRangeAttackBonusHandler()
    setACBonusHandler()
    setHitPointsHandler()
    setSpecialAbilities()
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("rollNameHandler")
  def rollNameHandler(): Unit = {
    val race: String = character_race_select.value
    val gender: String = character_gender_select.value

    val characterName = NameGenerator.getName(race, gender)
    character_name_input.value = characterName
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
    checkMaxStr()
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
    val race: String = character_race_select.value

    ranged_attack_bonus.textContent = calcRangeAttackModifier(dexterity, baseAttackBonus, race)
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

  @JSExportTopLevel("setSpecialAbilities")
  def setSpecialAbilities(): Unit = {
    val race = character_race_select.value

    special_abilities.innerHTML= getRacialAbilities(race)
  }

  @JSExportTopLevel("checkClass")
  def checkClass(): Unit = {
    val race = character_race_select.value
    val characterClass = character_class_select.value

    if(!checkCharacterClass(race, characterClass))
      character_class_select.selectedIndex = 0
  }

  @JSExportTopLevel("checkMaxStr")
  def checkMaxStr(): Unit = {
    val race = character_race_select.value
    if(race == "Halfling" && str_select.selectedIndex >= 15)
      str_select.selectedIndex = 14
  }

  @JSExportTopLevel("checkMaxDex")
  def checkMaxDex(): Unit = {
    val race = character_race_select.value
    if(race == "Halfling" && dex_select.selectedIndex < 6)
      dex_select.selectedIndex = 6
  }

  @JSExportTopLevel("checkMaxCon")
  def checkMaxCon(): Unit = {
    val race = character_race_select.value
    if(race == "Elf" && con_select.selectedIndex >= 15)
      con_select.selectedIndex = 14
    if(race == "Dwarf" && con_select.selectedIndex < 6)
      con_select.selectedIndex = 6
  }

  @JSExportTopLevel("checkMaxInt")
  def checkMaxInt(): Unit = {
    val race = character_race_select.value
    if(race == "Elf" && int_select.selectedIndex < 6)
      int_select.selectedIndex = 6
  }

  @JSExportTopLevel("checkChrChr")
  def checkMaxChr(): Unit = {
    val race = character_race_select.value
    if(race == "Dwarf" && chr_select.selectedIndex >= 15)
      chr_select.selectedIndex = 14
  }


}
