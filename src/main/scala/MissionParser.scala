import util.parsing.combinator.RegexParsers

class MissionParser extends RegexParsers {

  def numberLiteral = regex("[0-9]"r)
  def directionLiteral = regex("[NSEW]"r)
  def commandLiteral = regex("[MLR]"r)

  def command:Parser[Command] = commandLiteral ^^ { case c => Command(c) }
  def scover:Parser[Scover] = numberLiteral ~ numberLiteral ~ directionLiteral ~ commands ^^ { case x ~ y ~ d ~ c => Scover(x.toInt, y.toInt, d, c) }
  def plateau:Parser[Plateau] = numberLiteral ~ numberLiteral ^^ { case x ~ y => Plateau(x.toInt, y.toInt) }


  def commands:Parser[List[Command]] = (command *)
  def rovers:Parser[List[Scover]] = (scover *)

  //def mission:Parser[Mission] = plateau ~ rovers ^^ {case p ~ r  => Mission(p,r)}
  def mission:Parser[Mission] = plateau ~ scover ^^ {case p ~ r  => Mission(p,r)}


  def parseMission(s:String): Mission = {
    parse(mission, s) match {
      case Success(result, _) => result
      case _ => throw new IllegalArgumentException("Bad syntax: " + s)
    }
  }
}
