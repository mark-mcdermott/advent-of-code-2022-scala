import scala.io.Source

object RunDay2 extends App {

  val inputPath = "src/main/input/day2.txt"
  val input = Source.fromFile(inputPath).getLines().mkString("\n")
  val day2 = new Day2
  println("part 1: " + day2.scoreSumFromThemAndMeInput(input)) // 11150
  println("part 2: " + day2.scoreSumFromThemAndResultInput(input))

}

class Day2 {

  def gameResult(game: String): String = {
    val them = game(0)
    val me = game(2)
    if (them=='A' & me=='X') "draw" // rock & rock
    else if (them=='B' & me=='Y') "draw" // paper & paper
    else if (them=='C' & me=='Z') "draw" // scissors & scissors
    else if (them=='A' & me=='Z') "loss" // rock & scissors
    else if (them=='C' & me=='X') "win"  // scissors & rock
    else if (them=='B' & me=='Z') "win" // paper & scissors
    else if (them=='C' & me=='Y') "loss" // scissors & paper
    else if (them=='A' & me=='Y') "win" // rock & paper
    else if (them=='B' & me=='X') "loss" // paper & rock
    else "error"
  }

  // x=lose, y=draw, z=win
  def gameStringFromThemAndResult(themAndResult: String): String = {
    val them = themAndResult(0)
    val result = themAndResult(2)
    val me = if (them == 'A' & result == 'X') "Z" // rock & scissors = loss
    else if (them == 'A' & result == 'Y') "X" // rock & rock = draw
    else if (them == 'A' & result == 'Z') "Y" // rock & paper = win
    else if (them == 'B' & result == 'X') "X" // paper & rock = loss
    else if (them == 'B' & result == 'Y') "Y" // paper & paper = draw
    else if (them == 'B' & result == 'Z') "Z" // paper & scissors = win
    else if (them == 'C' & result == 'X') "Y" // scissors & paper = loss
    else if (them == 'C' & result == 'Y') "Z" // scissors & scissors = draw
    else if (them == 'C' & result == 'Z') "X" // scissors & rock = win
    else "error"
    val gameString = them + " " + me
    gameString
  }

  def gameScore(gameString: String): Int = {
    val played = gameString(2)
    val result = gameResult(gameString)
    val resultScore: Int =
      if (result == "loss") 0
      else if (result == "draw") 3
      else if (result == "win") 6
      else -1
    val playedScore: Int =
      if (played == 'X') 1
      else if (played == 'Y') 2
      else if (played == 'Z') 3
      else -1
    resultScore + playedScore
  }

  def scoreSumFromThemAndMeInput(input: String): Int = {
    val lineIterator = input.linesIterator
    val scoresList = List.newBuilder[Int]
    for (line <- lineIterator) {
      val score = gameScore(line)
      scoresList += score
    }
    scoresList.result().sum
  }

  def scoreSumFromThemAndResultInput(themAndResultInput: String): Int = {
    val lineIterator = themAndResultInput.linesIterator
    val themAndMeList = List.newBuilder[String]
    for (line <- lineIterator) {
      val themAndMeString = gameStringFromThemAndResult(line)
      themAndMeList += themAndMeString
    }
    val themAndMeInputString = themAndMeList.result().mkString("\n")
    scoreSumFromThemAndMeInput(themAndMeInputString)
  }

}
