package basic.webapp

import basic.fantasy.backgrounds.BackgroundGenerator.Background
import basic.fantasy.backgrounds.{AlignmentGenerator, CharacterAlignment, Races}
import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.{CharacterClasses, CharacterState, SavingsThrows}
import basic.fantasy.characterclass.CharacterClasses.CharacterClass
import basic.fantasy.equipment.Equipment
import org.scalajs.dom.html.{Button, Div, Input, Select, Span, TextArea}
import org.scalajs.dom.{document, html}

object DOMObjects {

  // DOM Objects
  val character_name_input: Input = document.getElementById("character_name_input").asInstanceOf[Input]
  val character_gender_select: Select = document.getElementById("character_gender_select").asInstanceOf[Select]
  val character_height_input: Input =  document.getElementById("character_height_input").asInstanceOf[Input]
  val character_weight_input: Input =  document.getElementById("character_weight_input").asInstanceOf[Input]
  val character_age_input: Input =  document.getElementById("character_age_input").asInstanceOf[Input]
  val character_alignment_select: Select =  document.getElementById("character_alignment_select").asInstanceOf[Select]
  val character_personality_input: Input = document.getElementById("character_personality_input").asInstanceOf[Input]

  val str_select: Select = document.getElementById("character_strength_select").asInstanceOf[Select]
  val dex_select: Select = document.getElementById("character_dexterity_select").asInstanceOf[Select]
  val con_select: Select = document.getElementById("character_constitution_select").asInstanceOf[Select]
  val int_select: Select = document.getElementById("character_intelligence_select").asInstanceOf[Select]
  val wis_select: Select = document.getElementById("character_wisdom_select").asInstanceOf[Select]
  val chr_select: Select = document.getElementById("character_charisma_select").asInstanceOf[Select]

  val character_race_select: Select = document.getElementById("character_race_select").asInstanceOf[Select]
  val character_class_select: Select = document.getElementById("character_class_select").asInstanceOf[Select]
  val character_level_select: Select = document.getElementById("character_level_select").asInstanceOf[Select]
  val rollButton: Button = document.getElementById("roll_ability_scores").asInstanceOf[Button]
  val rollNameButton: Button = document.getElementById("roll_character_name").asInstanceOf[Button]

  val base_attack_bonus: Span = document.getElementById("base_attack_bonus").asInstanceOf[Span]
  val melee_attack_bonus: Span = document.getElementById("melee_attack_bonus").asInstanceOf[Span]
  val ranged_attack_bonus: Span = document.getElementById("ranged_attack_bonus").asInstanceOf[Span]
  val ac_bonus: Span = document.getElementById("ac_bonus").asInstanceOf[Span]
  val base_ac: Span = document.getElementById("base_ac").asInstanceOf[Span]
  val hit_points: Span = document.getElementById("hit_points").asInstanceOf[Span]
  val special_abilities: TextArea = document.getElementById("special_abilities").asInstanceOf[TextArea]

  val deathSavingsThrow: Span = document.getElementById("death").asInstanceOf[Span]
  val wandsSavingsThrow: Span = document.getElementById("wands").asInstanceOf[Span]
  val paralysisSavingsThrow: Span = document.getElementById("paralysis").asInstanceOf[Span]
  val breathSavingsThrow: Span = document.getElementById("breath").asInstanceOf[Span]
  val spellsSavingsThrow: Span = document.getElementById("spells").asInstanceOf[Span]

  // Turn Undead
  val turnUndeadDiv: Div = document.getElementById("turn_undead_div").asInstanceOf[Div]
  turnUndeadDiv.style.display = "none"
  val turnSkeletonSpan: Span = document.getElementById("skeleton").asInstanceOf[html.Span]
  val turnZombieSpan = document.getElementById("zombie").asInstanceOf[html.Span]
  val turnGhoulSpan = document.getElementById("ghoul").asInstanceOf[html.Span]
  val turnWightSpan = document.getElementById("wight").asInstanceOf[html.Span]
  val turnWraithSpan = document.getElementById("wraith").asInstanceOf[html.Span]
  val turnMummySpan = document.getElementById("mummy").asInstanceOf[html.Span]
  val turnSpectreSpan = document.getElementById("spectre").asInstanceOf[html.Span]
  val turnVampireSpan = document.getElementById("vampire").asInstanceOf[html.Span]
  val turnGhostSpan = document.getElementById("ghost").asInstanceOf[html.Span]

