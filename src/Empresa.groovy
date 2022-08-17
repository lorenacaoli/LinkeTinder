class Empresa {

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String estado
    String cep
    String descricao
    List<String> competencias
    List<String> curtidas

    static listar(listaEmpresas) {
        println("-----Lista de Empresas-----\n")

        for(Empresa empresa : listaEmpresas)
            println(empresa.nome + "\n")
    }

    static Empresa novo(nome, emailCorporativo, cnpj, pais, estado, cep, descricao, competencias ){
        Empresa empresa = new Empresa()
        empresa.setNome(nome)
        empresa.setEmailCorporativo(emailCorporativo)
        empresa.setCnpj(cnpj)
        empresa.setPais(pais)
        empresa.setEstado(estado)
        empresa.setCep(cep)
        empresa.setDescricao(descricao)
        empresa.setCompetencias(competencias)

        return empresa
    }

    static Empresa cadastrar() {
        Empresa empresa = new Empresa()
        List<String> competencia = new ArrayList<String>()
        int escolha = 0

        println("-----Cadastro de Empresa-----\n")

        println "Digite o nome da empresa"
        empresa.setNome(System.in.newReader().readLine())
        println "Digite o e-mail corporativo da empresa"
        empresa.setEmailCorporativo(System.in.newReader().readLine())
        println "Digite o CNPJ da empresa"
        empresa.setCnpj(System.in.newReader().readLine())
        println "Digite o país da empresa"
        empresa.setPais(System.in.newReader().readLine())
        println "Digite o estado da empresa"
        empresa.setEstado(System.in.newReader().readLine())
        println "Digite o CEP da empresa"
        empresa.setCep(System.in.newReader().readLine())
        println "Digite a descrição da empresa"
        empresa.setDescricao(System.in.newReader().readLine())

        do{
            println "Digite a competência da empresa"
            competencia.add(System.in.newReader().readLine())
            println "Deseja cadastrar outra competência?\n"
            println "1. Sim \n"
            println "2. Não \n"
            escolha = System.in.newReader().readLine().toInteger()
            println escolha
        }while(escolha == 1)

        empresa.setCompetencias(competencia)

        return empresa
    }

    void curtir(listaCandidato){

        for(candidato in listaCandidato){
            if(curtidas.contains(candidato.nome))
                continue

            println "-----Candidato: "  + candidato.nome + "-----\n"
            println "Email: "  + candidato.email + "\n"
            println "CPF: "  + candidato.cpf + "\n"
            println "Idade: "  + candidato.idade + "\n"
            println "Estado: "  + candidato.estado + "\n"
            println "CEP: "  + candidato.cep + "\n"
            println "Descrição Pessoal: "  + candidato.descricaoPessoal + "\n"
            println "Competências: "  + candidato.competencias.join(", ") + "\n"
            println "1 - Curtir   2 - Próximo \n"

            if(System.in.newReader().readLine().toInteger() == 1){
                curtidas.add(candidato.nome)

                if(candidato.curtidas.contains(nome))
                    println "Você deu Match com esse candidato! \n"
            }
        }
    }
}

