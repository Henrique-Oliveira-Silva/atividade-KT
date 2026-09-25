import kotlin.system.exitProcess

fun main() {

    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readln()
    val pet = BichinhoVirtual(nomePet)

    while (true) {

        if (pet.vitoria()) {
            println("Parabéns! Você cuidou muito bem do(a) $nomePet!")
            exitProcess(0)
        }

        if (pet.derrota()) {
            println("Obrigado por tentar cuidar do(a) $nomePet!")
            exitProcess(0)
        }

        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Descansar com $nomePet")
        println("4. Verificar o status de $nomePet")
        println("5. Levar $nomePet ao banheiro")
        println("6. Levar $nomePet ao PetShop")
        println("7. Sair")

        val escolha = readln().toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.verificarStatus()
            5 -> pet.banheiro()
            6 -> pet.banho()
            7 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> { println("Escolha inválida. Tente novamente.")
            continue
            }
        }

        pet.passarTempo()

        if (pet.vitoria()) {
            println("Parabéns! Você cuidou muito bem do(a) $nomePet!")
            exitProcess(0)
        }
        if (pet.derrota()) {
            println("Obrigado por tentar cuidar do(a) $nomePet!")
            exitProcess(0)
        }
    }
}