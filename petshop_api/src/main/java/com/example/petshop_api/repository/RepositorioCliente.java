package com.example.petshop_api.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.petshop_api.model.Cliente;

@Repository
public interface RepositorioCliente extends CrudRepository<Cliente, Integer> {

    
    @SuppressWarnings("null")
    List<Cliente> findAll();
    Cliente findById(int id);
    List<Cliente> findByEmail(String email);
    List<Cliente> findBySenha(String senha);
    List<Cliente> findByOrderByNome();
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeStartingWith(String nome);
    int countByid (int id);
    
    
}
