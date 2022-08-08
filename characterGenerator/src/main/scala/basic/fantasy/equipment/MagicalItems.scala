package basic.fantasy.equipment

import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.CharacterClasses.CharacterClass

object MagicalItems {

  sealed trait MagicItem {
    def usable(characterClass: CharacterClass, race: Race): Boolean = true
  }

  sealed trait Potion extends MagicItem

  sealed trait Miscellaneous extends MagicItem

  sealed trait Ring extends MagicItem {
    override def toString: String = s"Ring of ${this.getClass}"
  }

  sealed trait Scroll extends MagicItem

  sealed trait WandStaffOrRod extends MagicItem


  // Rings
  case object AnimalControl extends Ring

  case object Delusion extends Ring

  case object DjinniSummoning extends Ring

  case object Ear extends Ring

  case object ElementalAdaptation extends Ring

  case object FareResistance extends Ring

  case object Holiness extends Ring {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isCleric
  }

  case object HumanControl extends Ring

  case object Invisibility extends Ring

  case object LifeProtection extends Ring

  case object Memory extends Ring {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isSpellCaster
  }

  case object PlantControl extends Ring

  case class Protection(level: Int) extends Ring {
    override def toString: String = s"Ring of Protection +{level/5}"
  }

  case object Quickness extends Ring

}
