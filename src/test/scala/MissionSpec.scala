import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

@RunWith(classOf[JUnitRunner])
class MissionSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("mission") {
    it("should run rover and return rover's final position") {
      val rover = mock[Rover]
      val plateau = mock[Plateau]
      val mission = Mission(plateau, rover)

      when(rover.run).thenReturn((0, 0, "E"))

      mission.run should be ((0, 0, "E"))
      
      verify(rover).run
    }
  }
}
