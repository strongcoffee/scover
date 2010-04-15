import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar


@RunWith(classOf[JUnitRunner])
class ScoverSpec extends Spec with ShouldMatchers {

  describe("scover") {
    it("should turn left") {

      Map("N"->"W", "E"->"N", "S"->"E", "W"->"S").foreach{ case(before, after) =>

        Scover(1, 1, before, List("L")).run should be (1,1,after)
      }
    }

    it("should turn right") {

      Map("N"->"E", "E"->"S", "S"->"W", "W"->"N").foreach{ case(before, after) =>

        Scover(1, 1, before, List("R")).run should be (1,1,after)
      }

    }

    it("should move") {

      val (x,y) = (23432,666)

      Map((x,y,"N")->(x,   y+1, "N"),
          (x,y,"E")->(x+1, y,   "E"),
          (x,y,"S")->(x,   y-1, "S"),
          (x,y,"W")->(x-1, y,   "W")

        ).foreach{ case(before, after) =>

        Scover(before._1, before._2, before._3, List("M")).run should be (after)
      }
    }


  }

  
}
