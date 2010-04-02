import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar


@RunWith(classOf[JUnitRunner])
class RoverSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("rover") {
    it("should turn left") {
      val rover = Rover(1, 1, "N", List(Command("L")))
      rover.run
      
      rover.direction should be ("W")
    }

    it("should turn right") {
      val rover = Rover(1, 1, "N", List(Command("R")))
      rover.run

      rover.direction should be ("E")
    }

    it("should move") {
      val rover = Rover(0, 1, "N", List(Command("M")))
      rover.run

      rover.x should be (0)
      rover.y should be (1)
    }

    it("should return (0, 0, E)") {
      val rover = Rover(0, 1, "N", List(Command("M")))
      rover.run should be ((0, 0, "E"))
    }
  }
}
