package com.vogon101.EasyLang1

/**
 *
 * Trait for objects that can define a language
 *
 */
trait LanguageDefinition {

  /**
   * @return The parsers for this language
   */
  def parsers: List[Parser]

}