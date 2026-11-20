package com.examplesimpleshop.ecommerce.service;

import com.examplesimpleshop.ecommerce.dto.*;
import com.examplesimpleshop.ecommerce.entity.*;
import com.examplesimpleshop.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Service public class UserService {
 private final UserRepository users;private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
 private final Map<String,Long> sessions=new ConcurrentHashMap<>();
 public UserService(UserRepository users){this.users=users;}
 public User register(RegisterRequest request){String email=request.email().trim().toLowerCase();if(users.existsByEmailIgnoreCase(email))throw new IllegalArgumentException("Email already registered");User user=new User();user.setName(request.name().trim());user.setEmail(email);user.setPassword(encoder.encode(request.password()));return users.save(user);}
 public Map<String,Object> login(LoginRequest request){User user=users.findByEmailIgnoreCase(request.email().trim()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));if(!encoder.matches(request.password(),user.getPassword()))throw new IllegalArgumentException("Invalid email or password");String token=UUID.randomUUID().toString()+UUID.randomUUID();sessions.put(token,user.getId());return Map.of("token",token,"user",user);}
 public User requireUser(String auth){if(auth==null||!auth.startsWith("Bearer "))throw new SecurityException("Please log in");Long id=sessions.get(auth.substring(7));if(id==null)throw new SecurityException("Session expired; please log in");return users.findById(id).orElseThrow(()->new SecurityException("User unavailable"));}
 public User requireAdmin(String auth){User user=requireUser(auth);if(user.getRole()!=Role.ADMIN)throw new SecurityException("Admin access required");return user;}
 public List<User> all(){return users.findAll();}
}
