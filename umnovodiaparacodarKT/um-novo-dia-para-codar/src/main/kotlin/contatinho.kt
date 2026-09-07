import kotlin.system.exitProcess

data class Contatos(
    val nomeDoContato: String,
    val telefoneDoContato: String
)
val listaDeContatos = mutableListOf<Contatos>()
var name: String = ""

fun main(){

    print("Digite seu nome: ")
    name = readlnOrNull().toString()

    println("\nOlá $name, seja bem-vindo(a) a lista de contatos: ")
    Painel()
}

fun Painel(){
while (true){
    println("\nSelecione uma opção: ")
    println("1 - Adiconar")
    println("2 - Buscar")
    println("3 - Remover")
    println("4 - Listar")
    println("5 - Sair")

    val escolha = readlnOrNull()?.toIntOrNull()

    when (escolha) {
        1 -> Adicionar(listaDeContatos)
        2 -> Buscar()
        3 -> Remover()
        4 -> Listar(listaDeContatos)
        5 -> Sair()
        else -> Erro()
    }

}
    }

fun Adicionar(listaDeContatos: MutableList<Contatos>) {
while (true) {
    println("Digite o nome do contato a ser adicionado ou digite 'Painel' para voltar ao painel: ")
    val nomeDoContato = readln().trim()

    if (nomeDoContato.equals("PAINEL", ignoreCase = true)) {
        return
    }

    println("Digite o telefone do contato a ser adicionado: ")
    val telefoneDoContato = readln().trim()

    val novoContato = Contatos(nomeDoContato, telefoneDoContato)
    listaDeContatos.add(novoContato)

    println("Novo contato adicionado!")


    }
}

fun Buscar(){

    println("Digite o nome para buscar o contato: ")
    val buscaDeContato = readln().trim()

    val contatoEncontratdo = listaDeContatos.filter { it.nomeDoContato.contains(buscaDeContato, ignoreCase = true) }

    if (contatoEncontratdo.isEmpty()) {
        println("Nenhum contato encontrado com o nome $buscaDeContato")
    } else{
        println("Encontramos seu contato ${contatoEncontratdo.size}")
        for (contato in contatoEncontratdo) {
            println("Nome: ${contato.nomeDoContato}\nTelefone: ${contato.telefoneDoContato}\n")
        }
    }

}

fun Remover(){

    println("\n      Remover Contatos      ")
    println("Digite o nome do contato que deseja remover:")
    val buscaRemove = readln().trim()

    val contatoEncontrado = listaDeContatos.filter {
        it.nomeDoContato.contains(buscaRemove, ignoreCase = true)
    }


    if (contatoEncontrado.isEmpty()) {
        println("Nenhum contato encontrado com o nome '$buscaRemove'.")
        return
    }


    println("\nSelecione o número do contato que deseja remover:")
    contatoEncontrado.forEachIndexed { index, contato ->
        println("${index + 1} - Nome: ${contato.nomeDoContato}\nTelefone: ${contato.telefoneDoContato}\n")
    }
    println("${contatoEncontrado.size + 1} - Cancelar operação e voltar ao painel")


    val escolha = readln().toIntOrNull()

    if (escolha == null || escolha < 1 || escolha > contatoEncontrado.size + 1) {
        println("Opção inválida! Operação cancelada.")
        return
    }


    if (escolha == contatoEncontrado.size + 1) {
        println("Operação cancelada.")
        return
    }


    val contatoParaRemover = contatoEncontrado[escolha - 1]


    listaDeContatos.remove(contatoParaRemover)
    println("\nO contato '${contatoParaRemover.nomeDoContato}' foi removido com sucesso!")
    println("Esta é a lista de contatos atual: ")
    Listar(listaDeContatos)
}

fun Listar(listaDeContatos:List<Contatos>) {

    println("\n         Lista de Contatos Cadastrados         ")
    if (listaDeContatos.isEmpty()) {
        println("Nenhum contato foi cadastrado.")
    }else{
        for (contato in listaDeContatos) {
            println("Nome: ${contato.nomeDoContato}\nTelefone: ${contato.telefoneDoContato}\n")
        }
    }

}

fun Sair(){

    println("Você deseja sair? (S/N) ")
    val confirma = readln().uppercase()

    when (confirma) {
        "S" -> { println("$name, foi um prazer ter você por aqui!") ; exitProcess(0)}
        "N" -> Painel()
        else -> Sair()
    }

}

fun Erro(){

    println("Por favor, informe um número entre 1 a 5.")
    Painel()

}