case class Mission(plateau: Plateau, rover: Rover) {

  def run(): (Int, Int, String) = {
    rover.run
  }
}