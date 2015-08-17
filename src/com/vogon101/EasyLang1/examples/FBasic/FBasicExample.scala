package com.vogon101.EasyLang1.examples.FBasic

import com.vogon101.EasyLang1.{Language, Grammar}

/**
 * Created by Freddie on 17/08/2015.
 */
object FBasicExample extends App{

  val grammar  = new Grammar (FBasic.parsers)
  val language = new Language(grammar)

  language.execute(
    "PRINT \"Hello\"\n"+
    "print \"What is your name? \"\n" +
    "IN name\n" +
    "PRINT \"Hello\"\n" +
    "PRINT name"
  )

}
