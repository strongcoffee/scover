case class Rover(var x: Int, var y: Int, var direction: String, commands: List[Command]) {
  def run: (Int, Int, String) = {
    for (c: Command <- commands) c match {
      case Command("L") => direction = "W"
      case Command("R") => direction = "E"
      case Command("M") => y = 1
    }

    (0, 0, "E")
  }
}