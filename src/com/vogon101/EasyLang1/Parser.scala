package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.examples.FBasic.parsers.{InParser, PrintParser}
import com.vogon101.EasyLang1.tokenizser.Token

/**
 * Parses and executes a line
 */
abstract class Parser {

  /**
   * @return The keyword that starts the like ie PRINT
   */
  def keyword: String

  /**
   * @return The number of parameters required by this line
   */
  def parameterNumber: Int

  /**
   * Execute this command
   * @param params - The parameters of length parameterNumber
   * @param context - The current contextof this line
   */
  def execute (params: List[Token], context: Context)

}
