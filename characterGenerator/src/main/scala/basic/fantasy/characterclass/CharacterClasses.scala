package basic.fantasy.characterclass

object CharacterClasses {

  sealed trait CharacterClass {
    val isCleric = false
    val isFighter = false
    val isMagicUser = false
    val isThief = false
    val isMultiClass = false
    val isSpellCaster = false
  }

  case object Cleric extends CharacterClass {
    override val isCleric = true
    override val isSpellCaster = true
  }

  case object Fighter extends CharacterClass {
    override val isFighter = true
  }

  case object FighterMagicUser extends CharacterClass {
    override val isFighter = true
    override val isMagicUser = true
    override val isMultiClass = true
    override val isSpellCaster = true
  }

  case object MagicUser extends CharacterClass {
    override val isMagicUser = true
    override val isSpellCaster = true
  }

  case object MagicUserThief extends CharacterClass {
    override val isThief = true
    override val isMagicUser = true
    override val isMultiClass = true
  }

  case object Thief extends CharacterClass {
    override val isThief = true
  }

  case class InvalidCharacterClassException(msg: String) extends Exception(msg)

  def stringToCharacterClass(characterClass: String): CharacterClass = characterClass match {
    case "Fighter" => Fighter
    case "Magic-User" => MagicUser
    case "Thief" => Thief
    case "Cleric" => Cleric
    case "Fighter/Magic-User" => FighterMagicUser
    case "Magic-User/Thief" => MagicUserThief
    case _ => throw InvalidCharacterClassException(s"Invalid character class: $characterClass")
  }

  val All_CLASSES: Set[CharacterClass] = Set(Fighter, MagicUser, Thief, Cleric, FighterMagicUser, MagicUserThief)
}
