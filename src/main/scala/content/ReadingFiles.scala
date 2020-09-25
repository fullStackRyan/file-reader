package content

import java.io.File
import java.util
import java.util.Scanner

import org.apache.commons.io.FileUtils

import scala.io.Source


object ReadingFiles {

  val filePath = "src/main/resources/index.html"

  // Version 1 - the Java way
  val file = new File(filePath)
  val scanner = new Scanner(file)

  //  while (scanner.hasNextLine) {
  //    val line = scanner.nextLine()
  //    println(line)
  //  }

  // Version 2 - the Java way with cheats
  val fileContents: util.List[String] = FileUtils.readLines(file)
  //  fileContents.forEach(println)

  // Version 3 - the Scala way
  val scalaFileContents: Iterator[String] = Source.fromFile(file).getLines
//  scalaFileContents.foreach(println)

  // Version 4
  def open(path: String) = new File(path)

  implicit class RichFile(file: File) {
    def read(): Iterator[String] = Source.fromFile(file).getLines
  }

  val readLikeABoss: Iterator[String] = open(filePath).read() // new RichFile(open(filePath)).read()
  readLikeABoss.foreach(println)

  def main(args: Array[String]): Unit = {

  }

}
