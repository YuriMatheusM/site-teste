package com.example.petshop_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.petshop_api.model.Cliente;
import com.example.petshop_api.model.Mensagem;
import com.example.petshop_api.model.Pet;
import com.example.petshop_api.repository.RepositorioCliente;
import com.example.petshop_api.repository.RepositorioPet;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioCliente acao;
    @Autowired
    private RepositorioPet acaopet;

    
    //MENSAGEM DE CADASTRO DO CLIENTE
    public ResponseEntity<?> cadastroCliente(Cliente obj){
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O campo nome deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getCpf().equals("")){
            mensagem.setMensagem("O campo cpf deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getEndereco().equals("")){
            mensagem.setMensagem("O campo endereço deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getNum_casa().equals("")){
            mensagem.setMensagem("O campo numero de endereço deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getTelefone().equals("")){
            mensagem.setMensagem("Ocampo telefone deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getNome_pet().equals("")){
            mensagem.setMensagem("O campo nome do pet deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getEmail().equals("")){
            mensagem.setMensagem("O campo Email deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getSenha().equals("")){
            mensagem.setMensagem("O campo senha deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }


    }

    //LOGIN
    public ResponseEntity<?> entrar(Cliente obj){
        if(acao.findByEmail(obj.getEmail()).equals(obj.getEmail())){
            mensagem.setMensagem("Email incorreto!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(acao.findBySenha(obj.getSenha()) .equals(obj.getSenha())){
            mensagem.setMensagem("Senha incorreta!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            mensagem.setMensagem("seja bem vindo!!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

    //SELECIONAR COM ID
    public ResponseEntity<?> selecionarPorId(int id){
        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Cliente nao existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
        }
    }

    //EDITAR CLIENTE
    public ResponseEntity<?> editar(Cliente obj){
        if(acao.countByid(obj.getId())== 0){
            mensagem.setMensagem("Não foi encontrado nemhum cliente com este id.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(obj.getNome().equals("")){
            mensagem.setMensagem("Informe um nome se usuario.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getCpf().equals(obj.getCpf() != obj.getCpf())){
           mensagem.setMensagem("O campo cpf deve ser preenchido.");
           return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getEndereco().equals("")){
            mensagem.setMensagem("O campo endereço deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getNum_casa().equals("")){
            mensagem.setMensagem("O campo numero de endereço deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getTelefone().equals("")){
            mensagem.setMensagem("Ocampo telefone deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getNome_pet().equals("")){
            mensagem.setMensagem("O campo nome do pet deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getEmail().equals("")){
            mensagem.setMensagem("O campo Email deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getSenha().equals("")){
            mensagem.setMensagem("O campo senha deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    //VIZUALIZAR CLIENTES
    public ResponseEntity<?> printClientes(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }
    
    //DELETAR CLIENTE
    public ResponseEntity<?> deletar(int id){
        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Usuario não encontrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else{
            Cliente obj = acao.findById(id);
            acao.delete(obj);
            mensagem.setMensagem("Usuario excluido com sucesso.");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //MENSAGEM DO CADASTRO DO ANIMAL
    public ResponseEntity<?> cadastroPet(Pet objP){
        if(objP.getNome().equals("")){
            mensagem.setMensagem("O campo nome deve ter preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getTipo_animal().equals("")){
            mensagem.setMensagem("O campo tipo de animal deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getNome_dono().equals("")){
            mensagem.setMensagem("O campo nome do dono deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getRaca().equals("")){
            mensagem.setMensagem("O campo raça do animal deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getTipo_sanguineo().equals("")){
            mensagem.setMensagem("O campo tipo sanguineo deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acaopet.save(objP), HttpStatus.CREATED);
        }

    }
    //DELETAR ANIMAL
    public ResponseEntity<?> deletarPet(int id){
        if(acaopet.countByid(id) == 0){
            mensagem.setMensagem("Informe um id de animal valido.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else{
            Pet objp = acaopet.findByid(id);
            acaopet.delete(objp);
            mensagem.setMensagem("Animal excluido com sucesso.");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    //EDITAR ANIMAL
    public ResponseEntity<?> editar(Pet objP){
        if(acaopet.countByid(objP.getId()) == 0){
            mensagem.setMensagem("Informe um id valido.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(objP.getNome().equals("")){
            mensagem.setMensagem("O campo nome deve ter preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getTipo_animal().equals("")){
            mensagem.setMensagem("O campo tipo de animal deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getNome_dono().equals("")){
            mensagem.setMensagem("O campo nome do dono deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getRaca().equals("")){
            mensagem.setMensagem("O campo raça do animal deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(objP.getTipo_sanguineo().equals("")){
            mensagem.setMensagem("O campo tipo sanguineo deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acaopet.save(objP), HttpStatus.OK);
        }
    }
    //BUSCAR POR ID
    public ResponseEntity<?> buscarPetPorId(int id){
        if(acaopet.countByid(id) == 0){
            mensagem.setMensagem("Informe um id valido.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(acaopet.findById(id), HttpStatus.OK );
        }
    }
}

