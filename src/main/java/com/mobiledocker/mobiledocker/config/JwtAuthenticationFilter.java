package com.mobiledocker.mobiledocker.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mobiledocker.mobiledocker.AuthService.CustomUserDetailsService;
import com.mobiledocker.mobiledocker.helper.JwtUtil;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private static final Logger logger=LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, "
                + "Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        
        if ( request.getMethod().equals("OPTIONS") ) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
		
		
		
		
		// get header
		// Bearer
		// validate

		// get header
		String requestTokenHeader = request.getHeader("Authorization");

		String userName = null;
		String jwtToken = null;

		// null and format check
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			// removing space after bearer
			jwtToken = requestTokenHeader.substring(7);

			try {
			userName=this.jwtUtil.extractUsername(jwtToken);

			} catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(userName);
			//security
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("Token is not valid");
			}	
		}
		filterChain.doFilter(request, response);
	}
	
}
