#EasyLang
###An easy way to create programming languages in Scala

The current version is E-Lang 1. This will only support VERY simple languages like BASIC clones. Se the "Language Examples" for samples.

##How to use
###Run the examples
The easiest way to use EasyLang is to use an example laguage included in the examples package. To do this all you need to greate a Grammar object by passing it a List[Parser] with all the keyword parsers in your language. A default list of these is provided by an example. This list is what really defines your language. Then you create a Language instance from that grammar. From this insatnce you can run code by using `Language.execute(code: String)`

```scala
/**
 * Example language App. Runs F-BASIC Code
 * (Very simple BASIC clone)
 */
object FBasicExample extends App{
  //Create a grammar object from the example parser list
  val grammar  = new Grammar (FBasic.parsers)
  //Create a language from that Grammar
  val language = new Language(grammar)

  //Execute some code
  language.execute(
    "PRINT \"Hello\"\n"+
    "print \"What is your name? \"\n" +
    "IN name\n" +
    "PRINT \"Hello\"\n" +
    "PRINT name"
  )
}
```
###Create your own
To create your own languages you need to define some Parsers. A parser in E-Lang 1 is a keyword followed by some parameters. These parameters are passed as a list of tokens. See some example parsers for inspiration. Below is an example of a PRINT Parser

```scala
/**
 *  Example parser for a print command
 */
class PrintParser extends Parser{

  //Data about the command
  def keyword: String = "PRINT"
  def parameterNumber: Int = 1

  //Execute the command
  def execute (params: List[Token], context:Context): Unit = {
    //Get the parameter
    val param = params.head
    //Match the type of token
    param.TType match {
        case TokenType.STRING_LITERAL => println(param.token) //Print a string
        case TokenType.INT_LITERAL    => println(param.token) //Print an integer
        case TokenType.IDENTIFIER     => println(context.getVariable(param.token)) //Find the variable in the context
        case _                        => throw new IllegalArgumentException("Illegal arguments for PRINT keyword") //Cannot print any other type
    }
  }
}
```
You can then pass your parsers in a list to the Grammar
```scala
List (
    new InParser(),
    new PrintParser()
  )
```