  // Thief Skills
  val thiefSkillsDiv = document.getElementById("thief_skills_div").asInstanceOf[html.Div]
  thiefSkillsDiv.style.display = "none"
  val openLocksSpan = document.getElementById("openLocks").asInstanceOf[html.Span]
  val removeTrapsSpan = document.getElementById("removeTraps").asInstanceOf[html.Span]
  val pickPocketsSpan = document.getElementById("pickPockets").asInstanceOf[html.Span]
  val moveSilentlySpan = document.getElementById("moveSilently").asInstanceOf[html.Span]
  val climbWallsSpan = document.getElementById("climbWalls").asInstanceOf[html.Span]
  val hideSpan = document.getElementById("hide").asInstanceOf[html.Span]
  val listenSpan = document.getElementById("listen").asInstanceOf[html.Span]

  // Monk Skills
  val monkSkillsDiv = document.getElementById("monk_skills_div").asInstanceOf[html.Div]
  monkSkillsDiv.style.display = "none"

  val monkMoveSilentlySpan = document.getElementById("monkMoveSilently").asInstanceOf[html.Span]
  val monkClimbWallsSpan = document.getElementById("monkClimbWalls").asInstanceOf[html.Span]
  val monkHideSpan = document.getElementById("monkHide").asInstanceOf[html.Span]
  val monkListenSpan = document.getElementById("monkListen").asInstanceOf[html.Span]

  // Spells
  val casterSpellsDiv = document.getElementById("caster_spells_div").asInstanceOf[html.Div]
  casterSpellsDiv.style.display = "none"
  val firstLvlSpellsSpan = document.getElementById("first_level").asInstanceOf[html.Span]
  val secondLvlSpellsSpan = document.getElementById("second_level").asInstanceOf[html.Span]
  val thirdLvlSpellsSpan = document.getElementById("third_level").asInstanceOf[html.Span]
  val fourthLvlSpellsSpan = document.getElementById("fourth_level").asInstanceOf[html.Span]
  val fifthLvlSpellsSpan = document.getElementById("fifth_level").asInstanceOf[html.Span]
  val sixthLvlSpellsSpan = document.getElementById("sixth_level").asInstanceOf[html.Span]


  // Background
  val nationalitySpan = document.getElementById("nationality").asInstanceOf[html.Span]
  val languageSpan = document.getElementById("language").asInstanceOf[html.Span]
  val parentOccupationSpan = document.getElementById("parentOccupation").asInstanceOf[html.Span]
  val birthOrderSpan = document.getElementById("birthOrder").asInstanceOf[html.Span]
  val childhoodEventsDiv = document.getElementById("childhoodEvents").asInstanceOf[html.Div]
  val adolescentEventsDiv = document.getElementById("adolescentEvents").asInstanceOf[html.Div]



  // Equipment
  val armorInput: Input = document.getElementById("armor").asInstanceOf[Input]
  val mainHandInput: Input = document.getElementById("mainHand").asInstanceOf[Input]
  val offHandInput: Input = document.getElementById("offHand").asInstanceOf[Input]
  val rangedWeaponInput: Input = document.getElementById("rangedWeapon").asInstanceOf[Input]
  val magicItemsTextArea: TextArea = document.getElementById("magicItems").asInstanceOf[TextArea]
  val equipmentPackInput: Input = document.getElementById("equipmentPack").asInstanceOf[Input]

  def getStrength(): Int = str_select.value.toInt
  def getDexterity(): Int = dex_select.value.toInt
  def getConstitution(): Int = con_select.value.toInt
  def getIntelligence(): Int = int_select.value.toInt
  def getWisdom(): Int = wis_select.value.toInt
  def getCharisma(): Int = chr_select.value.toInt

  def getGender() = character_gender_select.value
  def getRace(): Race = Races.stringToRace(character_race_select.value)
  def getCharacterClass(): CharacterClass = CharacterClasses.stringToCharacterClass(character_class_select.value)
  def getCharacterLevel(): Int =  character_level_select.value.toInt
  def getCharacterAlignment(): CharacterAlignment =  AlignmentGenerator.stringToCharacterAlignment(character_alignment_select.value)

  var state: CharacterState = CharacterState(
    name = character_name_input.value,
    race =  getRace(),
    characterClass = getCharacterClass(),
    level = character_level_select.value.toInt,
    gender = character_gender_select.value,
    height = character_height_input.value,
    weight = character_weight_input.value.toInt,
    age = character_age_input.value.toInt,
    alignment = getCharacterAlignment(),
    personality = character_personality_input.toString,
    strength = getStrength(),
    dexterity = getDexterity(),
    constitution = getConstitution(),
    intelligence = getIntelligence(),
    wisdom = getWisdom(),
    charisma = getCharisma(),
    attackBonus = base_attack_bonus.textContent,
    meleeBonus = melee_attack_bonus.textContent,
    rangedBonus = ranged_attack_bonus.textContent,
    acBonus = ac_bonus.textContent,
    acBase = base_ac.textContent,
    hitPoints = hit_points.textContent.toInt,
    savingsThrows = ???,
    abilities = ???, //: String,
    background = ???, //: Background,
    equipment = ??? //: Equipment

  )

}
