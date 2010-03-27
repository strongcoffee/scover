import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._


@RunWith(classOf[JUnitRunner])
class ScoverCommanderSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover commander") {

    it("should parse mission using mission parser") {

      val missionParser = mock[MissionParser]
      val commander = new ScoverCommander(missionParser)

      commander.performMission("foo")

      verify(missionParser).parseMission("foo")

    }

    
    

  }
}
