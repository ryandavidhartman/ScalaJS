package fantasy.utilities

object BackgroundGenerator2 {

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

    val random = Roller.randomInt(birthOrders.size)+1
    birthOrders(random)
  }

  def getParentsOccupation: String = {

    val occupations: Map[Int, String] = Map(
        1 -> "Beggar",
        2 -> "Drifter",
        3 -> "Criminal",
        4 -> "Peasant/Farm worker",
        5 -> "Farmer",
        6 -> "Fisherman",
        7 -> "Miner",
        8 -> "Forester",
        9 -> "Sailor",
        10 -> "Soldier",
        11 -> "Mercenary",
        12 -> getCrafts(),
        13 -> getCrafts(),
        14 -> "Sage/Scholar/Alchemist",
        15 -> "Scribe",
        16 -> "Slaver",
        17 -> "Adventurer",
        18 -> "Actor/Bard/Courtesan",
        19 -> getGovernmentJob(),
        20 -> getMerchantJob(),
        21 -> getMerchantJob(),
        22 -> getClergyJob(),
        23 -> "Genteel",
        24 -> getNobility()
      )
      val random = Roller.randomInt(occupations.size)+1
      occupations(random)
    }


  def getCrafts(): String = {
    val crafts: Map[Int, String] = Map(
      1 -> "Tailor",
      2 -> "Fletcher/Bowyer",
      3  -> "Glass Blower",
      4  -> "Carpenter",
      5  -> "Animal trainer/Beast master",
      6  -> "Cartographer",
      7  -> "Smith",
      8  -> "Cobbler",
      9  -> "Weaver",
      10  -> "Armorer",
      11  -> "Brewer",
      12  -> "Mason",
      13  -> "Potter",
      14  -> "Miller",
      15  -> "Dyer",
      16  -> "Shipwright",
      17  -> "Jeweler",
      18  -> "Artist",
      19  -> "Sculptor",
      20  -> "Musician",
      21  -> "Baker",
      22  -> "Weaponsmith",
    )
    val random = Roller.randomInt(crafts.size)+1
    crafts(random)
  }

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

    val random = Roller.randomInt(governmentJobs.size)+1
    governmentJobs(random)
  }

  def getMerchantJob(): String = {
    val merchantJobs = Map(
      1 -> "Shopkeeper, foodstuffs",
      2 -> "Shopkeeper, dry goods",
      3 -> "Shopkeeper, exotic goods",
      4 -> "Innkeeper",
      5 -> "Local trader",
      6 -> "caravan trader"
    )

    val random = Roller.randomInt(merchantJobs.size)+1
    merchantJobs(random)
  }

  def getClergyJob(): String = {
    val clergyJobs = Map(
      1 -> "Parish Priest (mainstream religion)",
      2 -> "Parish Priest (mainstream religion)",
      3 -> "Upper clergy (mainstream religion)",
      4 -> "Clergy (heretic religion)",
      5 -> "Druid",
      6 -> "Priest of Elder gods"
    )

    val random = Roller.randomInt(clergyJobs.size)+1
    clergyJobs(random)
  }

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

    val random = Roller.randomInt(nobility.size)+1
    nobility(random)
  }

}
