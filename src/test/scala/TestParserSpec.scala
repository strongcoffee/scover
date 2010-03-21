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
class TestParserSpec extends Spec with ShouldMatchers with MockitoSugar with Parsers {

  describe("test parser should") {
    it("parse stuff") {
      val parser = (TestParser)
      val plateau = parser.apply("2 3")

      plateau.x should be (2)
      plateau.y should be (3)
    }
  }
}
