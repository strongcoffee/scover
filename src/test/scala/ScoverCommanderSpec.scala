import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._


@RunWith(classOf[JUnitRunner])
class ScoverCommanderSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover commander should") {
    it("run all rovers") {

      val rover = mock[Rover]
      val mission = Mission(null, List(rover))

      val commander = new ScoverCommander

      commander.performMission(mission)

      verify(rover).run
    }

  }
}
