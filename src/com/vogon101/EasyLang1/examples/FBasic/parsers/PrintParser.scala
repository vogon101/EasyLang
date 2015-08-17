package com.vogon101.EasyLang1.examples.FBasic.parsers

import com.vogon101.EasyLang1.{Context, Parser}
import com.vogon101.EasyLang1.tokenizser.{TokenType, Token}

/**
 *  Example parser for a print command
 *
 *  eg:
 *  PRINT "Hello World"
 *  PRINT variable
 */
class PrintParser extends Parser{

  //Data about the command
  def keyword: String = "PRINT"
  def parameterNumber: Int = 1

  //Execute the command
  def execute (params: List[Token], context:Context): Unit = {
    //Get the parameter
    val param = params.head
    //Match the type of token
    param.TType match {
        case TokenType.STRING_LITERAL => println(param.token) //Print a string
        case TokenType.INT_LITERAL    => println(param.token) //Print an integer
        case TokenType.IDENTIFIER     => println(context.getVariable(param.token)) //Find the variable in the context
        case _                        => throw new IllegalArgumentException("Illegal arguments for PRINT keyword") //Cannot print any other type
    }
  }
}
