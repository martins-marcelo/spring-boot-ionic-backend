package com.marcelomartins.cursomc.resources;



import com.marcelomartins.cursomc.dto.ProdutoPageableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marcelomartins.cursomc.domain.Produto;
import com.marcelomartins.cursomc.dto.ProdutoDTO;
import com.marcelomartins.cursomc.resources.utils.URL;
import com.marcelomartins.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestBody ProdutoPageableDTO produtoPageableDTO){
		String nomeDecoded = URL.decodeParam(produtoPageableDTO.getNome());
		Page<Produto> list = service.search(produtoPageableDTO);
		Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
