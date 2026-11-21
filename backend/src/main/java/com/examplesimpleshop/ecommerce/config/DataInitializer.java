package com.examplesimpleshop.ecommerce.config;

import com.examplesimpleshop.ecommerce.entity.*;
import com.examplesimpleshop.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.math.BigDecimal;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner seed(UserRepository users,CategoryRepository categories,ProductRepository products,@Value("${simpleshop.admin.email}") String email,@Value("${simpleshop.admin.password}") String password){return args->{
 if(!users.existsByEmailIgnoreCase(email)){User admin=new User();admin.setName("Demo Administrator");admin.setEmail(email);admin.setPassword(new BCryptPasswordEncoder().encode(password));admin.setRole(Role.ADMIN);users.save(admin);}
 if(categories.count()==0){Category electronics=new Category();electronics.setName("Electronics");categories.save(electronics);Category clothing=new Category();clothing.setName("Clothing");categories.save(clothing);
 Product a=new Product();a.setName("Wireless Headphones");a.setDescription("Comfortable everyday wireless headphones");a.setPrice(new BigDecimal("1499.00"));a.setStock(20);a.setCategory(electronics);products.save(a);
 Product b=new Product();b.setName("Cotton T-Shirt");b.setDescription("Soft cotton casual t-shirt");b.setPrice(new BigDecimal("499.00"));b.setStock(35);b.setCategory(clothing);products.save(b);}
 };}
}
