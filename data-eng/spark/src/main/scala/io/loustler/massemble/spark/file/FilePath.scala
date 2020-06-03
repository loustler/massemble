package io.loustler.massemble.spark.file

object FilePath {

  /**
    * Absolute path of this project.
    *
    * `/user/home/path/to/project`
    */
  lazy val ProjectRoot: String = locally {
    import java.nio.file.{ Path, Paths }

    val pwd = Paths.get(".").toAbsolutePath

    @scala.annotation.tailrec
    def parent(path: Path)(n: Int): Path =
      n match {
        case x if x <= 0 => path
        case x           => parent(path)(x - 1)
      }

    parent(pwd)(7).toString
  }

  /**
    * Get file path
    *
    * @param format file format.
    * @param fileName file name
    * @return
    */
  def path(format: FileFormat, fileName: String): String = {
    val dataDirectory = "data"

    val formatDirectory = format match {
      case FileFormat.CSV     => "csv"
      case FileFormat.JSON    => "json"
      case FileFormat.Parquet => "parquet"
      case FileFormat.ORC     => "orc"
    }

    s"$ProjectRoot/$dataDirectory/$formatDirectory/$fileName"
  }
}
