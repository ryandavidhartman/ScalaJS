package fantasy.utilities

object Spells {

  val clericSpells = Map(
    //        1  2  3  4  5  6
    1 ->  Seq(0, 0, 0, 0, 0, 0),
    2 ->  Seq(1, 0, 0, 0, 0, 0),
    3 ->  Seq(2, 0, 0, 0, 0, 0),
    4 ->  Seq(2, 1, 0, 0, 0, 0),
    5 ->  Seq(2, 2, 0, 0, 0, 0),
    6 ->  Seq(2, 2, 1, 0, 0, 0),
    7 ->  Seq(3, 2, 2, 0, 0, 0),
    8 ->  Seq(3, 2, 2, 1, 0, 0),
    9 ->  Seq(3, 3, 2, 2, 0, 0),
    10 -> Seq(3, 3, 2, 2, 1, 0),
    11 -> Seq(4, 3, 3, 2, 2, 0),
    12 -> Seq(4, 4, 3, 2, 2, 1),
    13 -> Seq(4, 4, 3, 3, 2, 2),
    14->  Seq(4, 4, 4, 3, 2, 2),
    15 -> Seq(4, 4, 4, 3, 3, 2),
    16 -> Seq(5, 4, 4, 3, 3, 2),
    17 -> Seq(5, 5, 4, 4, 3, 2),
    18->  Seq(5, 5, 4, 4, 3, 3),
    19 -> Seq(6, 5, 4, 4, 3, 3),
    20 -> Seq(6, 5, 5, 4, 3, 3),
  )

  val magicUserSpells = Map(
    //        1  2  3  4  5  6
    1 ->  Seq(1, 0, 0, 0, 0, 0),
    2 ->  Seq(2, 0, 0, 0, 0, 0),
    3 ->  Seq(2, 1, 0, 0, 0, 0),
    4 ->  Seq(2, 2, 0, 0, 0, 0),
    5 ->  Seq(2, 2, 1, 0, 0, 0),
    6 ->  Seq(3, 2, 2, 0, 0, 0),
    7 ->  Seq(3, 2, 2, 1, 0, 0),
    8 ->  Seq(3, 3, 2, 2, 0, 0),
    9 ->  Seq(3, 3, 2, 2, 1, 0),
    10 -> Seq(4, 3, 3, 2, 2, 0),
    11 -> Seq(4, 4, 3, 2, 2, 1),
    12 -> Seq(4, 4, 3, 3, 2, 2),
    13 -> Seq(4, 4, 4, 3, 2, 2),
    14->  Seq(4, 4, 4, 3, 2, 2),
    15 -> Seq(5, 4, 4, 3, 3, 2),
    16 -> Seq(5, 5, 4, 5, 3, 2),
    17 -> Seq(5, 5, 4, 4, 3, 3),
    18->  Seq(6, 5, 4, 4, 3, 3),
    19 -> Seq(6, 5, 5, 4, 3, 3),
    20 -> Seq(6, 5, 5, 4, 4, 3),
  )

  def getSpells(characterClass: String, level: Int): Seq[Int] = {
     if(characterClass.contains("Magic-User"))
       magicUserSpells(level)
     else if (characterClass == "Cleric")
       clericSpells(level)
     else
       clericSpells(1)
  }

}
