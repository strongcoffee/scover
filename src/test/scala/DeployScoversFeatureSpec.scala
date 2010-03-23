import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{GivenWhenThen, FeatureSpec}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

@RunWith(classOf[JUnitRunner])
class DeployScoversFeatureSpec extends FeatureSpec with ShouldMatchers with GivenWhenThen with MockitoSugar {


  def runProgram(spec: String): String = {

    val in = new java.io.StringReader(spec)
    val out = new java.io.ByteArrayOutputStream

    Console.withOut(out) {
      Console.withIn(in) {

        (ScoverConsole).main(new Array[String](0))
      }
    }

    out.toString

  }


  feature("little scover takes first steps") {

    scenario("move forward") {

      val spec =
      """ |5 5
          |0 0 N
          |M""".stripMargin

      runProgram(spec) should equal("0 1 N")
    }


    scenario("turn left") {

      pending

      val spec =
      """ |5 5
          |0 0 N
          |L""".stripMargin

      runProgram(spec) should equal("0 0 W")
    }

    scenario("turn right") {

      pending

      val spec =
      """ |5 5
          |0 0 N
          |R""".stripMargin

      runProgram(spec) should equal("0 0 E")
    }


    scenario("practices some ballet") {

      pending

      val spec =
      """ |5 5
          |0 0 E
          |L MLM""".stripMargin

      runProgram(spec) should equal("1 1 N")

    }
  }
}

