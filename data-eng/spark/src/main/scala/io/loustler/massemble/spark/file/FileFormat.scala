package io.loustler.massemble.spark.file

/**
  * ADT for FileType
  */
sealed trait FileFormat extends Serializable

object FileFormat {

  /**
    * ADT for CSV file format
    */
  final case object CSV extends FileFormat

  /**
    * ADT for JSON file format
    */
  final case object JSON extends FileFormat

  /**
    * ADT for Parquet file format
    */
  final case object Parquet extends FileFormat

  /**
    * ADT for ORC file format
    */
  final case object ORC extends FileFormat
}
