package com.example.petshop_api.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    private String num_casa;

    @NotBlank
    private String telefone;

    @NotBlank
    private String nome_pet;
    
    @NotBlank
    private String data_pet;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome_pet() {
        return nome_pet;
    }
    public void setNome_pet(String nome_pet) {
            this.nome_pet = nome_pet;
    }
    public String getNome() {
            return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getNum_casa() {
        return num_casa;
    } 
    public void setNome(String nome_cliente) {
        this.nome = nome_cliente;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }
    public String getData_pet() {
        return data_pet;
    }
    public void setData_pet(String data_pet) {
        this.data_pet = data_pet;
    }
 }

