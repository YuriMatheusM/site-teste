package com.example.petshop_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name= "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nome;
    @NotBlank
    private String tipo_animal;
    @NotBlank
    private String raca;
    @NotBlank
    private String tipo_sanguineo;
    @NotBlank
    private String nome_dono;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome_dono() {
        return nome_dono;
    }
    public void setNome_dono(String nome_dono) {
        this.nome_dono = nome_dono;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo_animal() {
        return tipo_animal;
    }
    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }
    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }
    public Cliente getNome_dono(Cliente nome_Cliente) {
        return nome_Cliente;
    }
    public void setNome_dono(Cliente nome_Cliente) {
    }


}
