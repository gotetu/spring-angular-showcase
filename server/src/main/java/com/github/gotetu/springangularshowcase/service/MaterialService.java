package com.github.gotetu.springangularshowcase.service;

import com.github.gotetu.springangularshowcase.domain.model.Material;
import com.github.gotetu.springangularshowcase.web.domain.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaterialService {
    private final MaterialRepository repository;

    public MaterialService(final MaterialRepository repository) {
        this.repository = repository;
    }
    public List<Material> findAll() {
        return repository.selectAll();
    }
}
