package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.examples.FBasic.parsers.{InParser, PrintParser}
import com.vogon101.EasyLang1.tokenizser.Token

/**
 * Created by Freddie Poser on 14/08/2015.
 *
 */
abstract class Parser {

  def keyword: String

  def parameterNumber: Int

  def execute (params: List[Token], context: Context)

}
