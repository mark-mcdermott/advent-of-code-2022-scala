import scala.io.Source

object RunDay6 extends App {

  val inputPath = "src/main/input/day6Input.txt"
  val input = Source.fromFile(inputPath).getLines().mkString("\n")
  val day6 = new Day6
  println("part1: " + day6.part1GetFourUniqueIndex(input)) // 1855
  println("part2: " + day6.part2GetFourteenUniqueIndex(input)) // 3256
}

class Day6() {

  def part1GetFourUniqueIndex(input:String): Int = {
    var index:Int = -1
    val fourUniqueIndex = input.zipWithIndex.foreach { case (z, i) =>
      if (index == -1 & i <= input.length-4) {
        val fourChars = input.substring(i,i+4)
        val substring1 = fourChars.substring(1, 4)
        val substring2 = fourChars(0) + fourChars.substring(2,4)
        val substring3 = fourChars.substring(0,2) + fourChars(3)
        val substring4 = fourChars.substring(0,3)

        val c1 = fourChars(0)
        val c2 = fourChars(1)
        val c3 = fourChars(2)
        val c4 = fourChars(3)

        if (
          !substring1.contains(c1) &
          !substring2.contains(c2) &
          !substring3.contains(c3) &
          !substring4.contains(c4)
        ) {
          index = i+4
        }
      }
    }
    index
  }

  def part2GetFourteenUniqueIndex(input: String): Int = {
    var index: Int = -1
    val fourteenUniqueIndex = input.zipWithIndex.foreach { case (z, i) =>
      if (index == -1 & i <= input.length - 14) {
        val fourteenChars = input.substring(i, i + 14)
        val substring1 = fourteenChars.substring(1, 14)
        val substring2 = fourteenChars(0) + fourteenChars.substring(2, 14)
        val substring3 = fourteenChars.substring(0,2) + fourteenChars.substring(3, 14)
        val substring4 = fourteenChars.substring(0,3) + fourteenChars.substring(4, 14)
        val substring5 = fourteenChars.substring(0,4) + fourteenChars.substring(5, 14)
        val substring6 = fourteenChars.substring(0,5) + fourteenChars.substring(6, 14)
        val substring7 = fourteenChars.substring(0,6) + fourteenChars.substring(7, 14)
        val substring8 = fourteenChars.substring(0,7) + fourteenChars.substring(8, 14)
        val substring9 = fourteenChars.substring(0,8) + fourteenChars.substring(9, 14)
        val substring10 = fourteenChars.substring(0,9) + fourteenChars.substring(10, 14)
        val substring11 = fourteenChars.substring(0,10) + fourteenChars.substring(11, 14)
        val substring12 = fourteenChars.substring(0,11) + fourteenChars.substring(12, 14)
        val substring13 = fourteenChars.substring(0,12) + fourteenChars(13)
        val substring14 = fourteenChars.substring(0,13)

        val c1 = fourteenChars(0)
        val c2 = fourteenChars(1)
        val c3 = fourteenChars(2)
        val c4 = fourteenChars(3)
        val c5 = fourteenChars(4)
        val c6 = fourteenChars(5)
        val c7 = fourteenChars(6)
        val c8 = fourteenChars(7)
        val c9 = fourteenChars(8)
        val c10 = fourteenChars(9)
        val c11 = fourteenChars(10)
        val c12 = fourteenChars(11)
        val c13 = fourteenChars(12)
        val c14 = fourteenChars(13)

        if (
          !substring1.contains(c1) &
            !substring2.contains(c2) &
            !substring3.contains(c3) &
            !substring4.contains(c4) &
            !substring5.contains(c5) &
            !substring6.contains(c6) &
            !substring7.contains(c7) &
            !substring8.contains(c8) &
            !substring9.contains(c9) &
            !substring10.contains(c10) &
            !substring11.contains(c11) &
            !substring12.contains(c12) &
            !substring13.contains(c13) &
            !substring14.contains(c14)
        ) {
          index = i + 14
        }
      }
    }
    index
  }

}
