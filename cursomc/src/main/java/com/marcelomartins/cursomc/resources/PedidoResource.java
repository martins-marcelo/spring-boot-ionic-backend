package com.marcelomartins.cursomc.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelomartins.cursomc.domain.Pedido;
import com.marcelomartins.cursomc.services.PedidoService;

@RestController //Definindo que este é um controlador rest
@RequestMapping(value="/pedidos") //Adicionando endpoint ao controlador
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Adicionando verbo http para dizer que este é um metodo rest
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
