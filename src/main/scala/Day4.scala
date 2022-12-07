import scala.io.Source
import scala.util.matching.Regex

object RunDay4 extends App {

  val inputPath = "src/main/input/day4.txt"
  val input = Source.fromFile(inputPath).getLines().mkString("\n")
  val day4 = new Day4
  println("part 1: " + day4.part1CountContained(input)) // 595
  println("part 2: " + day4.part2CountOverlaps(input)) // 952

}

class Day4 {

  def part1CountContained(input:String): Int = {
    val linesIterator = input.linesIterator
    var count = 0
    for (line <- linesIterator) {
      val ranges: Regex = "([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)".r
      for (patternMatch <- ranges.findAllMatchIn(line)) {
        val aLow = patternMatch.group(1).toInt
        val aHigh = patternMatch.group(2).toInt
        val bLow = patternMatch.group(3).toInt
        val bHigh = patternMatch.group(4).toInt
        if (
          (aLow >= bLow) & (aHigh <= bHigh) |
          (bLow >= aLow) & (bHigh <= aHigh)
        ) count += 1
      }
    }
    count
  }

  def part2CountOverlaps(input: String): Int = {
    val linesIterator = input.linesIterator
    var count = 0
    for (line <- linesIterator) {
      val ranges: Regex = "([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)".r
      for (patternMatch <- ranges.findAllMatchIn(line)) {
        val aLow = patternMatch.group(1).toInt
        val aHigh = patternMatch.group(2).toInt
        val bLow = patternMatch.group(3).toInt
        val bHigh = patternMatch.group(4).toInt
        if (
          (aLow >= bLow) & (aLow <= bHigh) |
            (aHigh >= bLow) & (aHigh <= bHigh) |
            (bLow >= aLow) & (bLow <= aHigh) |
            (bHigh >= aLow) & (bHigh <= aHigh)
        ) count += 1
      }
    }
    count
  }

}
