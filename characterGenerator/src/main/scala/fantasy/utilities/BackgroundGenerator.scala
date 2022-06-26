package fantasy.utilities
import fantasy.utilities.Races._

sealed trait Nationality {
  def niceString(): String = {
    this.toString.replace("()", "")
  }
}
case object Karameikos extends Nationality
case object Ylaruam extends Nationality
case object Glantri extends Nationality
case object Ierendi extends Nationality
case object Alfheim extends Nationality
case object Rockhome extends Nationality
case object NorthernReaches extends Nationality
case object FiveShires extends Nationality
case object Minrothad extends Nationality
case object Thar extends Nationality
case object Darokin extends Nationality
case object Ethengar extends Nationality
case object ShadowLands extends Nationality
case object Altruaghin extends Nationality
case object Alphatia extends Nationality
case object Thyatis extends Nationality
case object Wildlands extends Nationality

sealed trait FamilyWealth {
  def niceString(): String = {
    this.toString.replace("()", "")
  }
}
case class Poor() extends FamilyWealth
case class BelowAverage() extends FamilyWealth {
  override def toString = "Below Average"
}
case class Average() extends FamilyWealth
case class WellToDo() extends FamilyWealth
{
  override def toString = "Well To Do"
}
case class Wealthy() extends FamilyWealth
case class VeryWealthy() extends FamilyWealth {
  override def toString= "Very Wealthy"
}



sealed abstract class Background(race: Race) {
  val wealthModifier: Int = 0
  val familyWealth: FamilyWealth = {
    val random = Roller.randomInt(100) + wealthModifier

    if(random < 20)
      Poor()
    else if(random < 40)
      BelowAverage()
    else if(random < 60)
      Average()
    else if(random < 80)
      WellToDo()
    else if(random < 95)
      Wealthy()
    else
      VeryWealthy()
  }
  val nationality: Nationality = {
    val random = Roller.randomInt(100)

    race match {
      case Human =>
        if(random < 15)
          Karameikos
        else if(random < 20)
          Ylaruam
        else if(random < 30)
          Glantri
        else if(random < 35)
          Ierendi
        else if(random < 36)
          Alfheim
        else if(random < 37)
          Rockhome
        else if(random < 43)
          NorthernReaches
        else if(random < 44)
          FiveShires
        else if(random < 49)
          Minrothad
        else if(random < 50)
          Thar
        else if(random < 65)
          Darokin
        else if(random < 70)
          Ethengar
        else if(random < 71)
          ShadowLands
        else if(random < 76)
          Altruaghin
        else if(random < 85)
          Alphatia
        else if(random < 95)
          Thyatis
        else
          Wildlands
      case Elf =>
        if(random < 2)
          Karameikos
        else if(random < 4)
          Ylaruam
        else if(random < 14)
          Glantri
        else if(random < 15)
          Ierendi
        else if(random < 65)
          Alfheim
        else if(random < 66)
          Rockhome
        else if(random < 67)
          NorthernReaches
        else if(random < 68)
          FiveShires
        else if(random < 69)
          Minrothad
        else if(random < 70)
          Thar
        else if(random < 75)
          Darokin
        else if(random < 71)
          Ethengar
        else if(random < 80)
          ShadowLands
        else if(random < 81)
          Altruaghin
        else if(random < 84)
          Alphatia
        else if(random < 90)
          Thyatis
        else
          Wildlands
      case Dwarf =>
        if(random < 2)
          Karameikos
        else if(random < 4)
          Ylaruam
        else if(random < 5)
          Glantri
        else if(random < 15)
          Ierendi
        else if(random < 16)
          Alfheim
        else if(random < 66)
          Rockhome
        else if(random < 67)
          NorthernReaches
        else if(random < 68)
          FiveShires
        else if(random < 69)
          Minrothad
        else if(random < 70)
          Thar
        else if(random < 75)
          Darokin
        else if(random < 71)
          Ethengar
        else if(random < 80)
          ShadowLands
        else if(random < 81)
          Altruaghin
        else if(random < 84)
          Alphatia
        else if(random < 90)
          Thyatis
        else
          Wildlands
      case Halfling => Darokin
        if(random < 2)
          Karameikos
        else if(random < 4)
          Ylaruam
        else if(random < 5)
          Glantri
        else if(random < 15)
          Ierendi
        else if(random < 16)
          Alfheim
        else if(random < 17)
          Rockhome
        else if(random < 18)
          NorthernReaches
        else if(random < 68)
          FiveShires
        else if(random < 69)
          Minrothad
        else if(random < 70)
          Thar
        else if(random < 75)
          Darokin
        else if(random < 71)
          Ethengar
        else if(random < 80)
          ShadowLands
        else if(random < 81)
          Altruaghin
        else if(random < 84)
          Alphatia
        else if(random < 90)
          Thyatis
        else
          Wildlands
      case HalfElf =>
        if(random < 10)
          Karameikos
        else if(random < 15)
          Ylaruam
        else if(random < 30)
          Glantri
        else if(random < 35)
          Ierendi
        else if(random < 55)
          Alfheim
        else if(random < 56)
          Rockhome
        else if(random < 60)
          NorthernReaches
        else if(random < 61)
          FiveShires
        else if(random < 65)
          Minrothad
        else if(random < 66)
          Thar
        else if(random < 75)
          Darokin
        else if(random < 80)
          Ethengar
        else if(random < 90)
          ShadowLands
        else if(random < 91)
          Altruaghin
        else if(random < 93)
          Alphatia
        else if(random < 98)
          Thyatis
        else
          Wildlands

      case HalfOrc =>
        if(random < 5)
          Karameikos
        else if(random < 10)
          Ylaruam
        else if(random < 15)
          Glantri
        else if(random < 20)
          Ierendi
        else if(random < 21)
          Alfheim
        else if(random < 22)
          Rockhome
        else if(random < 27)
          NorthernReaches
        else if(random < 28)
          FiveShires
        else if(random < 33)
          Minrothad
        else if(random < 60)
          Thar
        else if(random < 65)
          Darokin
        else if(random < 70)
          Ethengar
        else if(random < 71)
          ShadowLands
        else if(random < 76)
          Altruaghin
        else if(random < 81)
          Alphatia
        else if(random < 86)
          Thyatis
        else
          Wildlands
    }
  }
  def occupation(): String = {
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
      "Architect"
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
      "Vintner"
    else if(random < 85)
      "Gambler"
    else if(random < 90)
      "Astrologer"
    else
      "Diplomat"
  }

