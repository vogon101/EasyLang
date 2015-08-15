package com.vogon101.EasyLang.tokenizse

/**
 * Created by Freddie Poser on 15/08/2015.
 *
 */
class TokenType extends Enumeration{

  type TokenType = Value
  val IDENTIFIER,
      STRING_LITERAL,
      INT_LITERAL,
      TOKEN,
      EMPTY = Value

}
