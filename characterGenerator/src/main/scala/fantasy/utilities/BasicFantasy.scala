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
}