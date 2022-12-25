import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object RunDay8 extends App {

  val file = "src/main/input/day8Input.txt"
  val input = Source.fromFile(file).getLines().toArray
  val testInput =
    """30373
      |25512
      |65332
      |33549
      |35390""".stripMargin.split("\n")
  val day8 = new Day8(input)
  println(day8.part1GetVisibleCount(input)) // 1698
  println(day8.part2GetHighestScenicScore(input)) // 672280

}

class Day8(trees:Array[String]) {

  def getIntStringMax(set: String): Int = {
    set.toCharArray.map(_.asDigit).max
  }

  def isVisibleHorizontally(index:Int, line:String): Boolean = {
    val mid = line.charAt(index).asDigit
    val leftStr = line.substring(0, index)
    val rightStr = line.substring(index+1, line.length)
    val leftMax = getIntStringMax(leftStr)
    val rightMax = getIntStringMax(rightStr)
    if ((leftMax<mid) | (rightMax<mid)) true else false
  }

  def isVisibleVertically(row:Int, col:Int, trees:Array[String]): Boolean = {
    val mid = trees(row)(col).asDigit
    var topStr = ""
    for (thisRow <- 0 to (row-1)) {
      topStr += trees(thisRow)(col)
    }
    var botStr = ""
    for (thisRow <- row+1 to trees.length-1) {
      botStr += trees(thisRow)(col)
    }
    val topMax = getIntStringMax(topStr)
    val botMax = getIntStringMax(botStr)
    if ((topMax<mid) | (botMax<mid)) true else false
  }

  def isVisible(row:Int, col:Int, trees:Array[String]): Boolean = {
    val horiz = isVisibleHorizontally(col, trees(row))
    val vert = isVisibleVertically(row, col, trees)
    if (horiz | vert) true else false
  }

  def part1GetVisibleCount(trees:Array[String]): Int = {
    var numVisible = 0
    for ((rowStr,rowIndex) <- trees.zipWithIndex) {
      for ((tree,colIndex) <- rowStr.zipWithIndex) {
        if (rowIndex==0 | rowIndex==trees.length-1) numVisible = numVisible + 1
        else if (colIndex==0 | colIndex==rowStr.length-1) numVisible = numVisible + 1
        else if (isVisible(rowIndex,colIndex,trees)) numVisible = numVisible + 1
      }
    }
    numVisible
  }

  def getHorizScore(row:Int, col:Int, trees:Array[String]): Int = {
    val height = trees(row)(col)
    val line = trees(row)
    val leftStr = line.substring(0, col)
    val rightStr = line.substring(col + 1, line.length)
    var leftTrees = 0
    breakable {
      for (left <- leftStr.length - 1 to 0 by -1) {
        val leftHeight = line(left)
        if (leftHeight >= height) {
          leftTrees = leftStr.length - left
          break
        } else {
          if (left == 0) {
            leftTrees = leftStr.length
          }
        }
      }
    }
    var rightTrees = 0
    breakable {
      for (right <- 0 to rightStr.length - 1) {
        val rightHeight = rightStr(right)
        if (rightHeight >= height) {
          rightTrees = right + 1
          break
        } else {
          if (right == rightStr.length - 1) {
            rightTrees = rightStr.length
          }
        }
      }
    }
    leftTrees * rightTrees
  }

  def getVertScore(row:Int, col:Int, trees:Array[String]): Int = {
    val mid = trees(row)(col).asDigit
    var topStr = ""
    for (thisRow <- 0 to (row - 1)) {
      topStr += trees(thisRow)(col)
    }
    var botStr = ""
    for (thisRow <- row + 1 to trees.length - 1) {
      botStr += trees(thisRow)(col)
    }
    var topTrees = 0
    breakable {
      for (top <- topStr.length - 1 to 0 by -1) {
        val topHeight = topStr(top).asDigit
        if (topHeight >= mid) {
          topTrees = topStr.length - top
          break
        } else {
          if (top == 0) {
            topTrees = topStr.length
          }
        }
      }
    }
    var botTrees = 0
    breakable {
      for (bot <- 0 to botStr.length - 1) {
        val botHeight = botStr(bot).asDigit
        if (botHeight >= mid) {
          botTrees = bot + 1
          break
        } else {
          if (bot == botStr.length - 1) {
            botTrees = botStr.length
          }
        }
      }
    }
    topTrees * botTrees
  }

  def getScenicScore(row:Int, col:Int, trees:Array[String]): Int = {
    val horizScore = getHorizScore(row,col,trees)
    val vertScore = getVertScore(row,col,trees)
    val scenicScore = horizScore * vertScore
    scenicScore
  }

  def part2GetHighestScenicScore(trees:Array[String]): Int = {
    var highestScenicScore = -1
    for (row <- 0 to trees.length-1) {
      for (col <- 0 to trees(row).length-1) {
        val scenicScore = getScenicScore(row,col,trees)
        if (scenicScore > highestScenicScore) highestScenicScore = scenicScore
      }
    }
    highestScenicScore
  }

}
