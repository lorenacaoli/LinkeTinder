
class Candidato {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricaoPessoal
    List<String> competencias
    List<String> curtidas

    static listar(listaCandidatos) {
        println("-----Lista de Candidatos-----\n")

        for(Candidato candidato : listaCandidatos)
            println(candidato.nome + "\n")
    }

    static Candidato novo(nome, cpf, idade, email, estado, cep, descricaoPessoal, competencias ) {
        Candidato candidato = new Candidato()
        candidato.setNome(nome)
        candidato.setCpf(cpf)
        candidato.setIdade(idade)
        candidato.setEmail(email)
        candidato.setEstado(estado)
        candidato.setCep(cep)
        candidato.setDescricaoPessoal(descricaoPessoal)
        candidato.setCompetencias(competencias)

        return candidato
    }

    static Candidato cadastrar() {
        Candidato candidato = new Candidato()
        List<String> competencia = new ArrayList<String>()
        int escolha = 0

        println("-----Cadastro de Candidatos-----\n")

        println "Digite o nome do candidato"
        candidato.setNome(System.in.newReader().readLine())
        println "Digite o e-mail"
        candidato.setEmail(System.in.newReader().readLine())
        println "Digite o CPF"
        candidato.setCpf(System.in.newReader().readLine())
        println "Digite a idade"
        candidato.setIdade(System.in.newReader().readLine().toInteger())
        println "Digite o estado"
        candidato.setEstado(System.in.newReader().readLine())
        println "Digite o CEP"
        candidato.setCep(System.in.newReader().readLine())
        println "Digite a descrição"
        candidato.setDescricaoPessoal(System.in.newReader().readLine())


        do{
            println "Digite a competência do candidato"
            competencia.add(System.in.newReader().readLine())
            println "Deseja cadastrar outra competência?\n"
            println "1. Sim \n"
            println "2. Não \n"
            escolha = System.in.newReader().readLine().toInteger()
        }while(escolha == 1)

        candidato.setCompetencias(competencia)

        return candidato
    }

    void curtir(listaEmpresa){

        for(empresa in listaEmpresa){
            if(curtidas.contains(empresa.nome))
                continue

            println "-----Empresa: "  + empresa.nome + "-----\n"
            println "Email Corporativo: "  + empresa.emailCorporativo + "\n"
            println "CNPJ: "  + empresa.cnpj + "\n"
            println "País: "  + empresa.pais + "\n"
            println "Estado: "  + empresa.estado + "\n"
            println "CEP: "  + empresa.cep + "\n"
            println "Descrição: "  + empresa.descricao + "\n"
            println "Competências: "  + empresa.competencias.join(", ") + "\n"
            println "1- Curtir   2- Próximo \n"

            if(System.in.newReader().readLine().toInteger() == 1){
                curtidas.add(empresa.nome)

                if(emmpresa.curtidas.contains(nome))
                    println "Você deu Match com essa empresa! \n"
            }
        }
    }
}