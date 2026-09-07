fun main() {
    val frutasNoEstoque = mutableListOf(
        mutableListOf("Maçã", "Banana", "Uva"),
        mutableListOf("Pera", "Melancia", "Morango"),
        mutableListOf("Manga", "Mamão", "Tamara")
    )

    print("Digite seu nome: ")
    val nome = readlnOrNull().toString()

    println("Olá $nome, seja bem-vindo(a) ao mercadinho de frutas do Gabriel Augusto!")
    println()

    while (true) {
        if (frutasNoEstoque.all { it.isEmpty() }) {
            println("\nLista de compras finalizada")
            break
        }

        println("\nEssas são as frutas disponíveis no estoque:")
        for (linha in frutasNoEstoque) {
            if (linha.isNotEmpty()) {
                println(linha.joinToString(separator = " | "))
            }
        }

        println("\nDigite o nome de uma fruta: ")
        val frutaDigitada = readln().trim()

        if (frutaDigitada.equals("PARE", ignoreCase = true)) {
            println("\nPrograma encerrado pelo usuário.")
            println("Frutas restantes no mercado: ${frutasNoEstoque.flatten().filter { it.isNotEmpty() }}")
            break
        }

        val frutaEncontrada = frutasNoEstoque.flatten().find { it.equals(frutaDigitada, ignoreCase = true) }

        if (frutaEncontrada != null) {
            println("Fruta encontrada!")
            println("Você deseja remover a fruta do estoque? (S/N) ")
            val resposta = readln().uppercase().trim()

            if (resposta == "PARE") {
                println("\nPrograma encerrado pelo usuário.")
                println("Frutas restantes no mercado: ${frutasNoEstoque.flatten().filter { it.isNotEmpty() }}")
                break
            }

            if (resposta == "S") {
                for (linha in frutasNoEstoque) {
                    linha.remove(frutaEncontrada)
                }
                println("Fruta foi retirada da lista")
            }
        } else {
            println("Fruta indisponível no nosso mercado")
        }
    }
}
