package basic.fantasy.backgrounds

import basic.fantasy.Roller
import basic.fantasy.characterclass.CharacterClasses.CharacterClass

sealed trait CharacterAlignment
case object Lawful extends CharacterAlignment
case object Neutral extends CharacterAlignment
case object Chaotic extends CharacterAlignment

object AlignmentGenerator {

  def getAlignment(characterClass: CharacterClass): CharacterAlignment = {

    val random =
      if(characterClass.isThief)
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

  def stringToCharacterAlignment(alignment: String): CharacterAlignment = alignment match {
    case "Lawful" => Lawful
    case "Neutral" => Neutral
    case "Chaotic" => Chaotic
    case _ => throw InvalidAlignmentException(s"Invalid character alignment: $alignment")
  }

  case class InvalidAlignmentException(msg: String) extends Exception(msg)

}