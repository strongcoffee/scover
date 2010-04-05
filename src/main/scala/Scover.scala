case class Scover(var x: Int, var y: Int, var direction: String, commands: List[Command]) {
  def run: (Int, Int, String) = {
    for (c: Command <- commands) c match {
      case Command("L") => direction match {
          case "N" => direction = "W"
          case "E" => direction = "N"
          case "S" => direction = "E"
          case "W" => direction = "S"
        }
      case Command("R") => direction match {
          case "N" => direction = "E"
          case "E" => direction = "S"
          case "S" => direction = "W"
          case "W" => direction = "N"
        }
      case Command("M") => direction match {
          case "N" => y+=1
          case "E" => x+=1
          case "S" => y-=1
          case "W" => x-=1
        }
    }

    (x, y, direction)
  }
}