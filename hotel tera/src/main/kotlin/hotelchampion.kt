import kotlin.system.exitProcess
import kotlin.math.ceil
import kotlin.math.floor

var usuario: String? = ""

data class RelatorioDados(
    var quartosConfirmados: Int = 0,
    var hospedesCadastrados: Int = 0,
    var eventosConfirmados: Int = 0,
    var receitaQuartos: Double = 0.0,
    var receitaEventos: Double = 0.0
)

fun main() {

    val listaQuartos = MutableList(20) { false }
    val dadosRelatorio = RelatorioDados()

    println("⭐Bem-vindo(a) ao Hotel Champions⭐")
    println()

    print("Digite seu usuario: ")
    usuario = readlnOrNull()
    println()

    senha(listaQuartos, dadosRelatorio)
}

fun senha(listaQuartos: MutableList<Boolean>, dadosRelatorio : RelatorioDados) {
    var tentativas = 3
    var senha: String? = "2678"
    while (tentativas > 0) {
        println("Informe sua senha: ")
        senha = readlnOrNull()

        if (senha == "2678") {
            println("Acesso liberado com sucesso!")
            println()
            painelHospedes(listaQuartos, dadosRelatorio)
            break
        }
        tentativas--

        if (tentativas > 0) {
            println("Senha incorreta!")
            println("Tentativas restantes: $tentativas")
        }
    }
    if (tentativas == 0) {
        println("Programa finalizado! Tentativas excedidas!")
        exitProcess(0)
    }
}

