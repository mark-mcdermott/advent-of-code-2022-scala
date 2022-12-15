//import scala.io.Source
//
//object RunDay7 extends App {
//
//  val file = "src/main/input/day7Input.txt"
//  val input = Source.fromFile(file).getLines().mkString("\n")
//
//}
//
//class Day7 {
//
//  def parseCLIInput(input:String): Unit = {
//    val linesIterator = input.linesIterator
//    var currentDir = new Dir()
//    for (line <- linesIterator) {
//      line.substring(0,4) match {
//        case "$ cd"
//        => "zero"
//        case "$ ls"
//        => "one"
//        case 2
//        => "two"
//        case _ => "other"
//      }
//    }
//  }
//
//}
//
//class Dir(var parent:Dir, var name:String, var size:Int = 0)
