package fantasy.utilities

import fantasy.utilities.Races._

object Background2 {

  sealed trait Nationality
  case class Karameikos() extends Nationality
  case class Ylaruam() extends Nationality
  case class Glantri() extends Nationality
  case class Ierendi() extends Nationality
  case class Alfheim() extends Nationality
  case class Rockhome() extends Nationality
  case class NorthernReaches() extends Nationality
  case class FiveShires() extends Nationality
  case class Minrothad() extends Nationality
  case class Thar() extends Nationality
  case class Darokin() extends Nationality
  case class Ethengar() extends Nationality
  case class ShadowLands() extends Nationality
  case class Altruaghin() extends Nationality
  case class Alphatia() extends Nationality
  case class Thyatis() extends Nationality
  case class Wildlands() extends Nationality

  sealed trait FamilyWealth
  case class Poor() extends FamilyWealth
  case class BelowAverage() extends FamilyWealth
  case class Average() extends FamilyWealth
  case class WellToDo() extends FamilyWealth
  case class Wealthy() extends FamilyWealth
  case class VeryWealthy() extends FamilyWealth



  sealed trait SocialClass {
    val wealthModifier: Int = 0
    def familyWealth: FamilyWealth = {
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
    def nationality(race: Race): Nationality = {
      val random = Roller.randomInt(100)

      race match {
        case _:Human =>
          if(random < 15)
            Karameikos()
          else if(random < 20)
            Ylaruam()
          else if(random < 30)
            Glantri()
          else if(random < 35)
            Ierendi()
          else if(random < 36)
            Alfheim()
          else if(random < 37)
            Rockhome()
          else if(random < 43)
            NorthernReaches()
          else if(random < 44)
            FiveShires()
          else if(random < 49)
            Minrothad()
          else if(random < 50)
            Thar()
          else if(random < 65)
            Darokin()
          else if(random < 70)
            Ethengar()
          else if(random < 71)
            ShadowLands()
          else if(random < 76)
            Altruaghin()
          else if(random < 85)
            Alphatia()
          else if(random < 95)
            Thyatis()
          else
            Wildlands()
        case _:Elf =>
          if(random < 2)
            Karameikos()
          else if(random < 4)
            Ylaruam()
          else if(random < 14)
            Glantri()
          else if(random < 15)
            Ierendi()
          else if(random < 65)
            Alfheim()
          else if(random < 66)
            Rockhome()
          else if(random < 67)
            NorthernReaches()
          else if(random < 68)
            FiveShires()
          else if(random < 69)
            Minrothad()
          else if(random < 70)
            Thar()
          else if(random < 75)
            Darokin()
          else if(random < 71)
            Ethengar()
          else if(random < 80)
            ShadowLands()
          else if(random < 81)
            Altruaghin()
          else if(random < 84)
            Alphatia()
          else if(random < 90)
            Thyatis()
          else
            Wildlands()
        case _:Dwarf => Darokin()
        case _:Halfling => Darokin()
        case _:HalfElf => Darokin()
        case _:HalfOrc => Darokin()
      }
    }

  }

  sealed abstract class Commoner extends SocialClass
  sealed abstract class Freeman extends SocialClass
  sealed abstract class Clergy extends SocialClass
  sealed abstract class Genteel extends SocialClass
  sealed abstract class Nobel extends SocialClass
  sealed abstract class Royalty extends SocialClass

  case class Serf() extends Commoner {
    override val wealthModifier: Int = -60
  }
  case class Peasant() extends Commoner {
    override val wealthModifier: Int = -40
  }

  case class Farmer() extends Freeman {
    override val wealthModifier: Int = -10
  }

  case class Craftsman() extends Freeman {
    override val wealthModifier: Int = -5
  }
  case class Merchant() extends Freeman

  case class Priest() extends Clergy
  case class Curate() extends Clergy
  case class Canon() extends Clergy {
    override val wealthModifier: Int = 10
  }
  case class Patriarch() extends Clergy {
    override val wealthModifier: Int = 20
  }
  case class HighPriest() extends Clergy {
    override val wealthModifier: Int = 30
}

  case class Vassal() extends Genteel
  case class Knight() extends Genteel {
    override val wealthModifier: Int = 10
  }
  case class MerchantPrince() extends Genteel {
    override val wealthModifier: Int = 40
  }

  case class Baron() extends Nobel {
    override val wealthModifier: Int = 10
  }
  case class Count() extends Nobel {
    override val wealthModifier: Int = 20
  }
  case class Marquis() extends Nobel {
    override val wealthModifier: Int = 30
  }
  case class Duke() extends Nobel {
    override val wealthModifier: Int = 40
  }

  case class DistantRelation() extends Royalty {
    override val wealthModifier: Int = 20
  }

  case class ThirdCousin() extends Royalty {
    override val wealthModifier: Int = 30
  }

  case class SecondCousin() extends Royalty {
    override val wealthModifier: Int = 40
  }

  case class Cousin() extends Royalty {
    override val wealthModifier: Int = 50
  }
}

object BackgroundGenerator2 {



}
