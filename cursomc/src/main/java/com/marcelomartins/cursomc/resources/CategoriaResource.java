package com.marcelomartins.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Definindo que este é um controlador rest
@RequestMapping(value="/categorias") //Adicionando endpoint ao controlador
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET) //Adicionando verbo http para dizer que este é um metodo rest
	public String listar() {
		return "Rest esta funcionando";
	}
}
