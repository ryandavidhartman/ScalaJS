package basic.fantasy.equipment

import basic.fantasy.Roller
import basic.fantasy.backgrounds.Races.{Dwarf, Elf, HalfElf, HalfOrc, Halfling, Human, Race}
import basic.fantasy.characterclass.CharacterClasses.{CharacterClass, Cleric, Fighter, FighterMagicUser, MagicUser, MagicUserThief, Thief}

object MeleeWeapons {

  sealed trait WeaponSize
  case object Small extends WeaponSize
  case object Medium extends WeaponSize
  case object Large extends WeaponSize

  sealed abstract class MeleeWeapon(
     val baseCost: Int,
     val size: WeaponSize,
     val weight: Int,
     val damage: String,
     val magicBonus: Int = 0
   ) {
    def name: String

    def cost: Int = if(magicBonus > 1)
      baseCost + (1000 * Math.pow(4,magicBonus-1)).toInt
    else
      baseCost

    override def toString: String = {
      val magicString = if(magicBonus > 0) s" (+$magicBonus)" else ""
      val magicDamage = if(magicBonus > 0) s" +$magicBonus" else ""
      s"Melee: $name$magicString, dmg: $damage$magicDamage, weight: $weight"
    }
  }

  //Axes
  case class HandAxe(magic: Int) extends MeleeWeapon(4, Small, 5, "1d6", magic) {
    val name: String = "Hand Axe"
  }

  case class BattleAxe(magic: Int) extends MeleeWeapon(7, Medium, 7, "1d8", magic) {
    val name: String = "Battle Axe"
  }

  case class GreatAxe(magic: Int) extends MeleeWeapon(14, Large, 15, "1d10", magic) {
    val name: String = "Great Axe"
  }

  case class MilitaryPick(magic: Int) extends MeleeWeapon(6, Small, 4, "1d6", magic) {
    val name: String = "Military Pick"
  }

  case class FootmansPick(magic: Int) extends MeleeWeapon(8, Medium, 6, "1d8", magic) {
    val name: String = "Footman's Pick"
  }

  def getAxe(level: Int, maxSize: WeaponSize): MeleeWeapon = {
    val magic: Int = Roller.randomMagicBonus(level)
    val roll = Roller.randomInt(100)

    maxSize match {
      case Small =>
        if(roll < 50)
          HandAxe(magic)
        else
          MilitaryPick(magic)
      case Medium =>
        if(roll < 10)
          HandAxe(magic)
        else if(roll < 80)
          BattleAxe(magic)
        else if(roll < 90)
          MilitaryPick(magic)
        else
          FootmansPick(magic)
      case Large =>
        if(roll < 10)
          HandAxe(magic)
        else if(roll < 55)
          BattleAxe(magic)
        else if(roll < 90 )
          GreatAxe(magic)
        else if(roll < 95)
          MilitaryPick(magic)
        else
          FootmansPick(magic)
    }
  }

  // Daggers
  case class Dagger(magic: Int) extends MeleeWeapon(2, Small, 1, "1d4", magic) {
    val name: String = "Dagger"
  }

  case class DefendingDagger(magic: Int) extends MeleeWeapon(7, Small, 2, "1d4", magic) {
    val name: String = "Defending Dagger"

    override def toString: String = {
      val magicString = if(magicBonus > 0) s" (+$magicBonus)" else ""
      val magicDamage = if(magicBonus > 0) s" +$magicBonus" else ""
      s"Melee: $name$magicString, dmg: $damage$magicDamage OR +1 to melee AC, weight: $weight"
    }
  }

  case class SilverDagger(magic: Int) extends MeleeWeapon(25, Small, 1, "1d4", magic) {
    val name: String = "Silver Dagger"
  }

  def getDagger(level: Int, offHand: Boolean): MeleeWeapon = {
    val magic: Int = Roller.randomMagicBonus(level)
    val roll = Roller.randomInt(100)

    offHand match {
      case false =>
        if(roll < 75)
          Dagger(magic)
        else
          SilverDagger(magic)
      case true =>
        if(roll < 50)
          Dagger(magic)
        else if(roll < 75)
          DefendingDagger(magic)
        else
          SilverDagger(magic)
    }
  }

  // Swords
  case class ShortSword(magic: Int) extends MeleeWeapon(6, Small, 3, "1d6", magic) {
    val name: String = "Short Sword"
  }

  case class Cutlass(magic: Int) extends MeleeWeapon(6, Small, 3, "1d6", magic) {
    val name: String = "Cutlass"
  }

