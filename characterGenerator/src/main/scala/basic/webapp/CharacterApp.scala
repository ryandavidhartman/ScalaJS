package basic.webapp

import basic.fantasy.Roller.getSixScores
import basic.fantasy.backgrounds.PersonalityGenerator.getPersonality
import basic.fantasy.backgrounds.Races._
import basic.fantasy.backgrounds._
import basic.fantasy.characterclass.CharacterClasses._
import basic.fantasy.characterclass.KiPowers.KiPower
import basic.fantasy.characterclass.{CharacterClasses, KiPowers, MonkSkills, SavingsThrows, SpellsPerLevel, ThiefSkills, TurnUndead}
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
      val characterName = NameGenerator.getName(state.race, state.gender)
      character_name_input.value = characterName
      state = state.copy(name = characterName)
    })

    character_race_select.addEventListener("change", { (_: dom.MouseEvent) =>
      val newRace = Races.stringToRace(character_race_select.value)
      state = state.copy(race = newRace)
      updateAllModifiers()
      setSpecialAbilities()
      setHeightWeight()
      setAge()
    })

    character_gender_select.addEventListener("change", { (_: dom.MouseEvent) =>
      val newGender = character_gender_select.value
      state = state.copy(gender = newGender)
      setHeightWeight()
    })

    character_class_select.addEventListener("change", { (_: dom.MouseEvent) =>
      checkClass()  // this updates state
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
    })

    character_level_select.addEventListener("change", { (_: dom.MouseEvent) =>
      val newLevel = character_level_select.value.toInt
      state = state.copy(level = newLevel)
      updateAllModifiers()
      setSavingsThrows()
      setTurnUndead()
      setThiefSkills()
      setAge()
    })

    character_alignment_select.addEventListener("change", { (_: dom.MouseEvent) =>
      //val newAlignment = CharacterAlignment.     //character_alignment_select.value
      //state = state.copy(alignment = )
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
    setMonkSkillsAndPowers()
    setEquipment()
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }


  @JSExportTopLevel("addRollHandler")
  def getRandomAbilityScores(): Unit = {
    val scores = getSixScores()

    val attributes: Seq[html.Select] = state.characterClass match {
      case Cleric => Seq(wis_select, str_select, con_select, int_select,  chr_select, dex_select)
      case Fighter => Seq(str_select, con_select, dex_select, chr_select,  wis_select, int_select)
      case FighterMagicUser =>  Seq(int_select, str_select, con_select, dex_select, wis_select, chr_select)
      case MagicUser => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case MagicUserThief => Seq(int_select, dex_select, con_select, wis_select, chr_select, str_select)
      case Monk => Seq(wis_select, dex_select, str_select, con_select, int_select, chr_select)
      case Thief => Seq(dex_select, con_select, str_select, chr_select, int_select, wis_select)
    }

    (0 to 5).foreach(i => attributes(i).selectedIndex = scores(i))

    state = state.copy (
      strength = getStrengthFromDom(),
      dexterity = getDexterityFromDom(),
      constitution = getConstitutionFromDom(),
      intelligence = getIntelligenceFromDom(),
      wisdom = getWisdomFromDom(),
      charisma = getCharismaFromDom()
    )

  }

  @JSExportTopLevel("setBaseAttackBonusHandler")
  def setBaseAttackBonusHandler(): Unit = {
    val newBaseAttackBonus = calcBaseAttackModifier(state.characterClass, state.level)
    base_attack_bonus.textContent = newBaseAttackBonus
    state = state.copy(attackBonus = newBaseAttackBonus)
  }

  @JSExportTopLevel("setMeleeAttackBonusHandler")
  def setMeleeAttackBonusHandler(): Unit = {
    val newMeleeAttackBonus = calcMeleeAttackModifier(state.strength, state.attackBonus.toInt)
    melee_attack_bonus.textContent = newMeleeAttackBonus
    state = state.copy(meleeBonus = newMeleeAttackBonus)
  }

  @JSExportTopLevel("setRangeAttackBonusHandler")
  def setRangeAttackBonusHandler(): Unit = {
    val newRangedAttackBonus = calcRangeAttackModifier(state.dexterity, state.attackBonus.toInt, state.race)
    ranged_attack_bonus.textContent = newRangedAttackBonus
    state = state.copy(rangedBonus = newRangedAttackBonus)
  }

  @JSExportTopLevel("setACBonusHandler")
  def setACBonusHandler(): Unit = {

    val newACBonus = calcACModifier(state.dexterity, state.wisdom, state.characterClass, state.level)
    ac_bonus.textContent = newACBonus
    state = state.copy(acBonus = newACBonus)
  }

  @JSExportTopLevel("setHitPointsHandler")
  def setHitPointsHandler(): Unit = {
    val newHitPoints = calcHitPoints(state.characterClass, state.race, state.level, state.constitution)
    hit_points.textContent = newHitPoints.toString
    state = state.copy(hitPoints = newHitPoints)
  }

  @JSExportTopLevel("setSpecialAbilities")
  def setSpecialAbilities(): Unit = {
    val newAbilities = getAbilities(state.race, state.characterClass)
    special_abilities.innerHTML = newAbilities
    state = state.copy(abilities = newAbilities)
  }


  @JSExportTopLevel("checkClass")
  def checkClass(): Unit = {

    val newCharacterClass = CharacterClasses.stringToCharacterClass(character_class_select.value)

    if(!checkCharacterClass(state.race,newCharacterClass)) {
      character_class_select.selectedIndex = 0
      state = state.copy(characterClass = Fighter)
    } else {
      state = state.copy(characterClass = newCharacterClass)
    }

    if(state.characterClass.isCleric)
      turnUndeadDiv.style.display = "inline"
    else
      turnUndeadDiv.style.display = "none"

    if(state.characterClass.isThief)
      thiefSkillsDiv.style.display = "inline"
    else
      thiefSkillsDiv.style.display = "none"

    if(state.characterClass.isSpellCaster)
      casterSpellsDiv.style.display = "inline"
    else
      casterSpellsDiv.style.display = "none"

    if(state.characterClass.isMonk) {
      monkSkillsDiv.style.display = "inline"
      monkPowersDiv.style.display = "inline"
    } else {
      monkSkillsDiv.style.display = "none"
      monkPowersDiv.style.display = "none"
    }

  }

  @JSExportTopLevel("checkMaxStr")
  def checkMaxStr(): Unit = {

    if(state.race == Halfling && str_select.selectedIndex >= 15) {
      str_select.selectedIndex = 14
      state = state.copy(strength = 17)
    }

    if(state.characterClass == Monk && str_select.selectedIndex < 10) {
      str_select.selectedIndex = 10
      state = state.copy(strength = 13)
    }
  }

  @JSExportTopLevel("checkMaxDex")
  def checkMaxDex(): Unit = {

    if(state.race == Halfling && dex_select.selectedIndex < 6) {
      dex_select.selectedIndex = 6
      state = state.copy(dexterity = 9)
    }

    if(state.characterClass == Monk && dex_select.selectedIndex < 10) {
      dex_select.selectedIndex = 10
      state = state.copy(dexterity = 13)
    }
  }

  @JSExportTopLevel("checkMaxWis")
  def checkMaxWis(): Unit = {
    if(state.characterClass == Monk && wis_select.selectedIndex < 10) {
      wis_select.selectedIndex = 10
      state = state.copy(wisdom = 13)
    }
  }

  @JSExportTopLevel("checkMaxCon")
  def checkMaxCon(): Unit = {

    if((state.race == Elf || state.race == HalfElf) && con_select.selectedIndex >= 15) {
      con_select.selectedIndex = 14
      state = state.copy(constitution = 17)
    }

    if((state.race == Dwarf || state.race == HalfOrc) && con_select.selectedIndex < 6) {
      con_select.selectedIndex = 6
      state = state.copy(constitution = 9)
    }

    if(state.characterClass == Monk && con_select.selectedIndex < 6) {
      con_select.selectedIndex = 6
      state = state.copy(constitution = 9)
    }
  }

  @JSExportTopLevel("checkMaxInt")
  def checkMaxInt(): Unit = {
    if((state.race == Elf || state.race == HalfElf) && int_select.selectedIndex < 6) {
      int_select.selectedIndex = 6
      state = state.copy(intelligence = 9)
    }

    if(state.race == HalfOrc && int_select.selectedIndex >= 15) {
      int_select.selectedIndex = 14
      state = state.copy(intelligence = 17)
    }
  }

  @JSExportTopLevel("checkMaxChr")
  def checkMaxChr(): Unit = {
    if(state.race == Dwarf && chr_select.selectedIndex >= 15) {
      chr_select.selectedIndex = 14
      state = state.copy(charisma = 17)
    }
  }

  @JSExportTopLevel("setSavingsThrows")
  def setSavingsThrows(): Unit = {

    val saves = SavingsThrows.getSavingsThrows(state.characterClass, state.race, state.level)

    deathSavingsThrow.textContent = saves.deathRayOrPoison.toString
    wandsSavingsThrow.textContent = saves.magicWands.toString
    paralysisSavingsThrow.textContent = saves.paralysisOrPetrify.toString
    breathSavingsThrow.textContent = saves.breathWeapons.toString
    spellsSavingsThrow.textContent = saves.spells.toString

    state = state.copy(savingsThrows = saves)
  }

  @JSExportTopLevel("setSpells")
  def setSpells(): Unit = {

    val newSpells: Seq[String] = SpellsPerLevel.getSpells(state.characterClass, state.level, state.alignment)

    firstLvlSpellsSpan.textContent = newSpells.head
    secondLvlSpellsSpan.textContent = newSpells(1)
    thirdLvlSpellsSpan.textContent = newSpells(2)
    fourthLvlSpellsSpan.textContent = newSpells(3)
    fifthLvlSpellsSpan.textContent = newSpells(4)
    sixthLvlSpellsSpan.textContent = newSpells(5)

    state = state.copy(spells = newSpells)
  }

  @JSExportTopLevel("setHeight")
  def setHeightWeight(): Unit = {

    val (height, weight) = HeightWeightGenerator.getHeight(state.race, state.gender, state.strength)
    character_height_input.value = height
    character_weight_input.value = weight
    state.copy(height = height, weight = weight.toInt)
  }

  @JSExportTopLevel("setAge")
  def setAge(): Unit = {
    val newAge = AgeGenerator.getAge(state.race, state.level)
    character_age_input.value = newAge.toString
    state = state.copy(age = newAge)
  }

  @JSExportTopLevel("setAlignment")
  def setAlignment(): Unit = {
    val newAlignment = AlignmentGenerator.getAlignment(state.characterClass)
    character_alignment_select.value = newAlignment.toString
    state = state.copy(alignment = newAlignment)
  }

  @JSExportTopLevel("setTurnUndead")
  def setTurnUndead(): Unit = {

    val clericLevel = if(state.characterClass.isCleric) state.level else 0
    val newTurnUndead: Seq[String] = TurnUndead.turns(clericLevel)

    turnSkeletonSpan.textContent = newTurnUndead.head
    turnZombieSpan.textContent   = newTurnUndead(1)
    turnGhoulSpan.textContent    = newTurnUndead(2)
    turnWightSpan.textContent    = newTurnUndead(3)
    turnWraithSpan.textContent   = newTurnUndead(4)
    turnMummySpan.textContent    = newTurnUndead(5)
    turnSpectreSpan.textContent  = newTurnUndead(6)
    turnVampireSpan.textContent  = newTurnUndead(7)
    turnGhostSpan.textContent    = newTurnUndead(8)

    state = state.copy(turnUndead = newTurnUndead)
  }

  @JSExportTopLevel("setThiefSkills")
  def setThiefSkills(): Unit = {

    val thiefLevel = if(state.characterClass.isThief) state.level else 0
    val newThiefSkills:Seq[String] = ThiefSkills.skills(thiefLevel)

    openLocksSpan.textContent = newThiefSkills.head
    removeTrapsSpan.textContent = newThiefSkills(1)
    pickPocketsSpan.textContent = newThiefSkills(2)
    moveSilentlySpan.textContent = newThiefSkills(3)
    climbWallsSpan.textContent = newThiefSkills(4)
    hideSpan.textContent = newThiefSkills(5)
    listenSpan.textContent = newThiefSkills(6)

    state = state.copy(thiefSkills = newThiefSkills)
  }

  @JSExportTopLevel("setMonkSkills")
  def setMonkSkillsAndPowers(): Unit = {

    if(state.characterClass.isMonk) {

      val monkLevel = state.level
      val newMonkSkills: Seq[String] = MonkSkills.skills(monkLevel)

      monkMoveSilentlySpan.textContent = newMonkSkills.head
      monkClimbWallsSpan.textContent = newMonkSkills(1)
      monkHideSpan.textContent = newMonkSkills(2)
      monkListenSpan.textContent = newMonkSkills(3)

      val newMonkPowers: Set[KiPower] = KiPowers.getKiPowers(monkLevel)
      monkPowers.value = newMonkPowers.map(power => power.name).mkString("\n")
    }
  }

  @JSExportTopLevel("setBackground")
  def setBackground(): Unit = {
    val languageBonus = BasicFantasy.getLanguageBonus(state.intelligence)
    val newBackground = BackgroundGenerator.getBackground(state.race, languageBonus)

    nationalitySpan.textContent = newBackground.parentsNationality.toString
    languageSpan.textContent = newBackground.languages.mkString(",")
    parentOccupationSpan.textContent = newBackground.parentsOccupation
    birthOrderSpan.textContent = newBackground.birthOrder
    childhoodEventsDiv.innerHTML = newBackground.childHoodEvents.map(a => s"<tr><td>$a</td>")
      .mkString("<table class=\"unstriped\">", "", "</table>")
    adolescentEventsDiv.innerHTML = newBackground.adolescentEvents.map(a => s"<tr><td>$a</td>")
      .mkString("<table class=\"unstriped\">", "", "</table>")

    state = state.copy(background = newBackground)
  }
  @JSExportTopLevel("setPersonality")
  def setPersonality(): Unit = {
    val newPersonality = getPersonality()
    character_personality_input.value = newPersonality
    state = state.copy(personality = newPersonality)
  }

  @JSExportTopLevel("setEquipment")
  def setEquipment(): Unit = {
    val newEquipment = EquipmentGenerator.getEquipment(state.characterClass, state.level, state.race)

    armorInput.value = newEquipment.armor.toString
    base_ac.textContent = newEquipment.armor.ac.toString
    mainHandInput.value = newEquipment.meleeWeapon.toString
    if(newEquipment.shield == NoShield)
      offHandInput.value = newEquipment.offhand.toString
    else
      offHandInput.value = newEquipment.shield.toString
    rangedWeaponInput.value = newEquipment.rangedWeapon.toString
    magicItemsTextArea.value = newEquipment.magicalItems.mkString("Magic Items: ", ", ", "")
    equipmentPackInput.value = newEquipment.equipmentPack.toString()

    state = state.copy(equipment = newEquipment)
  }

}
