package basic.fantasy.equipment

import basic.fantasy.characterclass.CharacterClasses.CharacterClass
import basic.fantasy.equipment.Armors.Armor

case class Equipment(armor: Armor)

object EquipmentGenerator {

  def getEquipment(characterClass: CharacterClass, level: Int): Equipment = {
    val armor = Armors.getArmor(characterClass, level)
    Equipment(armor)
  }

}
