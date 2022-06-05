package fantasy.utilities

import Math.min

object SavingsThrows {

  val cleric: Map[Int, (Int, Int, Int, Int, Int)] = Map(
    1  -> (11, 12, 14, 16, 15),
    2  -> (10, 11, 13, 15, 14),
    3  -> ( 9, 10, 13, 15, 14),
    4  -> ( 9, 10, 12, 14, 13),
    5  -> ( 8,  9, 12, 14, 13),
    6  -> ( 8,  9, 11, 13, 12),
    7  -> ( 7,  8, 11, 13, 12),
    8  -> ( 7,  8, 10, 12, 11),
    9  -> ( 6,  7, 10, 12, 11),
    10 -> ( 6,  7,  9, 11, 10),
    11 -> ( 5,  6,  9, 11, 10),
  )

  val magicUser: Map[Int, (Int, Int, Int, Int, Int)] = Map(
    1  -> (13, 14, 13, 16, 15),
    2  -> (13, 14, 13, 15, 14),
    3  -> (12, 13, 12, 15, 13),
    4  -> (12, 12, 11, 14, 13),
    5  -> (11, 11, 10, 14, 12),
    6  -> (11, 10,  9, 13, 11),
    7  -> (10, 10,  9, 13, 11),
    8  -> (10,  9,  8, 12, 10),
    9  -> ( 9,  8,  7, 12,  9),
    10 -> ( 9,  7,  6, 11,  9),
    11 -> ( 8,  6,  5, 11,  8),
  )

  val fighter: Map[Int, (Int, Int, Int, Int, Int)] = Map(
    1  -> (12, 13, 14, 15, 17),
    2  -> (11, 12, 14, 15, 16),
    3  -> (11, 11, 13, 14, 15),
    4  -> (10, 11, 12, 14, 15),
    5  -> ( 9, 10, 12, 13, 14),
    6  -> ( 9,  9, 11, 12, 13),
    7  -> ( 8,  9, 10, 12, 13),
    8  -> ( 7,  8, 10, 11, 12),
    9  -> ( 7,  7,  9, 10, 11),
    10 -> ( 6,  7,  8, 10, 11),
    11 -> ( 5,  6,  8,  9, 10),
  )

  val thief: Map[Int, (Int, Int, Int, Int, Int)] = Map(
    1  -> (13, 14, 13, 16, 15),
    2  -> (12, 14, 12, 15, 14),
    3  -> (11, 13, 12, 14, 13),
    4  -> (11, 13, 11, 13, 13),
    5  -> (10, 12, 11, 12, 12),
    6  -> ( 9, 12, 10, 11, 11),
    7  -> ( 9, 10, 10, 10, 11),
    8  -> ( 8, 10,  9,  9, 10),
    9  -> ( 7,  9,  9,  8,  9),
    10 -> ( 7,  9,  8,  7,  9),
    11 -> ( 6,  8,  8,  6,  8),
  )

  def getSavingsThrows(characterClass: String, level: Int): (Int, Int, Int, Int, Int) = {
    val modLevel = level/2 +1

    characterClass match {
      case "Fighter" => fighter(modLevel)
      case "Magic-User" => magicUser(modLevel)
      case "Thief" => thief(modLevel)
      case "Cleric" => cleric(modLevel)
      case "Fighter/Magic-User" =>
        val f = fighter(modLevel)
        val m = magicUser(modLevel)
        (min(f._1, m._1), min(f._2, m._2), min(f._3, m._3), min(f._4, m._4), min(f._5, m._5))
      case "Magic-User/Thief" =>
        val t = thief(modLevel)
        val m = magicUser(modLevel)
        (min(t._1, m._1), min(t._2, m._2), min(t._3, m._3), min(t._4, m._4), min(t._5, m._5))
    }
  }
}