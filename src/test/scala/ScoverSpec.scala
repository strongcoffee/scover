import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar


@RunWith(classOf[JUnitRunner])
class ScoverSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("scover") {
    it("should turn left") {
      Scover(1, 1, "N", List(Command("L"))).run should be (1,1,"W")
    }

    it("should turn right") {
      Scover(1, 1, "N", List(Command("R"))).run should be (1,1,"E")
    }

    it("should move") {
      Scover(0, 1, "N", List(Command("M"))).run should be (0,2,"N")

    }
    
  }
}
