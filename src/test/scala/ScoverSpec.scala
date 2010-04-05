import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar


@RunWith(classOf[JUnitRunner])
class ScoverSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover") {
    it("should turn left") {
      val scover = Scover(1, 1, "N", List(Command("L")))
      scover.run

      scover.direction should be ("W")
    }

    it("should turn right") {
      val scover = Scover(1, 1, "N", List(Command("R")))
      scover.run

      scover.direction should be ("E")
    }

    it("should move") {
      val scover = Scover(0, 1, "N", List(Command("M")))
      scover.run

      scover.x should be (0)
      scover.y should be (1)
    }

    it("should return (0, 0, E)") {
      val scover = Scover(0, 1, "N", List(Command("M")))
      scover.run should be ((0, 0, "E"))
    }
  }
}
