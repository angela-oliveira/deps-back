package br.edu.ifpb.girls.getshirt.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.girls.getshirt.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByEmailAndSenha(String email, String senha);
}
