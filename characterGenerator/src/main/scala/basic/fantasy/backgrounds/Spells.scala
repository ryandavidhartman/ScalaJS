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
  case object DetectEvil extends Spell("Detect Evil", "60'", "1 round/level")
}
