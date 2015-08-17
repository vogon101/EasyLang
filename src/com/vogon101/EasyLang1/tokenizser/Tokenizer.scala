package com.vogon101.EasyLang1.tokenizser

import java.util.regex.{Pattern, Matcher}

import com.vogon101.EasyLang1.Grammar

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

/**
 * Class to spilt up a string of code into tokens for parsing
 * @param _code The string to tokenize
 * @param grammar The grammar defenition of the language
 */
class Tokenizer (var _code: String, val grammar: Grammar){

  private var _lastToken: Token = null
  private var _pushBack : Boolean = false

  /** Has more tokens to provide **/
  def hasNextToken = !code.isEmpty
  /** When nextToken() is called return the last one **/
  def pushBackNext() = if (_lastToken != null) _pushBack = true
  /** T - Next time nextToken() is called it will return the previous token **/
  def pushBack = _pushBack
  /** The code be tokenized **/
  def code = _code
  /** The last token tokenized by nextToken() **/
  def lastToken = _lastToken
  /** The different types that could be returned **/
  val tokenDatas = grammar.tokenDatas

  /**
   * Get the next token, available whilst hasNextToken() == true
   * Also removes that token from the code to be tokenized
   * @return The next token
   */
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

  /**
   * Wrapper for nextToken() but fully tokenizes the entire code string
   * and returns it as a List of Tokens. When done this.code will be empty
   * @return All the tokens from the string
   */
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

  /**
   * The default list of TokenDatas for use with ELang-1. It is best
   * to use these instead of custom ones. They will work with the example
   * parsers and should be fine for all languages ELang-1 can support
   * @return The list of default Token definitions
   */
  def defaultTokenDatas = _defaultTokenDatas

}
