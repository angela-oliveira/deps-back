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

import br.edu.ifpb.girls.getshirt.api.model.Pedido;
import br.edu.ifpb.girls.getshirt.api.service.PedidoService;

/**
 * @author andreia
 *
 */
@RestController
@RequestMapping("/")
public class PedidoController {

	@Autowired
	private PedidoService PedidoService;

	@GetMapping("/pedidos")
	public List<Pedido> getPedidos() {
		return this.PedidoService.getPedidos();
	}

	@GetMapping("/pedidos/{id}")
	public Pedido getPedidoPorId(@PathVariable("id") Long idPedido) {
		return this.PedidoService.getPedidoPorId(idPedido);
	}

	@PostMapping("/pedidos")
	public Pedido inserirPedido(@RequestBody Pedido pedido) {
		return this.PedidoService.inserirPedido(pedido);
	}

	@PutMapping("/pedidos/{id}")
	public Pedido atualizarPedido(@RequestBody Pedido pedido) {
		return this.PedidoService.atualizarPedido(pedido);
	}

	@DeleteMapping("/pedidos/{id}")
	public void apagarPedido(@PathVariable("id") Long id) {
		this.PedidoService.apagarPedido(id);
	}
}
