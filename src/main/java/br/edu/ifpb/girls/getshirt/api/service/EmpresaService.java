package br.edu.ifpb.girls.getshirt.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.girls.getshirt.api.exception.ResourceNotFoundException;
import br.edu.ifpb.girls.getshirt.api.model.Cliente;
import br.edu.ifpb.girls.getshirt.api.model.Empresa;
import br.edu.ifpb.girls.getshirt.api.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> getEmpresas() {
		return this.empresaRepository.findAll();
	}

	public Empresa getEmpresaPorId(Long idEmpresa) {
		return this.empresaRepository.findById(idEmpresa).orElse(null);
	}

	public Empresa inserirEmpresa(Empresa empresa) {
		Empresa empresaInserido = this.empresaRepository.save(empresa);
		return empresaInserido;
	}
	
	public Empresa atualizarEmpresa(Empresa empresa) {
		Optional<Empresa> empresaDb = this.empresaRepository.findById(empresa.getIdEmpresa());
		if(empresaDb.isPresent()) {
			return empresaRepository.save(empresa);
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + empresa.getIdEmpresa());
		}
	}


	public void apagarEmpresa(Long id) {
		this.empresaRepository.deleteById(id);
	}
	
	public Empresa login(String email, String senha) {
		return (this.empresaRepository.findByEmailAndSenha(email, senha));
	}
}
