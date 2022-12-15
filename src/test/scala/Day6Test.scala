import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class Day6Test extends AnyFunSuite {

  test("part1GetFourUniqueIndex: abcd") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("abcd") should equal(4)
  }
  test("part1GetFourUniqueIndex: abcde") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("abcde") should equal(4)
  }
  test("part1GetFourUniqueIndex: aabcd") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("aabcd") should equal(5)
  }
  test("part1GetFourUniqueIndex: mjqjpqmgbljsphdztnvjfqwrcgsmlb") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("mjqjpqmgbljsphdztnvjfqwrcgsmlb") should equal(7)
  }
  test("part1GetFourUniqueIndex: bvwbjplbgvbhsrlpgdmjqwftvncz") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("bvwbjplbgvbhsrlpgdmjqwftvncz") should equal(5)
  }
  test("part1GetFourUniqueIndex: nppdvjthqldpwncqszvftbrmjlhg") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("nppdvjthqldpwncqszvftbrmjlhg") should equal(6)
  }
  test("part1GetFourUniqueIndex: nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") should equal(10)
  }
  test("part1GetFourUniqueIndex: zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") {
    val day6 = new Day6
    day6.part1GetFourUniqueIndex("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") should equal(11)
  }

  test("part2GetFourteenUniqueIndex: abcdefghijklmn") {
    val day6 = new Day6
    day6.part2GetFourteenUniqueIndex("abcdefghijklmn") should equal(14)
  }
  test("part2GetFourteenUniqueIndex: abcdefghijklmno") {
    val day6 = new Day6
    day6.part2GetFourteenUniqueIndex("abcdefghijklmno") should equal(14)
  }
  test("part2GetFourteenUniqueIndex: aabcdefghijklmno") {
    val day6 = new Day6
    day6.part2GetFourteenUniqueIndex("aabcdefghijklmno") should equal(15)
  }

}
