package fantasy.webapp

import org.scalajs.dom.{document, html}

object DOMObjects {

  // DOM Objects
  val character_name_input = document.getElementById("character_name_input").asInstanceOf[html.Input]
  val character_gender_select = document.getElementById("character_gender_select").asInstanceOf[html.Select]
  val character_height_input =  document.getElementById("character_height_input").asInstanceOf[html.Input]
  val character_weight_input =  document.getElementById("character_weight_input").asInstanceOf[html.Input]
  val character_age_input =  document.getElementById("character_age_input").asInstanceOf[html.Input]
  val character_alignment_select =  document.getElementById("character_alignment_select").asInstanceOf[html.Select]
  val character_background_input = document.getElementById("character_background_input").asInstanceOf[html.Input]

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

  val deathSavingsThrow = document.getElementById("death").asInstanceOf[html.Span]
  val wandsSavingsThrow = document.getElementById("wands").asInstanceOf[html.Span]
  val paralysisSavingsThrow = document.getElementById("paralysis").asInstanceOf[html.Span]
  val breathSavingsThrow = document.getElementById("breath").asInstanceOf[html.Span]
  val spellsSavingsThrow = document.getElementById("spells").asInstanceOf[html.Span]

  // Savings Throws
  val turnSkeletonSpan = document.getElementById("skeleton").asInstanceOf[html.Span]
  val turnZombieSpan = document.getElementById("zombie").asInstanceOf[html.Span]
  val turnGhoulSpan = document.getElementById("ghoul").asInstanceOf[html.Span]
  val turnWightSpan = document.getElementById("wight").asInstanceOf[html.Span]
  val turnWraithSpan = document.getElementById("wraith").asInstanceOf[html.Span]
  val turnMummySpan = document.getElementById("mummy").asInstanceOf[html.Span]
  val turnSpectreSpan = document.getElementById("spectre").asInstanceOf[html.Span]
  val turnVampireSpan = document.getElementById("vampire").asInstanceOf[html.Span]
  val turnGhostSpan = document.getElementById("ghost").asInstanceOf[html.Span]

  // Pick Pockets
  val openLocksSpan = document.getElementById("openLocks").asInstanceOf[html.Span]
  val removeTrapsSpan = document.getElementById("removeTraps").asInstanceOf[html.Span]
  val pickPocketsSpan = document.getElementById("pickPockets").asInstanceOf[html.Span]
  val moveSilentlySpan = document.getElementById("moveSilently").asInstanceOf[html.Span]
  val climbWallsSpan = document.getElementById("climbWalls").asInstanceOf[html.Span]
  val hideSpan = document.getElementById("hide").asInstanceOf[html.Span]
  val listenSpan = document.getElementById("listen").asInstanceOf[html.Span]

  // Back Ground
  val socialClassSpan = document.getElementById("socialClass").asInstanceOf[html.Span]
  val familyWealthSpan = document.getElementById("familyWealth").asInstanceOf[html.Span]
  val backgroundSkillsSpan = document.getElementById("backgroundSkills").asInstanceOf[html.Span]

}
