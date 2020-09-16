package com.github.gotetu.springangularshowcase.web.rest;

import com.github.gotetu.springangularshowcase.domain.model.Recipe;
import com.github.gotetu.springangularshowcase.service.recipe.RecipeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeResource {
    private final RecipeService service;

    public RecipeResource(RecipeService service) {
        this.service = service;
    }
    @ApiOperation(value="レシピを作成します。", nickname="recipe_create")
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody final Recipe recipe) {
        Recipe created = service.create(recipe);
        return ResponseEntity.created(
                URI.create("/api/v1/recipe/" + created.getId())
        ).build();
    }
    @ApiOperation(value="IDのレシピを返します。", nickname="recipe_get")
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable final long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @ApiOperation(value="レシピを更新します。", nickname="recipe_save")
    @PutMapping("/save")
    public ResponseEntity<Void> save(@RequestBody final Recipe recipe) {
        service.save(recipe);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value="IDのレシピを削除します。", nickname="recipe_remove")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable final long id,
            @RequestParam("version") final int version) {
        service.remove(id, version);
        return ResponseEntity.ok().build();
    }
}
