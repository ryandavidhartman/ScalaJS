package fantasy.utilities

object BasicFantasy {

  def calcBaseAttackModifier(characterClass: String, level: Int): String = {
    characterClass match {
      case f if f.contains("Fighter") =>
        if(level == 1)
          "+1"
        else if(level <= 3)
          "+2"
        else if(level == 4)
          "+3"
        else if(level <= 6)
          "+4"
        else if(level == 7)
          "+5"
        else if(level <= 10)
        "+6"
        else if(level <= 12)
          "+7"
        else if(level <= 15)
          "+8"
        else if(level <= 17)
          "+9"
        else
          "+10"
      case s if s.contains("Thief") | s.contains("Cleric")=>
        if(level <= 2)
          "+1"
        else if(level == 4)
          "+2"
        else if(level <= 6)
          "+3"
        else if(level <= 8)
          "+4"
        else if(level <= 11)
          "+5"
        else if(level <= 14)
          "+6"
        else if(level <= 17)
          "+7"
        else
          "+8"
      case "Magic-User" =>
        if(level <= 3)
          "+1"
        else if(level <= 5)
          "+2"
        else if(level <= 8)
          "+3"
        else if(level <= 12)
          "+4"
        else if(level <= 15)
          "+5"
        else if(level <= 18)
          "+6"
        else
          "+7"
    }
  }

  def calcMeleeAttackModifier(strength: Int, baseAttackBonus: Int): String = {
    val num = baseAttackBonus + attributeModifiers(strength)
    modifierBonusIntToString(num)
  }

  def calcRangeAttackModifier(dexterity: Int, baseAttackBonus: Int, race: String): String = {
    val num = if(race == "Halfling")
      baseAttackBonus + attributeModifiers(dexterity) + 1
    else
      baseAttackBonus + attributeModifiers(dexterity)
    modifierBonusIntToString(num)
  }

  def calcACModifier(dexterity: Int): String = {
    val num = attributeModifiers(dexterity)
    modifierBonusIntToString(num)
  }

  def calcHitPoints(characterClass: String, level: Int, constitution: Int): Int = {

    val mod = attributeModifiers(constitution)

    val truncated_level = Math.min(level, 9)

    val hpForFirst9 = characterClass match {
      case f if f.contains("Fighter") => Roller.rollHP(truncated_level, 8, mod)
      case c if c.contains("Cleric") => Roller.rollHP(truncated_level, 6, mod)
      case s if s.contains("Thief") | s.contains("Magic-User") => Roller.rollHP(truncated_level, 4, mod)
    }

    val hpFor9AndUp = if(level > 9)
      (level-9)
    else
      0

    hpForFirst9 + hpFor9AndUp
  }

  def attributeModifiers(attribute: Int): Int = attribute match {
    case 3 => -3
    case i if i >= 4 && i <= 5 => -2
    case i if i >= 6 && i <= 8 => -1
    case i if i >= 9 && i <= 12 => 0
    case i if i >= 13 && i <= 15 => 1
    case i if i >= 16 && i <= 17 => 2
    case _ => 3
  }

  def modifierBonusIntToString(mod: Int): String = {
    if(mod > 0)
      s"+${mod}"
    else
      mod.toString
  }

  def checkCharacterClass(race: String, characterClass: String): Boolean = race match {
    case "Human" => !characterClass.contains("/")
    case "Elf" => true
    case "Dwarf" => !characterClass.contains("Magic-User")
    case "Halfling" => !characterClass.contains("Magic-User")
  }

  def getRacialAbilities(race: String): String= race match {
    case "Human" =>
      """
        |<table class="unstriped">
        |  <tr>
        |    <td>+10% Bonus on Earned XP</td>
        |  </tr>
        |</table>
        |""".stripMargin
    case "Elf" =>
      """
        |<table class="unstriped">
        |  <tr>
        |    <td>Darkvision with a 60' range</td>
        |  </tr>
        |  <tr>
        |    <td>Find secret door 1-2 on d6 when searching</td>
        |  </tr>
        |  <tr>
        |    <td>Find secret door 1 on d6 with a cursory look</td>
        |  </tr>
        |  <tr>
        |    <td>Immune to paralyzing attacks of Ghouls</td>
        |  </tr>
        |  <tr>
        |    <td>Only surprised on 1 on d6</td>
        |  </tr>
        |</table>
        |""".stripMargin
    case "Dwarf" =>
      """
        |<table class="unstriped">
        |  <tr>
        |    <td>Darkvision with a 60' range</td>
        |  </tr>
        |  <tr>
        |    <td>Detect slanting passages, traps, shifting walls, and new construction on 1-2 on d6 when searching</td>
        |  </tr>
        |</table>
        |""".stripMargin
    case "Halfling" =>
      """
        |<table class="unstriped">
        |  <tr>
        |    <td>+2 to AC against melee attacks from large opponents</td>
        |  </tr>
        |  <tr>
        |    <td>+1 to initiative rolls</td>
        |  </tr>
        |  <tr>
        |    <td>Find secret door 1 on d6 with a cursory look</td>
        |  </tr>
        |  <tr>
        |    <td>90% to hide in forest terrain</td>
        |  </tr>
        |  <tr>
        |    <td>70% chance to hide in other terrains</td>
        |  </tr>
        |</table>
        |""".stripMargin
  }
}