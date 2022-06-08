package fantasy.utilities

object HeightWeightGenerator {

  def getHeight(race: String, gender: String, strength: Int): (String, String) = {

    val (baseHeight, baseWeight) = race match {
      case "Human" =>
        val hMod = (Roller.randomInt(14)-1) + (Roller.randomInt(14)-1)
        val wMod = (Roller.randomInt(5)-1) + (Roller.randomInt(5)-1)
        (54+hMod, 130 + hMod  + wMod)
      case _ => (100, 100)
    }

    val strMod: Double =
      if(strength <= 6)
        0.90
      else if(strength <= 9)
        0.95
      else if(strength < 12)
        1.0
      else if(strength < 17)
        1.05
      else
        1.10

    val (height, weight) =
      if(gender == "Female")
      (baseHeight-6, (baseWeight * strMod).toInt)
    else
      (baseHeight, (1.1* baseWeight * strMod).toInt)


    (inchesToString(height), weight.toString)
  }


  def inchesToString(inches: Int): String = {
    val feet:Int = inches / 12
    val remainder = inches - (12*feet)
    s"""$feet\' $remainder""""
  }

}
