class ScoverCommander() {
    def performMission(mission: Mission): String = {
      val rover = mission.rovers(0)
      rover.run

      rover.x + " " + rover.y + " " + rover.direction
    }
}