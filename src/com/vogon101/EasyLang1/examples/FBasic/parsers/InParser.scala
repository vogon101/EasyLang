package com.vogon101.EasyLang1.examples.FBasic.parsers

import com.vogon101.EasyLang1.{Context, Parser}
import com.vogon101.EasyLang1.tokenizser.{TokenType, Token}

/**
 * Example parser for an IN command that takes in
 * user input and stores it in a variable
 *
 * e.g. IN variableName
 */
class InParser extends Parser{

  def keyword: String = "IN"

  def parameterNumber:Int = 1

  def execute(params: List[Token], context: Context) = {
    val param = params.head
    param.TType match {
      case TokenType.IDENTIFIER     => context.setVariable(param.token, readLine().asInstanceOf[AnyVal])
      case _                        => throw new IllegalArgumentException("Illegal arguments for PRINT keyword")
    }
  }

}
