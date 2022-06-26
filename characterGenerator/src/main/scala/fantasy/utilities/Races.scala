package fantasy.utilities

object Races {
  sealed trait Race {
    val weapons: Seq[String] = Seq("Large weapons require two hands")
    val getAbilities: Seq[String]
  }
  case object Human extends Race {
    override val getAbilities: Seq[String] = Seq("+10% Bonus on Earned XP")
  }
  case object Elf extends Race {
    override val getAbilities: Seq[String] = Seq(
      "Darkvision with a 60' range",
      "Find secret door 1-2 on d6 when searching",
      "Find secret door 1 on d6 with a cursory look",
      "Immune to paralyzing attacks of Ghouls",
      "Only surprised on 1 on d6"
    )
  }
  case object Dwarf extends Race {
    override val weapons = Seq(
      "Large weapons require two hands",
      "No 2-handed swords, pole-arms, or longbows"
    )

    override val getAbilities: Seq[String] = Seq(
      "Darkvision 60'",
      "Detect new construction, shifting walls slanting passages, traps w/ 1-2 on d6 when searching"
    )
  }

  case object Halfling extends Race {
    override val weapons: Seq[String] = Seq(
      "Must use medium weapons in two hands",
      "Cannot use large weapons"
    )
    override val getAbilities: Seq[String] = Seq(
      "+1 attack bonus on ranged weapons (bonus added)",
      "+2 bonus to AC when attacked in melee by creatures larger than man-sized",
      "+1 to initiative die rolls",
      "Hide (10% chance to be detected outdoors, 30% chance to be detected indoors)"
    )
  }
  case object HalfElf extends Race {
    override val getAbilities: Seq[String] = Seq(
      "Darkvision with a 30' range",
      "Able to find secret doors on a 1-2 on 1d6, when searching",
      "+5% on all earned experience, except for multiclass."
    )
  }
  case object HalfOrc extends Race {
    override val getAbilities: Seq[String] = Seq(
      "+5% on all earned experience.",
      "Darkvision with a 60' range",
      "When dealing with humanoids of Human-size or smaller, a Half-Orc gains an additional +1 on any reaction"
    )
  }

  def stringToRace(race: String): Race = race match {
    case "Human" => Human
    case "Elf" => Elf
    case "Dwarf" => Dwarf
    case "Halfling" => Halfling
    case "HalfElf" => HalfElf
    case "HalfOrc" => HalfOrc
    case _ => throw InvalidRaceException(s"Invalid character race: $race")
  }

  case class InvalidRaceException(msg: String) extends Exception(msg)
}