  def niceString(): String = {
    this.toString.replace("()", "")
  }
}

sealed abstract class Commoner(race: Race) extends Background(race) {
  override def occupation(): String = {
    val random = Roller.randomInt(100)
    if (random < 10)
      "Vagabond"
    else if (random < 55)
      "Farmer"
    else if (random < 60)
      "Tinker"
    else if (random < 65)
      "Miner"
    else if (random < 70)
      "Woodsman"
    else if (random < 75)
      "Sailor"
    else if (random < 85)
      "Fisherman"
    else if (random < 95)
      "Smith"
    else
      "Solider"
  }
  override def toString: String = "Commoner"
}
sealed abstract class Freeman(race: Race) extends Background(race) {
  override def toString: String = "Freeman"
}
sealed abstract class Clergy(race: Race) extends Background(race) {
  override def toString: String = "Clergy"
  override def occupation(): String = {
    "Clergy"
  }
}
sealed abstract class Genteel(race: Race) extends Background(race) {
  override def toString: String = "Genteel"
}
sealed abstract class Nobel(race: Race) extends Background(race) {
  override def toString: String = "Nobel"
}
sealed abstract class Royalty(race: Race) extends Background(race) {
  override def toString: String = "Royality"
}

case class Serf(race: Race) extends Commoner(race) {
  override val wealthModifier: Int = -60
  override def toString: String = "Commoner/Serf"
}
case class Peasant(race: Race) extends Commoner(race) {
  override val wealthModifier: Int = -40
  override def toString: String = "Commoner/Peasant"
}

case class Farmer(race: Race) extends Freeman(race) {
  override val wealthModifier: Int = -10
  override def occupation(): String = {
    "Farmer"
  }
  override def toString: String = "Freeman"
}


case class Craftsman(race: Race) extends Freeman(race) {
  override val wealthModifier: Int = -5
  override def occupation(): String = {
    val random = Roller.randomInt(100)
    if (random < 5)
      "Scribe"
    else if (random < 10)
      "Seaman"
    else if (random < 15)
      "Carpenter"
    else if (random < 20)
      "Animal Trainer"
    else if (random < 25)
      "Shipwright"
    else if (random < 30)
      "Mason"
    else if (random < 35)
      "Fisherman"
    else if (random < 40)
      "Tailor"
    else if (random < 45)
      "Fletcher"
    else if (random < 50)
      "Cobbler"
    else if (random < 55)
      "Weaver"
    else if (random < 60)
      "Baker"
    else if (random < 65)
      "Inn Keeper"
    else if (random < 70)
      "Jeweler"
    else if (random < 75)
      "Armorer"
    else if (random < 80)
      "Bowyer"
    else if (random < 85)
      "Jeweler"
    else if (random < 90)
      "Explorer"
    else if (random < 95)
      "Army Officer"
    else
      "Navel Officer"
  }
  override def toString: String = "Freeman/Craftsman"
}


