package fantasy.utilities

object Races {
  sealed trait Race
  case class Human() extends Race
  case class Elf() extends Race
  case class Dwarf() extends Race
  case class Halfling() extends Race
  case class HalfElf() extends Race
  case class HalfOrc() extends Race

  def stringToRace(race: String): Race = race match {
    case "Human" => Human()
    case "Elf" => Elf()
    case "Dwarf" => Dwarf()
    case "Halfling" => Halfling()
    case "HalfElf" => HalfElf()
    case "HalfOrc" => HalfOrc()
  }
}
