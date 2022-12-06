// I couldn't figure this one out. This is a modified version of the answer found at https://scalacenter.github.io/scala-advent-of-code/2022/puzzles/day01, accessed 12/6/22

import scala.io.Source

object RunDay1Rough extends App {
  val inputFile = "src/main/input/day1.txt"
  val input = Source.fromFile(inputFile).getLines().mkString("\n")
  val day1Part1 = new Day1Rough
  val day1Part2 = new Day1Rough
  println("part 1: " + day1Part1.getMax(day1Part1.sumLists(day1Part1.getLists(input))))
  println("part 2: " + day1Part2.sumTop3(day1Part2.sumLists(day1Part2.getLists(input))))
}

class Day1Rough {
  var lists = List.newBuilder[List[Int]]
  var list = List.newBuilder[Int]

  def getLists(input: String): List[List[Int]] = {
    val linesIterator = input.linesIterator
    for (line <- linesIterator) {
      if (line.isEmpty) {
        lists += list.result()
        list = List.newBuilder
      } else list += line.toInt
    }
    lists.result()
  }

  def sumLists(lists: List[List[Int]]): List[Int] = {
    val sumList = List.newBuilder[Int]
    for (list <- lists) {
      sumList += list.sum
    }
    sumList.result()
  }

  def getMax(list: List[Int]): Int = {
    val sorted = list.sorted(Ordering.Int.reverse)
    sorted.head
  }

  def sumTop3(list: List[Int]): Int = {
    val sorted = list.sorted(Ordering.Int.reverse)
    val top3 = sorted.take(3)
    top3.sum
  }



}


