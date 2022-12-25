

import scala.util.matching.Regex
import scala.io.Source

object RunDay7 extends App {

  val file = "src/main/input/day7Input.txt"
  val input = Source.fromFile(file).getLines().mkString("\n")
  val day7 = new Day7
  println(day7.findSumOfDirsWithAtMost100000(input)).toString // 1423358
  println(day7.findSmallestDirSizeAtLeastXBig(input).toString()) // 545729

}

class Day7 {

  var dirsWithAtMost100000 = List[Dir]()
  var sumOfDirsWithAtMost100000 = 0
  var dirsAtLeastXBig = List[Dir]()
  var smallestDirSizeAtLeastXBig:Int = Int.MaxValue
  var smallestDirAtLeastXBig = new Dir(null, null, null, null)

  def findSmallestDirSizeAtLeastXBig(input: String): Int = {
    val / = parseWholeInputStr(input, -1)
    val unusedSpace = 70000000 - /.size
    val deleteableDirSize = 30000000 - unusedSpace
    setSmallestDirSizeAtLeastXBig(/,deleteableDirSize)
    smallestDirSizeAtLeastXBig
//    val deleteableDirs = dirsAtLeastXBig
//    deleteableDirs
  }

  def setSmallestDirSizeAtLeastXBig(dir:Dir, size:Int): Unit = {
    if (dir.size >= size) {
      if (dir.size < smallestDirSizeAtLeastXBig) {
        smallestDirSizeAtLeastXBig = dir.size
        smallestDirAtLeastXBig = dir
      }
//      dirsAtLeastXBig = dirsAtLeastXBig :+ dir
    }
    if (dir.children.size > 0) {
      for (child <- dir.children) {
        setSmallestDirSizeAtLeastXBig(child, size)
      }
    }
  }

  def getDirSizeToDelete(input:String): Int = {
    30000000 - getUnusedSpace(input)
  }

  def getUnusedSpace(input:String):Int = {
    val / = parseWholeInputStr(input, -1)
    70000000 - /.size
  }

  def findSumOfDirsWithAtMost100000(input:String, numLines:Int = -1): Int = {
    val / = parseWholeInputStr(input, numLines)
    findDirsWithAtMost(/,100000)
    sumOfDirsWithAtMost100000
  }

  def parseWholeInputStr(input:String, numLines:Int): Dir = {
    var / = new Dir(null, List[Dir](), List[File](), "/")
    var inLs = false
    var thisDir:Dir = null
//    val input = Source.fromFile(filepath).getLines().mkString("\n")
    val lineIterator = input.linesIterator
    var linesRead = 0
    for (line <- lineIterator) {
//      println(line)
      if (numLines == -1 | linesRead < numLines) {
        val file = raw"(\d+) ([a-z]+)(\.[a-z]+)?".r
//        val file = raw"(\d+) ([a-z]+)".r
        val dir = raw"dir ([a-z]+)".r
        val cd = raw". cd ([/a-z\.]+)".r
        val ls = raw". ls".r
        if (line == "dir qlpvwf") {
          val z=0
        }
        line match {
          case cd(name) => {
//            println (s"cd: $name")
            inLs = false
            if (name=="/") thisDir = /
            else if (name == "..") {
              thisDir = thisDir.parent
            }
            else thisDir = thisDir.getChild(name)
          }
          case file(size, basename, extension) => {
//            println("2")
            val filename =
              if (extension==null) basename
              else basename + extension
//            println(filename)
//            println(s"file: $size $filename")
            val newFile = new File(filename.toString, size.toInt)
            var found = false
            val thisDirsFiles = thisDir.files
            for (file <- thisDirsFiles) {
              if (file.name==filename) found = true
            }
            if (!found) {
              thisDir.files = thisDir.files :+ newFile
              thisDir.size = thisDir.size + size.toInt
              addToParents(thisDir,size.toInt)
            }
          }

          case dir(name) => {
//            println(s"dir: $name")
            var found = false
            for (children <- thisDir.children) {
              if (children.name == name) {
                found = true
              }
            }
            if (!found) {
              val newDir = new Dir(thisDir, List[Dir](), List[File](), name.toString)
              thisDir.children = thisDir.children :+ newDir
            }
          }
          case ls => {
//            println("ls: " + line)
            inLs = true
          }
          case _ => "other"
        }
        linesRead += 1
      }
    }

   / // return the root Dir called "/"
  }

  def setIndirectSizes(dir: Dir): Unit = {
    for (child <- dir.children) {
      setIndirectSizes(child)
      child.indirectSize = recursiveSize(child)
    }
  }

  def recursiveSize(dir: Dir): Int = {
    var thisRecusiveSize = 0
    if (dir.children.size == 0) {
      thisRecusiveSize = dir.size
    } else {
      for (child <- dir.children) {
        thisRecusiveSize += recursiveSize(child)
      }
    }
    thisRecusiveSize
  }

  def addToParents(dir:Dir, size:Int): Unit = {
    if (dir.parent != null) {
      val parent = dir.parent
      parent.size = parent.size + size
      addToParents(parent, size)
    }
  }

  def findDirsWithAtMost(dir:Dir,atMost:Int): Unit = {
    if (dir.children != null) {
      for (child <- dir.children) {
        if (child.size != null & atMost != null) {
          val childSize = child.size
          if (childSize <= atMost) {
            dirsWithAtMost100000 = dirsWithAtMost100000 :+ child
            sumOfDirsWithAtMost100000 = sumOfDirsWithAtMost100000 + childSize
          }
          findDirsWithAtMost(child, atMost)
        }
      }
    }
  }

}




class Dir(
           var parent:Dir, var children:List[Dir] = List[Dir](),
           var files:List[File] = List[File](), var name:String,
           var size:Int = 0, var indirectSize:Int = 0
         ) {
  def getChild(name:String): Dir = {
    var found = false
    var childDir:Dir = null
    for (child <- children) {
      if (child.name == name) childDir = child
      found = true
    }
    if (!found) println("child dir not found")
    childDir
  }
  override def toString(): String = {
    name
//    val nameStr = name
//    val parentStr = if (parent != null) parent.name else "null"
//    val childrenStr = if (children != null) children.toString() else "null"
//    val filesStr = if (files != null) files.toString() else "null"
//    "name: " + nameStr + ", parent: " + parentStr + ", children: " + childrenStr +
//    ", files:" + filesStr
  }
}
class File(val name:String, val size:Int) {
  override def toString(): String = {
    name
//    name + ":" + size
  }
}
