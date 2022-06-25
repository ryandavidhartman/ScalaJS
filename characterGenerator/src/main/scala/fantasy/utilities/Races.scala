package fantasy.utilities

object Races {
  sealed trait Race
  case object Human extends Race
  case object Elf extends Race
  case object Dwarf extends Race
  case object Halfling extends Race
  case object HalfElf extends Race
  case object HalfOrc extends Race

  def stringToRace(race: String): Race = race match {
    case "Human" => Human
    case "Elf" => Elf
    case "Dwarf" => Dwarf
    case "Halfling" => Halfling
    case "HalfElf" => HalfElf
    case "HalfOrc" => HalfOrc
    case _ => throw InvalidRaceException(s"Invalid character race: $race")
  }

  case class InvalidRaceException(msg: String) extends Exception(msg)
}
