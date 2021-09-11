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
import br.edu.ifpb.girls.getshirt.api.model.Empresa;
import br.edu.ifpb.girls.getshirt.api.service.EmpresaService;

/**
 * @author andreia
 *
 */
@RestController
@RequestMapping("/")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/empresas")
	public List<Empresa> getEmpresas() {
		return this.empresaService.getEmpresas();
	}

	@GetMapping("/empresas/{id}")
	public Empresa getEmpresaPorId(@PathVariable("id") Long idEmpresa) {
		return this.empresaService.getEmpresaPorId(idEmpresa);
	}

	@GetMapping("/empresas/{email}/{senha}")
	public Empresa login(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		return this.empresaService.login(email, senha);
	}

	@PostMapping("/empresas")
	public Empresa inserirEmpresa(@RequestBody Empresa empresa) {
		return this.empresaService.inserirEmpresa(empresa);
	}

	@PutMapping("/empresas/{id}")
	public Empresa atualizarEmpresa(@RequestBody Empresa empresa) {
		return this.empresaService.atualizarEmpresa(empresa);
	}

	@DeleteMapping("/empresas/{id}")
	public void apagarEmpresa(@PathVariable("id") Long id) {
		this.empresaService.apagarEmpresa(id);
	}
}
