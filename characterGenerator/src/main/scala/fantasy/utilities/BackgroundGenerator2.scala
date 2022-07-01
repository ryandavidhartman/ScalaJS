package fantasy.utilities

object BackgroundGenerator2 {

  def getRandomData(data: Map[Int, String]): String = {
    val random = Roller.randomInt(data.size)+1
    data(random)
  }

  //Chart 1. Birth Order
  def getBirthOrder(): String = {
    val birthOrders: Map[Int, String] = Map(
      1 -> "First born",
      2 -> "Second child",
      3 -> "Second child",
      4 -> "Third child",
      5 -> "Third child",
      6 -> "Fourth",
      7 -> "Fifth",
      8 -> "Sixth",
      9 -> "Seventh",
      10 -> "Eighth or more"
    )

    getRandomData(birthOrders)
  }

  //Chart 2: Parent Occupation
  def getOccupation(): String = {

    val occupations: Map[Int, String] = Map(
      1 -> "Beggar",
      2 -> "Drifter",
      3 -> "Criminal",
      4 -> "Peasant",
      5 -> "Farm worker",
      6 -> "Farmer",
      7 -> "Fisherman",
      8 -> "Miner",
      9 -> "Forester",
      10 -> "Sailor",
      11 -> "Soldier",
      12 -> "Mercenary",
      13 -> getCrafts(),
      14 -> getCrafts(),
      15 -> "Sage",
      16 -> "Scholar",
      17 -> "Alchemist",
      18 -> "Scribe",
      19 -> "Slaver",
      20 -> "Adventurer",
      21 -> "Actor/Bard/Courtesan",
      22 -> getGovernmentJob(),
      23 -> getMerchantJob(),
      24 -> getMerchantJob(),
      25 -> getClergyJob(),
      26 -> "Genteel",
      27 -> getNobility()
    )
    getRandomData(occupations)
  }

  //Chart 2A: Craft
  def getCrafts(): String = {
    val crafts: Map[Int, String] = Map(
      1 -> "Tailor",
      2 -> "Fletcher",
      3 -> "Bowyer",
      4  -> "Glass Blower",
      5  -> "Carpenter",
      6  -> "Animal trainer",
      7 -> "Beast master",
      7  -> "Cartographer",
      8  -> "Smith",
      9  -> "Cobbler",
      10  -> "Weaver",
      11  -> "Armorer",
      12  -> "Brewer",
      13  -> "Mason",
      14  -> "Potter",
      15  -> "Miller",
      16  -> "Dyer",
      17  -> "Shipwright",
      18  -> "Jeweler",
      19  -> "Artist",
      20  -> "Sculptor",
      21  -> "Musician",
      22  -> "Baker",
      23  -> "Weaponsmith",
    )
    getRandomData(crafts)
  }

  //Chart 2B: Government Officials
  def getGovernmentJob(): String = {
    val governmentJobs = Map(
      1 -> "Tax collector",
      2 -> "Tex collector",
      3 -> "Sheriff",
      4 -> "Forest warden",
      5 -> "Magistrate",
      6 -> "Town mayor",
      7 -> "City mayor",
      8 -> "Ducal advisor",
      9 -> "Royal advisor",
    )
    getRandomData(governmentJobs)
  }

  //Chart 2C: Merchant
  def getMerchantJob(): String = {
    val merchantJobs = Map(
      1 -> "Shopkeeper, foodstuffs",
      2 -> "Shopkeeper, dry goods",
      3 -> "Shopkeeper, exotic goods",
      4 -> "Innkeeper",
      5 -> "Local trader",
      6 -> "Caravan trader"
    )
    getRandomData(merchantJobs)
  }

  //Chart 2D: Clergy
  def getClergyJob(): String = {
    val clergyJobs = Map(
      1 -> "Parish Priest (mainstream religion)",
      2 -> "Parish Priest (mainstream religion)",
      3 -> "Upper clergy (mainstream religion)",
      4 -> "Clergy (heretic religion)",
      5 -> "Druid",
      6 -> "Priest of an Elder god"
    )
    getRandomData(clergyJobs)
  }

