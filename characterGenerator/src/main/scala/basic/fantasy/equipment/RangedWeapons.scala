package basic.fantasy.equipment

import basic.fantasy.Roller
import basic.fantasy.backgrounds.Races.{Dwarf, Elf, HalfElf, HalfOrc, Halfling, Human, Race}
import basic.fantasy.characterclass.CharacterClasses.{CharacterClass, Cleric, Fighter, FighterMagicUser, MagicUser, MagicUserThief, Thief}
import basic.fantasy.equipment.Weapons.{Large, Medium, Small, WeaponSize}

object RangedWeapons {

  sealed trait Ammo {
    def name: String
    def magicBonus: Int
    def count: Int

    def ammoString: String = {
      if(magicBonus > 0)
        s", ammo: $name (+$magicBonus) x($count)"
      else
        s", ammo: $name x($count)"
    }
  }

  case class Arrow(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Arrow"
  }

  case class SilverArrow(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Silver Arrow"
  }

  case class Quarrel(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Quarrel"
  }

  case class SilverQuarrel(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Silver Quarrel"
  }

  case class Bullet(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Bullet"
  }

  case class SilverBullet(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Silver Bullet"
  }

  case class Stone(count:Int, magicBonus:Int = 0) extends Ammo{
    val name = "Stone"
  }

  sealed trait RangedWeapon{
    def name: String
    def size: WeaponSize
    def baseCost: Int
    def weight: Int
    def damage: String
    def ammo: Option[Ammo] = None
    def magicBonus: Int = 0

    def cost: Int = if(magicBonus > 1)
      baseCost + (1000 * Math.pow(4,magicBonus-1)).toInt
    else
      baseCost

    override def toString: String = {
      val magicString = if(magicBonus > 0) s" (+$magicBonus)" else ""
      val magicDamage = if(magicBonus > 0) s" +$magicBonus" else ""
      val ammoString = ammo.map(_.ammoString).getOrElse("")
      s"Ranged: $name$magicString, dmg: $damage$magicDamage$ammoString, weight: $weight"
    }
  }

  case class ShortBow(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Short Bow"
    val size: WeaponSize = Medium
    val baseCost: Int = 25
    val weight: Int = 2
    val damage: String = "1d6"
  }

  case class LongBow(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Long Bow"
    val size: WeaponSize = Large
    val baseCost: Int = 60
    val weight: Int = 3
    val damage: String = "1d8"
  }

  case class LightCrossbow(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Light Crossbow"
    val size: WeaponSize = Medium
    val baseCost: Int = 30
    val weight: Int = 7
    val damage: String = "1d6"
  }

  case class HeavyCrossbow(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Heavy Crossbow"
    val size: WeaponSize = Large
    val baseCost: Int = 50
    val weight: Int = 14
    val damage: String = "1d8"
  }

  case class HandCrossbow(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Hand Crossbow"
    val size: WeaponSize = Small
    val baseCost: Int = 150
    val weight: Int = 3
    val damage: String = "1d3"
  }

  case class Sling(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Sling"
    val size: WeaponSize = Small
    val baseCost: Int = 1
    val weight: Int = 0
    val damage: String = "1d4"
  }

  case class Blowgun(override val magicBonus: Int = 0, override val ammo: Option[Ammo] = None) extends RangedWeapon{
    val name: String = "Blowgun"
    val size: WeaponSize = Medium
    val baseCost: Int = 2
    val weight: Int = 1
    val damage: String = "1d3"
  }

  case class Bola(override val magicBonus: Int = 0) extends RangedWeapon{
    val name: String = "Bola"
    val size: WeaponSize = Small
    val baseCost: Int = 2
    val weight: Int = 2
    val damage: String = "1d3"
  }

  case class Dart(override val magicBonus: Int = 0) extends RangedWeapon{
    val name: String = "Dart"
    val size: WeaponSize = Small
    val baseCost: Int = 1
    val weight: Int = 0
    val damage: String = "1d3"
  }

  case class ThrowingKnife(override val magicBonus: Int = 0) extends RangedWeapon{
    val name: String = "Throwing Knife"
    val size: WeaponSize = Small
    val baseCost: Int = 2
    val weight: Int = 0
    val damage: String = "1d3"
  }

  case class Javelin(override val magicBonus: Int = 0) extends RangedWeapon{
    val name: String = "Javelin"
    val size: WeaponSize = Medium
    val baseCost: Int = 2
    val weight: Int = 2
    val damage: String = "1d4"
  }

  def getSling(level: Int): RangedWeapon = {
    val weaponMagicBonus: Int = Roller.randomMagicWeaponBonus(level)
    val ammoMagicBonus: Int = Roller.randomMagicAmmoBonus(level)
    val ammoCount = Roller.randomInt(30)+1
    val ammo = Bullet(ammoCount, ammoMagicBonus)
    Sling(weaponMagicBonus, Some(ammo))

  }

  def getRangedWeapon(characterClass: CharacterClass, level: Int, race: Race): RangedWeapon = {
    val maxSize = race match {
      case Human => Large
      case Elf => Large
      case Dwarf => Medium
      case Halfling => Medium
      case HalfElf => Large
      case HalfOrc => Large
    }

    val roll = Roller.randomInt(100)

    characterClass match {
      case Cleric => getSling(level)
      case Fighter => getSling(level)
      case FighterMagicUser => getSling(level)
      case MagicUser => getSling(level)
      case MagicUserThief => getSling(level)
      case Thief => getSling(level)
    }

  }


}
