package basic.fantasy.equipment

import basic.fantasy.Roller
import basic.fantasy.backgrounds.Races.{Dwarf, Elf, HalfElf, HalfOrc, Halfling, Human, Race}
import basic.fantasy.characterclass.CharacterClasses.CharacterClass

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
      s"Melee: $name$magicString, dmg: $damage, weight: $weight"
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
        if(roll < 50) HandAxe(magic)
        else MilitaryPick(magic)
      case Medium =>
        if(roll < 10) HandAxe(magic)
        else if(roll < 50) BattleAxe(magic)
        else if(roll < 80 ) GreatAxe(magic)
        else if(roll < 90)  MilitaryPick(magic)
        else FootmansPick(magic)
      case Large =>
        if(roll < 10) HandAxe(magic)
        else if(roll < 80) BattleAxe(magic)
        else if(roll < 90)  MilitaryPick(magic)
        else FootmansPick(magic)
    }
  }


  def getMeleeWeapon(characterClass: CharacterClass, level: Int, race: Race, hasShield: Boolean): MeleeWeapon = {

    val maxSize = race match {
      case Human => if(hasShield) Medium else Large
      case Elf => if(hasShield) Medium else Large
      case Dwarf => if(hasShield) Small else Medium
      case Halfling => if(hasShield) Small else Medium
      case HalfElf => if(hasShield) Medium else Large
      case HalfOrc => if(hasShield) Medium else Large
    }

    getAxe(level, maxSize)
  }

}
