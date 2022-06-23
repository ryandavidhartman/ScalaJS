package fantasy.utilities


object Roller {

  val r = scala.util.Random

  def getRandomScoreIndex(): Int = {
    r.nextInt(16)
  }

  def getSixScores(): Seq[Int] = {
    (1 to 6).map(_ => getRandomScoreIndex()).sortWith(_ > _)
  }

  def rollDice(numOfDice: Int, typeOfDice: Int, mod: Int): Int = {
    (1 to numOfDice).map(_ => r.nextInt(typeOfDice) + 1 + mod).sum
  }

  def rollHP(numOfDice: Int, typeOfDice: Int, mod: Int): Int = {
    (1 to numOfDice)
      .map(_ => r.nextInt(typeOfDice) + 1 + mod)
      .map(r => Math.max(r, 1))  // You get at least 1 HP per level even if you have a negative con modifier
      .sum
  }

  def randomInt(max: Int): Int = r.nextInt(max)

}