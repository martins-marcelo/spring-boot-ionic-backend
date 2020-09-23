package com.marcelomartins.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelomartins.cursomc.domain.Categoria;
import com.marcelomartins.cursomc.domain.Produto;
import com.marcelomartins.cursomc.repositories.CategoriaRepository;
import com.marcelomartins.cursomc.repositories.ProdutoRepository;
import com.marcelomartins.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private CategoriaRepository catRepo;

	public Produto find(Integer id) {
		Optional<Produto> obj = prodRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = catRepo.findAllById(ids);
		return prodRepo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
