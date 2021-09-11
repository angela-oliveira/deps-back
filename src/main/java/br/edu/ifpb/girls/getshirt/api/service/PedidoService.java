package br.edu.ifpb.girls.getshirt.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.girls.getshirt.api.exception.ResourceNotFoundException;
import br.edu.ifpb.girls.getshirt.api.model.Pedido;
import br.edu.ifpb.girls.getshirt.api.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository PedidoRepository;

	public List<Pedido> getPedidos() {
		return this.PedidoRepository.findAll();
	}

	public Pedido getPedidoPorId(Long idPedido) {
		return this.PedidoRepository.findById(idPedido).orElse(null);
	}

	public Pedido inserirPedido(Pedido Pedido) {
		Pedido PedidoInserido = this.PedidoRepository.save(Pedido);
		return PedidoInserido;
	}

	public Pedido atualizarPedido(Pedido Pedido) {
		Optional<Pedido> PedidoDb = this.PedidoRepository.findById(Pedido.getIdPedido());
		if (PedidoDb.isPresent()) {
			return PedidoRepository.save(Pedido);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Pedido.getIdPedido());
		}
	}

	public void apagarPedido(Long id) {
		this.PedidoRepository.deleteById(id);
	}
}
