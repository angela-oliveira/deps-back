package br.edu.ifpb.girls.getshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.girls.getshirt.api.model.Cliente;
import br.edu.ifpb.girls.getshirt.api.service.ClienteService;

/**
 * @author andreia
 *
 */
@RestController
@RequestMapping("/")
public class ClienteController {

	@Autowired
	private ClienteService ClienteService;

	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return this.ClienteService.getClientes();
	}

	@GetMapping("/clientes/{id}")
	public Cliente getClientePorId(@PathVariable("id") Long idCliente) {
		return this.ClienteService.getClientePorId(idCliente);
	}

	@GetMapping("/clientes/{email}/{senha}")
	public Cliente login(@PathVariable("email") String email,@PathVariable("senha") String senha ){
		return this.ClienteService.login(email, senha);
	}

	@PostMapping("/clientes")
	public Cliente inserirCliente(@RequestBody Cliente cliente) {
		return this.ClienteService.inserirCliente(cliente);
	}

	@PutMapping("/clientes/{id}")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return this.ClienteService.atualizarCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
	public void apagarCliente(@PathVariable("id") Long id) {
		this.ClienteService.apagarCliente(id);
	}
}
