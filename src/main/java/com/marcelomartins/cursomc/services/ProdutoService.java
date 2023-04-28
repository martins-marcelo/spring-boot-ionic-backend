package com.marcelomartins.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.marcelomartins.cursomc.dto.ProdutoPageableDTO;
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

	public Page<Produto> search(ProdutoPageableDTO data){
		PageRequest pageRequest = PageRequest.of(data.getPage(), data.getLinesPerPage(),
				Direction.valueOf(data.getDirection()),
				data.getOrderBy());
		List<Categoria> categorias = catRepo.findAllById(data.getCategorias());
		return prodRepo.findDistinctByNomeContainingAndCategoriasIn(data.getNome(), categorias, pageRequest);
	}
}
