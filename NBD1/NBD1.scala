import scala.annotation.tailrec

object NBD {

  //Zadanie 1
  def zad1(): Unit = {
    println("Zadanie 1:");
    println("--------------------")

    var lista = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    println("1.a: ")
    for(a <- lista) {
      print(s"${a} ")
    }

    println("\n1.b: ")
    for(a <- lista) {
      if(a.startsWith("P")) {
        print(s"${a} ")
      }
    }

    println("\n1.c: ")
    while(lista.nonEmpty) {
      print(s"${lista.head} ")
      lista = lista.tail
    }
  }

  //Zadanie 2
  def zad2(): Unit = {
    println("Zadanie 2:");
    println("--------------------")
    var lista = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    println("\n2.a: ")
    def recFunction(list: List[String]): String = {
      if(list.nonEmpty) {
        if(list.tail.isEmpty) {
          list.head + recFunction(list.tail)
        } else {
          list.head + ", " + recFunction(list.tail)
        }
      } else {
        ""
      }
    }
    println(s"${recFunction(lista)}\n")

    def reverseRecFunction(list: List[String]): String = {
      if(list.nonEmpty) {
        if(list.tail.isEmpty) {
          list.head + reverseRecFunction(list.tail)
        } else {
          reverseRecFunction(list.tail) + ", " + list.head
        }
      } else {
        ""
      }
    }
    println(s"${reverseRecFunction(lista)}\n")
  }

  //Zadanie 3
  def zad3(): Unit = {
    println("Zadanie 3:");
    println("--------------------")
    var lista = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    def tailRecFunc(list: List[String]): String = {
      @tailrec
      def iter(list: List[String], result: String): String = {
        if (list.nonEmpty) {
          if (result.ne("")) {
            iter(list.tail, result + ", " + list.head)
          } else {
            iter(list.tail, result + list.head)
          }
        } else {
          result
        }
      }

      iter(list, "")
    }

    println(s"${tailRecFunc(lista)}\n")
  }

  //Zadanie 4
  def zad4(): Unit = {
    println("Zadanie 4:");
    println("--------------------")

    var lista = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    println("Metoda FOLDL")
    println(lista.tail.foldLeft(lista.head)(_ + ", " + _))

    println("Metoda FOLDR")
    println(lista.foldRight("")(_ + ", " + _))

    println("Metoda FOLDL 3.c ")
    println(
      lista.foldLeft("")((x, y) => {
        if(y.startsWith("P")) {
          if(x.isEmpty) {
            y
          } else {
            x + ", " + y
          }
        } else {
          x
        }
      })
    )
  }


  //Zadanie 5
  def zad5(): Unit = {
    println("Zadanie 5:");
    println("--------------------")

    println("Przed obnizka:")
    val items = Map("Opony" -> 2000, "Olej" -> 400, "Wycieraczki" -> 100)
    println(items)

    println("Po obnizce:")
    val promItems = items map {case (key, value) => (key, value * 0.9)}
    println(promItems)

  }

  //Zadanie 6
  def zad6(): Unit = {
    println("Zadanie 6:");
    println("--------------------")

    val t = Tuple3("Argument 1", 2, 3.5)

    println(t)
  }

  //Zadanie 7
  def zad7(): Unit = {
    println("Zadanie 7:");
    println("--------------------")

    val persons = Map(1 -> "Krzysztof", 2 -> "Stanislaw", 3 -> "Magdalena")

    def check(z: Option[String]) = z match {
      case Some(s) => (s)

      case None => ("NOT FOUND")
    }

    println(check(persons.get(1)))
    println(check(persons.get(4)))
  }

  //Zadanie 8
  def zad8(): Unit = {
    println("Zadanie 8:");
    println("--------------------")

    val digits = List(2,4,6,7,9,0,2,0,2,8,3,0,6,0)

      @tailrec
      def removeZeros(inputArg: List[Int], resultArg: List[Int]): List[Int] = {
        if (inputArg.nonEmpty) {
          val head: Int = inputArg.head
          if (!head.equals(0)) {
            removeZeros(inputArg.tail, resultArg.::(head))
          } else {
            removeZeros(inputArg.tail, resultArg)
          }
        } else {
          resultArg
        }
      }

      val resultDigits = removeZeros(digits, List.empty)
      println(digits)
      println(resultDigits)
  }

  //Zadanie 9
  def zad9(): Unit = {
    println("Zadanie 9:");
    println("--------------------")

    val input = List(7,4,5,2,3,6,7,8,12,43,5,454,8)
    val output = input.map(input => input +1)
    println(s"Input= ${input}")
    println(s"Output= ${output}")
  }

  //Zadanie 10
  def zad10(): Unit = {
    println("Zadanie 10:");
    println("--------------------")

    val input = List(-2,-44,-5,-6,-1,-52,-56,-90,-5,7,2,2,6,7,8,345,4)
    val output = input.filter(input => input >= -5 && input <= 12)

    println(s"Input= ${input}")
    println(s"Output= ${output}")
  }

  def main(args: Array[String]): Unit = {

    //NBD1
    zad1()
    zad2()
    zad3()
    zad4()
    zad5()
    zad6()
    zad7()
    zad8()
    zad9()
    zad10()
  }
}