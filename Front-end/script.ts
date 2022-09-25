class candidato {
    nome: string
    email: string
    cpf: string
    idade: string
    estado: string
    cep: string
    descricao: string
    compentencias: Array<string>
}

class empresa {
    nome: string
    email: string
    cnpj: string
    pais: string
    estado: string
    cep: string
    descricao: string
    compentencias: Array<string>
}

const candidatos: Array<candidato> = []
const empresas: Array<empresa> = []

function cadastrar(tela: string) {
    mudarBotoes(false)
    limpar()

    const div: any = document.getElementById(tela);
    const tabela: any = document.getElementById('visualizar');

    div.classList.remove('hidde')
    tabela.classList.add('hidde')
}

function mudarBotoes(mostrar: boolean) {
    const botao: any = document.getElementById('botoes');

    if (mostrar)
        botao.classList.remove('hidde')
    else
        botao.classList.add('hidde')
}

function preencherLista(evt: KeyboardEvent, elemento: any) {
    if (evt.key === 'Enter') {

        const lista = document.getElementsByClassName('lista')

        for (let index = 0; index < lista.length; index++) {
            var li = document.createElement('li');
            li.appendChild(document.createTextNode(elemento.value));
            lista[index].append(li)
        }

        elemento.value = ''
    }
}

function limpar() {
    const elementos = document.getElementsByClassName('input')
    const elementos2 = document.getElementsByTagName('ul')
    const tabela = document.getElementsByTagName('tbody')

    for (let index = 0; index < elementos.length; index++) {
        (<HTMLInputElement>elementos[index]).value = ''
    }

    for (let index = 0; index < elementos2.length; index++)
        elementos2[index].innerHTML = ''

    for (let index = 0; index < tabela.length; index++)
        tabela[index].innerHTML = ''

}

function salvar(tipo: string) {

    if (tipo == 'cadastro-candidato') {

        const ul = document.getElementsByName('competencias-candidato')[0].getElementsByTagName('li')
        const competencias: Array<string> = []

        for (let index = 0; index < ul.length; index++) {
            const element = ul[index].innerText;
            competencias.push(element)
        }

        const candidato: candidato = {
            nome: (<HTMLInputElement>document.getElementById('nome-candidato')).value,
            email: (<HTMLInputElement>document.getElementById('email-candidato')).value,
            cpf: (<HTMLInputElement>document.getElementById('cpf-candidato')).value,
            idade: (<HTMLInputElement>document.getElementById('idade-candidato')).value,
            estado: (<HTMLInputElement>document.getElementById('estado-candidato')).value,
            cep: (<HTMLInputElement>document.getElementById('cep-candidato')).value,
            descricao: (<HTMLInputElement>document.getElementById('descricao-candidato')).value,
            compentencias: competencias,
        }

        candidatos.push(candidato)
    } else {
        const ul = document.getElementsByName('competencias-empresa')[0].getElementsByTagName('li')
        const competencias: Array<string> = []

        for (let index = 0; index < ul.length; index++) {
            const element = ul[index].innerText;
            competencias.push(element)
        }

        const empresa: empresa = {
            nome: (<HTMLInputElement>document.getElementById('nome-empresa')).value,
            email: (<HTMLInputElement>document.getElementById('email-empresa')).value,
            cnpj: (<HTMLInputElement>document.getElementById('cnpj-empresa')).value,
            pais: (<HTMLInputElement>document.getElementById('pais-empresa')).value,
            estado: (<HTMLInputElement>document.getElementById('estado-empresa')).value,
            cep: (<HTMLInputElement>document.getElementById('cep-empresa')).value,
            descricao: (<HTMLInputElement>document.getElementById('descricao-empresa')).value,
            compentencias: competencias,
        }

        empresas.push(empresa)
    }

    mudarBotoes(true)
    limpar()

    const div: any = document.getElementById(tipo);
    div.classList.add('hidde')
}

function listar(tipo: string) {
    limpar()

    const div: any = document.getElementById('visualizar');

    div.classList.remove('hidde')

    const tabela = (<HTMLInputElement>document.getElementById('tbody'))
    if (tipo == 'candidato') {
        for (let index = 0; index < candidatos.length; index++) {

            var tr = document.createElement('tr');
            var td = document.createElement('td')
            var td2 = document.createElement('td')

            td.appendChild(document.createTextNode(candidatos[index].nome))
            td2.appendChild(document.createTextNode(candidatos[index].compentencias.join(', ')))

            tr.appendChild(td)
            tr.appendChild(td2)

            tabela.appendChild(tr)
        }
    }
    else {
        for (let index = 0; index < empresas.length; index++) {

            var tr = document.createElement('tr');
            var td = document.createElement('td')
            var td2 = document.createElement('td')

            td.appendChild(document.createTextNode(empresas[index].nome))
            td2.appendChild(document.createTextNode(empresas[index].compentencias.join(', ')))

            tr.appendChild(td)
            tr.appendChild(td2)

            tabela.appendChild(tr)
        }
    }
}