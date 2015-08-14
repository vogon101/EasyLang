package com.vogon101.EasyLang

import scala.collection.immutable.HashMap

/**
 * Created by Freddie Poser on 14/08/2015.
 */
class Language (
  val grammar: Grammar
){


  //TODO: Alone

  def tokenize(text: String): Unit = {
    val lines = text.split("""\n""")

    var toks = List[String]()

    lines.foreach(L=> {
      grammar.tokens.foreach(T => {
        val regex = T.regex + "($| )"
        //println(regex)
        val matches = regex.r.findAllMatchIn(L)
        if (matches.nonEmpty) {
          matches.foreach(
            M => {
              toks ++= T.tokens
            }
          )
        }
      })
      toks = toks :+ ";"
    })


    println(toks)

  }

}
