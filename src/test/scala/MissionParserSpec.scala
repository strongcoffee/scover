import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.specs.Specification
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._


@RunWith(classOf[JUnitRunner])
class MissionParserSpec extends Spec with ShouldMatchers with MockitoSugar {

  describe("mission parser should") {
    it("always return the same value as a tuple") {
      val parser = new MissionParser
      parser.parse("foo") should be ((0,0,"N"),"M")
    }
  }
}