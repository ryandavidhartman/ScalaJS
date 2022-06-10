package fantasy.utilities

object AlignmentGenerator {

  def getAlignment(): String = {

    val random = Roller.randomInt(max = 100)

    if(random < 50)
      "Lawful"
      else if(random < 75)
        "Neutral"
      else
        "Chaotic"
    }

}
