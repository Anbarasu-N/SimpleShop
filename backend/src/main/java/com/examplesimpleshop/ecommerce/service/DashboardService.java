package com.examplesimpleshop.ecommerce.service;

import com.examplesimpleshop.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service public class DashboardService {
 private final ProductRepository products;private final CategoryRepository categories;private final UserRepository users;private final OrderRepository orders;
 public DashboardService(ProductRepository products,CategoryRepository categories,UserRepository users,OrderRepository orders){this.products=products;this.categories=categories;this.users=users;this.orders=orders;}
 public Map<String,Long> summary(){Map<String,Long> data=new LinkedHashMap<>();data.put("totalProducts",products.count());data.put("totalCategories",categories.count());data.put("totalUsers",users.count());data.put("totalOrders",orders.count());return data;}
}
