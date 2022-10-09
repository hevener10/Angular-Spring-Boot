package io.github.hevener10.clientes.model.repository;

import io.github.hevener10.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//Primeiro parametro <Entidade da interface,
// Segundo parametro <,Tipo de dado da chave primaria>
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
