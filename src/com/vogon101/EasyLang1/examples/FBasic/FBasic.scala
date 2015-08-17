package com.vogon101.EasyLang1.examples.FBasic

import com.vogon101.EasyLang1.examples.FBasic.parsers.{PrintParser, InParser}
import com.vogon101.EasyLang1.{Parser, LanguageDefenition}

/**
 * Created by Freddie on 17/08/2015.
 */
object FBasic extends LanguageDefenition{

  def parsers: List[Parser] = List (
    new InParser(),
    new PrintParser()
  )

}
