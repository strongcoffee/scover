import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import util.parsing.combinator.Parsers


@RunWith(classOf[JUnitRunner])
class MissionParserSpec extends Spec with ShouldMatchers with Parsers {
  describe("mission parser should") {
    it("parse a move command") {
      val s = "M"
      val parser = new MissionParser
      val command: Command = parser.parse(parser.command, s).get

      command.command should be (s)
    }

    it("parse a left command") {
      val s = "L"
      val parser = new MissionParser
      val command: Command = parser.parse(parser.command, s).get

      command.command should be (s)
    }

    it("parse a right command") {
      val s = "R"
      val parser = new MissionParser
      val command: Command = parser.parse(parser.command, s).get
      
      command.command should be (s)
    }

    it ("parse multiple commands") {
      val s = "MLR"
      val parser = new MissionParser
      val commands: List[Command] = parser.parse(parser.commands, s).get

      commands should be (Command("M") :: Command("L") :: Command("R") :: Nil)
    }

    it ("parse a plateau") {
      val s = "2 3"
      val parser = new MissionParser
      val plateau: Plateau = parser.parse(parser.plateau, s).get

      plateau.x should be (2)
      plateau.y should be (3)
    }

    it ("parse a scover") {
      val s = "1 2 N\nLMR"
      val parser = new MissionParser
      val scover: Scover = parser.parse(parser.scover, s).get

      scover.x should be (1)
      scover.y should be (2)
      scover.direction should be ("N")
      scover.commands should be (Command("L") :: Command("M") :: Command("R") :: Nil)

    }

    it("throw runtime exception when presented with unknown command") {
      val s = "C"
      val parser = new MissionParser

      try {
        parser.parse(parser.command, s)
      } catch {
        case e: RuntimeException => e should be ("No result when parsing failed")
        case _ => fail
      }
    }
  }
}