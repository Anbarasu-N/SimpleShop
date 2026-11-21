package com.examplesimpleshop.ecommerce.service;

import com.examplesimpleshop.ecommerce.entity.*;
import com.examplesimpleshop.ecommerce.dto.ProductRequest;
import com.examplesimpleshop.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class ProductService {
 private final ProductRepository products;private final CategoryService categories;
 public ProductService(ProductRepository products,CategoryService categories){this.products=products;this.categories=categories;}
 public List<Product> all(String search,Long categoryId){return products.search(search==null||search.isBlank()?null:search.trim(),categoryId);}
 public Product get(Long id){return products.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found"));}
 public Product save(Long id,ProductRequest request){Product p=id==null?new Product():get(id);p.setName(request.name().trim());p.setDescription(request.description());p.setPrice(request.price());p.setStock(request.stock());p.setImageUrl(request.imageUrl());p.setCategory(request.categoryId()==null?null:categories.get(request.categoryId()));return products.save(p);}
 public void delete(Long id){get(id);products.deleteById(id);}
}