  //Chart 2E: Nobility
  def getNobility(): String = {
    val nobility = Map(
      1 -> "Landless Knight",
      2 -> "Landless Knight",
      3 -> "Landless Knight",
      4 -> "Knight Banneret",
      5 -> "Knight Banneret",
      6 -> "Knight",
      7 -> "Knight",
      8 -> "Knight",
      9 -> "Knight",
      10 -> "Knight",
      11 -> "Earl",
      12 -> "Earl",
      13 -> "Baron",
      14 -> "Baron",
      15 -> "Baron",
      16 -> "Count",
      17 -> "Marquis",
      18 -> "Duke",
      19 -> "Arch Duke",
      20 -> "Prince",
      21 -> "King"
    )
    getRandomData(nobility)
  }

  //Chart 3: Significant Events in Childhood and Adolescence
  def getChildhoodEvents: String = {
    val events: Map[Int, String] = Map(
      1 -> "Loved by parents",
      2 -> "Protected by parents",
      3 -> "Unloved by parents",
      4 -> "Spurned by parents",
      5 -> getGuardians(), //Adopted
      6 -> getGuardians(), //Adopted
      7 -> s"Family Member killed by ${getOther()}",
      8 -> s"Caused the death of ${getRelative()}",
      9 -> s"Caused the death of ${getOther()}",
      10 -> s"Illegitimate raised by ${getGuardians()}",
      11 -> "Apprenticed in parent's occupation",
      12 -> s"Apprenticed in ${getOccupation}",
      13 -> "Parent killed by Relative",
      14 -> s"Parent outlawed for ${getCrime()}",
      15 -> s"Religious experience: ${getReligiousExperience()}",
      16 -> "Jealous sibling",
      17 -> "Sibling rivalry",
      18 -> "Lived a nomadic life",
      19 -> "Moved to the big city",
      20 -> "Moved to the borderlands",
      21 -> "Moved to the wilderness",
      22 -> "Run away from home",
      23 -> "Learned to use a weapon",
      24 -> s"Magical occurrence ${getMagicalOccurrence()}",
      25 ->  s"Committed a crime ${getCrime()}",
    )
    getRandomData(events)
  }

  // Chart 3A: Guardians
  def getGuardians(): String = {
    val guardians: Map[Int, String] = Map(
      1 -> "Raised by a wicked step-father",
      2 -> "Raised by a cruel step-father",
      3 -> "Raised by a wicked step-mother",
      4 -> "Raised by a cruel step-mother",
      5 -> "Raised by a hedge Wizard",
      6 -> "Raised in a monastery or convent",
      7 -> s"Raised by ${getCrafts()}",
      8 -> s"Raised by ${getRelative()}",
      9 -> "Sold into slavery",
      10 -> "Raised by orcs",
      11 -> "Raised by an Adventurer",
      12 -> "Raised by dwarven indentured servants",
      13 -> "Mysterious red-robed /“elven/” guardians",
      14 -> "Centaurs/Hobgoblins/Deep Ones/ other monsters",
      15 -> "Raised by mercenaries",
      16 -> "Bandits/pirates",
      17 -> "Nomads/cossacks/barbarians",
      18 -> s"Adopted by ${getMerchantJob()}",
      19 -> s"Adopted by ${getClergyJob()}",
      20 -> s"Adopted by a ${getNobility()}",
      21 -> "Lived on the streets/no guardian",
      22 -> "Lived on the streets/no guardian",
      23 -> "Lived on the streets/no guardian",
    )
    getRandomData(guardians)
  }

  //Chart 3B: Relatives
  def getRelative(): String = {
    val relatives = Map(
      1 -> "Brother",
      2 -> "Sister",
      3 -> "First Cousin",
      4 -> "Uncle",
      5 -> "Aunt",
      6 -> "Grandfather",
      7 -> "Grandmother",
      8 -> "Great Uncle",
      9 -> "Great Aunt",
      10 -> "Distant relation"
    )

    getRandomData(relatives)
  }

