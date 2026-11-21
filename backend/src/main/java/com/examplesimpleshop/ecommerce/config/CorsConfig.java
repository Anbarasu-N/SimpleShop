package com.examplesimpleshop.ecommerce.config;

import com.examplesimpleshop.ecommerce.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.*;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;
@Configuration public class CorsConfig {
 @Bean public CorsConfigurationSource corsConfigurationSource(){CorsConfiguration c=new CorsConfiguration();c.setAllowedOrigins(List.of("http://localhost:5173","http://127.0.0.1:5173"));c.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));c.setAllowedHeaders(List.of("Authorization","Content-Type"));UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();source.registerCorsConfiguration("/api/**",c);return source;}
 @Bean @Order(1) public Filter adminWriteFilter(UserService users){return new OncePerRequestFilter(){@Override protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain)throws ServletException,IOException{
 String path=request.getRequestURI();String method=request.getMethod();boolean protectedWrite=(path.startsWith("/api/products")||path.startsWith("/api/categories"))&&!method.equals("GET")&&!method.equals("OPTIONS");boolean dashboard=path.startsWith("/api/dashboard");
 if(protectedWrite||dashboard){try{users.requireAdmin(request.getHeader("Authorization"));}catch(SecurityException e){response.sendError(403,e.getMessage());return;}}
 chain.doFilter(request,response);
 }};}
}
