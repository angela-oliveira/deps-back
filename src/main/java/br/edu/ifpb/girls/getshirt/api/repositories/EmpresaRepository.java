package br.edu.ifpb.girls.getshirt.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpb.girls.getshirt.api.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	public Empresa findByEmailAndSenha(String email, String senha);
}
