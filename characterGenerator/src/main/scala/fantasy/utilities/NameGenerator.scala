package fantasy.utilities

object NameGenerator {

  def getName(race: String, gender: String): String = race match {
    case "Human" =>
      if(gender == "Male")
        s"$getHumanMaleFirstName $getHumanSurname"
      else
        s"$getHumanFemaleFirstName $getHumanSurname"
    case _ => "bob"
  }


  def getHumanSurname(): String = {

    val surNames: Seq[String] = Seq("Hill", "Morton", "Hutchinson", "Hutchinson", "Brooks", "Montgomery", "Jensen",
      "Rogers", "Mccarthy", "O'Quinn", "Gardner", "Booth", "Pham", "Austin", "Jackson", "Day", "Ayala", "Page",
      "Vazquez", "Zang", "Rice", "Wolf", "Abbott", "Mcguire", "Aguilar", "Mckinney", "Henry","Baker", "Ross", "Lowe",
      "Cole", "Arnold", "Pratt", "Rowe", "Cummings", "Frank", "Clark", "Clayton", "Wilson","Hammond", "Byrne",
      "Sweeney", "Porter", "Aguirre", "Robles", "Beck", "Harvey", "Alvarez", "Medina", "Benson", "Franklin",
      "Bass", "Lloyd", "Allen", "Hughes", "Lyons", "Howell", "Flores", "Harris", "Brady", "Dominguez", "Young",
      "Tate", "Rivera", "Luna", "Rios", "Bird", "Becker", "Grant", "Jennings", "Bell", "Miller", "Stevens", "Mccoy",
      "English","Williamson", "Lynch", "Gough", "Waters", "Newman", "Ingram", "Vaughn", "Williams", "Estrada",
      "Edwards", "Scott", "Griffiths", "Mack", "Solis", "Price", "Lambert", "Roberts", "Munoz", "Graham", "Garza",
      "Poole", "Dunn", "Wallace", "Peterson", "Pham", "Hawkins", "Finch", "Strickland", "Barrett", "Mohamed",
      "Cunningham", "Bailey", "Myers", "Spencer", "Romero", "Armstrong", "Austin", "O'Connor", "Peters", "Thomas",
      "Foster", "Carey", "Cruz", "Hamilton", "Love", "Keller", "Taylor", "Gibbs", "Cook", "Mckenna", "Williamson",
      "Garcia", "Flores", "Stanley", "Juarez", "Burns", "Mejia", "Stevenson", "Fletcher", "Palmer", "Alexander",
      "Jimenez", "Jones", "Bush", "Carlson", "Dean", "Atherton", "Mann", "Vasquez", "Wise", "Sherman", "Gibson",
      "Garrett", "Brown", "Waters", "Parsons", "Mcdonald", "Watson", "Osborne", "Thornton", "Harmon", "Park", "Wilkins",
      "Alvarado", "Hunt", "Carrillo", "Gardner", "Crossley", "Burgess", "Wood", "Field", "Abbott", "Khan", "Elliott",
      "Terry", "Leonard", "Allen", "Barnett", "Herbert", "Boyd", "Naylor", "Sims", "Joyce", "Sharp", "Patterson",
      "Nichols", "Thompson", "Moran", "Figueroa", "Graham", "Fuller", "Reed", "Horton", "Kaye", "Reynolds", "Rossi",
      "Nicholson", "Brady", "Black", "Gallegos")

    val count = surNames.length
    surNames(Roller.randomInt(count))
  }

  def getHumanMaleFirstName(): String = {

    val firstName: Seq[String] = Seq("Arkandor", "Aeryk", "Aubir", "Birker", "Coro", "Charn", "Dunni", "Dhenor",
      "Enlo", "Ferdirk", "Golian", "Ghörn", "Hold", "Ivor", "Jarum", "Kolm", "Kherano", "Laef", "Mannur", "Nixor",
      "O'mar", "Paulu", "Phork", "Quoro", "Redgar", "Särk", "Shönn", "Skold", "Thonas", "Thudgar", "Ulfvaer", "Villo",
      "Wilham", "Xärn", "Ymor", "Ziermo","Årukr", "Äleks", "Öykir", "Alsar", "Aenir", "Asur", "Boris", "Birt", "Collun",
      "Dunhir", "Sighard" , "Dharko", "Alric", "Fontur", "Fufnir", "Elkar", "Leiks", "Mervan", "Irminric", "Coenred",
      "Paetr", "Phlick", "Quaggi", "Rory", "Ronder", "Ruddar", "Caelin", "Saren", "Sturv", "Hislir", "Issolur",
      "Ulrekk", "Vigor", "Thorold", "Wulfer","Xeron", "Yarlo", "Zorn", "Ilfarulv", "Jonnus", "Merlot", "Mimur",
      "Neolo", "Borker", "Oerkur", "Parus", "Pertus", "Rialter", "Raulfur", "Thul", "Tirul", "Timbul", "Sturv", "Särkor",
      "Sturmnir", "Solan", "Svert", "Ernoldus", "Albinus",  "Ailmar",     "Gredlan" ,"Gaufridus", "Turbert")

    val count = firstName.length
    firstName(Roller.randomInt(count))
  }

  def getHumanFemaleFirstName(): String = {

    val firstName: Seq[String] = Seq("Alonina", "Aena", "Aula", "Belea", "Celinda", "Chistri", "Dorah", "Dhunha",
      "Essai", "Flora", "Gunn", "Gharee", "Hejlaga", "Ingera", "Jess", "Kolmee", "Khira", "Lomma", "Moniské",
      "Nonna", "O'sarena", "Paladina", "Phera", "Quenn", "Reena", "Sunni", "Shaelah", "Skalda", "Tulla", "Thera",
      "Urvella", "Verona", "Wienna", "Xorone", "Ylfmar", "Zara", "Åsha", "Älta", "Öja", "Annalyn", "Bridonna",
      "Celestine", "Chasnera", "Desini", "Efari", "Fritha", "Gwenna", "Halette", "Ilenne", "Justaline", "Kassathra",
      "Khirta", "Lonna", "Maritt", "Nixi", "Orana", "Polona", "Phora", "Qannae", "Rohana", "Reya", "Ritta", "Selena",
      "Stina", "Stella", "Tressa", "Uneste", "Ulrekkana", "Vehlma", "Verkaa", "Wolkaee", "Xera", "Yenna", "Zelma",
      "Amara", "Ada", "Ani", "Aelli", "Alandra", "Belga", "Alba", "Branda", "Beasir", "Chelena", "Delia", "Dorah",
      "Debera", "Ellena", "Eiri", "Halaë", "Ilda", "Mirla", "Tembla", "Sinea", "Senessa", "Salana", "Sonna", "Stella",
      "Alta",
    )

    val count = firstName.length
    firstName(Roller.randomInt(count))
  }

}
