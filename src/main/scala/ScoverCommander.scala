class ScoverCommander(parser: MissionParser) {
    def performMission(spec:String): String = {
      val stuff = parser.parseMission(spec)
      "0 1 N"
    }
}