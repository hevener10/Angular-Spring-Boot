package io.github.hevener10.clientes.rest;

import io.github.hevener10.clientes.model.entity.Cliente;
import io.github.hevener10.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private ClienteRepository repository;

    @Autowired
    public ClientController(ClienteRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setRepository(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);

    }
}