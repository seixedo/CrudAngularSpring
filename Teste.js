var pessoa1 = {
    nome:'Abraao',
    idade:25

}

var pessoa2 = {
    nome:'Joao',
    idade:35

}

var comunidade = []
comunidade.push(pessoa1,pessoa2)

comunidade.forEach((pessoa)=>{
    console.log('Nome:'+pessoa.nome+' idade:'+pessoa.idade)
}
)

