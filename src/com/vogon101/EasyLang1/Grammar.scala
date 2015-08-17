package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.tokenizser.{Tokenizer, TokenData, Token}

/**
 * Created by Freddie Poser on 14/08/2015.
 *
 */
class Grammar (
  val parsers: List[Parser],
  private val _tokenDefenitions: List[TokenData] = null,
  val decapitalize:Boolean = true,
  val capitalize:Boolean = true){

  def tokenDatas: List[TokenData] = if (_tokenDefenitions == null) Tokenizer.defaultTokenDatas else _tokenDefenitions

}
