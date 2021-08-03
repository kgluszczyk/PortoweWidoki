import java.lang.IllegalArgumentException

//Wprowadzenie do Kotlina - podsumowanie
//Niemodyfikowalna zmienna
val text = "Shinny"
// Modyfikowalna, opcjonalna zmienna typu nullowalnego
val mutableText: String? = null
// Funkcje w Kotlinie są obywatelami pierwszego świata co oznacza, że mogą być przypisywane do zmiennych - nazywamy je wtedy lambdami, są one również anonimowe (nie specyfikujemy ich nazwy)
val action = { text: String -> println(text) }
text.evaluate(2)
//funkcja wyższego rzędu (przujmuje inną funkcje jako parametr)
.also(action)

evaluate(2, text)
//w przypadku funkcji wyższego rzędu przyjmującej pojedynczy parametr, lambde można pominąć nawiasy i bezpośrednio zdefiniować lambde
.also { evaluatedText -> println(evaluatedText) }

//Jako, że odwołujemy się do nullowalnej zmiennej tylko bezpieczne (?.) lub określone jako nie-nullowe (!!.) odwołania są dopuszczlne
mutableText?.evaluate(2)
//korzystając z domyślnego parametru możemy wywołanie skrócić jeszcze bardziej
.also { println(it) }

//Operator Elvis (?:) oraz kolejna(po also), jedna z 5ciu, scope function (wykonywanie bloku kodu na obiekcie)
runCatching {
    (mutableText ?: throw IllegalArgumentException("Ups...")).run {
        println("Ufff")
    }
}.getOrElse { println("Ufff2") }

println("### Data klasy ###")
/**
 * Klasy których celem jest trzymanie danych, wyposażone w mechanizmy powszechnie wykorzystywane w takich przypadkach
 */
println("### Data klasy ###")
val user = User("MyName")
val user2 = User("MyName")
println("Are users equal? - ${user == user2}")
println("__${user}__ vs __${user2}__")
val userIt = UserIT("MyName", 1)
val userIt2 = userIt.copy(skillLevel = 1)
//Interpolacja ciagów tekstowych
println("Are users IT equal? - ${userIt == userIt2}")
println("__${userIt}__ vs __${userIt2}__")

//Extention functions
fun String.evaluate(position: Int = 0) = this.substring(position, position + 1)

//Domyślny parametr, uproszczona definicja funkcji
fun evaluate(position: Int = 0, text: String) = text.substring(position, position + 1)

//Klasa otwarta na rozszerzanie
open class User(val name: String = "Kowalski") {

    override fun toString(): String {
        return "_%_${name}_%_"
    }
}

//Data klasa + named parameter
data class UserIT(val name2: String, val skillLevel: Int) : User(name = name2)