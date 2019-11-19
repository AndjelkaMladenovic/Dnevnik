package com.example.dnevnikjartest.configuration;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("admin")) {
            response.sendRedirect("/admin/sviKorisnici");
            
        } else if (roles.contains("ucitelj")) {
            response.sendRedirect("/ucitelj/listaUcenikaZaOdabirOcena");
            
        } else if (roles.contains("roditelj")) {
            response.sendRedirect("/roditelj/djackaKnjizica");
            
        } else if (roles.contains("direktor")) {
            response.sendRedirect("/direktor/statistika");
        }
    }

}
