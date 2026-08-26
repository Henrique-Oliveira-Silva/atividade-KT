import kotlin.system.exitProcess

var saldo = 100.5 // Float
var nome: String = ""

fun main() {

    print("Digite seu nome: ")
    nome = readlnOrNull().toString()

    println("Olá $nome, é um prazer ter você aqui!")
    println()

    inicio()
}

fun inicio() {
    println("Escolha uma opção:")
    println("1 - Ver saldo")
    println("2 - Extrato")
    println("3 - Fazer saque")
    println("4 - Fazer deposito")
    println("5 - Fazer transferencia")
    println("6 - Sair")

    val escolha = readlnOrNull()?.toIntOrNull()

    when (escolha) {
        1 -> verSaldo()
        2 -> extrato()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        5 -> transferencia()
        6 -> sair()
        else -> erro()
    }
}

fun verSaldo() {
    senha()
    println("Seu saldo atual é:  ${String.format("%.2f", saldo)}")//"%.2f" - mostra duas casas após o ponto
    inicio()
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    val deposito = readlnOrNull()?.toFloatOrNull()
    // Usando readln e Elvis operator -> Operador de coalescência nula
    // val deposito = readln().toFloatOrNull() ?: 0.0

    if (deposito == null || deposito <= 0) {
        println("Operção não autorizada!")
        fazerDeposito()
    } else {
        senha()
        saldo += deposito
        println("Seu atual agora é: ${String.format("%.2f", saldo)}")
        inicio()
    }
}

fun fazerSaque() {
    print("Qual o valor para saque? ")
    val saque = readlnOrNull()?.toFloatOrNull()

    if (saque == null || saque <= 0.0) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    }
    else if(saque > saldo) {
        println("O saque não pode ser maior que o saldo!")
        fazerSaque()
    }
    else {
        senha()
        saldo -= saque
        println("Saque realizado com sucesso! ")
        println("Seu saldo restante é: ${String.format("%.2f", saldo)}")
        println()
        inicio()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 a 6.")
    inicio()
}

fun sair() {
    print("Você deseja sair? (S/N)")
    // Usando readln e Elvis operator -> Operador de coalescência nula
    val confirma = readln().uppercase()
    // Locale -> Localização do usuário para converter para maiúsculo
    //val confirma = readLine()?.uppercase(Locale.getDefault())

    when (confirma) {
        "S" -> { println("$nome, foi um prazer ter você por aqui!") ; exitProcess(0)}//Hasta la vista, baby}
        "N" -> inicio() // Volta para o início
        else -> sair()
    }
}

fun extrato(){
    val extrato = "Transferência Pix Recebida - Mariana Souza+ 450,00 \nCrédito 05/08 Compra no Débito - Posto de Combustível- 150,00 \nDébito 08/08 Pagamento de Boleto - Internet Fibra- 100,00 \nDébito 10/08 Depósito Recebido - Crédito de Salário+ 3.000,00 \nCrédito 12/08 Compra Débito - Supermercado Central- 400,00 \nDébito 14/08 Transferência Pix Enviada - Aluguel Imobiliária- 1.500,00\n"
    senha()

    println("Extrato: \n$extrato")
    inicio()
}

fun transferencia(){
    print("Para qual conta deseja realizar a transferencia? ")
    val conta = readlnOrNull()?.toIntOrNull()
    println()
    print("Qual valor você deseja tranferir? ")
    val valor = readlnOrNull()?.toDoubleOrNull()

    if(valor == null || valor <= 0.0){

        print("Operação não autorizada! ")
        transferencia()
    }
    else if(valor > saldo){
        println("O valor a ser trasnferido não pode ser maior que o saldo autal!")
        transferencia()
    }
    else{
        senha()
        print("Operação realizada com sucesso!\n")
        saldo -= valor
        println("Seu saldo restante é: ${String.format("%.2f", saldo)}")
        inicio()
    }
}

fun senha(){
    val senha1 = "3589"

    println("Digite a senha para concluir a operação: ")
    val senha2 = readlnOrNull()

    when(senha2){
        senha1 -> {
            println("Operação autorizada!")
        }
        else -> {
            println("Senha incorreta! ")
            println("Digite novamente sua senha! ")
            senha()
        }

    }
}
