package com.examplesimpleshop.ecommerce.controller;

import com.examplesimpleshop.ecommerce.entity.Category;
import com.examplesimpleshop.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/categories") public class CategoryController {
 private final CategoryService service;public CategoryController(CategoryService service){this.service=service;}
 @GetMapping public List<Category> all(){return service.all();}
 @GetMapping("/{id}") public Category get(@PathVariable Long id){return service.get(id);}
 @PostMapping public Category create(@RequestBody Category input){return service.save(null,input);}
 @PutMapping("/{id}") public Category update(@PathVariable Long id,@RequestBody Category input){return service.save(id,input);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
