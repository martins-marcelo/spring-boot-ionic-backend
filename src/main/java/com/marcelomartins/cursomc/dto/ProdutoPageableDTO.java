package com.marcelomartins.cursomc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoPageableDTO extends PageableDTO  {
    private List<Integer> categorias;
    private String nome;
}
