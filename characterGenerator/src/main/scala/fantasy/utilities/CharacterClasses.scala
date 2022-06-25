package fantasy.utilities

object CharacterClasses {

  sealed trait CharacterClass

  case object Cleric extends CharacterClass
  case object Fighter extends CharacterClass
  case object FighterMagicUser extends CharacterClass
  case object MagicUser extends CharacterClass
  case object MagicUserThief extends CharacterClass
  case object Thief extends CharacterClass

  case class InvalidCharacterClassException(msg: String) extends Exception(msg)

  def stringToCharacterClass(characterClass: String): CharacterClass = characterClass match {
    case "Fighter" =>  Fighter
    case "Magic-User" => MagicUser
    case "Thief" => Thief
    case "Cleric" => Cleric
    case "Fighter/Magic-User" => FighterMagicUser
    case "Magic-User/Thief" => MagicUserThief
    case _ => throw InvalidCharacterClassException(s"Invalid character class: $characterClass")
  }

}


