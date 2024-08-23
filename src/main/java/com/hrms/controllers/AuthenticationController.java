package com.hrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.hrms.jwtConfigurations.CustomUserDetailsService;
import com.hrms.jwtConfigurations.JwtTokenUtils;
import com.hrms.requestDTO.AuthenticationRequestDTO;
import com.hrms.responseDTO.AuthenticationResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    
    @Operation(summary = "Authenticate a user and generate JWT token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "JWT token generated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
     // start authentication
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequest) throws Exception {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDTO(userDetails.getUsername(),token));
    }
}
