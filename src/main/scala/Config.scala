package jp.ac.utokyo.k.cb.mlab.yt

final case class Config
(metaData: Map[String, String],
 input: String,
 output: String,
 paramInt : Int,
 paramDouble: Double){

  require(metaData.contains("createdAt"))
  require(metaData.contains("experimentID"))
  require(paramInt > 0)
  require(paramDouble > 0)
}


object Config {
  import org.json4s.{JValue, DefaultFormats}
  import org.json4s.jackson.JsonMethods.parse
  import scala.io.Source.fromFile

  def apply(jsonArgs: JValue): Config = {
    implicit val formats = DefaultFormats
    jsonArgs.extract[Config]
  }

  def apply(jsonFileName: String): Config =
    Config(parse(fromFile(jsonFileName).getLines().mkString("")))
}
