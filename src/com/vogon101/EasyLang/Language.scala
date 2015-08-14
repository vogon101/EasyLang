package com.vogon101.EasyLang

/**
 * Created by Freddie Poser on 14/08/2015.
 *
 */
class Language (
  val grammar: Grammar
){


  //TODO: Alone

  def tokenize(text: String): Unit = {
    val lines = text.split("""\n""")

    var toks = List[String]()

    var fullMatch = ""
    grammar.tokens.foreach(U => fullMatch+= "("+U.regex+")?")


    lines.foreach(L=> {
      /*
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
      */
      fullMatch.r.findAllMatchIn(L).foreach(M => {
        M.subgroups.foreach(G => println(G))
      })
    })


    println(toks)

  }

}
