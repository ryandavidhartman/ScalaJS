package basic.fantasy.equipment

import basic.fantasy.Roller
import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.CharacterClasses.{CharacterClass, Cleric, Fighter, FighterMagicUser, MagicUser, MagicUserThief, Thief}


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

  sealed trait WandStaffOrRod extends MagicItem {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isMagicUser
  }

  // Miscellaneous
  case object AmuletOfProofAgainstDetectionAndLocation extends Miscellaneous {
     override def toString: String = "Amulet of Proof against Detection and Location"
  }
  case object BagOfDevouring extends Miscellaneous {
    override def toString: String = "Bag of Devouring"
  }
  case object BagOfHolding extends Miscellaneous {
    override def toString: String = "Bag of Holding"
  }
  case object BootsOfLevitation extends Miscellaneous {
    override def toString: String = "Boots of Levitation"
  }
  case object BootsOfSpeed extends Miscellaneous {
    override def toString: String = "Boots of Speed"
  }
  case object BootsOfTravelingAndLeaping extends Miscellaneous {
    override def toString: String = "Boots of Traveling and Leaping"
  }
  case object BowlCommandingWaterElementals extends Miscellaneous {
    override def toString: String = "Bowl Commanding Water Elementals"
  }
  case object BrazierCommandingFireElementals extends Miscellaneous {
    override def toString: String = "Brazier Commanding Fire Elementals"
  }
  case object BroomofFlying extends Miscellaneous {
    override def toString: String = "Commanding Air Elementals"
  }
  case object CenserCommandingAirElementals extends Miscellaneous {
    override def toString: String = "Commanding Air Elementals"
  }
  case object CloakOfDisplacement extends Miscellaneous {
    override def toString: String = "Cloak of Displacement"
  }
  case object CrystalBall extends Miscellaneous {
    override def toString: String = "Crystal Ball"
  }
  case object CrystalBallWithClairaudience extends Miscellaneous {
    override def toString: String = "Crystal Ball with Clairaudience"
  }
  case object DrumsOfPanic extends Miscellaneous {
    override def toString: String = "Drums of Panic"
  }
  case object EfreetiBottle extends Miscellaneous {
    override def toString: String = "Efreeti Bottle"
  }
  case object ElvenBoots extends Miscellaneous {
    override def toString: String = "Elven Boots"
  }
  case object ElvenCloak extends Miscellaneous {
    override def toString: String = "Elven Cloak"
  }
  case object FlyingCarpet extends Miscellaneous {
    override def toString: String = "Flying Carpet"
  }
  case object GauntletsOfOgrePower extends Miscellaneous {
    override def toString: String = "Gauntlets of Ogre Power"
  }
  case object GirdleOfGiantStrength extends Miscellaneous {
    override def toString: String = "Girdle of Giant Strength"
  }
  case object HelmOfReadingLanguagesAndMagic extends Miscellaneous {
    override def toString: String = "Helm of Reading Languages and Magic"
  }
  case object HelmOfTelepathy extends Miscellaneous {
    override def toString: String = "Helm of Telepathy"
  }
  case object HelmOfTeleportation extends Miscellaneous {
    override def toString: String = "Helm of Teleportation"
  }
  case object HornOfBlasting extends Miscellaneous {
    override def toString: String = "Horn of Blasting"
  }
  case object HornOfDoom extends Miscellaneous {
    override def toString: String = "Horn of Doom"
  }
  case object MedallionOfESP extends Miscellaneous {
    override def toString: String = "Medallion of ESP"
  }
  case object MirrorOfLifeTrapping extends Miscellaneous {
    override def toString: String = "Mirror of Life Trapping"
  }
  case object RopeOfClimbing extends Miscellaneous {
    override def toString: String = "Rope of Climbing"
  }
  case object ScarabOfProtection extends Miscellaneous {
    override def toString: String = "Scarab of Protection"
  }
  case object StoneCommandingEarthElementals extends Miscellaneous {
    override def toString: String = "Stone Commanding Earth Elementals"
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
  case object AnimalControl extends Ring {
    override def toString: String = s"Ring of Animal Control"
  }
  case object Delusion extends Ring
  case object DjinniSummoning extends Ring {
    override def toString: String = s"Ring of Djinni Summoning"
  }
  case object Ear extends Ring
  case object ElementalAdaptation extends Ring {
    override def toString: String = s"Ring of Elemental Adaptation"
  }
  case object FireResistanceRing extends Ring {
    override def toString: String = s"Ring of Fire Resistance"
  }
  case object Holiness extends Ring {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isCleric
  }
  case object HumanControl extends Ring {
    override def toString: String = s"Ring of Human Control"
  }
  case object Invisibility extends Ring
  case object LifeProtection extends Ring {
    override def toString: String = s"Ring of Life Protection"
  }
  case object Memory extends Ring {
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isSpellCaster
  }
  case object PlantControl extends Ring {
    override def toString: String = s"Ring of Plant Control"
  }
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
    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isCleric
  }
  case object StaffOfPower extends WandStaffOrRod {
    override def toString: String = s"Staff Of Power"
  }
  case object StaffOfStriking extends WandStaffOrRod {
    override def toString: String = s"Staff Of Striking"
  }
  case object StaffOfWizardry extends WandStaffOrRod {
    override def toString: String = s"Staff Of Wizardry"

    override def usable(characterClass: CharacterClass, race: Race): Boolean = characterClass.isMagicUser
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

  def getPotion(characterClass: CharacterClass, race: Race, level: Int): Potion = ???

  def getMiscellaneous(characterClass: CharacterClass, race: Race, level: Int): Miscellaneous = ???

  def getRing(characterClass: CharacterClass, race: Race, level: Int): Ring = {
    val roll = Roller.randomInt(100)
    val item: Ring =
      if(roll < 5) AnimalControl
      else if (roll < 10) Delusion
      else if (roll < 15) DjinniSummoning
      else if (roll < 20) Ear
      else if (roll < 25) ElementalAdaptation
      else if (roll < 30) FireResistanceRing
      else if (roll < 35) Holiness
      else if (roll < 40) HumanControl
      else if (roll < 45) Invisibility
      else if (roll < 50) LifeProtection
      else if (roll < 55) Memory
      else if (roll < 60) PlantControl
      else if (roll < 65) Quickness
      else Protection(level)

    if(item.usable(characterClass, race)) item else getRing(characterClass, race, level)

  }

  def getWandStaffOrRod(characterClass: CharacterClass, race: Race, level: Int):  WandStaffOrRod = {
    val roll = Roller.randomInt(100)
    val item: WandStaffOrRod =
      if(roll < 5) RodOfCancellation
      else if (roll < 10) SnakeStaff
      else if (roll < 15) StaffOfCommanding
      else if (roll < 20) StaffOfHealing
      else if (roll < 25) StaffOfPower
      else if (roll < 30) SnakeStaff
      else if (roll < 35) StaffOfCommanding
      else if (roll < 40) StaffOfHealing
      else if (roll < 45) StaffOfPower
      else if (roll < 50) StaffOfStriking
      else if (roll < 55) StaffOfWizardry
      else if (roll < 60) WandOfCold
      else if (roll < 65) WandOfEnemyDetection
      else if (roll < 70) WandOfFear
      else if (roll < 75) WandOfFireballs
      else if (roll < 80) WandOfIllusion
      else if (roll < 85) WandOfLightningBolts
      else if (roll < 90) WandOfMagicDetection
      else if (roll < 95) WandOfParalyzation
      else WandOfTrapDetection

    if(item.usable(characterClass, race)) item else getWandStaffOrRod(characterClass, race, level)
  }

  def getMagicItem(characterClass: CharacterClass, race: Race, level: Int): MagicItem = {
    val roll = Roller.randomInt(100)
    characterClass match {
      case c if c.isSpellCaster =>
        if(roll < 25) getPotion(characterClass, race, level)
        else if(roll < 50) getMiscellaneous(characterClass, race, level)
        else if(roll < 75) getRing(characterClass, race, level)
        else getWandStaffOrRod(characterClass, race, level)
      case _ =>
        if(roll < 33) getPotion(characterClass, race, level)
        else if(roll < 66) getMiscellaneous(characterClass, race, level)
        else getRing(characterClass, race, level)
    }
  }

  def getMagicItems(characterClass: CharacterClass, race: Race, level: Int): Set[MagicItem] = {
    val numItems: Int = level/5

    (0 to numItems).map(_ => getMagicItem(characterClass, race, level)).toSet
  }

}
