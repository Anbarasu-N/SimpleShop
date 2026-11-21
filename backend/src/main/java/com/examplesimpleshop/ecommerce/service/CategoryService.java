package com.examplesimpleshop.ecommerce.service;

import com.examplesimpleshop.ecommerce.entity.Category;
import com.examplesimpleshop.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class CategoryService {
 private final CategoryRepository categories; private final ProductRepository products;
 public CategoryService(CategoryRepository categories,ProductRepository products){this.categories=categories;this.products=products;}
 public List<Category> all(){return categories.findAll();}
 public Category get(Long id){return categories.findById(id).orElseThrow(()->new IllegalArgumentException("Category not found"));}
 public Category save(Long id,Category input){String name=input.getName()==null?"":input.getName().trim();if(name.isBlank())throw new IllegalArgumentException("Category name is required");if(categories.existsByNameIgnoreCase(name)&& (id==null||!get(id).getName().equalsIgnoreCase(name)))throw new IllegalArgumentException("Category already exists");Category c=id==null?new Category():get(id);c.setName(name);return categories.save(c);}
 public void delete(Long id){get(id);if(products.countByCategoryId(id)>0)throw new IllegalArgumentException("Category contains products");categories.deleteById(id);}
}
