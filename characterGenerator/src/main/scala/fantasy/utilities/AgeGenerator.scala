package fantasy.utilities

object AgeGenerator {

  def getAge(race: String, level: Int): Int = race match {
    case "Human" => 15 + Roller.randomInt(20) + level
    case "Elf" => 100 + Roller.randomInt(200) + level*10
    case "Dwarf" => 40 + Roller.randomInt(80) + level*4
    case "Halfling" => (17  + Roller.randomInt(22) + level*1.1).toInt
  }

}