  //Chart 3C: Others
  def getOther(): String = {
    val others: Map[Int, String] = Map(
      1 -> getGovernmentJob(),
      2 -> "Friend",
      3 -> "Thief",
      4 -> "Wizard",
      5 -> "Mentor",
      6 -> getNobility(),
      7 -> "Raider",
      8 -> "Orcs",
      9 -> "Demon",
      10 -> "Lover",
      11 -> getCrafts(),
      12 -> "Highwayman",
      13 -> "Adventurer",
      14 -> "Comrade",
      15 -> "Wild animal",
      16 -> "Nomad",
      17 -> "Religious sect member/leader",
      18 -> "Mysterious stranger",
      19 -> s"${getOther()} and ${getOther()}",
      20 -> "Invader",
      21 -> "Bandit",
      22 -> "Pirate",
    )
    getRandomData(others)
  }

  //Chart 3D: Crimes and Misdemeanors
  def getCrime(): String = {
    val crimes: Map[Int, String] = Map(
      1 -> "Theft",
      2 -> "Theft",
      3 -> "Assault",
      4 -> "Heresy",
      5 -> "Heresy",
      6 -> "Murder",
      7 -> "Insulting a noble",
      8 -> "Trespassing",
      9 -> "Treason",
      10 -> "Tax evasion",
      11 -> "Political dissidence",
      12 -> "Political dissidence",
      13 -> "Harboring criminals",
      14 -> "Unlawful sorcery",
      15 -> "Banditry",
      16 -> "Piracy",
      17 -> "Crime they didn't commit",
      18 -> "Crime they didn't commit",
    )
    getRandomData(crimes)
  }

  //Chart 4: Significant Events in Young Adulthood
  def getYoungAdultEvents: String = {
    val events: Map[Int, String] = Map(
      1 -> s"Religious experience: ${getReligiousExperience()}",
      2 -> s"Magical occurrence ${getMagicalOccurrence()}",
      3 -> s"Caused the death of ${getRelative()}",
      4 -> s"Developed virtues ${getVirtue()}",
      5 -> s"Developed vice ${getVice()}",
      6 -> s"Conscripted for military service: ${getMilitaryService()}",
      7 -> s"Volunteered for military service: ${getMilitaryService()}",
      8 -> { if(Roller.randomInt(100) > 75)  "Romantic affair" else "Has Child" },
      9 -> s"Learned occupation ${getOccupation()}",
      10 -> "Traveled abroad",
      11 -> "Survived plague",
      12 -> "Moved to big city",
      13 -> "Moved to borderlands",
      14 ->  "Moved to Wilderness",
      15 -> "Sold into slavery (escaped)",
      16 ->  s"Committed a crime ${getCrime()}",
      17 -> s"Home village/town wiped out by ${getOther()}",
      18 -> "Encountered monster",
      19 -> "Served wealthy patron",
      20 -> "Served Noble court",
      21 -> s"Saved life of ${getRelative()}",
      22 -> s"Saved life of ${getOther()}",
      23 -> s"Apprenticed to ${getCrafts()}"
    )
    getRandomData(events)
  }

  //Chart 4A: Military Service
  def getMilitaryService(): String = {
    val militaryService: Map[Int, String] = Map(
      1 -> "Promoted",
      2 -> "Demoted",
      3 -> "Lone survivor of unit",
      4 -> "Captured by enemy and tortured",
      5 -> "Deserted",
      6 -> "Joined mercenaries",
      7 -> "Responsible for the deaths of comrades",
      8 -> "Best friend killed at your side",
      9 -> "Prevented the destruction of innocents",
      10 -> s"Spent most time in “rear echelon” non-combat ${otherService()}",
      11 -> s"Committed an unsanctioned crime ${getCrime()}",
      12 -> "Ran away from battle",
      13 -> "Displayed heroism on the battlefield",
      14 -> "Learned use of exotic weapons",
      15 -> "Learned seigecraft",
      16 -> "Led a mutiny",
      17 -> "Survived disease",
      18 -> s"magical occurrence: ${getMagicalOccurrence()}",
      19 -> s"Developed virtue: ${getVirtue()}",
      20 -> s"Developed vice: ${getVice()}",
      21 -> s"Transferred to other service ${getOther()}",
    )
    getRandomData(militaryService)
  }

