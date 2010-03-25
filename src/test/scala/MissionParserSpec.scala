import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import util.parsing.combinator.Parsers


@RunWith(classOf[JUnitRunner])
class MissionParserSpec extends Spec with ShouldMatchers with MockitoSugar with Parsers {

  describe("test regex parser") {

    it("should parse a mission with only a plateau") {

      (new MissionParser).parseMission("5 6") should equal(Mission(Plateau(5, 6), List[Rover]()))
    }

    it("should parse a mission with a plateau and one rover") {

      val spec = """5 6
                   |1 1 E
                   |ML""".stripMargin

      (new MissionParser).parseMission(spec) should equal(Mission(Plateau(5, 6), List(Rover(1, 1, "E",
        List(Command("M"), Command("L"))))))

    }


    it("should parse a mission with a plateau and two rovers") {

      val spec = """5 6
                   |1 1 E
                   |M
                   |3 2 W
                   |L R""".stripMargin

      (new MissionParser).parseMission(spec) should equal(Mission(Plateau(5, 6),
        List(Rover(1, 1, "E", List(Command("M"))),
          Rover(3, 2, "W", List(Command("L"), Command("R"))))))

    }

    it("should not accept junk") {

      val caught = intercept[IllegalArgumentException] {
        (new MissionParser).parseMission("tom's work")
      }
      caught.getMessage should be ("Bad syntax: tom's work")

    }
  }


}
