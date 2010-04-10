import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec


@RunWith(classOf[JUnitRunner])
class FunctionThrowingMissionSpec extends Spec with ShouldMatchers {

  describe("Direction") {

    it("should get clockwise point") {

      Direction.clockwise("E") should be("S")
      Direction.clockwise("N") should be("E")


    }

    it("should get anticlockwise point") {

      Direction.anticlockwise("S") should be("E")
      Direction.anticlockwise("E") should be("N")

    }

  }

}