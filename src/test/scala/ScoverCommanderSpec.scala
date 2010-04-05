import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._


@RunWith(classOf[JUnitRunner])
class ScoverCommanderSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover commander") {

    it("should parse mission using mission parser, start mission and return scover's final position") {

      val spec = "spec"
      val mission = mock[Mission]
      when(mission.run).thenReturn((0, 1, "E"))

      val missionParser = mock[MissionParser]
      when(missionParser.parseMission(spec)).thenReturn(mission)

      new ScoverCommander(missionParser).performMission(spec) should be("0 1 E")

      verify(missionParser).parseMission(spec)
      verify(mission).run

    }
    

  }
}
