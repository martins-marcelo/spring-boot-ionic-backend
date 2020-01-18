package com.marcelomartins.cursomc.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelomartins.cursomc.domain.Categoria;
import com.marcelomartins.cursomc.repositories.CategoriaRepository;
import com.marcelomartins.cursomc.services.CategoriaService;

@RestController //Definindo que este é um controlador rest
@RequestMapping(value="/categorias") //Adicionando endpoint ao controlador
public class CategoriaResource implements CommandLineRunner{
	
	@Autowired
	private CategoriaService service;
	@Autowired
	CategoriaRepository categRepo;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Adicionando verbo http para dizer que este é um metodo rest
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1, cat2;
		cat1 = new Categoria(null, "Informática");
		cat2 = new Categoria(null, "Escritório");
		categRepo.saveAll(Arrays.asList(cat1, cat2));
	}
}
