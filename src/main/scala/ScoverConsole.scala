import io.Source

object ScoverConsole {
  def main(args: Array[String]) = {

    var lines = List[String]()
    var line = Console.readLine

    while (line != null) {

      lines ::= line
      line = Console.readLine
    }

    val spec = lines.reverse.foldRight("")((result, l) => result + "\n" + l).trim

    val parser = new MissionParser
    val commander = new ScoverCommander(parser)

    print(commander.performMission(spec))

  }
}