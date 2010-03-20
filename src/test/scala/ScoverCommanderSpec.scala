import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.specs.Specification
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._


@RunWith(classOf[JUnitRunner])
class ScoverCommanderSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover commander") {
    it("should ask parser for rover position and command from mission spec") {
      val missionSpec =
"""
0 0 N
M
"""
      
      val parser = mock[MissionParser]

      when(parser.parse(missionSpec)).thenReturn(((0,0,"N"),"M"))

      val commander = new ScoverCommander(parser)
      commander.performMission(missionSpec)

      verify(parser).parse(missionSpec)
    }

  }
}
