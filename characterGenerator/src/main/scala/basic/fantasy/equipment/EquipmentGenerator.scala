package basic.fantasy.equipment

import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.CharacterClasses.CharacterClass
import basic.fantasy.equipment.Armors.Armor
import basic.fantasy.equipment.Shields.{NoShield, Shield}
import basic.fantasy.equipment.MeleeWeapons.MeleeWeapon
import basic.fantasy.equipment.RangedWeapons.RangedWeapon

case class Equipment(
  armor: Armor,
  shield: Shield,
  meleeWeapon: MeleeWeapon,
  offhand: MeleeWeapon,
  rangedWeapon: RangedWeapon
)

object EquipmentGenerator {

  def getEquipment(characterClass: CharacterClass, level: Int, race: Race): Equipment = {
    val armor = Armors.getArmor(characterClass, level)
    val shield = Shields.getShield(characterClass, level)
    val hasShield = (shield != NoShield)
    val meleeWeapon = MeleeWeapons.getMeleeWeapon(characterClass, level, race, hasShield)
    val offhandWeapon = MeleeWeapons.getSecondaryWeapon(characterClass, race, level, meleeWeapon, hasShield)
    val rangedWeapon = RangedWeapons.getRangedWeapon(characterClass, level, race)
    Equipment(armor, shield, meleeWeapon, offhandWeapon, rangedWeapon)
  }

}
