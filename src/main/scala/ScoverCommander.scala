case class ScoverCommander(parser: MissionParser) {

  def performMission(missionSpec: String): String = {

    val mission = parser.parseMission(missionSpec)

    mission.run.toString

  }
}