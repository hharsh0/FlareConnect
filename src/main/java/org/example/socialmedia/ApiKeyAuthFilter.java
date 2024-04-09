package org.example.socialmedia;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {


    private String apiKey;
    private String apiSecret;

    public ApiKeyAuthFilter( Environment environment ) {
        this.apiKey =  environment.getProperty("apikey");
        this.apiSecret = environment.getProperty("apisecret");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestApiKey = request.getHeader("X-API-KEY");
        String requestApiSecret = request.getHeader("X-API-SECRET");


        if (apiKey.equals(requestApiKey) && apiSecret.equals(requestApiSecret)) {
            // Continue processing the request
            logger.info("authorized");
            filterChain.doFilter(request, response);
        } else {
            // Reject the request and send an unauthorized error
            logger.info("unauthorized") ;
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Unauthorized");
        }
    }
}