  case class LongSword(magic: Int) extends MeleeWeapon(10, Medium, 4, "1d8", magic) {
    val name: String = "Long Sword"
  }

  case class Scimitar(magic: Int) extends MeleeWeapon(10, Medium, 4, "1d8", magic) {
    val name: String = "Scimitar"
  }

  case class TwoHandedSword(magic: Int) extends MeleeWeapon(18, Large, 10, "1d10", magic) {
    val name: String = "Two-Handed Sword"
  }

  def getSword(level: Int, maxSize: WeaponSize, offHand: Boolean): MeleeWeapon = {

    val magic: Int = Roller.randomMagicBonus(level)
    val roll = Roller.randomInt(100)

    val modifiedMaxSize = if(offHand) Small else maxSize

    modifiedMaxSize match {
      case Small =>
        if(roll < 70)
          ShortSword(magic)
        else
          Cutlass(magic)
      case Medium =>
        if(roll < 40)
          ShortSword(magic)
        else if(roll < 45)
          Cutlass(magic)
        else if(roll < 95)
          LongSword(magic)
        else
          Scimitar(magic)
      case Large =>
        if(roll < 15)
          ShortSword(magic)
        else if(roll < 20)
          Cutlass(magic)
        else if(roll < 70)
          LongSword(magic)
        else if(roll < 75)
          Scimitar(magic)
        else
          TwoHandedSword(magic)
    }
  }

  // Hammer and Maces
  case class WarHammer(magic: Int) extends MeleeWeapon(4, Small, 3, "1d6", magic) {
    val name: String = "War Hammer"
  }

  case class LightMace(magic: Int) extends MeleeWeapon(5, Small, 5, "1d6", magic) {
    val name: String = "Light Mace"
  }

  case class Mace(magic: Int) extends MeleeWeapon(6, Medium, 10, "1d8", magic) {
    val name: String = "Mace"
  }

  case class Morningstar(magic: Int) extends MeleeWeapon(7, Medium, 7, "1d8", magic) {
    val name: String = "Morningstar"
  }

  case class Maul(magic: Int) extends MeleeWeapon(10, Large, 16, "1d10", magic) {
    val name: String = "Maul"
  }

  case class GreatMace(magic: Int) extends MeleeWeapon(10, Large, 16, "1d10", magic) {
    val name: String = "Great Mace"
  }

  def getHammerOrMace(level: Int, maxSize: WeaponSize): MeleeWeapon = {
    val magic: Int = Roller.randomMagicBonus(level)
    val roll = Roller.randomInt(100)

    maxSize match {
      case Small =>
        if(roll < 50)
          WarHammer(magic)
        else
          LightMace(magic)
      case Medium =>
        if(roll < 10)
          HandAxe(magic)
        else if(roll < 80)
          BattleAxe(magic)
        else if(roll < 90)
          MilitaryPick(magic)
        else
          FootmansPick(magic)
      case Large =>
        if(roll < 10)
          HandAxe(magic)
        else if(roll < 55)
          BattleAxe(magic)
        else if(roll < 90 )
          GreatAxe(magic)
        else if(roll < 95)
          MilitaryPick(magic)
        else
          FootmansPick(magic)
    }
  }

  // Spears and Polearms
  def getSpearOrPolearm(level: Int, maxSize: WeaponSize): MeleeWeapon = ???

  // Chain and Flail
  def getChainOrFlail(level: Int, maxSize: WeaponSize): MeleeWeapon = ???

  // Other Weapons
  def getOtherWeapons(level: Int, maxSize: WeaponSize): MeleeWeapon = ???

  // Magic user Weapons
  def getMageWeapons(level: Int, maxSize: WeaponSize): MeleeWeapon = ???

  def getMeleeWeapon(characterClass: CharacterClass, level: Int, race: Race, hasShield: Boolean): MeleeWeapon = {

    val maxSize = race match {
      case Human => if (hasShield) Medium else Large
      case Elf => if (hasShield) Medium else Large
      case Dwarf => if (hasShield) Small else Medium
      case Halfling => if (hasShield) Small else Medium
      case HalfElf => if (hasShield) Medium else Large
      case HalfOrc => if (hasShield) Medium else Large
    }

    characterClass match {
      case Cleric => getAxe(level, maxSize)
      case Fighter => getAxe(level, maxSize)
      case FighterMagicUser => getAxe(level, maxSize)
      case MagicUser => getAxe(level, maxSize)
      case MagicUserThief => getAxe(level, maxSize)
      case Thief => getAxe(level, maxSize)
    }
  }

}
