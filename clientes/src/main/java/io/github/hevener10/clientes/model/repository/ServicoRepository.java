package io.github.hevener10.clientes.model.repository;

import io.github.hevener10.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
