package com.vogon101.EasyLang1

import scala.collection.immutable.HashMap
import scala.reflect.ClassTag

/**
 * Class for context for variables
 */
class Context {
  //TODO: Super context
  private var variables = HashMap[String, AnyVal] ()

  /** Get a variable from the context of no specific type **/
  def getVariable (name: String):AnyVal = variables(name)
  /** Set a variable in the context **/
  def setVariable (name: String, value: AnyVal) = variables += ((name, value))

  /**
   * Get a variable of a specific type in the context. Returns null.asInstanceOf[T]
   * if it is not found or is of the wrong type
   * @param name The name of the variable
   * @tparam T The type required
   * @return The value of the variable
   */
  def getVariableOfType[T <: AnyVal : ClassTag] (name:String):T ={
    val v = variables(name)
    v match {
      case x: T => x
      case _ => null.asInstanceOf[T]
    }
  }
}
