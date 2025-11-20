package com.velectronics.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*; import javax.servlet.http.*; import java.io.IOException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Collections;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String auth = req.getHeader("Authorization"); if(auth!=null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7); String user = jwtUtil.extractUsername(token);
            if(user!=null) SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
        }
        chain.doFilter(req,res);
    }
}
