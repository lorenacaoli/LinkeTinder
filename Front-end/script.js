var candidato = /** @class */ (function () {
    function candidato() {
    }
    return candidato;
}());
var empresa = /** @class */ (function () {
    function empresa() {
    }
    return empresa;
}());
var candidatos = [];
var empresas = [];
function cadastrar(tela) {
    mudarBotoes(false);
    limpar();
    var div = document.getElementById(tela);
    var tabela = document.getElementById('visualizar');
    div.classList.remove('hidde');
    tabela.classList.add('hidde');
}
function mudarBotoes(mostrar) {
    var botao = document.getElementById('botoes');
    if (mostrar)
        botao.classList.remove('hidde');
    else
        botao.classList.add('hidde');
}
function preencherLista(evt, elemento) {
    if (evt.key === 'Enter') {
        var lista = document.getElementsByClassName('lista');
        for (var index = 0; index < lista.length; index++) {
            var li = document.createElement('li');
            li.appendChild(document.createTextNode(elemento.value));
            lista[index].append(li);
        }
        elemento.value = '';
    }
}
function limpar() {
    var elementos = document.getElementsByClassName('input');
    var elementos2 = document.getElementsByTagName('ul');
    var tabela = document.getElementsByTagName('tbody');
    for (var index = 0; index < elementos.length; index++) {
        elementos[index].value = '';
    }
    for (var index = 0; index < elementos2.length; index++)
        elementos2[index].innerHTML = '';
    for (var index = 0; index < tabela.length; index++)
        tabela[index].innerHTML = '';
}
function salvar(tipo) {
    if (tipo == 'cadastro-candidato') {
        var ul = document.getElementsByName('competencias-candidato')[0].getElementsByTagName('li');
        var competencias = [];
        for (var index = 0; index < ul.length; index++) {
            var element = ul[index].innerText;
            competencias.push(element);
        }
        var candidato_1 = {
            nome: document.getElementById('nome-candidato').value,
            email: document.getElementById('email-candidato').value,
            cpf: document.getElementById('cpf-candidato').value,
            idade: document.getElementById('idade-candidato').value,
            estado: document.getElementById('estado-candidato').value,
            cep: document.getElementById('cep-candidato').value,
            descricao: document.getElementById('descricao-candidato').value,
            compentencias: competencias
        };
        candidatos.push(candidato_1);
    }
    else {
        var ul = document.getElementsByName('competencias-empresa')[0].getElementsByTagName('li');
        var competencias = [];
        for (var index = 0; index < ul.length; index++) {
            var element = ul[index].innerText;
            competencias.push(element);
        }
        var empresa_1 = {
            nome: document.getElementById('nome-empresa').value,
            email: document.getElementById('email-empresa').value,
            cnpj: document.getElementById('cnpj-empresa').value,
            pais: document.getElementById('pais-empresa').value,
            estado: document.getElementById('estado-empresa').value,
            cep: document.getElementById('cep-empresa').value,
            descricao: document.getElementById('descricao-empresa').value,
            compentencias: competencias
        };
        empresas.push(empresa_1);
    }
    mudarBotoes(true);
    limpar();
    var div = document.getElementById(tipo);
    div.classList.add('hidde');
}
function listar(tipo) {
    limpar();
    var div = document.getElementById('visualizar');
    div.classList.remove('hidde');
    var tabela = document.getElementById('tbody');
    if (tipo == 'candidato') {
        for (var index = 0; index < candidatos.length; index++) {
            var tr = document.createElement('tr');
            var td = document.createElement('td');
            var td2 = document.createElement('td');
            td.appendChild(document.createTextNode(candidatos[index].nome));
            td2.appendChild(document.createTextNode(candidatos[index].compentencias.join(', ')));
            tr.appendChild(td);
            tr.appendChild(td2);
            tabela.appendChild(tr);
        }
    }
    else {
        for (var index = 0; index < empresas.length; index++) {
            var tr = document.createElement('tr');
            var td = document.createElement('td');
            var td2 = document.createElement('td');
            td.appendChild(document.createTextNode(empresas[index].nome));
            td2.appendChild(document.createTextNode(empresas[index].compentencias.join(', ')));
            tr.appendChild(td);
            tr.appendChild(td2);
            tabela.appendChild(tr);
        }
    }
}
