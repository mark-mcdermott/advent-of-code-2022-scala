import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

import scala.io.Source

class Day5Test extends AnyFunSuite {

  val examplefile = "src/main/input/day5ExampleInput.txt"
  val exampleInput = Source.fromFile(examplefile).getLines().mkString("\n")
  val file = "src/main/input/day5Input.txt"
  val input = Source.fromFile(file).getLines().mkString("\n")

  test("getTopCrates: aoc example - all lines") {
    new Day5().part1GetTopCrates(exampleInput) should equal("CMZ")
  }

  test("getTopCrates: to line 11") {
    new Day5().part1GetTopCrates(input,11) should equal("MHGSNWSVF")
  }

  test("getTopCrates: to line 12") {
    new Day5().part1GetTopCrates(input,12) should equal("MHGFNWSVN")
  }

  test("getTopCrates: to line 13") {
    new Day5().part1GetTopCrates(input,13) should equal("MHGFNMSVL")
  }

  test("getTopCrates: to line 14") {
    new Day5().part1GetTopCrates(input,14) should equal("MWHFNMSVL")
  }

  test("getTopCrates: to line 15") {
    new Day5().part1GetTopCrates(input,15) should equal("MWHFNQSL")
  }

  test("getTopCrates: to line 16") {
    new Day5().part1GetTopCrates(input, 16) should equal("MWQFNTSL")
  }

  test("getTopCrates: to line 17") {
    new Day5().part1GetTopCrates(input, 17) should equal("MPQFNTSN")
  }

  test("getTopCrates: to line 18") {
    new Day5().part1GetTopCrates(input, 18) should equal("MQFNTSP")
  }

  test("getTopCrates: to line 19") {
    new Day5().part1GetTopCrates(input, 19) should equal("MQFCBSP")
  }

  test("getTopCrates: to line 20") {
    new Day5().part1GetTopCrates(input, 20) should equal("MQZMBSP")
  }

  test("getTopCrates: to line 21") {
    new Day5().part1GetTopCrates(input, 21) should equal("SQZMMSP")
  }

  test("getTopCrates: to line 22") {
    new Day5().part1GetTopCrates(input, 22) should equal("SQLMMS")
  }

  test("getTopCrates: to line 23") {
    new Day5().part1GetTopCrates(input, 23) should equal("MQLMS")
  }

  test("getTopCrates: to line 24") {
    new Day5().part1GetTopCrates(input, 24) should equal("MLMSW")
  }

  test("getTopCrates: to line 25") {
    new Day5().part1GetTopCrates(input, 25) should equal("PCMSW")
  }

  test("getTopCrates: to line 26") {
    new Day5().part1GetTopCrates(input, 26) should equal("PWCMSR")
  }

  test("getTopCrates: to line 27") {
    new Day5().part1GetTopCrates(input, 27) should equal("PCWSR")
  }

  test("getTopCrates: to line 28") {
    new Day5().part1GetTopCrates(input, 28) should equal("WJCWSR")
  }

  test("getTopCrates: to line 29") {
    new Day5().part1GetTopCrates(input, 29) should equal("WJFWSCR")
  }

  test("getTopCrates: to line 30") {
    new Day5().part1GetTopCrates(input, 30) should equal("WCFWSR")
  }

}
