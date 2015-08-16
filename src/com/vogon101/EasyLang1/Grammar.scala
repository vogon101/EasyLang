package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.tokenizse.{Tokenizer, TokenData, Token}

/**
 * Created by Freddie Poser on 14/08/2015.
 *
 */
class Grammar (
  private val _tokenDefenitions: List[TokenData] = null,
  private val _parsers: List[Parser[Any]] = null
){

  def tokenDatas: List[TokenData] = if (_tokenDefenitions == null) Tokenizer.defaultTokenDatas else _tokenDefenitions
  def parsers   : List[Parser[Any]] = if (_parsers == null) Parser.defaultParsers else _parsers

}
