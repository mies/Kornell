package kornell.repository.slick.plain

import java.util.UUID
import scala.slick.session.Database
import scala.slick.jdbc.StaticQuery.interpolation
import scala.slick.session.Database.threadLocalSession
import scala.slick.jdbc.StaticQuery
import java.nio.file.SimpleFileVisitor
import java.nio.file.FileSystems
import scala.collection.mutable.MutableList
import java.nio.file.Path
import java.nio.file.FileVisitResult._
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.charset.Charset
import scala.slick.session.PositionedParameters
import scala.slick.jdbc.SetParameter
import java.util.Date
import java.sql.Timestamp

trait Repository {
  def randUUID: String = UUID.randomUUID.toString
  //TODO: Use Connection Pooling from JNDI (have to care for off-container connections, useful in development)
  
  def forURL(url: String) = Database.forURL(url,
    driver = "com.mysql.jdbc.Driver",
    user = "kornell",
    password = "42kornell73")

  val nodb = forURL("jdbc:mysql://db.kornell/")

  val db = forURL("jdbc:mysql://db.kornell/ebdb")
}

