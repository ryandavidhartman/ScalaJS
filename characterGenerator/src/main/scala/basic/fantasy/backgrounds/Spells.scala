package basic.fantasy.backgrounds

object Spells {

  sealed abstract class Spell(
    name: String,
    range: String,
    duration: String,
    reversible: Boolean = false
  )

  case object AnimateDead extends Spell("Animate Dead", "touch", "special")
  case object AnimateObjects extends Spell("Animate Objects", "100' + 10'/level", "1 round/level")
  case object AntiMagicShell extends Spell("Anti-Magic Shell", "10'", "1 turn/level")
  case object BladeBarrier extends Spell("Blade Barrier", "90'", "1 round/level")
  case object Bless extends Spell("Bless", "50' radius", "1 minute/level", true)
  case object CharmAnimal extends Spell("Charm Animal", "60'", "level + 1d4 rounds")
  case object CharmMonster extends Spell("Charm Monster", "30'", "special")
  case object CharmPerson extends Spell("Charm Person", "30'", "special")
  case object Clairvoyance extends Spell("Clairvoyance", "60'", "12 turns")
  case object Cloudkill extends Spell("Cloudkill", "100' + 10'/level", "6 rounds/level")
  case object Commune extends Spell("Commune", "range", "1 round/level")
  case object Confusion extends Spell("Confusion", "360'", "2 rounds + 1 round/level")
  case object ConjureElemental extends Spell("Conjure Elemental", "240'", "special")
  case object ContinualLight extends Spell("Continual Light", "360'", "1 year/level", true)
  case object CreateFood extends Spell("Create Food", "10'", "permanent")
  case object CreateWater extends Spell("Create Water", "10'", "permanent")
  case object CureBlindness extends Spell("Cure Blindness", "touch", "instantaneous")
  case object CureDisease extends Spell("Cure Disease", "touch", "instantaneous", true)
  case object CureLightWounds extends Spell("Cure Light Wounds", "touch", "instantaneous", true)
  case object CureSeriousWounds extends Spell("Cure Serious Wounds", "touch", "instantaneous", true)
  case object DarkVision extends Spell("Dark Vision", "touch", "1 hour/level")
  case object DeathSpell extends Spell("Death Spell", "240'", "instantaneous")
  case object DetectEvil extends Spell("Detect Evil", "60'", "1 round/level", true)
  case object DetectInvisible extends Spell("Detect Invisible", "60'", "1 turn/level")
  case object DetectMagic extends Spell("Detect Magic", "60'", "2 turns")
  case object DimensionDoor extends Spell("Dimension Door", "10'", "instantaneous")
  case object Disintegrate extends Spell("Disintegrate", "60'", "instantaneous")
  case object DispelEvil extends Spell("Dispel Evil", "touch", "1 round/level")
  case object DispelMagic extends Spell("Dispel Magic", "120'", "instantaneous")
  case object ESP extends Spell("ESP", "60'", "1 turn/level")
  case object Feeblemind extends Spell("Feeblemind", "180'", "permanent")
  case object FindTraps extends Spell("Find Traps", "30'", "3 turns")
  case object FindThePath extends Spell("Find The Path", "touch", "1 turn/level")
  case object Fireball extends Spell("Fireball", "100' + 10'/level", "instantaneous")
  case object FleshToStone extends Spell("Flesh To Stone", "30'/level", "permanent", true)
  case object FloatingDisc extends Spell("Floating Disc", "0", "5 turns +1 turn/level")
  case object Fly extends Spell("Fly", "touch", "1 turn/level")
  case object Geas extends Spell("Geas", "5 foot/level", "special", true)
  case object GrowthOfAnimals extends Spell("Growth Of Animals", "60' + 10'/level", "1 turn/level")
  case object GrowthOfPlants extends Spell("Growth Of Plants", "120'", "permanent", true)

}
