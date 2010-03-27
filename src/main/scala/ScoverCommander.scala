case class ScoverCommander(parser: MissionParser) {

    def performMission(missionSpec: String): String = {

        parser.parseMission(missionSpec)
        ""
    }
}