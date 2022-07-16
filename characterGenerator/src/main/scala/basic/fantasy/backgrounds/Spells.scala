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
}
