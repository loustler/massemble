package io.loustler.massemble

package object spark {

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
}
