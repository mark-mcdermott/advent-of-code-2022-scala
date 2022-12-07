import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class Day3Test extends AnyFunSuite {

  val day3 = new Day3
  val firstLine = "WjmsdnddnmQPZPPJPL"

  val firstTwoLines = """WjmsdnddnmQPZPPJPL
bQllTtpBlgwtrbbCwfZcfSFPSfLCSF"""

  val first3Lines = """WjmsdnddnmQPZPPJPL
bQllTtpBlgwtrbbCwfZcfSFPSfLCSF
GgVgQrlpphBGrlVGgTtsRHRWVRMzRdVsqdnDnV"""

  val badgeInput1 = """rtFz
yeSzL
zEyslfsDFG"""

  val badgeInput2 =
    """rtFz
yeSzL
zEyslfsDFG
asYAW
jiaI
poqa"""

  val badgeInput3 =
    """rtFz
yeSzL
zEyslfsDFG
asYAW
jiaI
poqa
uZyio
ZhdioS
tewWZ"""

  val badgeInput4 =
    """rtFz
yeSzL
zEyslfsDFG
asYAW
jiaI
poqa
uZyio
ZhdioS
tewWZ
jsdJ3s"""

  test("getCharsInBothCompartments: first line") {
    day3.getCharsInBothCompartments(firstLine) should equal(List('m'))
  }
  test("getCharsInBothCompartments: first two lines") {
    day3.getCharsInBothCompartments(firstTwoLines) should equal(List('m','w'))
  }
  test("getCharsInBothCompartments: third line") {
    day3.getCharsInBothCompartments("GgVgQrlpphBGrlVGgTtsRHRWVRMzRdVsqdnDnV") should equal(List('V'))
  }

  test("charToInt: a") {
    day3.charToInt('a') should equal(1)
  }
  test("charToInt: m") {
    day3.charToInt('m') should equal(13)
  }
  test("charToInt: z") {
    day3.charToInt('z') should equal(26)
  }
  test("charToInt: A") {
    day3.charToInt('A') should equal(27)
  }
  test("charToInt: Z") {
    day3.charToInt('Z') should equal(52)
  }

  test("getPriorities: ybbi") {
    day3.getPriorities(day3.getCharsInBothCompartments("ybbi")) should equal (List(2))
  }
  test("getPriorities: first line") {
    day3.getPriorities(day3.getCharsInBothCompartments(firstLine)) should equal(List(13))
  }
  test("getPriorities: first two lines") {
    day3.getPriorities(day3.getCharsInBothCompartments(firstTwoLines)) should equal(List(13,23))
  }

  test("prioritySumFromInitialInput: ybbi") {
    day3.part1PrioritySumFromInitialInput("ybbi") should equal(2)
  }
  test("prioritySumFromInitialInput: first line") {
    day3.part1PrioritySumFromInitialInput(firstLine) should equal(13)
  }
  test("prioritySumFromInitialInput: first two line") {
    day3.part1PrioritySumFromInitialInput(firstTwoLines) should equal(36) // m,w -> 13,23
  }
  test("prioritySumFromInitialInput: first3Lines") {
    day3.part1PrioritySumFromInitialInput(first3Lines) should equal(84) // m,w,V -> 13,23,48
  }

  test("getBadgeCharList: badgeInput1") {
    day3.getBadgeCharList(badgeInput1) should equal(List('z'))
  }
  test("getBadgeCharList: badgeInput2") {
    day3.getBadgeCharList(badgeInput2) should equal(List('z','a'))
  }

  test("part2GetBadgePrioiritySum: badgeInput1") {
    day3.part2GetBadgePrioiritySum(badgeInput1) should equal(26) // z -> 26
  }
  test("part2GetBadgePrioiritySum: badgeInput2") {
    day3.part2GetBadgePrioiritySum(badgeInput2) should equal(27) // z,a -> 26,1
  }
  test("part2GetBadgePrioiritySum: badgeInput3") {
    day3.part2GetBadgePrioiritySum(badgeInput3) should equal(79) // z,a,Z -> 26,1,52
  }
  test("part2GetBadgePrioiritySum: badgeInput4") {
    day3.part2GetBadgePrioiritySum(badgeInput4) should equal(79) // z,a,Z -> 26,1,52
  }



}
