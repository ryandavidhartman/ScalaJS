package basic.fantasy.equipment

import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.CharacterClasses.CharacterClass


object MagicalItems {

  sealed trait MagicItem {
    def usable(characterClass: CharacterClass, race: Race): Boolean = true
  }

  sealed trait Potion extends MagicItem {
    override def toString: String = s"Potion of ${this.getClass}"
  }

  sealed trait Miscellaneous extends MagicItem

  sealed trait Ring extends MagicItem {
    override def toString: String = s"Ring of ${this.getClass}"
  }

  sealed trait Scroll extends MagicItem

  sealed trait WandStaffOrRod extends MagicItem {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isMagicUser
  }

  // Potions
  case object Clairaudience extends Potion {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isSpellCaster
  }
  case object Clairvoyance extends Potion {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isSpellCaster
  }

  case object ColdResistance extends Potion {
    override def toString: String = s"Potion of Cold Resistance"
  }
  case object ControlAnimal extends Potion {
    override def toString: String = s"Potion of Animal Control"
  }
  case object ControlDragon extends Potion {
    override def toString: String = s"Potion of Dragon Control"
  }
  case object ControlGiant extends Potion {
    override def toString: String = s"Potion of Giant Control"
  }
  case object ControlHuman extends Potion {
    override def toString: String = s"Potion of Human Control"
  }
  case object ControlPlant extends Potion {
    override def toString: String = s"Potion of Plant Control"
  }
  case object ControlUndead extends Potion {
    override def toString: String = s"Potion of Undead Control"
  }
  case object DelusionPotion extends Potion {
    override def toString: String = s"Potion of Delusion"
  }
  case object Diminution extends Potion
  case object ESP extends Potion {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isSpellCaster
  }
  case object FireResistance extends Potion {
    override def toString: String = s"Potion of Fire Resistance"
  }
  case object Flying extends Potion
  case object GaseousForm extends Potion {
    override def toString: String = s"Potion of Gaseous From"
  }
  case object GiantStrength extends Potion {
    override def toString: String = s"Potion of Giant Strength"
  }
  case object Growth extends Potion
  case object Healing extends Potion
  case object Heroism extends Potion
  case object InvisibilityPotion extends Potion {
    override def toString: String = s"Potion of Invisibility"
  }
  case object Invulnerability extends Potion
  case object Levitation extends Potion
  case object Longevity extends Potion
  case object Poison extends Potion
  case object PolymorphSelf {
    override def toString: String = s"Potion of Polymorph Self"
  }
  case object Speed extends Potion
  case object TreasureFinding extends Potion {
    override def toString: String = s"Potion of Treasure Finding"
  }


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

  // Wands, Staves and Rods
  case object RodOfCancellation extends WandStaffOrRod {
    override def toString: String = s"Rod Of Cancellation"
  }
  case object SnakeStaff extends WandStaffOrRod {
    override def toString: String = s"Snake Staff"
  }
  case object StaffOfCommanding extends WandStaffOrRod {
    override def toString: String = s"Staff Of Commanding"
  }
  case object StaffOfHealing extends WandStaffOrRod {
    override def toString: String = s"Staff Of Healing"
  }
  case object StaffOfPower extends WandStaffOrRod {
    override def toString: String = s"Staff Of Power"
  }
  case object StaffOfStriking extends WandStaffOrRod {
    override def toString: String = s"Staff Of Striking"
  }
  case object StaffOfWizardry extends WandStaffOrRod {
    override def toString: String = s"Staff Of Wizardry"
  }
  case object WandOfCold extends WandStaffOrRod {
    override def toString: String = s"Wand Of Cold"
  }
  case object WandOfEnemyDetection extends WandStaffOrRod {
    override def toString: String = s"Wand Of Enemy Detection"
  }
  case object WandOfFear extends WandStaffOrRod {
    override def toString: String = s"Wand Of Fear"
  }
  case object WandOfFireballs extends WandStaffOrRod {
    override def toString: String = s"Wand Of Fireballs"
  }
  case object WandOfIllusion extends WandStaffOrRod {
    override def toString: String = s"Wand Of Illusion"
  }
  case object WandOfLightningBolts extends WandStaffOrRod {
    override def toString: String = s"Wand Of Lightning Bolts"
  }
  case object WandOfMagicDetection extends WandStaffOrRod {
    override def toString: String = s"Wand Of Magic Detection"
  }
  case object WandOfParalyzation extends WandStaffOrRod {
    override def toString: String = s"Wand Of Magic Paralyzation"
  }
  case object WandOfPolymorph extends WandStaffOrRod {
    override def toString: String = s"Wand Of Polymorph"
  }
  case object WandOfSecretDoorDetection extends WandStaffOrRod {
    override def toString: String = s"Wand Of Secret Door Detection"
  }
  case object WandOfTrapDetection extends WandStaffOrRod {
    override def toString: String = s"Wand Of Trap Detection"
  }

}
