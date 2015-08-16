package com.vogon101.EasyLang1.test

import com.vogon101.EasyLang1.tokenizse.{Tokenizer, Token}
import com.vogon101.EasyLang1.{ Grammar, Language }

/**
 * Created by Freddie Poser on 14/08/2015.
 *
 */
object EasyLangTest extends App{

  val g = new Grammar()

  val t = new Tokenizer("print \"hello\"\n" + "print 2", g)

  while (t.hasNextToken) {
    val x = t.nextToken()
    println(x.token + " -- " + x.TType)
  }


}

