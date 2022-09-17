package basic.fantasy.characterclass

object KiPowers {

  sealed abstract trait KiPower {
    def description: String
    def name: String
    def canSelect(level: Int, kiPowers: Set[KiPower]): Boolean =  !kiPowers.contains(this)
    def canUseWhenEncumbered = false
  }

  case object AbundantStep extends KiPower {
    override def description: String =
      """The Monk can magically step between spaces. The Monk
        |gets the benefit of a dimension door spell once per day.
        |He or she gains a second use at 15th level. Must be at
        |least 7th level""".stripMargin

    override def name: String = "Abundant Step"

    override def canSelect(level: Int, kiPowers: Set[KiPower]): Boolean = (level >= 7) && super.canSelect(level, kiPowers)
  }

  case object BurstingFist extends KiPower {
    override def description: String =
      """Once per day a Monk may slam their palms together
        |creating a wave of force projecting forward for 50 feet.
        |Anyone caught in the burst takes 1d6 per monk level, but
        |may save vs. Dragon Breath for half damage. Must be at
        |least 15th level and already have diamond fist.
        |""".stripMargin

    override def name: String = "Bursting Fist"

    override def canSelect(level: Int, kiPowers: Set[KiPower]): Boolean =
      (level >= 15) &&
      kiPowers.contains(DiamondFist) &&
      super.canSelect(level, kiPowers)
  }

  case object DeflectArrows extends KiPower {
    override def description: String =
      """Once per round, the Monk may deflect incoming ranged
        |attacks that would have otherwise hit with a flick of their
        |wrist. This does not reduce the number of attacks the
        |Monk may make in the same round.
        |""".stripMargin

    override def name: String = "Deflect Arrows"
  }

  case object DiamondBody extends KiPower {
    override def description: String =
      """The Monk may flush any and all poison from their system
        |once a day. The Monk gains an additional use at 15th
        |level and a third use at 19th level. Must be at least 11th
        |level.""".stripMargin

    override def name: String = "Diamond Body"

    override def canSelect(level: Int, kiPowers: Set[KiPower]): Boolean = (level >= 11) && super.canSelect(level, kiPowers)

    override def canUseWhenEncumbered: Boolean = true
  }

  case object DiamondFist extends KiPower {
    override def description: String =
      """The Monk’s unarmed attacks ignore any hardness of the
        |target. Must be at least 11th level and have stunning fist.""".stripMargin

    override def name: String = "Diamond Fist"

    override def canSelect(level: Int, kiPowers: Set[KiPower]): Boolean =
      (level >= 11) &&
      kiPowers.contains(StunningFist) &&
      super.canSelect(level, kiPowers)
  }

  case object StunningFist extends KiPower {
    override def description: String = ???

    override def name: String = ???
  }

}
