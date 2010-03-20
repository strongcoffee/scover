import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.specs.Specification
import org.specs.mock.Mockito


@RunWith(classOf[JUnitRunner])
class ScoverCommanderSpec extends Spec with ShouldMatchers with Mockito{

  describe("scover commander") {
    it("should ask parser for rover position and command from mission spec") {
      val missionSpec =
"""
0 0 N
M
"""
      val parser = mock[MissionParser]

      parser.parse(missionSpec) returns ((0,0,"N"),"M")

      (ScoverCommander).performMission(missionSpec)

      parser.parse(missionSpec).was called
    }

  }
}
