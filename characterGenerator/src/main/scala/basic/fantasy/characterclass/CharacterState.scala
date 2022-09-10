package basic.fantasy.characterclass

import basic.fantasy.backgrounds.CharacterAlignment
import basic.fantasy.backgrounds.Races.Race
import basic.fantasy.characterclass.CharacterClasses.CharacterClass

case class CharacterState(
   name: String,
   race: Race,
   characterClass: CharacterClass,
   level: Int,
   gender: String,
   height: String,
   weight: Int,
   age: Int,
   alignment: CharacterAlignment,
   personality: String,
   strength: Int,
   dexterity: Int,
   constitution: Int,
   intelligence: Int,
   wisdom: Int,
   charisma: Int,
   attackBonus: String,

)
