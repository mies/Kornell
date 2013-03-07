package kornell.dev

import java.nio.file.SimpleFileVisitor
import java.nio.file.Paths
import java.nio.file.FileSystems
import java.nio.file.Files
import scala.collection.mutable.MutableList
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.FileVisitResult
import java.nio.file.FileVisitResult._
import java.nio.file.Path

class SQLFinder extends SimpleFileVisitor[Path] {
  val kornellApiSrc = System.getProperty("user.dir")
  val scriptsPath = Paths.get(kornellApiSrc, "src", "main", "sql")

  val matcher = FileSystems.getDefault.getPathMatcher("glob:**.sql");
  var result: MutableList[Path] = _

  override def visitFile(file: Path, attr: BasicFileAttributes): FileVisitResult = {
    if (matcher.matches(file))
      result += file
    CONTINUE
  }

  def files = {
    result = new MutableList[Path]
    Files.walkFileTree(scriptsPath, this);
    result
  }
}