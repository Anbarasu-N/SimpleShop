package com.examplesimpleshop.ecommerce.repository;

import com.examplesimpleshop.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Long>{
 @Query("select p from Product p where (:search is null or lower(p.name) like lower(concat('%',:search,'%'))) and (:categoryId is null or p.category.id = :categoryId) order by p.id desc")
 List<Product> search(@Param("search") String search,@Param("categoryId") Long categoryId);
 long countByCategoryId(Long categoryId);
}
