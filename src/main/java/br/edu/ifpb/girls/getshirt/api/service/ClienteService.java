package br.edu.ifpb.girls.getshirt.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.girls.getshirt.api.exception.ResourceNotFoundException;
import br.edu.ifpb.girls.getshirt.api.model.Cliente;
import br.edu.ifpb.girls.getshirt.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;

	public List<Cliente> getClientes() {
		return this.ClienteRepository.findAll();
	}

	public Cliente getClientePorId(Long idCliente) {
		return this.ClienteRepository.findById(idCliente).orElse(null);
	}

	public Cliente inserirCliente(Cliente cliente) {
		Cliente ClienteInserido = this.ClienteRepository.save(cliente);
		return ClienteInserido;
	}

	public Cliente atualizarCliente(Cliente cliente) {
		Optional<Cliente> ClienteDb = this.ClienteRepository.findById(cliente.getIdCliente());
		if (ClienteDb.isPresent()) {
			return ClienteRepository.save(cliente);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + cliente.getIdCliente());
		}
	}

	public void apagarCliente(Long id) {
		this.ClienteRepository.deleteById(id);
	}

	public Cliente login(String email, String senha) {
		return (this.ClienteRepository.findByEmailAndSenha(email, senha));
	}
}
