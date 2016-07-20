package jp.ac.utokyo.k.cb.mlab.yt.test

import org.scalatest.FunSuite

class ConfigTest extends FunSuite {
  import jp.ac.utokyo.k.cb.mlab.yt.Config

  test("initial test"){
    assert(1 + 1 == 2)
  }

  test("load configuration from a file"){
    val configFileName = "src/test/resources/config.json"
    val params = Config(configFileName)

    assert(params.input == "input_file")
    assert(params.output == "output_file")
    assert(params.paramInt == 1)
    assert(params.paramDouble == 1.0)
  }
}
