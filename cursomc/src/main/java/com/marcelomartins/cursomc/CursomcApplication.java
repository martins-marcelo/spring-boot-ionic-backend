package com.marcelomartins.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelomartins.cursomc.domain.Categoria;
import com.marcelomartins.cursomc.domain.Produto;
import com.marcelomartins.cursomc.repositories.CategoriaRepository;
import com.marcelomartins.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categRepo;
	@Autowired
	ProdutoRepository prodRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1, cat2;
		cat1 = new Categoria(null, "Informática");
		cat2 = new Categoria(null, "Escritório");
		
		Produto p1, p2, p3;
		p1 = new Produto(null, "Computador", 2000);
		p2 = new Produto(null, "Impressora", 800);
		p3 = new Produto(null, "Mouse", 80);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
