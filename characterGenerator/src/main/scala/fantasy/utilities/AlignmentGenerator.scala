package fantasy.utilities

object AlignmentGenerator {

  def getAlignment(characterClass: String): String = {

    val random =
      if(characterClass.contains("Thief"))
        Roller.randomInt(max = 50) + 50
      else
        Roller.randomInt(max = 100)

    if(random < 50)
      "Lawful"
      else if(random < 75)
        "Neutral"
      else
        "Chaotic"
    }

}
