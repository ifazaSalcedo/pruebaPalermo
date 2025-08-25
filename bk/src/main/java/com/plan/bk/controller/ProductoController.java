package com.plan.bk.controller;

import com.plan.bk.data.services.producto.uc.ProductoFindUC;
import com.plan.bk.dto.ProductoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    private final ProductoFindUC service;
    private final PagedResourcesAssembler<ProductoDto> pagedResourcesAssembler;

    @GetMapping("/listado-productos")
    public ResponseEntity<PagedModel<EntityModel<ProductoDto>>> getListadoProductos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size){

        Page<ProductoDto> listaProductos = service.findAll(page, size);

        if(listaProductos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(listaProductos, EntityModel::of));

    }

}
