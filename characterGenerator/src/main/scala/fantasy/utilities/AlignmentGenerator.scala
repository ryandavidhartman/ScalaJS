package fantasy.utilities

sealed trait Alignment
case object Lawful extends Alignment
case object Neutral extends Alignment
case object Chaotic extends Alignment

object AlignmentGenerator {

  def getAlignment(characterClass: String): Alignment = {

    val random =
      if(characterClass.contains("Thief"))
        Roller.randomInt(max = 50) + 50
      else
        Roller.randomInt(max = 100)

    if(random < 50)
      Lawful
    else if(random < 75)
      Neutral
    else
      Chaotic
    }

}
