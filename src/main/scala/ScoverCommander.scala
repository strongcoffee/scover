class ScoverCommander(parser: MissionParser) {
    def performMission(spec:String): String = {
      val stuff = parser.parse(spec)
      "0 1 N"
    }
}