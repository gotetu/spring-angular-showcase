package com.github.gotetu.springangularshowcase.web.rest;

import com.github.gotetu.springangularshowcase.domain.model.Material;
import com.github.gotetu.springangularshowcase.service.MaterialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/material")
public class MaterialResource {
    private final MaterialService service;
    public MaterialResource(final MaterialService service) {
        this.service = service;
    }
    @ApiOperation(value="素材を返します。", nickname="material_getAll")
    @GetMapping("/")
    public ResponseEntity<List<Material>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
