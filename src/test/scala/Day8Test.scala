import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class Day8Test extends AnyFunSuite {
  test("isVisibleHorizontally: 25512 index 1") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(1,"25512") should equal(true)
  }
  test("isVisibleHorizontally: 25512 index 2") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(2, "25512") should equal(true)
  }
  test("isVisibleHorizontally: 25512 index 3") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(3, "25512") should equal(false)
  }
  test("isVisibleHorizontally: 65332 index 1") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(1, "65332") should equal(true)
  }
  test("isVisibleHorizontally: 65332 index 2") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(2, "65332") should equal(false)
  }
  test("isVisibleHorizontally: 65332 index 3") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(3, "65332") should equal(true)
  }
  test("isVisibleHorizontally: 33549 index 1") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(1, "33549") should equal(false)
  }
  test("isVisibleHorizontally: 33549 index 2") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(2, "33549") should equal(true)
  }
  test("isVisibleHorizontally: 33549 index 3") {
    val day8 = new Day8(null)
    day8.isVisibleHorizontally(3, "33549") should equal(false)
  }

  test("isVisibleVertically: 1,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(1,1,trees) should equal(true)
  }
  test("isVisibleVertically: 1,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(1, 2, trees) should equal(true)
  }
  test("isVisibleVertically: 1,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(1, 3, trees) should equal(false)
  }
  test("isVisibleVertically: 2,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(2, 1, trees) should equal(false)
  }
  test("isVisibleVertically: 2,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(2, 2, trees) should equal(false)
  }
  test("isVisibleVertically: 2,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(2, 3, trees) should equal(false)
  }
  test("isVisibleVertically: 3,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(3, 1, trees) should equal(false)
  }
  test("isVisibleVertically: 3,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(3, 2, trees) should equal(true)
  }
  test("isVisibleVertically: 3,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisibleVertically(3, 3, trees) should equal(false)
  }
  test("isVisible: 1,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(1, 1, trees) should equal(true)
  }
  test("isVisible: 1,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(1, 2, trees) should equal(true)
  }
  test("isVisible: 1,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(1, 3, trees) should equal(false)
  }
  test("isVisible: 2,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(2, 1, trees) should equal(true)
  }
  test("isVisible: 2,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(2, 2, trees) should equal(false)
  }
  test("isVisible: 2,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(2, 3, trees) should equal(true)
  }
  test("isVisible: 3,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(3, 1, trees) should equal(false)
  }
  test("isVisible: 3,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(3, 2, trees) should equal(true)
  }
  test("isVisible: 3,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.isVisible(3, 3, trees) should equal(false)
  }
  test("visibleCount") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.part1GetVisibleCount(trees) should equal(21)
  }
    test("getHorizScore: 1,2") {
      val trees =
        """30373
          |25512
          |65332
          |33549
          |35390""".stripMargin.split("\n")
      val day8 = new Day8(trees)
      day8.getHorizScore(1,2,trees) should equal(2)
    }
  test("getHorizScore: 0,0") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getHorizScore(0, 0, trees) should equal(0)
  }
  test("getHorizScore: 0,1") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getHorizScore(0, 1, trees) should equal(1)
  }
  test("getHorizScore: 0,2") {
        val trees =
          """30373
            |25512
            |65332
            |33549
            |35390""".stripMargin.split("\n")
        val day8 = new Day8(trees)
        day8.getHorizScore(0, 2, trees) should equal(2)
      }
  test("getHorizScore: 0,3") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getHorizScore(0, 3, trees) should equal(3)
  }
  test("getVertScore: 1,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getVertScore(1, 2, trees) should equal(2)
  }
  test("getScenicScore: 1,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getScenicScore(1, 2, trees) should equal(4)
  }
  test("getScenicScore: 3,2") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.getScenicScore(3, 2, trees) should equal(8)
  }
  test("getHighestScenicScore: test input") {
    val trees =
      """30373
        |25512
        |65332
        |33549
        |35390""".stripMargin.split("\n")
    val day8 = new Day8(trees)
    day8.part2GetHighestScenicScore(trees) should equal(8)
  }

}