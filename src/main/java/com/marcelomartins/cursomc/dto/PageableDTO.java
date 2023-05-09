package com.marcelomartins.cursomc.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class PageableDTO {
    private Integer page;
    private Integer linesPerPage;
    private String orderBy;
    private String direction;

    public PageableDTO(Integer page, Integer linesPerPage, String orderBy, String direction){
        this.direction = direction;
        this.linesPerPage = linesPerPage;
        this.orderBy = orderBy;
        this.page = page;
    }


}
