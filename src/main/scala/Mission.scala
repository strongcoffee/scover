case class Mission(plateau: Plateau, scover: Scover) {

  def run(): (Int, Int, String) = {
    scover.run
  }
}