// I couldn't figure this one out. I found this answer (slightly modified) at https://scalacenter.github.io/scala-advent-of-code/2022/puzzles/day01, accessed 12/6/22

import scala.io.Source

object Day1 extends App {

  val filename = "src/main/input/day1.txt"
  val input = Source.fromFile(filename).getLines.mkString("\n")

  println("part 1: " + part1(input))
  println("part 1: " + part2(input))

  def part1(input: String): Int = {
    val inventories = scanInventories(input)
    val max = maxInventories(inventories, 1)
    max.head
  }

  def part2(input: String): Int =
    maxInventories(scanInventories(input), 3).sum

  case class Inventory(items: List[Int])

  def scanInventories(input: String): List[Inventory] = {
    val inventories = List.newBuilder[Inventory]
    var items = List.newBuilder[Int]
    val linesIterator = input.linesIterator
    for (line <- linesIterator) {
      if (line.isEmpty) {
        inventories += Inventory(items.result())
        items = List.newBuilder
      } else items += line.toInt
    }
    inventories.result()
  }

  def maxInventories(inventories: List[Inventory], n: Int): List[Int] =
    inventories
      .map(inventory => inventory.items.sum)
      .sorted(Ordering.Int.reverse)
      .take(n)

}