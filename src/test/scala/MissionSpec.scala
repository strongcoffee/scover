import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

@RunWith(classOf[JUnitRunner])
class MissionSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("mission") {
    it("should run scover and return scover's final position") {
      val scover = mock[Scover]
      val plateau = mock[Plateau]
      val mission = Mission(plateau, scover)

      when(scover.run).thenReturn((0, 0, "E"))

      mission.run should be ((0, 0, "E"))
      
      verify(scover).run
    }
  }
}
