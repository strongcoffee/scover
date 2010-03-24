import util.parsing.combinator.RegexParsers

object TestRegexParser extends RegexParsers {

  def number = regex("[0-9]".r)
  def direction = regex("[NSEW]".r)
  def char = regex("[A-Z]".r)

  def command:Parser[Command] = char ^^ { case c => Command(c) }
  def rover:Parser[Rover] = number ~ number ~ direction ^^ { case x ~ y ~ d => Rover(x.toInt, y.toInt, d) }
  def commands:Parser[List[Command]] = rep(command)
  def plateau:Parser[Plateau] = number ~ number ^^ { case x ~ y => Plateau(x.toInt, y.toInt) }

  def item = rover ~ commands
  def items = plateau ~ (item *)

  def parseItem(str: String) = parse(items, str)
}
