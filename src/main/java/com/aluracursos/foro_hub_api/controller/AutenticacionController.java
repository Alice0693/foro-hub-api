package com.aluracursos.foro_hub_api.controller;

import com.aluracursos.foro_hub_api.domain.usuario.DatosAutenticacion;
import com.aluracursos.foro_hub_api.domain.usuario.DatosJWTToken;
import com.aluracursos.foro_hub_api.domain.usuario.Usuario;
import com.aluracursos.foro_hub_api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacion datos) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.password());
        var usuarioAutenticado = manager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}