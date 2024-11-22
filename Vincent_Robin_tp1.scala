// Databricks notebook source
// MAGIC %md
// MAGIC # Hello World!

// COMMAND ----------

println("Hello World")

// COMMAND ----------

var x= 10

// COMMAND ----------

x = 20

// COMMAND ----------

val y = 5

// COMMAND ----------

y = 10

// COMMAND ----------

// COMMAND ----------

val y: Int = 10;
val y = 10

// COMMAND ----------

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(20, 5)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addSimpleNumbers = addSimple(30,6)

// COMMAND ----------

// COMMAND ----------

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

// COMMAND ----------

(x : Int) => {
  x + 100
}

// COMMAND ----------

val higherOrderFunctionTest1 = encode(10, (x: Int) => {x + 100})

// COMMAND ----------

// COMMAND ----------

val higherOrderFunctionTest2 = encode(10, (x: Int) => x + 100)

// COMMAND ----------

// COMMAND ----------

val higherOrderFunctionTest3 = encode(10, x => x + 100)

// COMMAND ----------

// COMMAND ----------

val higherOrderFunctionTest4 = encode(10, _ + 100)

// COMMAND ----------

// COMMAND ----------

class Car(mk: String, ml: String, cr: String){
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

corvette.repaint("Blue")

// COMMAND ----------

// COMMAND ----------

case class Message(from: String, to: String, content: String)
// equivalent to
// class Message(val from: String, val to: String, val content: String)

// COMMAND ----------

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10,20, "+")
val product = f(10, 20, "*")
