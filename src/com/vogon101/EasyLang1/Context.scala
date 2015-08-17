package com.vogon101.EasyLang1

import scala.collection.immutable.HashMap

/**
 * Created by Freddie on 17/08/2015.
 *
 */
class Context {
  private var variables = HashMap[String, AnyVal] ()

  def getVariable (name: String):AnyVal = variables(name)
  def setVariable (name: String, value: AnyVal) = variables += ((name, value))

  def getVariableOfType[T <: AnyVal] (name:String):T ={
    val v = variables(name)
    v match {
      case a : T => v.asInstanceOf[T]
      case _ => null.asInstanceOf[T]
    }
  }

}
