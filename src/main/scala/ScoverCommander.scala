case class ScoverCommander(parser: MissionParser) {

  def performMission(missionSpec: String): String = {

    val mission = parser.parseMission(missionSpec)

    val endPos = mission.run
    
    "%d %d %s".format(endPos._1, endPos._2, endPos._3)

  }
}