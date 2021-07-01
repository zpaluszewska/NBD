import scala.util.matching.Regex




object NBD2 {

  //Zadanie 1
  def zad1(): Unit = {
    println("--------------------")
    println("Zadanie 1:");
    println("--------------------")

    var list = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    val pattern: Regex = "Sobota|Niedziela".r
    val pattern1: Regex = "Poniedziałek|Wtorek|Środa|Czwartek|Piątek".r

    //println(list filter (x => pattern.pattern.matcher(x).matches()))

    for(day <- list) {

      if(pattern.pattern.matcher(day).matches()) {
        println(s"${day} => Weekend")
      } else if(pattern1.pattern.matcher(day).matches()) {
        println(s"${day} => Praca")
      } else {
        println("Nie ma takiego dnia")
      }
    }
  }

  //Zadanie 2
  class KontoBankowe(private var accountState: Int) {

    def this() {
      this(0)
    }

    def income(x: Int): Unit = {
      this.accountState += x
    }

    def payment(x: Int): Unit = {
      this.accountState -= x
    }

    def getAccountState: Int ={
      accountState
    }
  }

  //Zadanie 3
  class Osoba(private var imie: String, private var nazwisko: String) {

    def getImie(): CharSequence = {
      imie
    }

    def getNazwisko(): CharSequence = {
      nazwisko
    }
  }

  def helloPerson(person1: Osoba): String = {
    val pattern1: Regex = ".+ska".r
    val pattern2: Regex = ".+ski".r
    val pattern3: Regex = "\\w{3,5}".r //[A-Za-z]

    if(pattern1.pattern.matcher(person1.getNazwisko()).matches()) {
      s"Szanowna Pani ${person1.getImie()}"

    } else if(pattern2.pattern.matcher(person1.getNazwisko()).matches()) {
      s"Szanowny Panie ${person1.getImie()}"

    } else if(pattern3.pattern.matcher(person1.getImie()).matches()){
      s"Witaj ${person1.getImie()} z imieniem o długości od 3 do 5 znaków"

    } else {
      s"Hello ${person1.getImie()}"

    }
  }

  //Zadanie 4
  def foo(x: Int): Int = {
    x+x
  }

  def function(i: Int, i1: Int): Int = {
    i * i1 * i1 * i1
  }

  //Zadanie 5
  case class Osoba1(private var _imie: String, private var _nazwisko: String, private var _podatek: Double) {

    def imie:String = imie
    def nazwisko:String = nazwisko
    def podatek:Double = podatek

    def this() {
      this("Stanisław", "Kopytko", 65000)
    }
  }

  trait Pracownik extends Osoba1 {
    var _pensja: Double

    def pensja: Double = _pensja * podatek
    def pensja_(value: Double): Unit = {
      this._pensja = value
    }

    override def podatek: Double = 0.2
  }

  trait Student extends Osoba1 {
    override def podatek: Double = 0
  }

  trait Nauczyciel extends Pracownik {
    override var podatek: Double = 0.1
  }



  def main(args: Array[String]): Unit = {

    zad1()

    println("--------------------")
    println("Zadanie 2:")
    println("--------------------")
    val user1 = new KontoBankowe(15000)

    println(s"Stan konta: ${user1.getAccountState}")

    user1.income(1000)
    println(s"Stan konta po wpłacie: ${user1.getAccountState}")

    user1.payment(10000)
    println(s"Stan konta po wypłacie: ${user1.getAccountState}")

    println("--------------------")
    println("Zadanie 3:")
    println("--------------------")
    val person1 = new Osoba("Jan", "Kowalski")
    val person2 = new Osoba("Magdalena", "Wojcik")
    val person3 = new Osoba("Olga", "Kozlowska")
    val person4 = new Osoba("Adam", "Adamski")

    println(helloPerson(person1))
    println(helloPerson(person2))
    println(helloPerson(person3))
    println(helloPerson(person4))

    println("--------------------")
    println("Zadanie 4:")
    println("--------------------")
    println(function(1, foo(2)))

    println("--------------------")
    println("Zadanie 5:")
    println("--------------------")
    val osoba1 = new Pracownik {
      override var _pensja: Double = 7500
    }

    println(s"Pensja Pracownika= ${osoba1._pensja}")
  }
}