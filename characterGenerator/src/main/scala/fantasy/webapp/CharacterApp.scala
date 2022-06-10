package fantasy.webapp

import fantasy.utilities.Roller.getSixScores
import fantasy.utilities.BasicFantasy._
import fantasy.utilities.{AgeGenerator, AlignmentGenerator, HeightWeightGenerator, NameGenerator, SavingsThrows, ThiefSkills, TurnUndead}
import org.scalajs.dom
import org.scalajs.dom.{document, html}
import DOMObjects._

import scala.scalajs.js.annotation.JSExportTopLevel

object CharacterApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }


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
      setHeightWeight()
      setAge()
    })

    character_gender_select.addEventListener("change", { (e: dom.MouseEvent) =>
      setHeightWeight()
    })

    character_class_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkClass()
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
    })

    character_level_select.addEventListener("change", { (e: dom.MouseEvent) =>
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
      setAge()
    })

    str_select.addEventListener("change", { (e: dom.MouseEvent) =>
      checkMaxStr()
      setMeleeAttackBonusHandler()
      setHeightWeight()
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
    setSavingsThrows()
    setHeightWeight()
    setAge()
    setAlignment()
    setTurnUndead()
    setThiefSkills()
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

  @JSExportTopLevel("setSavingsThrows")
  def setSavingsThrows(): Unit = {
    val characterClass = character_class_select.value
    val level: Int = character_level_select.value.toInt

    val saves = SavingsThrows.getSavingsThrows(characterClass, level)

    deathSavingsThrow.textContent = saves._1.toString
    wandsSavingsThrow.textContent = saves._2.toString
    paralysisSavingsThrow.textContent = saves._3.toString
    breathSavingsThrow.textContent = saves._4.toString
    spellsSavingsThrow.textContent =saves._5.toString

  }

  @JSExportTopLevel("setHeight")
  def setHeightWeight(): Unit = {

    val race = character_race_select.value
    val gender = character_gender_select.value
    val strength = str_select.value.toInt

    val (height, weight) = HeightWeightGenerator.getHeight(race, gender, strength)
    character_height_input.value = height
    character_weight_input.value = weight
  }

  @JSExportTopLevel("setAge")
  def setAge(): Unit = {

    val race = character_race_select.value
    val level = character_level_select.value.toInt

    val age = AgeGenerator.getAge(race, level)

    character_age_input.value = age.toString

  }

  @JSExportTopLevel("setAlignment")
  def setAlignment(): Unit = {
    val alignment = AlignmentGenerator.getAlignment()
    character_alignment_select.value = alignment

  }




  @JSExportTopLevel("setTurnUndead")
  def setTurnUndead(): Unit = {
    val characterClass =  character_class_select.value
    val level = if(characterClass == "Cleric") character_level_select.value.toInt else 0

    val turns:Seq[String] = TurnUndead.turns(level)

    turnSkeletonSpan.textContent = turns(0)
    turnZombieSpan.textContent   = turns(1)
    turnGhoulSpan.textContent    = turns(2)
    turnWightSpan.textContent    = turns(3)
    turnWraithSpan.textContent   = turns(4)
    turnMummySpan.textContent    = turns(5)
    turnSpectreSpan.textContent  = turns(6)
    turnVampireSpan.textContent  = turns(7)
    turnGhostSpan.textContent    = turns(8)
  }

  @JSExportTopLevel("setThiefSkills")
  def setThiefSkills(): Unit = {

    val characterClass =  character_class_select.value
    val level = if(characterClass.contains("Thief")) character_level_select.value.toInt else 0

    val skills:Seq[String] = ThiefSkills.skills(level)

    openLocksSpan.textContent = skills(0)
    removeTrapsSpan.textContent = skills(1)
    pickPocketsSpan.textContent = skills(2)
    moveSilentlySpan.textContent = skills(3)
    climbWallsSpan.textContent = skills(4)
    hideSpan.textContent = skills(5)
    listenSpan.textContent = skills(6)
  }





}
