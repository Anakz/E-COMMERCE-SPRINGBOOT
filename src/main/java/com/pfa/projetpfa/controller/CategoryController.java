package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.CategoryVo;
import com.pfa.projetpfa.service.ICategoryService;
import com.pfa.projetpfa.service.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @GetMapping(value = "/api/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryVo> getCategories(){

        return service.getCategories();
    }
    @GetMapping(value = "/api/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCategoryById(@PathVariable(value = "id") Long categoryVoId){
        CategoryVo categoryVoFound = service.getCategoryById(categoryVoId);
        if (categoryVoFound == null)
            return new ResponseEntity<>("product doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(categoryVoFound, HttpStatus.OK);
    }
    @GetMapping(value = "/api/category/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCategoryByName(@PathVariable(value = "name") String categoryVoName){
        List<CategoryVo> categoryVoFound = service.getCategoryByName(categoryVoName);
        if (categoryVoFound == null)
            return new ResponseEntity<>("product doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(categoryVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/category")
    public ResponseEntity<Object> createCategory(@Validated @RequestBody CategoryVo categoryVo){
        service.save(categoryVo);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/category/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(name = "id") Long categoryVoId, @RequestBody CategoryVo categoryVo){
        CategoryVo categoryVoFound = service.getCategoryById(categoryVoId);
        if (categoryVoFound == null)
            return new ResponseEntity<>("Category doesn't exist", HttpStatus.OK);
        categoryVo.setId(categoryVoId);
        service.save(categoryVo);
        return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/category/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(name = "id") Long categoryVoId, @RequestBody CategoryVo categoryVo){
        CategoryVo categoryVoFound = service.getCategoryById(categoryVoId);
        if (categoryVoFound == null)
            return new ResponseEntity<>("Category doesn't exist", HttpStatus.OK);
        categoryVoFound.setIs_deleted(true);
        service.save(categoryVoFound);
        return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
    }
    /*@GetMapping(value = "/api/categorybyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryVo> getCategoryByName(@PathVariable(value = "name") String categoryVoName){
        return service.findByName(categoryVoName);
    }*/
}