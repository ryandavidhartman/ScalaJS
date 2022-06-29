package fantasy.utilities

object BackgroundGenerator2 {

  def getRandomData(data: Map[Int, String]): String = {
    val random = Roller.randomInt(data.size)+1
    data(random)
  }

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
    getRandomData(crafts)
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
    getRandomData(governmentJobs)
  }

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

  def getClergyJob(): String = {
    val clergyJobs = Map(
      1 -> "Parish Priest (mainstream religion)",
      2 -> "Parish Priest (mainstream religion)",
      3 -> "Upper clergy (mainstream religion)",
      4 -> "Clergy (heretic religion)",
      5 -> "Druid",
      6 -> "Priest of Elder gods"
    )
    getRandomData(clergyJobs)
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
    getRandomData(nobility)
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
    getRandomData(occupations)
    }

  def getRelative(): String = {
    val relatives = Map(
      1 -> "Brother/Sister",
      2 -> "First Cousin",
      3 -> "Uncle/Aunt",
      4 -> "Grandfather/mother",
      5 -> "Great Uncle/aunt",
      6 -> "Distant relation"
    )

    getRandomData(relatives)
  }

  def getGuardians(): String = {
    val guardians: Map[Int, String] = Map(
      1 -> "Wicked/cruel stepmother or father",
      2 -> "Hedge Wizard/Mage",
      3 -> "Monastery/Convent",
      4 -> getCrafts(),
      5 -> getRelative(),
      6 -> "Sold into slavery",
      7 -> "Raised by wolves",
      8 -> "Adventurer",
      9 -> "Dwarven indentured servants",
      10 -> "Mysterious red-robed /“elven/” guardians",
      11 -> "Centaurs/Hobgoblins/Deep Ones/ other monsters",
      12 -> "Raised by mercenaries",
      13 -> "Bandits/pirates",
      14 -> "Nomads/cossacks/barbarians",
      15 -> s"Adopted by ${getMerchantJob()}",
      16 -> s"Adopted by ${getClergyJob()}",
      17 -> s"Adopted by a ${getNobility()}",
      18 -> "Lived on the streets/no guardian",
      19 -> "Lived on the streets/no guardian",
      20 -> "Lived on the streets/no guardian",
    )
    getRandomData(guardians)
  }

  def getLifeEvents: String = {
    val events: Map[Int, String] = Map(
      1 -> "Loved/protected by parents",
      2 -> "Unloved/spurned by parents",
      3 -> getGuardians(), //Adopted
      4 -> "Peasant/Farm worker", //Family killed by Other
      5 -> "Farmer",
      6 -> "Fisherman",
      7 -> "Miner",
      8 -> "Forester",
      9 -> "Sailor",
      10 -> "Soldier",
    )
    getRandomData(events)
  }

}
