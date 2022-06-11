package fantasy.utilities

case class Background(socialClass: String, familyWealth: String, backgroundSkills: Seq[String])

object BackgroundGenerator {

  def apply(): Background = {
    val socialClass = getSocialClass()
    val familyWealth = getFamilyWealth(socialClass)
    val backgroundSkills = getOccupations(socialClass, familyWealth).distinct

    Background(socialClass, familyWealth, backgroundSkills)
  }

  def getSocialClass(): String = {
    val random = Roller.randomInt(100)

    if(random < 30)
      "Commoner"
    else if(random < 85)
      "Merchant"
    else if(random < 96)
      "Genteel"
    else
      "Nobel"
  }

  def getFamilyWealth(socialClass: String): String = socialClass match {
    case "Commoner" => getCommonerWealth()
    case "Merchant" => getMerchantWealth()
    case "Genteel" => getGenteelWealth()
    case "Nobel" => getNobelWealth()
  }

  def getOccupations(socialClass: String, familyWealth: String): Seq[String] = socialClass match {
    case "Commoner" => Seq(getGroup1Occupation())
    case "Merchant" =>
      val jobs = Seq(getGroup1Occupation(), getGroup2Occupation())
      if(familyWealth ==  "Very Wealthy")
        getGroup3Occupation() +: jobs
      else
        jobs
    case "Genteel" => familyWealth match {
      case "Below Average" => Seq(getGroup1Occupation(), getGroup2Occupation())
      case "Very Wealthy" => Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation()
      )
      case _ => Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup3Occupation())
    }
    case "Nobel" =>  familyWealth match {
      case "Poor" =>  Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation()
      )
      case "Below Average" =>  Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation()
      )
      case "Average" => Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup1Occupation(), getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation(),
        getGroup3Occupation())
      case "Well-to-do" => Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup1Occupation(), getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation(),
        getGroup3Occupation())
      case "Wealthy" => Seq(getGroup1Occupation(), getGroup1Occupation(),
        getGroup1Occupation(), getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation(),
        getGroup3Occupation())
      case "Very Wealthy" => Seq(getGroup1Occupation(), getGroup1Occupation(), getGroup1Occupation(),
        getGroup1Occupation(), getGroup2Occupation(), getGroup2Occupation(), getGroup3Occupation(),
        getGroup3Occupation())
    }


  }

  def getCommonerWealth(): String = {
    val random = Roller.randomInt(100)

    if(random < 25)
      "Peasant"
    else if(random < 40)
      "Average"
    else if(random < 71)
      "Well-to-do"
    else
      "Wealthy"
  }

  def getMerchantWealth(): String = {
    val random = Roller.randomInt(100)

    if(random < 25)
      "Below Average"
    else if(random < 60)
      "Average"
    else if(random < 80)
      "Well-to-do"
    else if(random < 95)
      "Wealthy"
    else
      "Very Wealthy"
  }

  def getGenteelWealth(): String = {
    val random = Roller.randomInt(100)

    if(random < 20)
      "Below Average"
    else if(random < 65)
      "Average"
    else if(random < 90)
      "Well-to-do"
    else if(random < 95)
      "Wealthy"
    else
      "Very Wealthy"
  }

  def getNobelWealth(): String = {
    val random = Roller.randomInt(100)

    if(random < 20)
      "Poor"
    else if(random < 40)
      "Below Average"
    else if(random < 85)
      "Average"
    else if(random < 90)
      "Well-to-do"
    else if(random < 97)
      "Wealthy"
    else
      "Very Wealthy"
  }

  def getGroup1Occupation(): String = {
    val random = Roller.randomInt(100)

    if(random < 10)
      "Vagabond"
    else if(random < 55)
      "Farmer/Serf"
    else if(random < 60)
      "Tinker"
    else if(random < 65)
      "Miner"
    else if(random < 70)
      "Woodsman"
    else if(random < 75)
      "Sailor"
    else if(random < 85)
      "Fisherman"
    else if(random < 95)
      "Craftsman"
    else if(random < 99)
      "Solider"
    else
      "Adventurer"
  }

  def getGroup2Occupation(): String = {
    val random = Roller.randomInt(100)

    if(random < 35)
      "Normal Merchant"
    else if(random < 60)
      "Independent Craftsman"
    else if(random < 65)
      "Scribe"
    else if(random < 70)
      "Seaman"
    else if(random < 75)
      "Carpenter"
    else if(random < 80)
      "Animal Trainer"
    else if(random < 85)
      "Shipwright"
    else if(random < 95)
      "Master Merchant"
    else if(random < 99)
      "Mason"
    else
      "Adventurer"
  }

  def getGroup3Occupation(): String = {
    val random = Roller.randomInt(100)

    if(random < 2)
      "Assassin/Spytracker"
    else if(random < 5)
      "Sheriff"
    else if(random < 8)
      "Magistrate"
    else if(random < 11)
      "Sage"
    else if(random < 15)
      "Alchemist"
    else if(random < 20)
      "Physician"
    else if(random <25)
      "Artist/Sculpter/Musician"
    else if(random < 30)
      "Engineer"
    else if(random < 40)
      "Soldier"
    else if(random < 45)
      "Interpreter"
    else if(random < 50)
      "Writer"
    else if(random < 55)
      "Astronomer"
    else if(random < 60)
      "Lothario"
    else if(random < 65)
      "Orator/Actor"
    else if(random < 70)
      "Dream Interpreter"
    else if(random < 75)
      "Naturalist"
    else if(random < 80)
      "Navel Office"
    else if(random < 85)
      "Gambler"
    else if(random < 90)
      "Astrologer"
    else
      "Adventurer"
  }



}
