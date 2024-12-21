package com.example.petshop_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop_api.model.Cliente;
import com.example.petshop_api.model.Pet;
import com.example.petshop_api.service.Servico;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@CrossOrigin("*")
@Validated
@RequestMapping("/petshop")
public class Contoller{

	@Autowired
	private com.example.petshop_api.repository.RepositorioCliente acao;
	@Autowired
	private com.example.petshop_api.repository.RepositorioPet acaopet;
	@Autowired
	private Servico servico;


	//CLIENTE

	//CADASTRO DE USUARIOS
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Cliente c){
		return servico.cadastroCliente(c);
	}
	//LOGIN 
	@PutMapping("/user/login")
	public ResponseEntity<?> entrar(@Valid @RequestBody Cliente c){
		return servico.entrar(c);
	}
	
	//LISTAR USUARIOS CADASTRADOS
	@GetMapping("/users")
	public ResponseEntity<?> listarusuarios(){
		return servico.printClientes();
	}
	//LISTAR USUARIOS EM ORDEM ALFABETICA
	@GetMapping("/users/order")
	public List<Cliente> clientes(){
		return acao.findByOrderByNome();
	}
	//SELECIONAR USUARIO POR ID
	@GetMapping("/user/id/{id}")
	public ResponseEntity<?> selecionarClientePorId(@PathVariable int id){
		return servico.selecionarPorId(id);
	}
	//EDITAR INFORMAÇÕES DO USUARIO
	@PutMapping("/user/edit")
	public ResponseEntity<?> editarCliente(@Valid @RequestBody Cliente c){
		return servico.editar(c);
	}
	//DELETAR USUARIO INFORMANDO O ID
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return servico.deletar(id);
	}
	//INFORMAR A QUANTIDADE DE USUARIOS CADASTRADOS
	@GetMapping("/users/count")
	public String contador(){
		return "Temos atualmente "+ acao.count()+ " usuarios.";
	}
	//SELECIONAR USUARIOS ULTILIZANDO O NOME
	@GetMapping("/users/{nome}")
	public List<Cliente> selecionarClientes(@PathVariable String nome){
		return acao.findByNome(nome);
	}
	//LISTAR USUARIOS ULTILIZANDO A INICIAL DO NOME
	@GetMapping("/users/inicial/{inicial}")
	public List<Cliente> inicial(@PathVariable String inicial){
		return acao.findByNomeStartingWith(inicial);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//ANIMAL

	//CADASTRO DE PETS
	@PostMapping("/cadastro_pets")
	public ResponseEntity<?> cadastrar(@RequestBody Pet p){
		return servico.cadastroPet(p);
	}
	//LISTAR PETS
	@GetMapping("/pets")
	public List<Pet> pet(){
		return acaopet.findAll();
	}
	//LISTAR ANIMAIS POR TIPO DE ANIMAL
	@GetMapping("/pets/animal/{animal}")
	public List<Pet> consulta(@PathVariable String animal){
		return acaopet.animal(animal);
	}
	//EDITAR ANIMAL
	@GetMapping("/pet/edit")
	public ResponseEntity<?> editar(@Valid @RequestBody Pet p){
		return servico.editar(p);
	}
	//BUSCAR ANIMAL POR ID
	@GetMapping("/pet/id/{id}")
	public ResponseEntity<?> buscarporid(@PathVariable int id){
		return servico.buscarPetPorId(id);
	}
	//INFORMA A QUANTIDADE DE ANIMAIS CADASTRADOS
	@GetMapping("/pets/count")
	public String quantidadeDeAnimais(){
		return "Atualmente existe "+acaopet.count()+" Animais cadastrados"; 
	}	
	
}
