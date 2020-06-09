package com.marcelomartins.cursomc.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelomartins.cursomc.domain.Cliente;
import com.marcelomartins.cursomc.services.ClienteService;

@RestController //Definindo que este é um controlador rest
@RequestMapping(value="/clientes") //Adicionando endpoint ao controlador
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Adicionando verbo http para dizer que este é um metodo rest
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
