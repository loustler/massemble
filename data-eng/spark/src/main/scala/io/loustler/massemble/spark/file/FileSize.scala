package io.loustler.massemble.spark.file

object FileSize {
  val capacity = 1024

  final implicit class SizeImplicit(private val n: Int) {
    def kb: Int = n * capacity * capacity

    def mb: Int = capacity * kb

    def gb: Int = capacity * mb

    def tb: Int = capacity * gb

    def pb: Int = capacity * tb
  }
}
