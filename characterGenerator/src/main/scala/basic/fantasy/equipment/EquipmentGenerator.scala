package basic.fantasy.equipment

import basic.fantasy.characterclass.CharacterClasses.CharacterClass
import basic.fantasy.equipment.Armors.Armor
import basic.fantasy.equipment.Shields.Shield

case class Equipment(armor: Armor, shield: Shield)

object EquipmentGenerator {

  def getEquipment(characterClass: CharacterClass, level: Int): Equipment = {
    val armor = Armors.getArmor(characterClass, level)
    val shield = Shields.getShield(characterClass, level)
    Equipment(armor, shield)
  }

}
