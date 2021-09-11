package br.edu.ifpb.girls.getshirt.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.girls.getshirt.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

//    public List<Cliente> findByIdadeAndCpf(Integer idade, String cpf);
//
////    @Query("SELECT u FROM Usuario u where u.idade>=60")
//    public List<Cliente> getUsuariosIdosos();
}
