import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

import scala.List
import scala.io.Source

class Day1RoughTest extends AnyFunSuite {

  test("getLists: just List(1,2)") {
    val day1 = new Day1Rough
    val input1 =
    """1
2

"""
    day1.getLists(input1) should equal (List(List(1,2)))
  }

  test("getLists: List(1,2) and List(3,4)") {
    val day1 = new Day1Rough
    val input2 =
      """1
2

3
4

"""
    day1.getLists(input2) should equal(List(List(1, 2),List(3, 4)))
  }

  test("sumLists: just List(1,2)") {
    val day1 = new Day1Rough
    val input1 =
      """1
2

"""
    day1.sumLists(day1.getLists(input1)) should equal(List(3))
  }

  test("sumLists: List(1,2) and List(3,4)") {
    val day1 = new Day1Rough
    val input2 =
      """1
2

3
4

"""
    day1.sumLists(day1.getLists(input2)) should equal(List(3,7))
  }


  test("getMax: List(1,2)") {
    val day1 = new Day1Rough
    val input2 =
      """1
2

"""
    day1.getMax(day1.sumLists(day1.getLists(input2))) should equal(3)
  }

  test("getMax: List(1,2) and List(3,4)") {
    val day1 = new Day1Rough
    val input2 =
      """1
2

3
4

"""
    day1.getMax(day1.sumLists(day1.getLists(input2))) should equal(7)
  }


}
