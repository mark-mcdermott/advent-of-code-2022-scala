import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

import scala.io.Source

class Day7Test extends AnyFunSuite {

  val file = "src/main/input/day7Input.txt"
  val input = Source.fromFile(file).getLines().mkString("\n")
  val day7 = new Day7

  test("File: simple filename") {
    val testFile = new File("test",12)
    testFile.name should equal("test")
  }
  test("File: filename with extension") {
    val testFile = new File("test.zip", 12)
    testFile.name should equal("test.zip")
  }
  test("File: file size") {
    val testFile = new File("test.zip", 12)
    testFile.size should equal(12)
  }
  test("Dir: simple name") {
    val testDir = new Dir(null,List[Dir](),List[File](),"testdir")
    testDir.name should equal("testdir")
  }
  test("Dir: null parent") {
    val testDir = new Dir(null, List[Dir](), List[File](), "testdir")
    testDir.parent should equal(null)
  }
  test("Dir: null children") {
    val testDir = new Dir(null, List[Dir](), List[File](), "testdir")
    testDir.children should equal(Array())
  }
  test("Dir: null files") {
    val testDir = new Dir(null, List[Dir](), List[File](), "testdir")
    testDir.files should equal(Array())
  }
  test("Dir: 1 file") {
    val testDir = new Dir(null, List[Dir](), List[File](), "testdir")
    val testFile = new File("test.zip", 12)
    testDir.files = testDir.files :+ testFile
    testDir.files.length should equal(1)
  }
  test("cd /: / name") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 1)
    /.name should equal("/")
  }
  test("cd /: / parent") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 1)
    /.parent should equal(null)
  }
  test("line 1: cd /") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 1)
    /.toString() should equal("/")
  }
  test("line 2: ls") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 2)
    /.toString() should equal("/")
  }
  test("line 3: 115454 dwdllt") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 3)
    /.files.toString() should equal("List(dwdllt)")
  }
  test("line 4: dir jmdf") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 4)
//    println(/.children.toString())
    /.children.toString() should equal("List(jmdf)")
  }
  test("line 5: dir jrgzmphz") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 5)
    /.children.toString() should equal("List(jmdf, jrgzmphz)")
  }
  test("multiline input 1 filename") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |115454 dwdllt
        |""".stripMargin
    val / = day7.parseWholeInputStr(inputLines, 3)
    /.files.toString() should equal("List(dwdllt)")
  }
  test("multiline input double filename") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |115454 dwdllt
        |20 dwdllt""".stripMargin
    val / = day7.parseWholeInputStr(inputLines, 3)
    /.files.toString() should equal("List(dwdllt)")
  }
  test("line 6: dir pdzrzbtf") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 6)
    /.children.toString() should equal("List(jmdf, jrgzmphz, pdzrzbtf)")
  }
  test("line 7: 177917 pvlvsfjw.qvw") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 7)
    /.files.toString() should equal("List(dwdllt, pvlvsfjw.qvw)")
  }
  test("line 8: dir qlpvwf") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 8)
    /.children.toString() should equal("List(jmdf, jrgzmphz, pdzrzbtf, qlpvwf)")
  }
  test("line 9: 30151 qvrwp.vsv") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 9)
    /.files.toString() should equal("List(dwdllt, pvlvsfjw.qvw, qvrwp.vsv)")
  }
  test("line 10: 73443 wzbtj") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 10)
    /.files.toString() should equal("List(dwdllt, pvlvsfjw.qvw, qvrwp.vsv, wzbtj)")
  }
  test("size at line 3") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 3)
    /.size should equal(115454)
  }
  test("size at line 6") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 6)
    /.size should equal(115454)
  }
  test("size at line 7") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 7)
    /.size should equal(115454 + 177917)
  }
  test("Dir.getChild test 1") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 7)
    /.getChild("pdzrzbtf").toString() should equal("pdzrzbtf")
  }
  test("size at line 10") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 10)
    /.size should equal(115454+177917+30151+73443)
  }
  test("size of jmdf dir at line 13") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 13)
    /.getChild("jmdf").size should equal(228633)
  }
  test("size of jmdf dir at line 14") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 14)
    /.getChild("jmdf").size should equal(228633+252639)
  }
  test("size of rgrcs dir at line 18") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 18)
    /.getChild("jmdf").getChild("rgrcs").size should equal(34044)
  }
  test("size of rgrcs dir at line 21") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 21)
    /.getChild("jmdf").getChild("rgrcs").size should equal(34044+266939)
  }
  test("size of drg dir at line 24") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 24)
    val drg = /.getChild("jmdf").getChild("rgrcs").getChild("drg")
    drg.size should equal(200446)
  }
  test("size of drg dir at line 28") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 28)
    val drg = /.getChild("jmdf").getChild("rgrcs").getChild("drg")
    drg.size should equal(200446+94067+121940+235672+179660)
  }
  test("size of gcfth dir at line 32") {
    val day7 = new Day7
    val / = day7.parseWholeInputStr(input, 32)
    val gcfth = /.getChild("jmdf").getChild("rgrcs").getChild("gcfth")
    gcfth.size should equal(49306)
  }
