
const formulario = document.querySelector("#form1");
const botao = document.querySelector("button");
const inome = document.querySelector(".pergunta1");
const icpf = document.querySelector(".pergunta9")
const iendereco = document.querySelector(".pergunta2");
const inum_casa = document.querySelector(".pergunta3");
const itele = document.querySelector(".pergunta4");
const inome_pet = document.querySelector(".pergunta5");
const idata_pet = document.querySelector(".pergunta6");
const iemail = document.querySelector(".pergunta7");
const isenha = document.querySelector(".pergunta8");

function cadastrar(){

    fetch("http://localhost:3000/petshop/cadastro",
        {
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: inome.value,
                cpf: icpf.value,
                endereco: iendereco.value,
                num_casa: inum_casa.value,
                telefone: itele.value,
                nome_pet: inome_pet.value,
                data_pet: idata_pet.value,
                email : iemail.value,
                senha: isenha.value
            })
        })
        .then(function (res) { console.log(res)})
        .catch(function (res) { console.log(res) })

};
function limpar(){
    inome.value= "";
    icpf.value="";
    iendereco.value="";
    inum_casa.value="";
    itele.value="";
    inome_pet.value="";
    idata_pet.value="";
    iemail.value="";
    isenha.value="";
};
formulario.addEventListener('submit', function (event) {

    event.preventDefault();
    cadastrar();
    limpar();

});