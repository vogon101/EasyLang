package com.vogon101.EasyLang1

import com.vogon101.EasyLang1.tokenizser.Tokenizer

import scala.collection.mutable.ListBuffer

/**
 * Class to run a language instance. Takes in a Grammar to define the
 * language
 * @param grammar The grammar that defines the language
 */
class Language (
  val grammar: Grammar
){

  /**
   * The top context of this instance, ie the global variables
   */
  val superContext = new Context()

  /**
   * Execute a string of code
   * @param code The string of code to execute
   * @param logAll Optional, logging for debugging
   */
  def execute (code: String, logAll: Boolean = false): Unit = {
    if (logAll)
      println("Starting Tokenize")
    var t = new Tokenizer(code, grammar)
    var tokens = t.fullTokenize()
    if (logAll) {
      print("TOKENS : ")
      tokens.foreach(T => print(T.TType + "=>" + T.token + " | "))
      println("\nTokenize Done")
    }


    while (tokens.nonEmpty) {
      val keyword = tokens.head.token
      var paramNo = 0
      var didExecute = false
      grammar.parsers.foreach(P => {
        paramNo = P.parameterNumber
        if (avaliableKeyword(P.keyword).contains(keyword)) {
          if (paramNo == 0)
            P.execute(List(), superContext)
          else {
            P.execute(tokens.slice(1, paramNo+1), superContext)
          }
          didExecute = true
        }
      })
      if (!didExecute) {
        throw new Error("Could not find command " + keyword)
      }
      tokens = tokens.drop(paramNo+1)
    }

  }

  /**
   * If enabled in grammar will return a list of the keyword
   * capitalized, decapitalized and as passed
   * @param keyword The keyword to use
   * @return The list of possibilities
   */
  def avaliableKeyword (keyword: String): List[String] = {
    val a = new ListBuffer[String]
    a.append(keyword)
    if (grammar.decapitalize)
      a.append(keyword.toLowerCase)
    if (grammar.capitalize)
      a.append(keyword.toUpperCase)
    a.toList
  }

}

