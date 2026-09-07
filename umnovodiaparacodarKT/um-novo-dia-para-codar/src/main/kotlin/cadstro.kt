import kotlin.system.exitProcess

data class Alunos(
    val cpf: Int,
    val nome: String,
    val email: String
)
var nome: String = ""
val alunosCads = mutableListOf<Alunos>()

fun main() {

    print("Digite seu nome: ")
    nome = readlnOrNull().toString()

    println("Olá $nome, é um prazer ter você aqui!")
    println()

    inicio()
}

fun inicio() {
        var cntAlunos = 0
        var pare = false

        while (true) {
            println("====Cadastro De Alunos====")
            println("1- Cadstre Alunos")
            println("2 - Alunos Cadastrados")
            println("3 - Sair")

            val escolha = readln().toIntOrNull()

            when (escolha){
                1 -> {
                    println("Cadastre seu aluno!")
                    println()
                    println("Digite o nome do aluno: ")
                    val nomeAl = readln()
                    if(nomeAl.equals("PARE", ignoreCase = true)) {pare = true; break}
                    println("Digite o email do aluno: ")
                    val emailAL = readln()
                    if (emailAL.equals("PARE", ignoreCase = true)) {pare = true; break}
                    println("Digite o CPF do aluno: ")
                    val cpfAlunos = readln()
                    if (cpfAlunos.equals("PARE", ignoreCase = true)) {pare = true; break}
                    val cpfAl = cpfAlunos.toInt()

                    val novosAlunos = Alunos(cpf = cpfAl, nome = nomeAl, email = emailAL)
                    alunosCads.add(novosAlunos)
                    cntAlunos++
                    println("Aluno cadastrado com sucesso! Alunos Cadastrados: $cntAlunos")
                }

                2 -> {
                    alunosCadastrados()
                }

                3 -> {
                    sair()
                }

                else -> erroCadastradosAlunos()
            }

        }
    if (pare) {
        println("          Program encerrado          ")
        alunosCadastrados()
        exitProcess(0)
    }
}

fun alunosCadastrados(){

    println("         Alunos Castrados!          ")
    println()
    println("Alunos:\n ${alunosCads.size}")
    if (alunosCads.isEmpty()) {
        println("Nenhuma aluno castrado!")
    } else {
        for (alunos in alunosCads) {
            println("Nome: ${alunos.nome} Email: ${alunos.email} Cpf: ${alunos.cpf}")
        }
    }
}

fun erroCadastradosAlunos(){
    println("Por favor, informe um número entre 1 e 3.")
}

fun sair() {
    print("Você deseja sair? (S/N)")
    val confirma = readln().uppercase()

    when (confirma) {
        "S" -> { println("$nome, foi um prazer ter você por aqui!") ; exitProcess(0)}
        "N" -> {
            return
        }
        else -> sair()
    }
}
