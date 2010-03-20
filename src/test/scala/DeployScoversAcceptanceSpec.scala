import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers;
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class DeployScoversAcceptanceSpec extends Spec with ShouldMatchers {

  describe("little scover") {
    it("should take first step") {
      val missionSpec =
  """
  5 5
  0 0 N
  M
  """
      val commander = new ScoverCommander
      commander.performMission(missionSpec) should equal ("0 1 N")
    }

    it("should practice some ballet") {
      val missionSpec =
  """
  5 5
  0 0 E 
  MLM
  """
      val commander = new ScoverCommander
      commander.performMission(missionSpec) should equal ("1 1 N")
    }
  }
}
