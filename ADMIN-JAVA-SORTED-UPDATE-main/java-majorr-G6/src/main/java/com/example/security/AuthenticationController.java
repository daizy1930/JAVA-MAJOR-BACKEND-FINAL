package com.example.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;
import com.example.repositiories.UserRepo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
    
    @Autowired
    UserRepo ur;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        System.out.println("user principal"+ authentication.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
       
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authority = principal.getAuthorities();
        List<String> roles = authority.stream().map(r -> r.getAuthority()).collect(Collectors.toList());

        JwtResponce jwtResponce = new JwtResponce();
        User user = ur.findByUsername(principal.getUsername());
        jwtResponce.setUsername(principal.getUsername());
        jwtResponce.setUserId(user.getUserId());
        jwtResponce.setRole(roles.get(0));
        jwtResponce.setToken(token);
        return ResponseEntity.ok(jwtResponce);
    }

}