package com.larajosed.pelicula.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.larajosed.pelicula.model.Usuario;
import com.larajosed.pelicula.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public Usuario login(@RequestParam("email") String email, @RequestParam("contrasena") String contrasena) {
		return usuarioService.findByEmail(email, contrasena);
	}
}
