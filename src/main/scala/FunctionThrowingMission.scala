import scala.Math._

case class FunctionThrowingMission(plateau: Plateau, scover: Scover) {

  val commands: List[Position => Position] = scover.commands map {

    case c => c match {  // get rid of the Command wrapper class - go strings!!
         case "L" => Befehl.turnLeft
         case "R" => Befehl.turnRight
         case "M" => Befehl.move
      }
  }

  def run(): Position = (Position(scover.x, scover.y, scover.direction) /: commands) { (acc,c) => c(acc) }


}

object Befehl {

  def turnLeft(start: Position) = Position(start.x, start.y, Direction.anticlockwise(start.direction))

  def turnRight(start: Position) = Position(start.x, start.y, Direction.clockwise(start.direction))

  def move(start: Position) = {
    val angle = Direction.angles(start.direction).toDouble.toRadians
    Position( (cos(angle)+start.x).toInt, (sin(angle)+start.y) .toInt, start.direction)
  }
}

case class Position(x: Int, y: int, direction: String) { }


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

