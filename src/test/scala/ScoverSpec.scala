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
      Scover(1, 1, "E", List(Command("L"))).run should be (1,1,"N")
      Scover(1, 1, "S", List(Command("L"))).run should be (1,1,"E")
      Scover(1, 1, "W", List(Command("L"))).run should be (1,1,"S")
      //given {startPosIs => (1,1,"N")} and {commandIs => Command("L")} when scoverIsRun then "endPos" should be (1,1,"W")
    }

    it("should turn right") {
      Scover(1, 1, "N", List(Command("R"))).run should be (1,1,"E")
      Scover(1, 1, "E", List(Command("R"))).run should be (1,1,"S")
      Scover(1, 1, "S", List(Command("R"))).run should be (1,1,"W")
      Scover(1, 1, "W", List(Command("R"))).run should be (1,1,"N")
    }

    it("should move") {
      Scover(0, 1, "N", List(Command("M"))).run should be (0,2,"N")
      Scover(0, 1, "E", List(Command("M"))).run should be (1,1,"E")
      Scover(0, 1, "S", List(Command("M"))).run should be (0,0,"S")
      Scover(0, 1, "W", List(Command("M"))).run should be (-1,1,"W")

    }


  }

  
}
