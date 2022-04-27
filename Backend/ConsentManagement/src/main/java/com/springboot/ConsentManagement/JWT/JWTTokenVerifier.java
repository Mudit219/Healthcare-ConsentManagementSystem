package com.springboot.ConsentManagement.JWT;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JWTTokenVerifier extends OncePerRequestFilter {
    private String username;

    public String getUsername() {
        return username;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization"); // Getting the value from Authorization header.
        if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String token = authorizationHeader.replace("Bearer ",""); // Removing Bearer String attached to token.

        try{
            // Once getting a token, decrypting the token to get the username and all the authorities assigned to it.
            String secretKey = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
            Jws<Claims> claimJws = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .parseClaimsJws(token);
            Claims body = claimJws.getBody();
            String username = body.getSubject();
            this.username = username;
            List<Map<String,String>> authorities= (List<Map<String,String>>)body.get("authorities");
            Set<SimpleGrantedAuthority> permissions = authorities.stream()
                    .map(auth-> new SimpleGrantedAuthority(auth.get("authority")))
                    .collect(Collectors.toSet());
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    permissions
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (JwtException e){
            throw new IllegalStateException(String.format("Token %s is invalid",token));
        }
        filterChain.doFilter(request,response); // Connecting filter.
    }
}
