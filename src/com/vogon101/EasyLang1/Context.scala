package com.vogon101.EasyLang1

import scala.collection.immutable.HashMap
import scala.reflect.ClassTag

/**
 * Created by Freddie on 17/08/2015.
 *
 */
class Context {
  private var variables = HashMap[String, AnyVal] ()

  def getVariable (name: String):AnyVal = variables(name)
  def setVariable (name: String, value: AnyVal) = variables += ((name, value))

  def getVariableOfType[T <: AnyVal : ClassTag] (name:String):T ={
    val v = variables(name)
    v match {
      case x: T => x
      case _ => null.asInstanceOf[T]
    }
  }

}
