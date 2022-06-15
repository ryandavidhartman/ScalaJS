package fantasy.utilities

object Races {
  sealed trait Race
  case class Human() extends Race
  case class Elf() extends Race
  case class Dwarf() extends Race
  case class Halfling() extends Race
  case class HalfElf() extends Race
  case class HalfOrc() extends Race
}
