// Databricks notebook source
// MAGIC %md
// MAGIC # Programming Paradigms

// COMMAND ----------

def f(x:Int): Int = x*2

def g(x:Int): Int = x+2

def h(x : Int): Int = f(g(x))

// COMMAND ----------

val input = 4
println(s"g($input) = ${g(input)}")
println(s"f(g($input)) = ${f(g(input))}")
println(s"h($input) = ${h(input)}")

// COMMAND ----------

// COMMAND ----------


val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

val language: Int = "Scala"

// COMMAND ----------

def add(x: Int, y:Int): Int = x + y
val sum = add(10,20)
println(s"Sum is: $sum")

// COMMAND ----------

val sumTest = add(10, "20")

// COMMAND -----------

val x =10
val y = 20
val z = x + y

// COMMAND ----------

val z = x.+(y)

// COMMAND ----------

val z1 = x.*(y)

// COMMAND ----------

// COMMAND ----------

trait Shape {
  def area(): Int
}

class Square(length: Int) extends Shape {
  def area = length * length
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area = length* width
}

val square = new Square(10)
val area = square.area

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "harry", true)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2
val third = threeElements._3

// COMMAND ----------

// COMMAND ----------

val arr = Array(10,20,30,40)

// COMMAND ----------

arr(0) = 50

// COMMAND ----------

val first = arr(0)

// COMMAND ----------


// COMMAND ----------

val xs = List(10,20,30,40)

// COMMAND ----------

val ys = (1 to 100).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

zs.head

// COMMAND ----------

zs.tail

// COMMAND ----------

zs.isEmpty

// COMMAND ----------

// COMMAND ----------

val v1 = Vector(0, 10, 20, 30, 40)

// COMMAND ----------

val v2 = v1 :+ 50

// COMMAND ----------

val v3 = v2 :+ 60

// COMMAND ----------

val v4 = v3(4)

// COMMAND ----------

val v5 = v3(5)

// COMMAND ----------

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana")

// COMMAND ----------

fruits.contains("Ananas")

// COMMAND ----------

// COMMAND ----------

val capitals = Map("France" -> "Paris", "Russia" -> "Moscow", "Australia" -> "Canberra")

// COMMAND ----------

val FranceCapital = capitals("France")

// COMMAND ----------

// COMMAND ----------

val myList = List(1, 2, 3, 4)

// COMMAND ----------

val myList1 = List(1.0, 2.0, 3.0, 4.0)

// COMMAND ----------

val myAnotherList1 = myList1.map((x: Double) => x * 10)

// COMMAND ----------

val myAnotherList = myList.map((x: Int) => x * 10.0)

// COMMAND ----------

val interType = myList.map {x => x * 10.0}

// COMMAND ----------

val fucntionLiteral = myList.map {_ * 10.0}

// COMMAND ----------


val line = "Scala is fun"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListChars = words.map{x => x.toList}

// COMMAND ----------

val arrayOfChars = words flatMap {x => x.toList}

// COMMAND ----------

val myNewList = (1 to 100).toList

// COMMAND ----------

val even = myNewList.filter { _ %2 ==  0}

// COMMAND ----------

val words = "Scala is fun".split(" ")

// COMMAND ----------

words.foreach(println)

// COMMAND ----------


val reduceList = List(2,4,6,8,10)

// COMMAND ----------

val sum = reduceList.reduce{(x,y) => x + y}

// COMMAND ----------

val mult = reduceList.reduce{(x,y) => x * y}
