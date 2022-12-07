import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class Day4Test extends AnyFunSuite {

  val day4 = new Day4

  val first9Lines =
    """
      |23-33,24-65
      |10-24,23-88
      |71-92,18-71
      |2-2,10-95
      |24-26,25-66
      |19-93,36-99
      |12-99,5-13
      |13-88,14-94
      |4-85,5-84
      |""".stripMargin

  val first13Lines =
  """23-33,24-65
    |10-24,23-88
    |71-92,18-71
    |2-2,10-95
    |24-26,25-66
    |19-93,36-99
    |12-99,5-13
    |13-88,14-94
    |4-85,5-84
    |78-88,79-87
    |13-82,13-83
    |3-98,3-99
    |27-69,28-89""".stripMargin

  test("part1CountContained: 23-33,24-65") {
    day4.part1CountContained("23-33,24-65") should equal(0)
  }
  test("part1CountContained: 4-85,5-84") {
    day4.part1CountContained("4-85,5-84") should equal(1)
  }
  test("part1CountContained: 2-2,10-95") {
    day4.part1CountContained("2-2,10-95") should equal(0)
  }
  test("part1CountContained: first9Lines") {
    day4.part1CountContained(first9Lines) should equal(1)
  }
  test("part1CountContained: first13Lines") {
    day4.part1CountContained(first13Lines) should equal(4)
  }

  test("part2CountOverlaps: 23-33,24-65") {
    day4.part2CountOverlaps("23-33,24-65") should equal(1)
  }
  test("part2CountOverlaps: 4-85,5-84") {
    day4.part2CountOverlaps("4-85,5-84") should equal(1)
  }
  test("part2CountOverlaps: 2-2,10-95") {
    day4.part2CountOverlaps("2-2,10-95") should equal(0)
  }

//  23 - 33, 24 - 65 y
//  10 - 24, 23 - 88 y
//  71 - 92, 18 - 71 y
//  2 - 2, 10 - 95   n
//  24 - 26, 25 - 66 y
//  19 - 93, 36 - 99 y
//  12 - 99, 5 - 13  y
//  13 - 88, 14 - 94 y
//  4 - 85, 5 - 84   y
//  78 - 88, 79 - 87 y
//  13 - 82, 13 - 83 y
//  3 - 98, 3 - 99   y
//  27 - 69, 28 - 89 y
  test("part2CountOverlaps: first9Lines") {
    day4.part2CountOverlaps(first9Lines) should equal(8)
  }
  test("part2CountOverlaps: first13Lines") {
    day4.part2CountOverlaps(first13Lines) should equal(12)
  }

}
