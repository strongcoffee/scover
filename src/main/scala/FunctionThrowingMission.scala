import scala.Math._

case class FunctionThrowingMission(plateau: Plateau, scover: Scover) {

  type Position = (Int, Int, String)

  def run(): Position = {

    (3, 3, "N")

  }


}

object Befehl {

  type Position = (Int, Int, String)
  
  def turnLeft(start: Position) = (start._1, start._2, Direction.anticlockwise(start._3))

  def turnRight(start: Position) = (start._1, start._2, Direction.clockwise(start._3))

  def move(start: Position) = {
    val angle = Direction.angles(start._3).toDouble.toRadians
    ( (cos(angle)+start._1).toInt, (sin(angle)+start._2) .toInt, start._3)
  }
}


object Direction {
  val angles = Map(
    "E" -> 0,
    "N" -> 90,
    "W" -> 180,
    "S" -> 270)

  val angles2names = Map[Int, String]() ++ (angles map (kv => (kv._2, kv._1)))


  def clockwise(point: String): String = angles2names((angles(point) + 270) % 360)

  def anticlockwise(point: String): String = angles2names((angles(point) + 90) % 360)

}

