//import RunDay5.stacks
//
//import scala.:+
//import scala.io.Source
//import scala.util.matching.Regex
//
//object RunDay5 extends App {
//
//  val filePath = "src/main/input/day5Input.txt"
//  val input = Source.fromFile(filePath).getLines().mkString("\n")
//  val day5 = new Day5
//
//  var stack1 = Seq[Char]()
//  var stack2 = Seq[Char]()
//  var stack3 = Seq[Char]()
//  var stack4 = Seq[Char]()
//  var stack5 = Seq[Char]()
//  var stack6 = Seq[Char]()
//  var stack7 = Seq[Char]()
//  var stack8 = Seq[Char]()
//  var stack9 = Seq[Char]()
//  stacks :+ stack1
//  stacks :+ stack2
//  stacks :+ stack3
//  stacks :+ stack4
//  stacks :+ stack5
//  stacks :+ stack6
//  stacks :+ stack7
//  stacks :+ stack8
//  stacks :+ stack9
//  stacks = day5.getInitialStacks(input)
//  day5.moveCrate(1,0)
//
//}
//
//class Day5 {
//
//  def moveCrate(from:Int, to:Int): Unit = {
//    var last = stacks(from).last
//    var fromStackAfterPop = stacks(from).init
//    println(stacks(from))
//  }
//
//  def moveCrates(input:String): Unit = {
//    val linesIterator = input.linesIterator
//    for (line <- linesIterator) {
//      if (line.contains("move")) {
//        val regex: Regex = "move ([1-9]+) from ([1-9]) to ([1-9])".r
//        for (patternMatch <- regex.findFirstMatchIn(line)) {
//          val numToMove = patternMatch.group(1)
//          val fromCol = patternMatch.group(2)
//          val toCol = patternMatch.group(3)
//
//
//        }
//      }
//    }
//  }
//
//  def getInitialStacks(input:String): List[Seq[Char]] = {
//    val linesIterator = input.linesIterator
////    var stack1 = Seq[Char]()
////    var stack2 = Seq[Char]()
////    var stack3 = Seq[Char]()
////    var stack4 = Seq[Char]()
////    var stack5 = Seq[Char]()
////    var stack6 = Seq[Char]()
////    var stack7 = Seq[Char]()
////    var stack8 = Seq[Char]()
////    var stack9 = Seq[Char]()
//    for (line <- linesIterator) {
//      if (!line.isEmpty & !line.contains("move") & !line.contains(" 1   2   3   4   5   6   7   8   9")) {
//        val regex: Regex = "(.[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?(..[A-Z ].)?".r
//        for (patternMatch <- regex.findFirstMatchIn(line)) {
//          val col1Crate: Char = if (patternMatch.group(1) != null) (patternMatch.group(1))(1) else ' '
//          val col2Crate: Char = if (patternMatch.group(2) != null) (patternMatch.group(2))(2) else ' '
//          val col3Crate: Char = if (patternMatch.group(3) != null) (patternMatch.group(3))(2) else ' '
//          val col4Crate: Char = if (patternMatch.group(4) != null) (patternMatch.group(4))(2) else ' '
//          val col5Crate: Char = if (patternMatch.group(5) != null) (patternMatch.group(5))(2) else ' '
//          val col6Crate: Char = if (patternMatch.group(6) != null) (patternMatch.group(6))(2) else ' '
//          val col7Crate: Char = if (patternMatch.group(7) != null) (patternMatch.group(7))(2) else ' '
//          val col8Crate: Char = if (patternMatch.group(8) != null) (patternMatch.group(8))(2) else ' '
//          val col9Crate: Char = if (patternMatch.group(9) != null) (patternMatch.group(9))(2) else ' '
//          if (col1Crate != ' ') stacks(0).+:(col1Crate)
//          if (col2Crate != ' ') stack2 = stack2.+:(col2Crate)
//          if (col3Crate != ' ') stack3 = stack3.+:(col3Crate)
//          if (col4Crate != ' ') stack4 = stack4.+:(col4Crate)
//          if (col5Crate != ' ') stack5 = stack5.+:(col5Crate)
//          if (col6Crate != ' ') stack6 = stack6.+:(col6Crate)
//          if (col7Crate != ' ') stack7 = stack7.+:(col7Crate)
//          if (col8Crate != ' ') stack8 = stack8.+:(col8Crate)
//          if (col9Crate != ' ') stack9 = stack9.+:(col9Crate)
//        }
//      }
//    }
//    val stacks = List.newBuilder[Seq[Char]]
////    stacks += stack1
////    stacks += stack2
////    stacks += stack3
////    stacks += stack4
////    stacks += stack5
////    stacks += stack6
////    stacks += stack7
////    stacks += stack8
////    stacks += stack9
//    stacks.result()
//  }
//
//}
