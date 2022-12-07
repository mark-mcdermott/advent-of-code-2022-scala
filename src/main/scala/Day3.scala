import scala.io.Source

object RunDay3 extends App {

  val filePath = "src/main/input/day3.txt"
  val input = Source.fromFile(filePath).getLines().mkString("\n")
  val day3 = new Day3
  println("part 1: " + day3.part1PrioritySumFromInitialInput(input)) // 7568
  println("part 2: " + day3.part2GetBadgePrioiritySum(input)) // 2780

}

class Day3 {

  def getBadgeCharList(input:String): List[Char] = {
    val badgeCharList = List.newBuilder[Char]
    val lineIterator = input.linesIterator
    var linesGroup = List.newBuilder[String]
    for (line <- lineIterator) {
      linesGroup += line
      if (linesGroup.result().length == 3) {
        val firstLine = linesGroup.result()(0)
        val commonCharList = List.newBuilder[Char]
        for (char <- firstLine) {
          if (linesGroup.result()(1).contains(char) & linesGroup.result()(2).contains(char)) {
            commonCharList += char
          }
        }
        badgeCharList += commonCharList.result().head
        linesGroup = List.newBuilder
      }
    }
//    println(badgeCharList.result())
    badgeCharList.result()
  }

  def part2GetBadgePrioiritySum(input:String): Int = {
    val badgeCharList = getBadgeCharList(input)
    val badgePrioirtyList = getPriorities(badgeCharList)
    badgePrioirtyList.sum
  }

  def getCharsInBothCompartments(input: String): List[Char] = {
    val lineIterator = input.linesIterator
    val commonLetters = List.newBuilder[Char]
    for (line <- lineIterator) {
      val size = line.length
      if ((size % 2) != 0) println("error")
      val half = size / 2
      val firstHalf:String = line.substring(0,half)
      val secondHalf:String = line.substring(half)
      val charListThisLine = List.newBuilder[Char]
      firstHalf.foreach(char => {
        if (secondHalf.contains(char)) charListThisLine += char
      })
      val repeatedCharThisLine = charListThisLine.result().head
      commonLetters += repeatedCharThisLine
    }
    commonLetters.result()
  }

  def charToInt(letter: Char): Int = {
    val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    alphabet.indexOf(letter) + 1
  }

  def getPriorities(charList:List[Char]):List[Int] = {
    val priorityList = charList.map(charToInt)
    priorityList
  }

  def part1PrioritySumFromInitialInput(input:String): Int =
    getPriorities(getCharsInBothCompartments(input)).sum

}
