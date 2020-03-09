package com.marcelomartins.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelomartins.cursomc.domain.Categoria;
import com.marcelomartins.cursomc.domain.Cidade;
import com.marcelomartins.cursomc.domain.Cliente;
import com.marcelomartins.cursomc.domain.Endereco;
import com.marcelomartins.cursomc.domain.Estado;
import com.marcelomartins.cursomc.domain.Produto;
import com.marcelomartins.cursomc.domain.enums.TipoCliente;
import com.marcelomartins.cursomc.repositories.CategoriaRepository;
import com.marcelomartins.cursomc.repositories.CidadeRepository;
import com.marcelomartins.cursomc.repositories.ClienteRepository;
import com.marcelomartins.cursomc.repositories.EnderecoRepository;
import com.marcelomartins.cursomc.repositories.EstadoRepository;
import com.marcelomartins.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categRepo;
	@Autowired
	ProdutoRepository prodRepo;
	@Autowired
	EstadoRepository estRepo;
	@Autowired
	CidadeRepository cidRepo;
	@Autowired
	ClienteRepository cliRepo;
	@Autowired
	EnderecoRepository endRepo;
	
	
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
		
		Estado est0, est1;
		est0 = new Estado(null, "Minas Gerais");
		est1 = new Estado(null, "Sao Paulo");
		
		Cidade c0, c1, c2;
		c0 = new Cidade(null, "Uberlandia", est0);
		c1 = new Cidade(null, "Sao Paulo", est1);
		c2 = new Cidade(null, "Campinas", est1);
		
		est0.getCidades().addAll(Arrays.asList(c0));
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		
		Cliente cli0;
		cli0 = new Cliente(null, "Maria Silva", "maria@gmail.com", "03634660295", TipoCliente.PESSOAFISICA);
		cli0.getTelefones().addAll(Arrays.asList("2345678", "1345688"));
		
		Endereco e0, e1;
		e0 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli0, c0);
		e1 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli0, c1);
		
		cli0.getEnderecos().addAll(Arrays.asList(e0, e1));
		
		
		estRepo.saveAll(Arrays.asList(est0, est1));
		cidRepo.saveAll(Arrays.asList(c0, c1, c2));
		cliRepo.saveAll(Arrays.asList(cli0));
		endRepo.saveAll(Arrays.asList(e0, e1));
	}
	
}
