package com.vogon101.EasyLang1.examples.FBasic

import com.vogon101.EasyLang1.examples.FBasic.parsers.{PrintParser, InParser}
import com.vogon101.EasyLang1.{Parser, LanguageDefinition}

/**
 * Example LanguageDefinition for FBasic
 */
object FBasic extends LanguageDefinition{

  def parsers: List[Parser] = List (
    new InParser(),
    new PrintParser()
  )

}
