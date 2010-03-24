import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.specs.Specification
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import scala.util.parsing.combinator.syntactical._
import util.parsing.combinator.Parsers


@RunWith(classOf[JUnitRunner])
class TestRegexParserSpec extends Spec with ShouldMatchers with MockitoSugar with Parsers {

  describe("test regex parser should") {
    it("parse stuff") {
      val junk = """5 6
1 2 N
MLMMR"""
      val parser = (TestRegexParser)
      val plateau = parser.parseItem(junk)

      print(plateau)
//      plateau.map { n => print(n) }
    }
  }
}
