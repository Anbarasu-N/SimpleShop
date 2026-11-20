package com.examplesimpleshop.ecommerce.controller;

import com.examplesimpleshop.ecommerce.dto.*;
import com.examplesimpleshop.ecommerce.entity.User;
import com.examplesimpleshop.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/users") public class UserController {
 private final UserService service;public UserController(UserService service){this.service=service;}
 @PostMapping("/register") public User register(@Valid @RequestBody RegisterRequest request){return service.register(request);}
 @PostMapping("/login") public Map<String,Object> login(@Valid @RequestBody LoginRequest request){return service.login(request);}
 @GetMapping("/me") public User me(@RequestHeader(value="Authorization",required=false) String auth){return service.requireUser(auth);}
 @GetMapping public List<User> all(@RequestHeader(value="Authorization",required=false) String auth){service.requireAdmin(auth);return service.all();}
}
