package com.examplesimpleshop.ecommerce.controller;

import com.examplesimpleshop.ecommerce.entity.Product;
import com.examplesimpleshop.ecommerce.dto.ProductRequest;
import com.examplesimpleshop.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products") public class ProductController {
 private final ProductService service;public ProductController(ProductService service){this.service=service;}
 @GetMapping public List<Product> all(@RequestParam(required=false) String search,@RequestParam(required=false) Long categoryId){return service.all(search,categoryId);}
 @GetMapping("/{id}") public Product get(@PathVariable Long id){return service.get(id);}
 @PostMapping public Product create(@Valid @RequestBody ProductRequest request){return service.save(null,request);}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody ProductRequest request){return service.save(id,request);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
