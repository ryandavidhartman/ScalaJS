package basic.fantasy.equipment

import basic.fantasy.Roller
import basic.fantasy.characterclass.CharacterClasses.{CharacterClass, Cleric, Fighter, FighterMagicUser, MagicUser, MagicUserThief, Thief}

object EquipmentPacks {

  trait EquipmentPack {
    def weight: Int
    def description: String
    override def toString(): String = "Gear: " + description
  }

  case object BurglarsPack  extends EquipmentPack {
    val weight: Int = 46
    val description: String = "backpack, a bag of 1,000 ball bearings, 10 feet of string, a bell, 5 candles, a crowbar," +
      "a hammer, 10 pitons, a hooded lantern, 2 flasks of oil, 5 days rations, a tinderbox, 50 feet of hempen rope, " +
      "and a waterskin."
  }

  case object DungeoneersPack  extends EquipmentPack {
    val weight: Int = 62
    val description: String = "backpack, a crowbar, a hammer, 10 pitons, 10 torches, a tinderbox, 10 days of rations, " +
      "50 feet of hempen rope, and a waterskin"
  }


  case object ExplorersPack  extends EquipmentPack {
    val weight: Int = 54
    val description: String = "backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, 50' of hempen " +
      "rope,and a waterskin"
  }

  case object PriestsPack  extends EquipmentPack {
    val weight: Int = 25
    val description: String = "backpack, a blanket, 10 candles, a tinderbox, an alms box, 2 blocks of incense, a censer, " +
      "vestments, 2 days of rations, and a waterskin."
  }

  case object ScholarsPack  extends EquipmentPack {
    val weight: Int = 11
    val description: String = "backpack, a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, a little bag of " +
      "sand, and a small knife."
  }

  case object ScholarBurglarsPack  extends EquipmentPack {
    val weight: Int = 50
    val description: String = "backpack, a bag of 1,000 ball bearings, 10 feet of string, a bell, 5 candles, a crowbar, " +
      "a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, " +
      "a hammer, 10 pitons, a hooded lantern, 2 flasks of oil, 5 days rations, a tinderbox, 50 feet of hempen rope, " +
      "and a waterskin."
  }

  case object ScholarExplorersPack  extends EquipmentPack {
    val weight: Int = 54
    val description: String = "backpack, a bedroll, a mess kit, a tinderbox, 10 torches, 10 days of rations, " +
      "a book of lore, a bottle of ink, an ink pen, 10 sheets of parchment, " +
      "50' of hempen rope, and a waterskin"
  }

  def getEquipmentPack(characterClass: CharacterClass): EquipmentPack = characterClass match {
    case Cleric => PriestsPack
    case Fighter => if(Roller.coinFLip()) ExplorersPack else DungeoneersPack
    case FighterMagicUser => ScholarExplorersPack
    case Thief => BurglarsPack
    case MagicUser => ScholarsPack
    case MagicUserThief => ScholarBurglarsPack
  }

}