case class Merchant(race: Race) extends Freeman(race) {
  override def occupation(): String = {
    val random = Roller.randomInt(100)
    if (random < 10)
      "Apprentice"
    else if (random < 30)
      "Peddler"
    else if (random < 50)
      "Trader"
    else if (random < 70)
      "Dealer"
    else if (random < 90)
      "Senior Merchant"
    else if (random < 98)
      "Magnate"
    else
      "Merchant Price"
  }
  override def toString: String = "Freeman"
}

case class Priest(race: Race) extends Clergy(race) {
  override def toString: String = "Priest"
}
case class Curate(race: Race) extends Clergy(race)  {
  override def toString: String = "Curate"
}
case class Canon(race: Race) extends Clergy(race) {
  override val wealthModifier: Int = 10
  override def toString: String = "Canon"
}
case class Patriarch(race: Race) extends Clergy(race) {
  override val wealthModifier: Int = 20
  override def toString: String = "Patriarch"
}
case class HighPriest(race: Race) extends Clergy(race) {
  override val wealthModifier: Int = 30
  override def toString: String = "High Priest"
}

case class Vassal(race: Race) extends Genteel(race) {
  override def toString: String = "(race: Race)Genteel"
}
case class Knight(race: Race) extends Genteel(race) {
  override val wealthModifier: Int = 10
  override def toString: String = "Genteel"
}
case class MerchantPrince(race: Race) extends Genteel(race) {
  override def toString: String = "Genteel"
  override val wealthModifier: Int = 40
}

case class Baron(race: Race) extends Nobel(race) {
  override def toString: String = "Nobel/Baron"
  override val wealthModifier: Int = 10
}
case class Count(race: Race) extends Nobel(race) {
  override def toString: String = "Nobel/Cont"
  override val wealthModifier: Int = 20
}
case class Marquis(race: Race) extends Nobel(race) {
  override def toString: String = "Nobel/Marquis"
  override val wealthModifier: Int = 30
}
case class Duke(race: Race) extends Nobel(race) {
  override def toString: String = "Nobel/Duke"
  override val wealthModifier: Int = 40
}

case class DistantRelation(race: Race) extends Royalty(race) {
  override def toString: String = "Royalty/ Distant Relation"
  override val wealthModifier: Int = 20
}

case class ThirdCousin(race: Race) extends Royalty(race) {
  override def toString: String = "Royalty/3rd Cousin"
  override val wealthModifier: Int = 30
}

case class SecondCousin(race: Race) extends Royalty(race) {
  override def toString: String = "Royalty/2nd Cousin"
  override val wealthModifier: Int = 40
}

case class Cousin(race: Race) extends Royalty(race) {
  override def toString: String = "Royalty/Cousin"
  override val wealthModifier: Int = 50
}


object BackgroundGenerator {

  def getBackground(race: Race): Background = {
    val random1 = Roller.randomInt(1000)
    val random2 = Roller.randomInt(100)

    val background = if (random1 < 400) {
      //Commoner
      if (random2 < 30)
        Serf(race)
      else
        Peasant(race)
    } else if (random1 < 800) {
      //Freeman
      if (random2 < 33)
        Farmer(race)
      else if (random2 < 66)
        Craftsman(race)
      else
        Merchant(race)
    } else if (random1 < 900) {
      //Clergy
      if (random2 < 25)
        Priest(race)
      else if (random2 < 75)
        Curate(race)
      else if(random2 < 90)
        Canon(race)
      else if(random2 < 98)
        Patriarch(race)
      else
        HighPriest(race)
    } else if (random1 < 990) {
      //Genteel
      if (random2 < 50)
        Vassal(race)
      else
        Knight(race)
    } else if (random1 < 998) {
      //Nobel
      if (random2 < 50)
        Baron(race)
      else if (random2 < 90)
        Count(race)
      else if(random2 < 98)
        Marquis(race)
      else
        Duke(race)
    } else {
      //Royalty
      if (random2 < 50)
        DistantRelation(race)
      else if (random2 < 75)
        ThirdCousin(race)
      else if (random2 < 98)
        SecondCousin(race)
      else
        Cousin(race)
    }

    background
  }

}
