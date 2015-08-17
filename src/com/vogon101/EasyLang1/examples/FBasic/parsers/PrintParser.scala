package com.vogon101.EasyLang1.examples.FBasic.parsers

import com.vogon101.EasyLang1.{Context, Parser}
import com.vogon101.EasyLang1.tokenizser.{TokenType, Token}

/**
 * Created by Freddie on 16/08/2015.
 *
 */
class PrintParser extends Parser{

  def keyword: String = "PRINT"

  def parameterNumber: Int = 1

  def keywordInsensitive = true

  def execute (params: List[Token], context:Context): Unit = {
    val param = params.head
    param.TType match {
        case TokenType.STRING_LITERAL => println(param.token)
        case TokenType.INT_LITERAL    => println(param.token)
        case TokenType.IDENTIFIER     => println(context.getVariable(param.token))
        case _                        => throw new IllegalArgumentException("Illegal arguments for PRINT keyword")
    }
  }

}
