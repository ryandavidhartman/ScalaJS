package fantasy

object Roller {

  val r = scala.util.Random

  def getRandomScoreIndex(): Int = {
    r.nextInt(16)
  }

  def getSixScores(): Seq[Int] = {
    (1 to 6).map(_ => getRandomScoreIndex()).sortWith(_ > _)
  }

}