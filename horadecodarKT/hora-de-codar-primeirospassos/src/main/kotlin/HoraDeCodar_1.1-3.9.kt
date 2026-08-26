//1.1/////////////////////////////////////////////
fun main(){
    var nome_do_carro = "Fusca"
    println(nome_do_carro)
}
//1.2/////////////////////////////////////////////
fun main(){
    print("Digite seu nome: ")
    var nome = readLine()
    println("Olá $nome!")
}
//1.3/////////////////////////////////////////////
fun main(){
    print("Digite seu nome: ")
    var nome = readLine()
    print("Digite sua idade: ")
    var idade = readLine()
    println("Olá $nome, você tem $idade anos")

}
//2.1/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0

    if (n1 > n2){
        println("O número $n1 é o maior!")
    }
    else if (n2 > n1){
        println("O número $n2 é o maior!")
    }
}
//2.2/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    if (n1>0){
        println("O número $n1 é positivo!")
    }
    if (n1<0){
        println("O número $n1 é negativo!")
    }
    else if (n1==0.0){
        println("Esse é o número 0!")
    }
}
//2.3/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n3 = readlnOrNull()?.toDoubleOrNull()?:0.0

    if (n1>n2 && n1>n3){
        println("O número $n1 é o maior!")
    }
    if (n2>n1 && n2>n3){
        println("O número $n2 é o maior!")
    }
    if (n3>n1 && n3>n2){
        println("O número $n3 é o maior!")
    }
}
//2.4/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digote outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n3 = readlnOrNull()?.toDoubleOrNull()?:0.0

    var total = n1+n2+n3

    if (n1<n2 && n1<n3){
        total=total-n1
    }
    else if (n2<n1 && n2<n3){
        total=total-n2
    }
    else if (n3<n1 && n3<n2){
        total=total-n3
    }
    println("A soma entre os maiores números é: $total")
}
//2.5/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n3 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n4 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n5 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n6 = readlnOrNull()?.toDoubleOrNull()?:0.0

    val total = (n1+n2+n3+n4+n5+n6)/6
    print("A média aritmética entre os números que você digitou é: $total")
}
//2.6/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    var n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    var n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    var n3 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    var n4 = readlnOrNull()?.toDoubleOrNull()?:0.0

    if (n1>n2 && n1>n3 && n1>n4){
        print("Esse é o primeiro número que você digitou $n1, esse é o maior número que você digitou $n1 e esse é o ultimo número que você digitou $n4")
    }
    if (n2>n1 && n2>n3 && n2>n4){
        print("Esse é o primeiro número que você digitou $n1, esse é o maior número que você digitou $n2 e esse é o ultimo número que você digitou $n4")
    }
    if (n3>n1 && n3>n2 && n3>n4){
        print("Esse é o primeiro número que você digitou $n1, esse é o maior número que você digitou $n3 e esse é o ultimo número que você digitou $n4")
    }
    if (n4>n1 && n4>n2 && n4>n3){
        print("Esse é o primeiro número que você digitou $n1, esse é o maior número que você digitou $n4 e esse é o ultimo número que você digitou $n4")
    }
}
//2.7/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n3 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n4 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n5 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n6 = readlnOrNull()?.toDoubleOrNull()?:0.0

    var total = 0.0

    if(n1<72){
        total=total+n1
    }
    if(n2<72){
        total=total+n2
    }
    if(n3<72){
        total=total+n3
    }
    if(n4<72){
        total=total+n4
    }
    if(n5<72){
        total=total+n5
    }
    if(n6<72){
        total=total+n6
    }
    println("Você digitou os seguintes números: $n1, $n2, $n3, $n4, $n5, $n6 e a soma dos números menores que 72 é: $total")
}
//2.8/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n3 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    val n4 = readlnOrNull()?.toDoubleOrNull()?:0.0
    var media = 0.0
    var soma = 0.0
    var contador = 0.0

    if(n1<=10 && n1>0){
        soma = soma + n1
        contador++
    }
    if(n2<=10 && n2>0){
        soma = soma + n2
        contador++
    }
    if(n3<=10 && n3>0){
        soma = soma + n3
        contador++
    }
    if(n4<=10 && n4>0){
        soma = soma + n4
        contador++
    }
    media = soma / contador

    if(media>=5){
        print("Sua média foi: $media, você passou no teste!")
    }
    else if(media<4.9){
        print("Sua médida foi: $media, você não passou no teste, tente novamente!")
    }

}
//2.9/////////////////////////////////////////////
fun main() {
    print("Digite seu nome: ")
    var nome = readlnOrNull()
    print("Digite o ano que você nasceu: ")
    var ano = readlnOrNull()?.toIntOrNull() ?: 0

    if (ano == null) {
        println("Por favor digite um ano válido!")
    }
    else {
        if (ano in 0..2008) {
            print("Seu nome é $nome, você nasceu em $ano e tem direito ao voto!")
        }
        if (ano >= 2009) {
            print("Seu nome é $nome, você nasceu em $ano e não tem direito ao voto!")
        }
    }
}
//3.1/////////////////////////////////////////////
fun main(){
    var contador=30

    while (contador>=0){
        println("A bomba irá explodir em $contador")
        contador=contador-1
    }
    println("EXPLOSÃO!!!BOOOOOOOOOOOOOM!!!")
}
//3.2/////////////////////////////////////////////
fun main(){
    print("Digite um número: ")
    var n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
    print("Digite outro número: ")
    var n2 = readlnOrNull()?.toDoubleOrNull()?:0.0

    while(n2<=0.0){
        print("Houve um erro, o segundo número não pode ser negativo ou 0. Digite outro número: ")
        n2 = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    }
    val total=n1/n2
    print("A divisão entre os dois número é: $total")
}
//3.3/////////////////////////////////////////////
fun main(){
    var contador = 15
    var soma = 0
    var media: Int = 0

    while (contador <= 100){
        println(contador)
        soma += contador
        contador += 1
    }
    media=soma/86
    println("media = $media")
}
//3.4/////////////////////////////////////////////
fun main(){
    print("Digite um nùmero: ")
    var n1 = readlnOrNull()?.toIntOrNull()?:0
    print("Digite outro número: ")
    var n2 = readlnOrNull()?.toIntOrNull()?:0

    var contador = n1
    var soma = 0
    var quantidade: Int = 0
    var media: Double = soma.toDouble()

    while(n2<=n1){
        print("Houve um erro, o primeiro número precisa ser menor que o segundo, digite outro número: ")
        n2 = readlnOrNull()?.toIntOrNull()?:0
    }
    while(contador<=n2){
        soma=soma+contador
        contador=contador+1
    }
    quantidade = n2-n1+1
    media = soma.toDouble()/quantidade
    println("A média entre os números é: $media")
}
//3.5/////////////////////////////////////////////
fun main() {
    var resposta = "S"
    var alunos = 0
    var alunos2 = 0
    while (resposta.equals("S", ignoreCase = true)){

        print("Digite a nota a primeira nota aluno: ")
        val n1 = readlnOrNull()?.toDoubleOrNull()?:0.0
        print("Digite a segunda nota aluno: ")
        val n2 = readlnOrNull()?.toDoubleOrNull()?:0.0

        val media = (n1+n2)/2

        println("A média é: $media")

        if(media>=9.5){
            println("Aluno aprovado!")
            alunos++
        }
        else{
            println("Aluno reprovado!")
            alunos2++
        }
        print("Quer calcular a média de outro aluno? (S/N): ")
        resposta = readlnOrNull()?: "N"

        println("Alunos aprovados: $alunos")
        println("Alunos reprovados: $alunos2")
    }


}
//3.6/////////////////////////////////////////////
fun main(){
    var soma: Double = 0.0
    var contador = 0
    var media: Double = 0.0

    while(contador<6){
        print("Digite a nota: ")
        var nota = readlnOrNull()?.toDoubleOrNull()?:0.0


        while(nota < 0 || nota > 10){
            print("Essa nota não é valida! Digite outra nota: ")
            nota = readlnOrNull()?.toDoubleOrNull()?:0.0
        }
        soma+=nota
        contador++
    }
    media = soma/6
    print("A média é: $media")
}
//3.7/////////////////////////////////////////////
fun main(){
    var contador = 0

    print("Informe o um número: ")
    var n1 = readlnOrNull()?.toDoubleOrNull()?:0.0

    while(contador <= n1){
        println(contador)
        contador++
    }
}
//3.8/////////////////////////////////////////////
fun main(){
    var contador = 101
    var quantidade = 0

    while(quantidade<10){
        println(contador)
        contador++
        quantidade++

    }
}
//3.9/////////////////////////////////////////////
fun main(){
    var contador = 0
    var dentro = 0
    var fora = 0

    while(contador < 10 ){
        print("Digite um valor: ")
        var valor = readlnOrNull()?.toIntOrNull()?:0

        if (valor>=24 && valor<=42){
            dentro++
        }
        else{
            fora++
        }
        contador++
    }
    println("Números fora: $fora")
    println("Números dentro $dentro")
}
//////////////////////////////////////////////////