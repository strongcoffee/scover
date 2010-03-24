import util.parsing.combinator.RegexParsers

object TestRegexParser extends RegexParsers {

  def numberLiteral = regex("[0-9]".r)
  def directionLiteral = regex("[NSEW]".r)
  def commandLiteral = regex("[MLR]".r)

  def command:Parser[Command] = commandLiteral ^^ { case c => Command(c) }
  def rover:Parser[Rover] = numberLiteral ~ numberLiteral ~ directionLiteral ~ commands ^^ { case x ~ y ~ d ~ c => Rover(x.toInt, y.toInt, d, c) }
  def plateau:Parser[Plateau] = numberLiteral ~ numberLiteral ^^ { case x ~ y => Plateau(x.toInt, y.toInt) }

  def commands:Parser[List[Command]] = (command *)
//  def item = rover ~ commands
//  def items = plateau ~ (rover *)
  def items = plateau ~ (rover *)

  def parseItem(str: String) = parse(items, str)
}
