import RunDay5.input

import scala.io.Source
import scala.util.matching.Regex

object RunDay5 extends App {

  val file = "src/main/input/day5Input.txt"
  val input = Source.fromFile(file).getLines().mkString("\n")
  val day5 = new Day5

  // println("part 1: " + day5.part1GetTopCrates(input)) // QPJPLMNNR
  println("part 2: " + day5.part2GetTopCrates(input))

}

class Day5 {
  var stacks = Array.ofDim[Char](9, 0)

  def moveCrate(fromColNum:Int, toColNum:Int): Unit = {

    // remove last crate from the From column
    val fromColIndex = fromColNum - 1
    val fromCol = stacks(fromColIndex)
    val lastCrateIndexInFromCol = getLastCrateIndex(fromCol)
    val crateToMoveLetter = stacks(fromColIndex)(lastCrateIndexInFromCol)
    stacks(fromColIndex) = stacks(fromColIndex).dropRight(1)

    // add the crate to the To column
    val toColIndex = toColNum -1
    val toCol = stacks(toColIndex)
    val lastCrateIndexInToCol = getLastCrateIndex(toCol)
    stacks(toColIndex) = stacks(toColIndex).:+(crateToMoveLetter)
  }

  def moveCrates(fromColNum: Int, toColNum: Int, crates:Array[Char]): Unit = {

    // remove crates to move from From column
    val fromColIndex = fromColNum - 1
    stacks(fromColIndex) = stacks(fromColIndex).dropRight(crates.length)

    // add the crate to move to the To column
    val toColIndex = toColNum - 1
    stacks(toColIndex) = Array.concat(stacks(toColIndex),(crates))
  }

  def getLastCrateIndex(stack: Array[Char]): Int = {
    var index: Int = -1
    for (i <- 0 to stack.length-1) {
      if (stack(i) != '\u0000') {
        index = i;
      }
    }
    index
  }

  def moveCratesAndReverseOrder(input:String, linesToRun:Int = -1): Array[Array[Char]] = {
    stacks = getInitialStacks(input)
    printStacks(stacks)
    println("0. Initial Setup\n\n")
    var linesRun = 0
    val linesIterator = input.linesIterator
    for (line <- linesIterator) {
      if (line.contains("move")) {
        if (linesToRun == -1 | linesRun < linesToRun) {
          val regex: Regex = "move ([0-9]+) from ([0-9]) to ([0-9])".r
          for (patternMatch <- regex.findFirstMatchIn(line)) {
            val numToMove = patternMatch.group(1).toInt
            val fromCol = patternMatch.group(2).toInt
            val toCol = patternMatch.group(3).toInt
            for (i <- 1 to numToMove) {
              moveCrate(fromCol, toCol)
            }
            printStacks(stacks)
            val lineNo = linesRun + 10
            val tempLinesRun = linesRun + 1
            println("Step #" + tempLinesRun + " (line " + lineNo + "): " + line + "\n\n")
          }
        }
        linesRun += 1
      }
    }
    stacks
  }

  def moveCratesInSameOrder(input: String, linesToRun: Int = -1): Array[Array[Char]] = {
    stacks = getInitialStacks(input)
    printStacks(stacks)
    println("0. Initial Setup\n\n")
    var linesRun = 0
    val linesIterator = input.linesIterator
    for (line <- linesIterator) {
      if (line.contains("move")) {
        if (linesToRun == -1 | linesRun < linesToRun) {
          val regex: Regex = "move ([0-9]+) from ([0-9]) to ([0-9])".r
          for (patternMatch <- regex.findFirstMatchIn(line)) {
            val numToMove = patternMatch.group(1).toInt
            val fromCol = patternMatch.group(2).toInt
            val toCol = patternMatch.group(3).toInt

            val fromStartIndex = stacks(fromCol-1).length - numToMove
            val fromEndIndex = stacks(fromCol-1).length - 1
            val cratesToMove = stacks(fromCol-1).slice(fromStartIndex,fromEndIndex+1)

            moveCrates(fromCol,toCol,cratesToMove)

//            for (i <- 1 to numToMove) {
//              moveCrate(fromCol, toCol)
//            }
            printStacks(stacks)
            val lineNo = linesRun + 10
            val tempLinesRun = linesRun + 1
            println("Step #" + tempLinesRun + " (line " + lineNo + "): " + line + "\n\n")
          }
        }
        linesRun += 1
      }
    }
    stacks
  }

