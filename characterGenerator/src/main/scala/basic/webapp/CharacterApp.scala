package basic.webapp

import basic.fantasy.Roller.getSixScores
import basic.fantasy.backgrounds.PersonalityGenerator.getPersonality
import basic.fantasy.backgrounds.Races._
import basic.fantasy.backgrounds._
import basic.fantasy.characterclass.CharacterClasses._
import basic.fantasy.characterclass.{MonkSkills, SavingsThrows, SpellsPerLevel, ThiefSkills, TurnUndead}
import basic.fantasy.equipment.EquipmentGenerator
import basic.fantasy.equipment.Shields.NoShield
import basic.fantasy.rules.BasicFantasy
import basic.fantasy.rules.BasicFantasy._
import basic.webapp.DOMObjects._
import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.JSExportTopLevel

object CharacterApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (_: dom.Event) =>
      setupUI()
    })
  }


  def setupUI(): Unit = {
    rollButton.addEventListener("click", { (_: dom.MouseEvent) =>
      getRandomAbilityScores()
      updateAllModifiers()
    })

    rollNameButton.addEventListener("click", { (_: dom.MouseEvent) =>
     rollNameHandler()
    })

    character_race_select.addEventListener("change", { (_: dom.MouseEvent) =>
      updateAllModifiers()
      setSpecialAbilities()
      setHeightWeight()
      setAge()
    })

    character_gender_select.addEventListener("change", { (_: dom.MouseEvent) =>
      setHeightWeight()
    })

    character_class_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkClass()
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
    })

    character_level_select.addEventListener("change", { (_: dom.MouseEvent) =>
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
      setAge()
    })

    character_alignment_select.addEventListener("change", { (_: dom.MouseEvent) =>
      setSpells()
    })

    str_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkMaxStr()
      setMeleeAttackBonusHandler()
      setHeightWeight()
    })

    int_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkMaxInt()
    })

    dex_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkMaxDex()
      setRangeAttackBonusHandler()
      setACBonusHandler()
    })

    con_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkMaxCon()
      setHitPointsHandler()
    })

    wis_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkMaxWis()
    })

    chr_select.addEventListener("change", { (_: dom.MouseEvent) =>
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
    setSpells()
    setBackground()
    setPersonality()
    setTurnUndead()
    setThiefSkills()
    setMonkSkills()
    setEquipment()
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("rollNameHandler")
  def rollNameHandler(): Unit = {
    val gender: String = character_gender_select.value

    val characterName = NameGenerator.getName(getRace(), gender)
    character_name_input.value = characterName
  }

  @JSExportTopLevel("addRollHandler")
  def getRandomAbilityScores(): Unit = {
    val scores = getSixScores()

    val attributes: Seq[html.Select] = getCharacterClass() match {
      case Cleric => Seq(wis_select, str_select, con_select, int_select,  chr_select, dex_select)
      case Fighter => Seq(str_select, con_select, dex_select, chr_select,  wis_select, int_select)
      case FighterMagicUser =>  Seq(int_select, str_select, con_select, dex_select, wis_select, chr_select)
      case MagicUser => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case MagicUserThief => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case Monk => Seq(wis_select, dex_select, str_select, con_select, int_select, chr_select)
      case Thief =>   Seq(dex_select, con_select, str_select, chr_select, int_select, wis_select)
    }

    (0 to 5).foreach(i => attributes(i).selectedIndex = scores(i))
  }

  @JSExportTopLevel("setBaseAttackBonusHandler")
  def setBaseAttackBonusHandler(): Unit = {

    val level: Int = character_level_select.value.toInt

    base_attack_bonus.textContent = calcBaseAttackModifier(getCharacterClass(), level)
  }

  @JSExportTopLevel("setMeleeAttackBonusHandler")
  def setMeleeAttackBonusHandler(): Unit = {
    val baseAttackBonus: Int = base_attack_bonus.textContent.toInt

    melee_attack_bonus.textContent = calcMeleeAttackModifier(getStrength(), baseAttackBonus)
  }

  @JSExportTopLevel("setRangeAttackBonusHandler")
  def setRangeAttackBonusHandler(): Unit = {

    val dexterity: Int = dex_select.value.toInt
    val baseAttackBonus: Int = base_attack_bonus.textContent.toInt

    ranged_attack_bonus.textContent = calcRangeAttackModifier(dexterity, baseAttackBonus, getRace())
  }

  @JSExportTopLevel("setACBonusHandler")
  def setACBonusHandler(): Unit = {

    val dexterity: Int = dex_select.value.toInt
    val wisdom: Int = wis_select.value.toInt
    ac_bonus.textContent = calcACModifier(dexterity, wisdom, getCharacterClass(), getCharacterLevel())
  }

  @JSExportTopLevel("setHitPointsHandler")
  def setHitPointsHandler(): Unit = {

    val constitution: Int = con_select.value.toInt
    val level: Int = character_level_select.value.toInt

    hit_points.textContent = calcHitPoints(getCharacterClass(), getRace(), level, constitution).toString
  }

  @JSExportTopLevel("setSpecialAbilities")
  def setSpecialAbilities(): Unit = special_abilities.innerHTML = getAbilities(getRace(), getCharacterClass())


  @JSExportTopLevel("checkClass")
  def checkClass(): Unit = {

    if(!checkCharacterClass(getRace(), getCharacterClass()))
      character_class_select.selectedIndex = 0

    val characterClass = getCharacterClass()
    if(characterClass.isCleric)
      turnUndeadDiv.style.display = "inline"
    else
      turnUndeadDiv.style.display = "none"

    if(characterClass.isThief)
      thiefSkillsDiv.style.display = "inline"
    else
      thiefSkillsDiv.style.display = "none"

    if(characterClass.isSpellCaster)
      casterSpellsDiv.style.display = "inline"
    else
      casterSpellsDiv.style.display = "none"

    if(characterClass.isMonk)
      monkSkillsDiv.style.display = "inline"
    else
      monkSkillsDiv.style.display = "none"

  }

  @JSExportTopLevel("checkMaxStr")
  def checkMaxStr(): Unit = {
    val race = getRace()
    val characterClass = getCharacterClass()

    if(race == Halfling && str_select.selectedIndex >= 15)
      str_select.selectedIndex = 14

    if(characterClass == Monk && str_select.selectedIndex < 10)
      str_select.selectedIndex = 10
  }

  @JSExportTopLevel("checkMaxDex")
  def checkMaxDex(): Unit = {
    val race = getRace()
    val characterClass = getCharacterClass()

    if(race == Halfling && dex_select.selectedIndex < 6)
      dex_select.selectedIndex = 6

    if(characterClass == Monk && dex_select.selectedIndex < 10)
      dex_select.selectedIndex = 10
  }

  @JSExportTopLevel("checkMaxWis")
  def checkMaxWis(): Unit = {
    val characterClass = getCharacterClass()
    if(characterClass == Monk && wis_select.selectedIndex < 10)
      wis_select.selectedIndex = 10
  }

  @JSExportTopLevel("checkMaxCon")
  def checkMaxCon(): Unit = {
    val race = getRace()
    val characterClass = getCharacterClass()

    if(race == Elf && con_select.selectedIndex >= 15)
      con_select.selectedIndex = 14
    if(race == HalfElf && con_select.selectedIndex >= 15)
      con_select.selectedIndex = 14
    if(race == Dwarf && con_select.selectedIndex < 6)
      con_select.selectedIndex = 6
    if(race == HalfOrc && con_select.selectedIndex < 6)
      con_select.selectedIndex = 6
    if(characterClass == Monk && con_select.selectedIndex < 6)
      con_select.selectedIndex = 6
  }

  @JSExportTopLevel("checkMaxInt")
  def checkMaxInt(): Unit = {
    val race = getRace()
    if(race == Elf && int_select.selectedIndex < 6)
      int_select.selectedIndex = 6

    if(race == HalfElf && int_select.selectedIndex < 6)
      int_select.selectedIndex = 6

    if(race == HalfOrc && int_select.selectedIndex >= 15)
      int_select.selectedIndex = 14
  }

  @JSExportTopLevel("checkChrChr")
  def checkMaxChr(): Unit = {
    val race = character_race_select.value
    if(race == "Dwarf" && chr_select.selectedIndex >= 15)
      chr_select.selectedIndex = 14
  }

  @JSExportTopLevel("setSavingsThrows")
  def setSavingsThrows(): Unit = {
    val level: Int = character_level_select.value.toInt

    val saves = SavingsThrows.getSavingsThrows(getCharacterClass(), getRace(), level)

    deathSavingsThrow.textContent = saves.deathRayOrPoison.toString
    wandsSavingsThrow.textContent = saves.magicWands.toString
    paralysisSavingsThrow.textContent = saves.paralysisOrPetrify.toString
    breathSavingsThrow.textContent = saves.breathWeapons.toString
    spellsSavingsThrow.textContent = saves.spells.toString
  }

  @JSExportTopLevel("setSpells")
  def setSpells(): Unit = {

    val spells: Seq[String] = SpellsPerLevel.getSpells(getCharacterClass(), getCharacterLevel(), getCharacterAlignment())

    firstLvlSpellsSpan.textContent = spells.head
    secondLvlSpellsSpan.textContent = spells(1)
    thirdLvlSpellsSpan.textContent = spells(2)
    fourthLvlSpellsSpan.textContent = spells(3)
    fifthLvlSpellsSpan.textContent = spells(4)
    sixthLvlSpellsSpan.textContent = spells(5)
  }

  @JSExportTopLevel("setHeight")
  def setHeightWeight(): Unit = {

    val (height, weight) = HeightWeightGenerator.getHeight(getRace(), getGender, getStrength())
    character_height_input.value = height
    character_weight_input.value = weight
  }

  @JSExportTopLevel("setAge")
  def setAge(): Unit = {
    val age = AgeGenerator.getAge(getRace(), getCharacterLevel())
    character_age_input.value = age.toString

  }

  @JSExportTopLevel("setAlignment")
  def setAlignment(): Unit = {
    val alignment = AlignmentGenerator.getAlignment(getCharacterClass())
    character_alignment_select.value = alignment.toString

  }

  @JSExportTopLevel("setTurnUndead")
  def setTurnUndead(): Unit = {

    val clericLevel = if(getCharacterClass().isCleric) getCharacterLevel() else 0
    val turns: Seq[String] = TurnUndead.turns(clericLevel)

    turnSkeletonSpan.textContent = turns.head
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

    val thiefLevel = if(getCharacterClass().isThief) getCharacterLevel() else 0
    val skills:Seq[String] = ThiefSkills.skills(thiefLevel)

    openLocksSpan.textContent = skills.head
    removeTrapsSpan.textContent = skills(1)
    pickPocketsSpan.textContent = skills(2)
    moveSilentlySpan.textContent = skills(3)
    climbWallsSpan.textContent = skills(4)
    hideSpan.textContent = skills(5)
    listenSpan.textContent = skills(6)
  }

  @JSExportTopLevel("setMonkSkills")
  def setMonkSkills(): Unit = {

    val monkLevel = if(getCharacterClass().isMonk) getCharacterLevel() else 0
    val skills:Seq[String] = MonkSkills.skills(monkLevel)

    monkMoveSilentlySpan.textContent = skills.head
    monkClimbWallsSpan.textContent = skills(1)
    monkHideSpan.textContent = skills(2)
    monkListenSpan.textContent = skills(3)
  }

  @JSExportTopLevel("setBackground")
  def setBackground(): Unit = {
    val languageBonus = BasicFantasy.getLanguageBonus(getIntelligence())
    val background = BackgroundGenerator.getBackground(getRace(), languageBonus)

    nationalitySpan.textContent = background.parentsNationality.toString
    languageSpan.textContent = background.languages.mkString(",")
    parentOccupationSpan.textContent = background.parentsOccupation
    birthOrderSpan.textContent = background.birthOrder
    childhoodEventsDiv.innerHTML = background.childHoodEvents.map(a => s"<tr><td>$a</td>")
      .mkString("<table class=\"unstriped\">", "", "</table>")
    adolescentEventsDiv.innerHTML = background.adolescentEvents.map(a => s"<tr><td>$a</td>")
      .mkString("<table class=\"unstriped\">", "", "</table>")

  }
  @JSExportTopLevel("setPersonality")
  def setPersonality(): Unit = {
    character_personality_input.value = getPersonality()
  }

  @JSExportTopLevel("setEquipment")
  def setEquipment(): Unit = {
    val equipment = EquipmentGenerator.getEquipment(getCharacterClass(), getCharacterLevel(), getRace())

    armorInput.value = equipment.armor.toString
    base_ac.textContent = equipment.armor.ac.toString
    mainHandInput.value = equipment.meleeWeapon.toString
    if(equipment.shield == NoShield)
      offHandInput.value = equipment.offhand.toString
    else
      offHandInput.value = equipment.shield.toString
    rangedWeaponInput.value = equipment.rangedWeapon.toString
    magicItemsTextArea.value = equipment.magicalItems.mkString("&#13;&#10;&#13;&#10;")    //.mkString("<table class=\"unstriped\">", "", "</table>")
    equipmentPackInput.value = equipment.equipmentPack.toString()
  }

}