fun painelHospedes(listaQuartos: MutableList<Boolean>, dadosRelatorio : RelatorioDados) {

    val listaHospedes = mutableListOf<String>()

    println("Bem-vindo(a) ao Hotel Champions! $usuario é um imenso prazer ter você por aqui!")

    while (true) {
        println("""
    Painel do Hotel Champions!
    Selecione uma opção:
    1. Reserva de Quartos
    2. Cadastro de Hóspedes
    3. Eventos
    4. Ar-Condicionado
    5. Abastecimento
    6. Relatórios Operacionais
    7. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> quartos(listaQuartos, dadosRelatorio)
            2 -> cadastrarHospede(listaHospedes, dadosRelatorio)
            3 -> eventos(dadosRelatorio)
            4 -> arCondicionado()
            5 -> abastecimento()
            6 -> relatoriosOperacionais(listaQuartos, dadosRelatorio)
            7 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarHospede(listaHospedes: MutableList<String>, dadosRelatorio : RelatorioDados) {

    println("Olá $usuario, bem-vindo(a) ao cadastro de hóspedes!")
    println()
    print("""
    1- Cadastro de Hóspedes
    2- Pesquisar Hóspede por nome exato
    3- Pesquisar Hóspede por prefixo
    4- Listar Hóspedes ordenadamente (A/Z)
    5- Atualizar Cadastro
    6- Remover Cadastro
    7- Voltar
    """.trimMargin())
    println()
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> {
            println("Cadastro de Hóspedes.\nPor favor, informe o nome da Hóspede:")
            val novoHospede = readln()

            val limiteDeHospedes = 15
            if (listaHospedes.size >= limiteDeHospedes) {
                println("Limite de $limiteDeHospedes hóspedes atingidos! Fale com o gerente para liberar mais hóspedes!")
                return
            }

            val nomeNovo = novoHospede.lowercase().replaceFirstChar { it.uppercase() }
            listaHospedes.add(nomeNovo)
            dadosRelatorio.hospedesCadastrados = listaHospedes.size
            println("$nomeNovo cadastrado com sucesso!")
            println("Lista de Hóspedes atuais: $listaHospedes\n")
        }
        2 -> {

            println("Digite exatamente o nome do Hóspede para buscalo: ")
            val nomeExato = readln().trim()

            val resultaDaPesquisa = listaHospedes.find { it.equals(nomeExato, true) }
            if (resultaDaPesquisa != null) {
                println("Hóspede encontrado: $resultaDaPesquisa \n")
            }else{
                println("Nenhum Hóspede cadastrado com esse nome: $nomeExato \n")
            }
        }
        3 ->{

            println("Digite somente o primeiro nome para buscar os Hóspedes: ")
            val nomePrefixo = readln().trim()

            val resultadoPrefixo = listaHospedes.filter { it.startsWith(nomePrefixo, true) }
            if (resultadoPrefixo.isNotEmpty()) {
                println("Hóspedes encontrados: \n")
                resultadoPrefixo.forEachIndexed { index, hospede ->
                    println("[${index + 1}] $hospede ")
                }
            }else{
                println("Nenhum Hóspede cadastrado com esse nome: $nomePrefixo \n")
            }
        }
        4 ->{
            println("          LISTA DE HÓPEDES EM ORDEM ALFABÉTICA          ")
            listaHospedes.sorted().forEachIndexed { index, hospede ->
                println("[${index + 1}] $hospede ")
            }
        }
        5 ->{
            if(listaHospedes.isEmpty()){
             println("Nenhum Hóspede para ter seu cadastro atualizado!")
            }else{
                println("Selecione o número do Hóspede a ser atualizado: ")
                listaHospedes.forEachIndexed { index, hospede ->
                    println("[${index + 1}] $hospede ")
                }
                println("[${listaHospedes.size + 1}] Cancelar e voltar ao painel")
                val escolha = readln().toIntOrNull()
                if (escolha == null || escolha < 1 || escolha > listaHospedes.size+1) {
                    println("Opção inválida! Operação cancelada!")
                }else if (escolha == listaHospedes.size+1){
                    println("Operação cancelada!")
                }else{
                    val numeroDoHospede = escolha - 1
                    val nomeAntigo = listaHospedes[numeroDoHospede]

                    println("Hóspede selecionado: $nomeAntigo \n")
                    println("Digite a atualização do Hóspede: ")
                    val novoNomeDoHospede = readln().trim()

                    if (novoNomeDoHospede.equals(nomeAntigo, ignoreCase = true) || novoNomeDoHospede.isEmpty()) {
                        println("O nome não pode ser vazio ou igual ao antigo!")
                    }else{
                        val nomeNovo = novoNomeDoHospede.lowercase().replaceFirstChar { it.uppercase() }

                        listaHospedes[numeroDoHospede] = nomeNovo

                        println("Cadastro atualizado com sucesso!")
                        println("De: $nomeAntigo -> Para: $nomeNovo\n")
                    }
                }
            }

        }
        6 ->{
            if(listaHospedes.isEmpty()){
                println("Nenhum Hóspede a ser removido!")
            }else{
                println("Selecione o número do Hóspede que deseja remover: ")
                listaHospedes.forEachIndexed { index, hospede ->
                    println("[${index + 1}] $hospede ")
                }
                println("[${listaHospedes.size + 1}] Cancelar e voltar ao painel!]")

                val escolha = readln().toIntOrNull()

                if (escolha == null || escolha < 1 || escolha > listaHospedes.size+1) {
                    println("Operação inválida! Operação cancelada!")
                }else if (escolha == listaHospedes.size+1) {
                    println("Operação cancelada!")
                }else{
                    val numeroDoHospede = escolha - 1
                    val nomeRemovido = listaHospedes[numeroDoHospede]

                    listaHospedes.removeAt(numeroDoHospede)
                    println("Hóspede $nomeRemovido com sucesso!\n")
                    println("Lista de Hóspedes atual \n")
                    listaHospedes.sorted().forEachIndexed { index, hospede ->
                        println("[${index + 1}] $hospede ")
                    }
                }
            }
        }
        7 ->{
            println("Você deseja voltar? S/N")
            val escolha = readln()

            when (escolha.uppercase()) {
                "S" -> {
                    println("Muito obrigado e até logo, $usuario.")
                    return
                }
                "N"->{
                    println("Ok, voltando ao cadastro.")
                    return(cadastrarHospede(listaHospedes, dadosRelatorio))
                }
                else -> {
                    println("Opção inválida! Escolha de 1 a 7.")
                }
            }
        }
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        "S" -> {
            println("Muito obrigado e até logo, $usuario.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            return
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 7.")
}

fun quartos(listaQuartos: MutableList<Boolean>, dadosRelatorio: RelatorioDados) {
    println("Olá $usuario, bem-vindo a selecão de quartos!")
    println()
    println("Informe o valor da diária: ")
    val valorDiaria = readln().toDoubleOrNull()
    println("Informe a quantidade de diárias (1-30): ")
    var diaria = readln().toIntOrNull()
    if (valorDiaria == null ||
        diaria == null ||
        valorDiaria <= 0 ||
        diaria < 1 || diaria > 30
    ) {
        println("Valor inválido, retornando ao inicio da reserva!")
        println()
        return(quartos(listaQuartos, dadosRelatorio))
    }
    println("Informe o nome do hóspede que está fazendo a reserva: ")
    val hospede = readln()
    println("Informe o tipo do quarto: ")
    println("S - Standard")
    println("E - Executivo")
    println("L - Luxo")
    val tipoDoQuarto = readln().uppercase().trim()

    val tipoQaurtoSEL = when (tipoDoQuarto) {
        "S" -> 1.00
        "E" -> 1.35
        "L" -> 1.65
        else -> {
            println("Tipo de quarto inválido, retornando ao inicio da reserva!")
            println()
            return(quartos(listaQuartos, dadosRelatorio))
        }
    }
    var numeroDoQuarto: Int? = 0
    while (true) {
        println("Informe o número do quarto! (1-20)")
        numeroDoQuarto = readln().toIntOrNull()

        if (numeroDoQuarto == null || numeroDoQuarto <= 0 || numeroDoQuarto > 20) {
            println("Numero do quarto inválido, voltando as reservas!")
            println()
            return(quartos(listaQuartos, dadosRelatorio))
        }

        if (listaQuartos[numeroDoQuarto - 1]) {
            println("Número do quarto ja ocupado!")
            println("Quartos livres: ")
            println("[L] = Livre | [O] = Ocupado\n")
            for (i in 0 until 20) {
                val numeroFormatado = String.format("%02d", i + 1)
                val statusDoQuarto = if (listaQuartos[i]) "O" else "L"
                print("$numeroFormatado:[$statusDoQuarto]  |  ")
                if ((i + 1) % 5 == 0) {
                    println()
                }
            }
            continue
        }
        break
    }
    val equacaoQuartos = valorDiaria * diaria * tipoQaurtoSEL
    val taxaDeServicoQuartos = equacaoQuartos * 0.10
    val equacaoFinalQuartos = equacaoQuartos + taxaDeServicoQuartos

    println()
    println("          Resumo Da Reserva          ")
    println("Hóspede que fez a reserva: $hospede")
    println("Quarto reservado: $numeroDoQuarto, tipo do quarto: $tipoDoQuarto")
    println("Diárias reservadas: $diaria")
    println("Subtotal: R$ %.2f".format(equacaoQuartos))
    println("Taxa de serviço (10%%): R$ %.2f".format(taxaDeServicoQuartos))
    println("Total: R$ %.2f".format(equacaoFinalQuartos))
    println()
    println("O Senhor(a) $hospede deseja confirmar a reserva? (S/N)")
    val confirmacaoDaReserva = readln().uppercase()

    if (confirmacaoDaReserva == "S") {
        listaQuartos[numeroDoQuarto - 1] = true

        dadosRelatorio.quartosConfirmados++
        dadosRelatorio.receitaQuartos += equacaoFinalQuartos

        println("Reserva confirmada com sucesso!")
    } else {
        println("Ok, voltando ao inicio!")
    }
}

fun eventos(dadosRelatorio: RelatorioDados) {
    // Parte A

    println("Olá $usuario, bem-vindo(a) a reserva de eventos!")
    println()

    var convidados = 0
    var auditorioSelecionado = ""
    var cadeirasAdicionais = 0

    while (true) {
        println("Informe a quantidade de convidados:")
        val convidados2 = readln().toIntOrNull()

        if (convidados2 == null || convidados2 <= 0 || convidados2 > 350) {
            println("Capacidade de convidados excedida")
            continue
        }
        convidados = convidados2
        if (convidados <= 220) {
            auditorioSelecionado = "Laranja"
            if (convidados > 150) {
                cadeirasAdicionais = convidados - 150
            }
        } else{
            auditorioSelecionado = "Colorado"
            cadeirasAdicionais = 0
        }
        break
    }
    if (auditorioSelecionado == "Laranja" && cadeirasAdicionais > 0) {
        println("Auditório selecionado: Laranja ($cadeirasAdicionais cadeiras adicionais)")
    }
    else{
        println("Auditório selecionado: $auditorioSelecionado")
    }
    println()

    //Parte B

    var diaSemana = ""
    var horaInicial = 0
    var duracao = 0
    var empresa = ""

    while (true) {
        print("Digite o dia da semana: ")
        diaSemana = readln().trim().lowercase()
        print("Digite a hora inicial (0-23): ")
        val horaDigitada = readln().toIntOrNull()
        if (horaDigitada == null || horaDigitada !in 0..23) {
            println("Hora inicial inválida!")
            continue
        }
        horaInicial = horaDigitada

        print("Digite a duração do evento em horas (1-12): ")
        val duracaoDigitada = readln().toIntOrNull()
        if (duracaoDigitada == null || duracaoDigitada !in 1..12) {
            println("Duração inválida! Deve ser entre 1 e 12 horas!")
            continue
        }
        duracao = duracaoDigitada

        val limiteEvento = if (diaSemana == "sábado" || diaSemana == "domingo" || diaSemana == "sábado") 15 else 23
        val horaTermino = horaInicial + duracao

        if (horaInicial < 7 || horaTermino > limiteEvento) {
            println("Auditório indisponível de acordo com as regras!")
            println("Janelas permitidas: Seg a Sex das 7h às 23h | Sáb e Dom das 7h às 15h. Tente outro horário.\n")
            continue
        }
        print("Digite o nome da empresa: ")
        empresa = readln().trim()
        print("\nStatus: Auditório reservado!\n")
        break
    }
    println()

    //Parte C

    val baseGarcons = ceil(convidados.toDouble() / 12.0).toInt()
    val reforcoGarcons = floor(duracao.toDouble() / 2.0).toInt()
    val totalGarcons = baseGarcons + reforcoGarcons
    val custoGarcons = totalGarcons * duracao * 10.50

    //Parte D

    val totalCafe = convidados * 0.2
    val totalAgua = convidados * 0.5
    val totalSalgados = convidados * 7

    val custoCafe = totalCafe * 0.80
    val custoAgua = totalAgua * 0.40
    val custoSalgados = (totalSalgados.toDouble() / 100.0) * 34.00
    val custoBuffet = custoCafe + custoAgua + custoSalgados

    val totalGeral = custoGarcons + custoBuffet

    //Parte E

    println("         RELATÓRIO DA RESERVA         \n")
    println("Auditório selecionado: $auditorioSelecionado")
    println("Empresa contratada: $empresa")
    println("Data/Hora: $diaSemana das ${horaInicial}h às ${horaInicial + duracao}h")
    println("Total de Convidados Solicitados: $convidados")
    println("Duração do Evento: ${duracao}h")
    println("Equipe de Garçons Necessários: $totalGarcons")

    println("\n         VALORES         \n")

    println("Custo com Garçons: R$ %.2f".format(custoGarcons))
    println("\nBuffet Solicitado:")
    println("Café: %.1f L (R$ %.2f)".format(totalCafe, custoCafe))
    println("Água: %.1f L (R$ %.2f)".format(totalAgua, custoAgua))
    println("Salgados: $totalSalgados un (R$ %.2f)".format(custoSalgados))
    println("Custo Total do Buffet: R$ %.2f".format(custoBuffet))

    println("\n         TOTAL         \n")

    println("Total do evento: R$ %.2f".format(totalGeral))

    print("Deseja confirmar o evento? (S/N): ")
    val confirmacao = readln().uppercase().trim()

    if (confirmacao == "S") {
        dadosRelatorio.eventosConfirmados++
        dadosRelatorio.receitaEventos += totalGeral

        println("Evento confirmado com sucesso!")
    } else {
        println("Evento não confirmado!.")
    }
}

fun arCondicionado() {
    println("Olá $usuario, seja bem-vindo(a) a manutenção do ar-condicionado!")

    var melhorEmpresa = ""
    var melhorOrcamneto = Double.MAX_VALUE

    var piorEmpresa = ""
    var piorOrcamneto = Double.MIN_VALUE

    while (true) {
        print("Digite o nome da empresa: ")
        val empresa = readln().trim()
        print("Digite o valor por aparelho: ")
        val valorPorAparelho = readln().toDoubleOrNull() ?: 0.0
        print("Digite a quantidade de aparelhos: ")
        val quantidadeDeAparelho = readln().toIntOrNull() ?: 0
        print("Desconto (%): ")
        val desconto = readln().toDoubleOrNull() ?: 0.0
        print("Mínimo para desconto: ")
        val minimoParaDesconto = readln().toIntOrNull() ?: 0
        print("Valor de deslocamneto: ")
        val deslocamento = readln().toDoubleOrNull() ?: 0.0

        val bruto = valorPorAparelho * quantidadeDeAparelho

        val valorDesconto = if (quantidadeDeAparelho >= minimoParaDesconto) {
            bruto * (desconto / 100.0)
        } else {
            0.0
        }
        val totalCalculado = bruto - valorDesconto + deslocamento

        println("O serviço da $empresa irá custar R$ %.2f".format(totalCalculado))
        println()

        if (totalCalculado < melhorOrcamneto) {
            melhorOrcamneto = totalCalculado
            melhorEmpresa = empresa
        }
        if (totalCalculado > piorOrcamneto) {
            piorOrcamneto = totalCalculado
            piorEmpresa = empresa
        }
        print("Deseja informar novos dados, $usuario? (S/N): ")
        val resposta = readln().uppercase().trim()

        if (resposta == "N") {
            break
        }
    }
        val diferencaPercentual = if (melhorOrcamneto > 0.0) {
            ((piorOrcamneto - melhorOrcamneto) / melhorOrcamneto) * 100.0
        } else {
            0.0
        }
        println("\n          Orçamentos          \n")
        println("Melhor orçamento: $melhorEmpresa — R$ %.2f".format(melhorOrcamneto))
        println("Pior orçamento: $piorEmpresa — R$ %.2f".format(piorOrcamneto))
        println("Diferença percentual entre melhor e pior: %.2f%%".format(diferencaPercentual))

    }

fun abastecimento(){
    println("Olá $usuario, seja bem-vindo(a) ao abastecimento!")

    val litrosTanque = 42

    println("\n     Posto Wayne Oil     \n")
    print("Digite o preço do álcool: ")
    val alcoolWayne = readln().toDoubleOrNull()?:0.0
    print("Digite o preço da gasolina: ")
    val gasolinaWayne = readln().toDoubleOrNull()?:0.0

    println("\n     Posto Stark Petrol     \n")
    print("Digite o preço do álcool: ")
    val alcoolStark = readln().toDoubleOrNull()?:0.0
    print("Digite o preço da gasolina: ")
    val gasolinaStark = readln().toDoubleOrNull()?:0.0

    val combustivelWayne = if (alcoolWayne <= gasolinaWayne * 0.70) "Álcool" else "Gasolina"
    val totalWayne = if(combustivelWayne == "Álcool"){
        alcoolWayne * litrosTanque
    }else{
        gasolinaWayne * litrosTanque
    }

    val combustivelStark = if (alcoolStark <= gasolinaStark * 0.70) "Álcool" else "Gasolina"
    val totalStark = if (combustivelStark == "Álcool"){
        alcoolStark * litrosTanque
    }else{
        gasolinaStark * litrosTanque
    }
    println("\nWayne Oil: melhor opção = $combustivelWayne | Total (42L) = R$ %.2f".format(totalWayne))
    println("Stark Petrol: melhor opção = $combustivelStark | Total (42L) = R$ %.2f".format(totalStark))
    println()

    if (totalWayne < totalStark) {
        val combustivelVencedor = combustivelWayne.lowercase()
        println("$usuario, é mais barato abastecer com $combustivelVencedor no posto Wayne Oil.")
    } else if (totalStark < totalWayne) {
        val combustivelVencedor = combustivelStark.lowercase()
        println("$usuario, é mais barato abastecer com $combustivelVencedor no posto Stark Petrol.")
    } else {
        val combustivelVencedor = combustivelWayne.lowercase()
        println(("$usuario, o custo é igual nos dois postos " +
                "Recomenda-se $combustivelVencedor por R$ %.2f.").format(totalWayne))
    }
}

fun relatoriosOperacionais(listaQuartos: List<Boolean>, dados: RelatorioDados) {
    val quartosOcupados = listaQuartos.count { it }
    val taxaCarregamento = (quartosOcupados.toDouble() / 20.0) * 100.0
    val receitaTotalGeral = dados.receitaQuartos + dados.receitaEventos

    println("\n    RELATÓRIO OPERACIONAL DO HOTEL CHAMPIONS     \n")
    println("Total de quartos confirmados: ${dados.quartosConfirmados}")
    println("Taxa de carregamento atual: $taxaCarregamento%")
    println("Quantidade de hóspedes cadastrados: ${dados.hospedesCadastrados}")
    println("Quantidade de eventos confirmados: ${dados.eventosConfirmados}")
    println("Receita acumulada com quartos: R$ ${dados.receitaQuartos}")
    println("Receita acumulada com eventos: R$ ${dados.receitaEventos}")
    println("Total geral arrecadado: R$ $receitaTotalGeral\n")
}
