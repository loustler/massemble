package io.loustler.massemble

package object tree {

  implicit val NothingOrdering: Ordering[Nothing] = new Ordering[Nothing] {
    override def compare(x: Nothing, y: Nothing): Int = ???
  }
}
