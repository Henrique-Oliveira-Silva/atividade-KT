fun main() {
    var lista_planetas =
        mutableListOf<String>("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno", "Plutão")

    println(lista_planetas)
    var resposta: String
    var continuar = true

    while(continuar) {
        println("Digite o nome de um planeta: ")
        var inputUsuario = readln().trim()

        val planetaEncontrado = lista_planetas.find { it.equals(inputUsuario, ignoreCase = true) }

        if (planetaEncontrado != null) {
            println("Planeta encontrado.")
            println("Você gostaria de removê-lo? S/N")

            resposta = readln()
            if (resposta.equals("S", ignoreCase = true)) {
                lista_planetas.remove(planetaEncontrado)
                println("O planeta $planetaEncontrado foi removido. Essa é a lista atual: $lista_planetas")
            }
        } else {
            println("Planeta não encontrado.")
            println("Você gostaria de adicioná-lo? S/N")

            resposta = readln()
            if (resposta.equals("S", ignoreCase = true)) {
                val planetaFormatado = inputUsuario.replaceFirstChar { it.uppercase() }
                lista_planetas.add(planetaFormatado)
                println("O planeta $planetaFormatado foi adicionado. Essa é a lista atual: $lista_planetas")
            }
        }

        println("Deseja encerrar o programa? S/N")
        resposta = readln()
        if (resposta.equals("S", ignoreCase = true)){
            continuar = false
            println("Programa encerrado com sucesso!")
        }
    }
}
