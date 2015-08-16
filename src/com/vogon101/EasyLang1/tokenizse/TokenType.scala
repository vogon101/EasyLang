package com.vogon101.EasyLang1.tokenizse

/**
 * Created by Freddie Poser on 15/08/2015.
 *
 */
object TokenType extends Enumeration{

  type TokenType = Value
  val IDENTIFIER,
      STRING_LITERAL,
      INT_LITERAL,
      TOKEN,
      EMPTY = Value

}
