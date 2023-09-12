package com.larajosed.pelicula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larajosed.pelicula.model.Usuario;
import com.larajosed.pelicula.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByEmail(String email, String contrasena){
		
		 Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
		 if(usuario != null && contrasena.equals(usuario.getContrasena())) {
			 return usuario;
		 } else {
			 return null;
		 }
	}
}
