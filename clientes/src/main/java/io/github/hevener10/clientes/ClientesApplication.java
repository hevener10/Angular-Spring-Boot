package io.github.hevener10.clientes;

import io.github.hevener10.clientes.model.entity.Cliente;
import io.github.hevener10.clientes.model.repository.ClienteRepository;
import io.github.hevener10.clientes.utilitarios.geradorDeCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ClientesApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            Cliente cliente = Cliente
                    .builder()
                    .cpf(new geradorDeCpf().fakeCPFSemFormatacao())
                    .nome("Fulano da silva")
                    .build();
            repository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
        System.out.println("Iniciado Sistema!");

    }

}