  def part1GetTopCrates(input:String, runToLine:Int = -1): String = {
    var topCrates:String = ""
    val linesToRun = if (runToLine == -1) -1 else runToLine - 10
    moveCratesAndReverseOrder(input, linesToRun)
    for (i <- 0 to stacks.length-1) {
      val stack = stacks(i)
      val stackLen = stack.length
      if (stackLen > 0) {
        val lastCrate = stack(stack.length - 1)
        topCrates += lastCrate
      } else {
        val lastCrate = ' '
        topCrates += lastCrate
      }
    }
    topCrates
  }

  def part2GetTopCrates(input: String, runToLine: Int = -1): String = {
    var topCrates: String = ""
    val linesToRun = if (runToLine == -1) -1 else runToLine - 10
    moveCratesInSameOrder(input, linesToRun)
    for (i <- 0 to stacks.length - 1) {
      val stack = stacks(i)
      val stackLen = stack.length
      if (stackLen > 0) {
        val lastCrate = stack(stack.length - 1)
        topCrates += lastCrate
      } else {
        val lastCrate = ' '
        topCrates += lastCrate
      }
    }
    topCrates
  }

  def getInitialStacks(input:String): Array[Array[Char]] = {
    val linesIterator = input.linesIterator
    for (line <- linesIterator) {
      if (!line.isEmpty & !line.contains("move") & !line.contains(" 1   2   3   4   5   6   7   8   9")) {
        val regex: Regex = "(.[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?".r
        for (patternMatch <- regex.findFirstMatchIn(line)) {
          val col1Crate: Char = if (patternMatch.group(1) != null) (patternMatch.group(1))(1) else ' '
          val col2Crate: Char = if (patternMatch.group(2) != null) (patternMatch.group(2))(2) else ' '
          val col3Crate: Char = if (patternMatch.group(3) != null) (patternMatch.group(3))(2) else ' '
          val col4Crate: Char = if (patternMatch.group(4) != null) (patternMatch.group(4))(2) else ' '
          val col5Crate: Char = if (patternMatch.group(5) != null) (patternMatch.group(5))(2) else ' '
          val col6Crate: Char = if (patternMatch.group(6) != null) (patternMatch.group(6))(2) else ' '
          val col7Crate: Char = if (patternMatch.group(7) != null) (patternMatch.group(7))(2) else ' '
          val col8Crate: Char = if (patternMatch.group(8) != null) (patternMatch.group(8))(2) else ' '
          val col9Crate: Char = if (patternMatch.group(9) != null) (patternMatch.group(9))(2) else ' '
          if (col1Crate != ' ') stacks(0) = stacks(0).+:(col1Crate)
          if (col2Crate != ' ') stacks(1) = stacks(1).+:(col2Crate)
          if (col3Crate != ' ') stacks(2) = stacks(2).+:(col3Crate)
          if (col4Crate != ' ') stacks(3) = stacks(3).+:(col4Crate)
          if (col5Crate != ' ') stacks(4) = stacks(4).+:(col5Crate)
          if (col6Crate != ' ') stacks(5) = stacks(5).+:(col6Crate)
          if (col7Crate != ' ') stacks(6) = stacks(6).+:(col7Crate)
          if (col8Crate != ' ') stacks(7) = stacks(7).+:(col8Crate)
          if (col9Crate != ' ') stacks(8) = stacks(8).+:(col9Crate)
        }
      }
    }
    stacks
  }

  def printStacks(stacks: Array[Array[Char]]): Unit = {
    for (i <- 0 to 8) {
      print(i+1 + " [")
      for (j <- 0 to stacks(i).length - 1) {
        val char = stacks(i)(j)
        if (char != '\u0000') {
          if (j < stacks(i).length-1) print(char + ", ")
          else print(char)
        }
      }
      print("]\n")
    }
    println("")
  }

}
