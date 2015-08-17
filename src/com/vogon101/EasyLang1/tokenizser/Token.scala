package com.vogon101.EasyLang1.tokenizser

import com.vogon101.EasyLang1.tokenizser.TokenType.TokenType

/**
 * Class for a token. Tokens split up a code string into easily
 * manageable parts
 * @param token The string of the token (ie print)
 * @param TType The type of the token i.e. IDENTIFIER found in the TokenType enum
 */
class Token (
  val token: String,
  val TType: TokenType
){

}
