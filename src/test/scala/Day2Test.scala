import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class Day2Test extends AnyFunSuite {

  val day2 = new Day2

  test("gameResult: rock & rock") { day2.gameResult("A X") should equal("draw") }
  test("gameResult: rock & paper") { day2.gameResult("A Y") should equal("win") }
  test("gameResult: rock & scissors") { day2.gameResult("A Z") should equal("loss") }
  test("gameResult: paper & rock") { day2.gameResult("B X") should equal("loss") }
  test("gameResult: paper & paper") { day2.gameResult("B Y") should equal("draw") }
  test("gameResult: paper & scissors") { day2.gameResult("B Z") should equal("win") }
  test("gameResult: scissors & rock") { day2.gameResult("C X") should equal("win") }
  test("gameResult: scissors & paper") { day2.gameResult("C Y") should equal("loss") }
  test("gameResult: scissors & scissors") { day2.gameResult("C Z") should equal("draw") }

  test("gameScore: rock & rock") { day2.gameScore("A X") should equal(4) }
  test("gameScore: rock & paper") { day2.gameScore("A Y") should equal(8) }
  test("gameScore: rock & scissors") { day2.gameScore("A Z") should equal(3) }
  test("gameScore: paper & rock") { day2.gameScore("B X") should equal(1) }
  test("gameScore: paper & paper") { day2.gameScore("B Y") should equal(5) }
  test("gameScore: paper & scissors") { day2.gameScore("B Z") should equal(9) }
  test("gameScore: scissors & rock") { day2.gameScore("C X") should equal(7) }
  test("gameScore: scissors & paper") { day2.gameScore("C Y") should equal(2) }
  test("gameScore: scissors & scissors") { day2.gameScore("C Z") should equal(6) }

  val twoLines = """A Z
A Y"""

  val sevenLines = """A Z
A Y
B X
B X
C X
B X
A X"""


  test("scoreSum: first two lines") { day2.scoreSumFromThemAndMeInput(twoLines) should equal(11) }
  test("scoreSum: first seven lines") { day2.scoreSumFromThemAndMeInput(sevenLines) should equal(25) }
}
