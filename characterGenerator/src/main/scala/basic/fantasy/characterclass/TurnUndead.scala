package basic.fantasy.characterclass

object TurnUndead {

  val turns = Map(
    //     01    02    03    04    05    06    07    08    09
    0 -> Seq("0", "0", "0", "0", "0", "0", "0", "0", "0"),
    1 -> Seq("13", "17", "19", "No", "No", "No", "No", "No", "No"),
    2 -> Seq("11", "15", "18", "20", "No", "No", "No", "No", "No"),
    3 -> Seq("9", "13", "17", "19", "No", "No", "No", "No", "No"),
    4 -> Seq("7", "11", "15", "18", "20", "No", "No", "No", "No"),
    5 -> Seq("5", "9", "13", "17", "19", "No", "No", "No", "No"),
    6 -> Seq("3", "7", "11", "15", "18", "20", "No", "No", "No"),
    7 -> Seq("2", "5", "9", "13", "17", "19", "No", "No", "No"),
    8 -> Seq("T", "3", "7", "11", "15", "18", "20", "No", "No"),
    9 -> Seq("T", "2", "5", "9", "13", "17", "19", "No", "No"),
    10 -> Seq("T", "T", "3", "7", "11", "15", "18", "20", "No"),
    11 -> Seq("D", "T", "2", "5", "9", "13", "17", "19", "No"),
    12 -> Seq("D", "T", "T", "3", "7", "11", "15", "18", "20"),
    13 -> Seq("D", "D", "T", "2", "5", "9", "13", "17", "19"),
    14 -> Seq("D", "D", "T", "T", "3", "7", "11", "15", "18"),
    15 -> Seq("D", "D", "D", "T", "2", "5", "9", "13", "17"),
    16 -> Seq("D", "D", "D", "T", "T", "3", "7", "11", "15"),
    17 -> Seq("D", "D", "D", "D", "T", "2", "5", "9", "13"),
    18 -> Seq("D", "D", "D", "D", "T", "T", "3", "7", "11"),
    19 -> Seq("D", "D", "D", "D", "D", "T", "2", "5", "9"),
    20 -> Seq("D", "D", "D", "D", "D", "T", "T", "3", "7"),
  )

}
