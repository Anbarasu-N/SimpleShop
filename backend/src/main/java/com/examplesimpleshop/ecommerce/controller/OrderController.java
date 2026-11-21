package com.examplesimpleshop.ecommerce.controller;

import com.examplesimpleshop.ecommerce.dto.OrderRequest;
import com.examplesimpleshop.ecommerce.entity.*;
import com.examplesimpleshop.ecommerce.service.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/orders") public class OrderController {
 private final OrderService orders;private final UserService users;
 public OrderController(OrderService orders,UserService users){this.orders=orders;this.users=users;}
 @PostMapping public Order create(@RequestHeader(value="Authorization",required=false) String auth,@Valid @RequestBody OrderRequest request){return orders.create(users.requireUser(auth),request);}
 @GetMapping("/my") public List<Order> mine(@RequestHeader(value="Authorization",required=false) String auth){return orders.mine(users.requireUser(auth));}
 @GetMapping public List<Order> all(@RequestHeader(value="Authorization",required=false) String auth){users.requireAdmin(auth);return orders.all();}
 @GetMapping("/{id}") public Order get(@RequestHeader(value="Authorization",required=false) String auth,@PathVariable Long id){return orders.getForUser(id,users.requireUser(auth));}
 @PatchMapping("/{id}/status") public Order status(@RequestHeader(value="Authorization",required=false) String auth,@PathVariable Long id,@RequestBody Map<String,String> body){users.requireAdmin(auth);return orders.status(id,OrderStatus.valueOf(body.getOrDefault("status","").toUpperCase()));}
}