  //Chart 4B: Other Service
  def otherService(): String = {
    val otherService: Map[Int, String] = Map(
      1 -> "Palace guard",
      2 -> "City guard/watch",
      3 -> "Temple guard",
      4 -> "Border militia/rangers",
      6 -> "Private bodyguard",
      7 -> "Engineer",
      8 -> "Sapper",
      9 -> "Scouts",
      10 -> "Navy",
      11 -> "Shipboard marine",
      12 -> "Messenger",
      13 -> "Caravan guard",
      14 -> "Border guard",
    )
    getRandomData(otherService)
  }

  //Chart 4C: Virtues
  def getVirtue(): String = {
     val virtues: Map[Int, String] = Map(
       1 -> "Cleanliness",
       2 -> "Benefactor for the poor",
       3 -> "Well-mannered",
       4 -> "Friendly",
       5 -> "Teetotaler",
       6 -> "Pious",
       7 -> "Sincere/earnes",
       8 -> "Quiet/good listener",
       9 -> "Honest",
       10 -> "Defender of the oppressed",
       11 -> "Loving",
       12 -> "Tolerant of all faiths",
       13 -> "Self-confident",
       14 -> "Hard-working",
       15 -> "Humble",
       16 -> "Good negotiator",
       17 -> "diplomatic",
       18 -> "Hard bargainer",
       19 -> "Punctual",
       20 -> "Sensitive/tender",
       21 -> "Gregarious"
    )

    getRandomData(virtues)

  }

  //Chart 4D: Vices
  def getVice(): String = {
    val vices: Map[Int,String] = Map(
      1 -> "Heavy drinker",
      2 -> "Drug problem",
      3 -> "Gambler",
      4 -> "Randiness",
      5 -> "Swears like a sailor",
      6 -> "Duplicitous",
      7 -> "Mistrustful",
      8 -> "Loner",
      9 -> "Pushy",
      10 -> "Loud",
      11 -> "Poor Hygiene",
      12 -> "Loves brawling",
      13 -> "Quick-tempered",
      14 -> "Selfish",
      15 -> "Braggart",
      16 -> "Lazy",
      17 -> "Greedy",
      18 -> "Intolerant",
      19 -> "Lacks self-confidence",
      20 -> "Sacrilegious"
    )
    getRandomData(vices)
  }

  //Chart 4E: Religious Experience
  def getReligiousExperience(): String = {
    val religiousExperiences: Map[Int, String] = Map(
      1 -> "Joined faith",
      2 -> "Lost faith",
      3 -> "Vision of demi-god",
      4 -> "Vision of a saint",
      5 -> "Vision of a deity",
      6 -> "Vision of a demon",
      7 -> "Vision of an elder god",
      8 -> "Became lay clergy",
      9 -> "Pilgrimage to holy place",
      10 -> "Excommunicated",
      11 -> "Persecuted for faith",
      12 -> "Involved in holy war",
      13 -> "Became religious hypocrite",
      14 -> "Made prophetic statement",
      15 -> "Discredited faith",
      16 -> "Sent to religious school",
      17 -> "Started own sect",
      18 -> s"Developed a virtue ${getVirtue()}",
      19 -> s"Developed a virtue ${getVirtue()}",
      20 -> s"Developed a vice ${getVice()}",
      21 -> s"Developed a vice ${getVice()}"
    )

    getRandomData(religiousExperiences)
  }

  //Chart 4F: Magical Occurrence
  def getMagicalOccurrence(): String = {
    val magicalOccurrences: Map[Int, String] = Map(
      1 -> "Survived magical disaster",
      2 -> "Witnessed a summoning",
      3 -> "Saw magical omens",
      4 -> "Visited by a witch",
      5 -> "Gathered spell components for hedge wizard",
      6 -> "Found magical place",
      7 -> "Found arcane scrolls",
      8 -> "Discovered ancient book",
      9 -> "Learned a cantrip"
    )

    getRandomData(magicalOccurrences)
  }

}
