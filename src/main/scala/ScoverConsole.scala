import io.Source

object ScoverConsole extends Application {


    var lines : List[String] = Nil
    var line = Console.readLine

    while (line != null) {
      lines ::= line
      line = Console.readLine
    }

    val spec = lines.reduceLeft[String] { (acc, n) =>
      n + "\n" + acc
    }

    print(ScoverCommander(new MissionParser).performMission(spec))

  
}