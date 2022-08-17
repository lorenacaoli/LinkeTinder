int escolha

println("-----Linketinder-----\n\n")

def listaEmpresas =[]

def competencias = ["Groovy", "Java"]
listaEmpresas.add(Empresa.novo("Sorveteria Mágica", "sorveteriamagica@gmail.com","0001456", "Brasil", "Goiás", "74680700", "Sorveteria Italiana", competencias))

competencias = ["Groovy", "Java"]
listaEmpresas.add(Empresa.novo("Supermercado Loquito", "loquito@gmail.com","00011698", "Brasil", "São Paulo", "72620070", "Supermercado de chocolate", competencias))

competencias = ["React", "Javascript", "C#"]
listaEmpresas.add(Empresa.novo("Pastelaria do Dudu", "dudupastel@gmail.com","0001456", "Brasil", "Goiás", "74680700", "Melhor pastel da região", competencias))

competencias = ["Angular", "node"]
listaEmpresas.add(Empresa.novo("Sanduicheria com q","comq@gmail.com", "0001456", "Brasil", "Goiás", "74680700", "Variedade de pães e recheios", competencias))

competencias = ["Ruby"]
listaEmpresas.add(Empresa.novo("Papelaria Papelão", "papelao@gmail.com", "0001456", "Brasil", "Goiás", "74680700", "Variedade em papéis", competencias))

def listaCandidato = []

competencias = ["Groovy", "Java"]
listaCandidato.add(Candidato.novo("Joana Darc", "04498096277", 22, "joaninhadarc@gmail.com","Goiás", "74682070", "Procurando primeiro emprego", competencias))

competencias = ["Javascript", "Java"]
listaCandidato.add(Candidato.novo("Nattan Silva", "04497096277", 25, "nattans@gmail.com","Goiás", "74682270", "Em busca de novas oportunidades", competencias))

competencias = ["Python"]
listaCandidato.add(Candidato.novo("Michele Obama", "04491096277", 18, "obamam@gmail.com","São Paulo", "72682270", "Em busca do primeiro estagio", competencias))

competencias = ["Java"]
listaCandidato.add(Candidato.novo("Wilisneyton Ludovico", "04497095277", 45, "wwludovico@gmail.com","Goiás", "74682271", "Para transição de carreira", competencias))

competencias = ["Groovy", "Java"]
listaCandidato.add(Candidato.novo("Lucas Batista", "04497076277", 26, "lucasls@gmail.com","Goiás", "74674223052", "Buscando novos horizontes", competencias))

do{
    println("-----Escolha-----\n")
    println("1. Cadastrar Empresa\n")
    println("2. Cadastrar Candidato\n")
    println("3. Listar Empresas\n")
    println("4. Listar Candidatos\n")
    println("5. Curtir\n")
    println("6. Encerrar\n")

    escolha = System.in.newReader().readLine().toInteger()

    switch(escolha){
        case 1:
            listaEmpresas.add(Empresa.cadastrar())
            break
        case 2:
            listaCandidato.add(Candidato.cadastrar())
            break
        case 3:
            Empresa.listar(listaEmpresas)
            break
        case 4:
            Candidato.listar(listaCandidato)
            break
        case 5:
            println("1-Empresa  2-Candidato ")
            def usuario = System.in.newReader().readLine().toInteger()

            if(usuario == 1){
                println("Digite o nome da Empresa ")
                def nomeEmpresa = System.in.newReader().readLine()

                def empresaAtual = listaEmpresas.find {element -> element.nome == nomeEmpresa}

                if(empresaAtual)
                    empresaAtual.curtir(listaCandidato)
                else
                    println "Empresa não cadastrada"
            }
            if(usuario == 2){
                println("Digite o nome do Candidato ")
                def nomeCandidato = System.in.newReader().readLine()

                def empresaCandidato = listaCandidato.find {element -> element.nome == nomeCandidato}

                if(empresaCandidato)
                    empresaCandidato.curtir(listaEmpresas)
                else
                    println "Candidato não cadastrado"
            }
    }

}while(escolha != 6)
