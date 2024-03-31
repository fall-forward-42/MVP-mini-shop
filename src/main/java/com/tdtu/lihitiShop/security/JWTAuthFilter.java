package com.tdtu.lihitiShop.security;

import com.tdtu.lihitiShop.service.UserService;
import com.tdtu.lihitiShop.service.impl.UserDetailsServiceImpl;
import com.tdtu.lihitiShop.service.impl.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {
    private JWTutils jwTutils;
    private UserDetailsServiceImpl userServiceImpl;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken ;
        final String username;
        if(authHeader == null || authHeader.isBlank()){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken = authHeader.substring(7);
        username = jwTutils.extractUsername(jwtToken);
        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userServiceImpl.loadUserByUsername(username);

            if(jwTutils.isTokenValid(jwtToken,userDetails)){
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);

            }
        }
        filterChain.doFilter(request,response);
    }
}
