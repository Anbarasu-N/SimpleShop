package com.examplesimpleshop.ecommerce.service;

import com.examplesimpleshop.ecommerce.dto.*;
import com.examplesimpleshop.ecommerce.entity.*;
import com.examplesimpleshop.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service public class OrderService {
 private final OrderRepository orders;private final ProductRepository products;
 public OrderService(OrderRepository orders,ProductRepository products){this.orders=orders;this.products=products;}
 @Transactional public Order create(User user,OrderRequest request){Order order=new Order();order.setUser(user);order.setShippingAddress(request.shippingAddress().trim());BigDecimal total=BigDecimal.ZERO;
 for(OrderItemRequest item:request.items()){Product product=products.findById(item.productId()).orElseThrow(()->new IllegalArgumentException("Product not found: "+item.productId()));if(product.getStock()<item.quantity())throw new IllegalArgumentException("Insufficient stock for "+product.getName());product.setStock(product.getStock()-item.quantity());OrderItem entry=new OrderItem();entry.setOrder(order);entry.setProduct(product);entry.setProductName(product.getName());entry.setQuantity(item.quantity());entry.setPrice(product.getPrice());order.getItems().add(entry);total=total.add(product.getPrice().multiply(BigDecimal.valueOf(item.quantity())));}
 order.setTotalAmount(total);return orders.save(order);}
 public List<Order> mine(User user){return orders.findByUserIdOrderByCreatedAtDesc(user.getId());}
 public List<Order> all(){return orders.findAllByOrderByCreatedAtDesc();}
 public Order get(Long id){return orders.findById(id).orElseThrow(()->new IllegalArgumentException("Order not found"));}
 public Order getForUser(Long id,User user){Order order=get(id);if(user.getRole()!=Role.ADMIN&&!order.getUser().getId().equals(user.getId()))throw new SecurityException("Access denied");return order;}
 @Transactional public Order status(Long id,OrderStatus status){Order order=get(id);order.setStatus(status);return orders.save(order);}
}
