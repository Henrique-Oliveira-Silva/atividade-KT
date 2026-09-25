import kotlin.system.exitProcess

class BichinhoVirtual(val nome: String) {

    var nivelDeFome = 20
    var nivelFelicidade = 50
    var nivelCansaco = 30
    var idade = 1
    var vontadeBanheiro = 0
    var sujeira = 0

    fun alimentar() {
        nivelDeFome -= 10
        if (nivelDeFome < 0) nivelDeFome = 0
        vontadeBanheiro += 5
        println("$nome foi alimentado(a). O nível de fome diminuiu.")
        println("Nivel atual de fome: ${nivelDeFome}\n")
        println("$nome está com vontade de usar o banheiro!")
        println("Vontade de usar o banheiro: ${vontadeBanheiro}\n")
    }

    fun brincar() {
        nivelFelicidade += 10
        if (nivelFelicidade > 100) nivelFelicidade = 100
        nivelDeFome += 5
        nivelCansaco += 5
        sujeira += 5
        println("$nome está brincando e se sentindo mais feliz.")
        println("$nome brincou e está com fome!")
        println("$nome brincou e está ficando mais cansado(a)!")
        println("$nome brincou e agora está sujo(a)!")
        println("Nivel atual de felicidade: ${nivelFelicidade}")
        println("Nivel atual de fome: ${nivelDeFome}")
        println("Nivel atual de cansaço: ${nivelCansaco}")
        println("Nivel atual de sujeira: ${sujeira}")

    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Idade: $idade")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelFelicidade")
        println("Nivel de cansaço: $nivelCansaco")
        println("Vontade de usar o banheiro: ${vontadeBanheiro}\n")
        println("Nivel de sujeira: $sujeira")
    }

    fun passarTempo() {
        nivelDeFome += 3
        nivelFelicidade -= 3
        nivelCansaco += 10
        idade += 1
        println("$nome está ficando mais faminto(a) com o passar do tempo.")
        println("Nivel atual de fome: ${nivelDeFome}\n")
        println("$nome está ficando mais triste com o passar do tempo.")
        println("Nivel atual de felicidade: ${nivelFelicidade}")
        println("$nome está ficando mais cansado com o passar do tempo.")
        println("Nivel atual de cansaço: ${nivelCansaco}\n")
    }

    fun descansar(){
        println("Você desejar deixar o(a) descansando por quantas horas?")
        var quantidadeDeDescanso = readln().trim().toIntOrNull()?: 0

        if (quantidadeDeDescanso >= 8) {
            nivelCansaco = 0
            println("$nome está totalmente descansado!")
        }else if (quantidadeDeDescanso in 1..7) {
            println("Está descansando!")
            nivelCansaco -= 15
        }
        if (nivelCansaco < 0) {
            nivelCansaco = 0
        }

        println("Nível atual de cansaço: $nivelCansaco/100")

    }

    fun derrota(): Boolean {
        if (nivelDeFome >= 100) {
            println("\n💀 GAME OVER! $nome chegou a 100 de fome e morreu! 🍔")
            return true
        }
        if (nivelCansaco >= 100) {
            println("\n💀 GAME OVER! $nome chegou a 100 de cansaço e desmaiou de exaustão! 💤")
            return true
        }
        if (nivelFelicidade <= 0) {
            println("\n💀 GAME OVER! $nome chegou a 0 de felicidade e fugiu de tristeza! 😢")
            return true
        }
        if (vontadeBanheiro >= 20){
            println("\n💀 GAME OVER! $nome fez caquinha na casa toda! \uD83D\uDCA9")
            return true
        }
        if (sujeira >= 20){
            println("\n💀 GAME OVER! $nome está muito fedorento! \uD83E\uDD22\uD83D\uDC43")
            return true
        }
        return false
    }

    fun vitoria(): Boolean {
        if (idade >= 50) {
            println("\n🎉 PARABÉNS! Você alcançou o objetivo!")
            println("🏆 $nome chegou saudável à idade 50 sob os seus cuidados. Você é um excelente cuidador!")
            return true
        }
        return false
    }

    fun banheiro(){
        vontadeBanheiro -= 5
        if (vontadeBanheiro < 0) vontadeBanheiro = 0
        println("$nome está usando o banheiro!")
    }

    fun banho(){
        sujeira -= 5
        if (sujeira < 0) sujeira = 0
        println("$nome está no PetShop se livrando da sujeira!")
    }
}