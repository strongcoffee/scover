import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class MissionIntegrationSpec extends Spec with ShouldMatchers {

  describe("mission") {
    it("should run single scover command and return scover's final position") {

      val (x, y) = (42, 69)

      Map( "M" -> Map( (x,y,"N") -> (x,    y+1, "N") , (x,y,"W") -> (x-1,  y,   "W") ),

           "R" -> Map( (x,y,"N") -> (x, y, "E") , (x,y,"S") -> (x,  y,   "W") ),

           "L" -> Map( (x,y,"E") -> (x, y, "N") , (x,y,"W") -> (x,  y,   "S") ) )

      .foreach{ case(command, spec) =>

        val plateau = Plateau(100,100)

          spec.foreach{ case(startPos, endPos) => 

            val scover = Scover(startPos._1, startPos._2, startPos._3, List(command))

            Mission(plateau, scover).run should be (endPos)

          }
      }
    }

  }
}



