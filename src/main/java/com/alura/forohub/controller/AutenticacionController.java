package com.alura.forohub.controller;

import com.alura.forohub.domain.usuario.DatosAutenticacionUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder; // IMPORTANTE
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService; // Inyectamos el servicio de tokens

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        // 1. Creamos el token de autenticación con los datos de Postman
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());

        // 2. Spring Security valida si el usuario existe y la clave coincide
        var usuarioAutenticado = authManager.authenticate(authenticationToken);

        // 3. Generamos el Token JWT real usando el usuario autenticado
        var tokenJWT = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        // 4. Devolvemos el Token en un objeto DTO (JSON)
        return ResponseEntity.ok(new DatosJWTToken(tokenJWT));
    }
}