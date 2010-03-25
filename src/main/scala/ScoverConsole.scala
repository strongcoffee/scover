import io.Source

object ScoverConsole {
  def main(args: Array[String]) = {

    var lines = List[String]()
    var line = Console.readLine

    while (line != null) {
      lines ::= line
      line = Console.readLine
    }

    val spec = lines.reduceLeft[String] { (acc, n) =>
      n + "\n" + acc
    }

    val mission: Mission = (new MissionParser).parseMission(spec)
    val commander: ScoverCommander = new ScoverCommander
    print(commander.performMission(mission))

  }
}