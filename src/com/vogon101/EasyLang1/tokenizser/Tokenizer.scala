package com.vogon101.EasyLang1.tokenizser

import java.util.regex.{Pattern, Matcher}

import com.vogon101.EasyLang1.Grammar

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

/**
 * Created by Freddie Poser on 15/08/2015.
 *
 */
class Tokenizer (var _code: String, val grammar: Grammar){

  private val _tokenDatas = grammar.tokenDatas

  private var _lastToken: Token = null
  private var _pushBack : Boolean = false

  def hasNextToken = !code.isEmpty
  def pushBackNext() = if (_lastToken != null) _pushBack = true
  def pushBack = _pushBack
  def code = _code
  def lastToken = _lastToken
  def tokenDatas = _tokenDatas

  def nextToken (): Token = {
    _code = code.trim

    if (pushBack) {
      _pushBack = false
      return lastToken
    }

    if (code.isEmpty) {
      _lastToken = new Token("", TokenType.EMPTY)
      return lastToken
    }

    tokenDatas.foreach( U => {
      val m = Pattern.compile(U.pattern).matcher(code)
      if (m.find()) {
        val t = m.group.trim
        _code = m.replaceFirst("")

        if (U.tokenType == TokenType.STRING_LITERAL) {
          _lastToken = new Token(
            t.substring(1, t.length -1),
            U.tokenType
          )
        }
        else {
          _lastToken = new Token(
            t,
            U.tokenType
          )
        }
        return lastToken
      }
    })

    throw new IllegalStateException("Could not parse" + code)
  }

  def fullTokenize(): List[Token] = {
    val tokens = new ListBuffer[Token]
    while (hasNextToken){
      tokens.append(nextToken())
    }
    tokens.toList
  }
}

object Tokenizer {
  private var _defaultTokenDatas = List (
    new TokenData(
      "^([a-zA-Z][a-zA-Z0-9]*)",
      TokenType.IDENTIFIER
    ),
    new TokenData(
      "^((-)?[0-9]+)",
      TokenType.INT_LITERAL
    ),
    new TokenData(
      "^(\".*\")",
      TokenType.STRING_LITERAL
    )
  )

  List("=", "\\(", "\\)", "\\.", "\\,").foreach (U => {
    val pattern = "^(" + U + ")"
    val t = TokenType.TOKEN
    _defaultTokenDatas = new TokenData(pattern, t) :: _defaultTokenDatas
  })

  def defaultTokenDatas = _defaultTokenDatas

}
