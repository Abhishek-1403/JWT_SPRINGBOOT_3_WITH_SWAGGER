package com.hrms.jwtConfigurations;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable
{
	private static final long serialVersionUID = 46745864576L;

	@Override
	public void commence (HttpServletRequest request, HttpServletResponse response, AuthenticationException authException ) throws IOException
	{
		response.sendError ( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
	}

	
}
