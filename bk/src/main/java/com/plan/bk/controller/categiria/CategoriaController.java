package com.plan.bk.controller.categiria;

import com.plan.bk.data.services.categoria.uc.CategoriaFindUC;
import com.plan.bk.dto.CategoriaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    private final CategoriaFindUC service;

    @GetMapping("/categoria-lista")
    public ResponseEntity<List<CategoriaDto>> getListaCategoria(){
        List<CategoriaDto> listaCategoria = service.findAll();
        return ResponseEntity.ok(listaCategoria);
    }



}
