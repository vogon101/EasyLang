package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.tokenizser.{Tokenizer, TokenData, Token}

/**
 * Defines the specific language grammar. Controls the Tokenizer and
 * Language execution
 * @param parsers The list of parsers to use
 * @param _tokenDefenitions The token defenitions to use, optional. Better to use the default by passing null
 * @param decapitalize If the Language should check a fully decapitalized version of the keyword when running a line
 * @param capitalize If the Language should check a fully capitalized version of the keyword when running a line
 */
class Grammar (
  val parsers: List[Parser],
  private val _tokenDefenitions: List[TokenData] = null,
  val decapitalize:Boolean = true,
  val capitalize:Boolean = true)
{
  def tokenDatas: List[TokenData] = if (_tokenDefenitions == null) Tokenizer.defaultTokenDatas else _tokenDefenitions
}
