import io.Source

object ScoverConsole extends Application {


    var lines = List[String]()
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