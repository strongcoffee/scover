import io.Source

object ScoverConsole {
  def main(args: Array[String]) = {

    var lines :List[String] = Nil
    var line = Console.readLine

    while (line != null) {
      lines ::= line
      line = Console.readLine
    }

    val spec = lines.reduceLeft[String] { (acc, n) =>
      n + "\n" + acc
    }


    val commander = ScoverCommander(new MissionParser)
    print(commander.performMission(spec))

  }
}