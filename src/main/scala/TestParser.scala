import scala.util.parsing.combinator.syntactical._
import util.parsing.combinator.Parsers

object TestParser extends StandardTokenParsers with Parsers {
  lexical.delimiters ++= List(" ")

  def value = numericLit ^^ { s => s.toInt }
  def plateau = value ~ value ^^ { case x ~ y => Plateau(x, y) }

  def expr = ( plateau )

  def parse(s: String) = {
    val tokens = new lexical.Scanner(s)
    phrase(expr)(tokens)
  }

  def apply(s:String): Plateau = {
    parse(s) match {
      case Success(tree, _) => tree
      case _ => throw new IllegalArgumentException("Bad syntax: " + s)
    }
  }
}

