package basic.fantasy.equipment

import basic.fantasy.characterclass.CharacterClasses.{All_CLASSES, CharacterClass}

object Armors {

  sealed abstract class Armor(
    val baseCost: Int,
    val weight: Int,
    val baseAC: Int,
    val characterClasses: Set[CharacterClass],
    val magicBonus: Int = 0
  ) {
    def ac: Int = baseAC + magicBonus
    def cost: Int = if(magicBonus > 1)
      baseCost + (1500*(Math.pow(4,magicBonus-1))).toInt
    else
      baseCost

  }

  case object NoArmor extends Armor(0, 0, 11, All_CLASSES)

  /*
  No Armor 0 gp 0 11
Padded or Quilted 15 gp 10 12
Hide 10 gp 30 13
Leather 20 gp 15 13
Studded Leather 30 gp 25 14
Ring Mail 25 gp 30 14
Brigandine 80 gp 30 15
Chain Mail 60 gp 40 15
Scale Mail 80 gp 55 16
Splint Mail 100 gp 45 16
Banded Mail 200 gp 35 16
Plate Mail 300 gp 50 17
Field Plate Mail 500 gp 70 18
Full Plate Mail 1,500 gp 80 19
   */

}