//  test("indirect size: dir a") {
//    val day7 = new Day7
//    val inputLines =
//      """$ cd /
//        |$ ls
//        |dir a
//        |14848514 b.txt
//        |8504156 c.dat
//        |dir d
//        |$ cd a
//        |$ ls
//        |dir e
//        |29116 f
//        |2557 g
//        |62596 h.lst
//        |$ cd e
//        |$ ls
//        |584 i
//        |$ cd ..
//        |$ cd ..
//        |$ cd d
//        |$ ls
//        |4060174 j
//        |8033020 d.log
//        |5626152 d.ext
//        |7214296 k""".stripMargin
//    val / = day7.parseWholeInputStr(inputLines)
//    /.getChild("a").size should equal(94853)
//  }
//  test("indirect size: dir e") {
//    val day7 = new Day7
//    val inputLines =
//      """$ cd /
//        |$ ls
//        |dir a
//        |14848514 b.txt
//        |8504156 c.dat
//        |dir d
//        |$ cd a
//        |$ ls
//        |dir e
//        |29116 f
//        |2557 g
//        |62596 h.lst
//        |$ cd e
//        |$ ls
//        |584 i
//        |$ cd ..
//        |$ cd ..
//        |$ cd d
//        |$ ls
//        |4060174 j
//        |8033020 d.log
//        |5626152 d.ext
//        |7214296 k""".stripMargin
//    val / = day7.parseWholeInputStr(inputLines)
//    /.getChild("a").getChild("e").size should equal(584)
//  }
//  test("indirect size: dir d") {
//    val day7 = new Day7
//    val inputLines =
//      """$ cd /
//        |$ ls
//        |dir a
//        |14848514 b.txt
//        |8504156 c.dat
//        |dir d
//        |$ cd a
//        |$ ls
//        |dir e
//        |29116 f
//        |2557 g
//        |62596 h.lst
//        |$ cd e
//        |$ ls
//        |584 i
//        |$ cd ..
//        |$ cd ..
//        |$ cd d
//        |$ ls
//        |4060174 j
//        |8033020 d.log
//        |5626152 d.ext
//        |7214296 k""".stripMargin
//    val / = day7.parseWholeInputStr(inputLines)
//    /.getChild("d").size should equal(24933642)
//  }
//  test("indirect size: dir /") {
//    val day7 = new Day7
//    val inputLines =
//      """$ cd /
//        |$ ls
//        |dir a
//        |14848514 b.txt
//        |8504156 c.dat
//        |dir d
//        |$ cd a
//        |$ ls
//        |dir e
//        |29116 f
//        |2557 g
//        |62596 h.lst
//        |$ cd e
//        |$ ls
//        |584 i
//        |$ cd ..
//        |$ cd ..
//        |$ cd d
//        |$ ls
//        |4060174 j
//        |8033020 d.log
//        |5626152 d.ext
//        |7214296 k""".stripMargin
//    val / = day7.parseWholeInputStr(inputLines)
//    /.size should equal(48381165)
//  }
  test("dirs with at most 100,000") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |dir a
        |14848514 b.txt
        |8504156 c.dat
        |dir d
        |$ cd a
        |$ ls
        |dir e
        |29116 f
        |2557 g
        |62596 h.lst
        |$ cd e
        |$ ls
        |584 i
        |$ cd ..
        |$ cd ..
        |$ cd d
        |$ ls
        |4060174 j
        |8033020 d.log
        |5626152 d.ext
        |7214296 k""".stripMargin
    val sumOfDirsWithAtMost100000 = day7.findSumOfDirsWithAtMost100000(inputLines,100000)
    sumOfDirsWithAtMost100000 should equal(95437)
  }
  test("get unused space") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |dir a
        |14848514 b.txt
        |8504156 c.dat
        |dir d
        |$ cd a
        |$ ls
        |dir e
        |29116 f
        |2557 g
        |62596 h.lst
        |$ cd e
        |$ ls
        |584 i
        |$ cd ..
        |$ cd ..
        |$ cd d
        |$ ls
        |4060174 j
        |8033020 d.log
        |5626152 d.ext
        |7214296 k""".stripMargin
    day7.getUnusedSpace(inputLines) should equal(21618835)
  }
  test("getDirSizeToDelete") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |dir a
        |14848514 b.txt
        |8504156 c.dat
        |dir d
        |$ cd a
        |$ ls
        |dir e
        |29116 f
        |2557 g
        |62596 h.lst
        |$ cd e
        |$ ls
        |584 i
        |$ cd ..
        |$ cd ..
        |$ cd d
        |$ ls
        |4060174 j
        |8033020 d.log
        |5626152 d.ext
        |7214296 k""".stripMargin
    day7.getDirSizeToDelete(inputLines) should equal(8381165)
  }
  test("runFindDirsAtLeastXBig") {
    val day7 = new Day7
    val inputLines =
      """$ cd /
        |$ ls
        |dir a
        |14848514 b.txt
        |8504156 c.dat
        |dir d
        |$ cd a
        |$ ls
        |dir e
        |29116 f
        |2557 g
        |62596 h.lst
        |$ cd e
        |$ ls
        |584 i
        |$ cd ..
        |$ cd ..
        |$ cd d
        |$ ls
        |4060174 j
        |8033020 d.log
        |5626152 d.ext
        |7214296 k""".stripMargin
    day7.findSmallestDirSizeAtLeastXBig(inputLines) should equal(24933642)

  }

}