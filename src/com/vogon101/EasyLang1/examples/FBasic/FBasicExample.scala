package com.vogon101.EasyLang1.examples.FBasic

import com.vogon101.EasyLang1.{Language, Grammar}

/**
 * Example language App. Runs F-BASIC Code
 * (Very simple BASIC clone)
 */
object FBasicExample extends App{
  //Create a grammar object from the example parser list
  val grammar  = new Grammar (FBasic.parsers)
  //Create a language from that Grammar
  val language = new Language(grammar)

  //Execute some code
  language.execute(
    "PRINT \"Hello\"\n"+
    "print \"What is your name? \"\n" +
    "IN name\n" +
    "PRINT \"Hello\"\n" +
    "PRINT name"
  )
}
