package com.larajosed.pelicula.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.larajosed.pelicula.model.Pelicula;
import com.larajosed.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaService {
	@Autowired
	PeliculaRepository peliculaRepository;
	
	public Optional<Pelicula> getById(int id){
		return peliculaRepository.findById(id);
	}
	
	public Pelicula savePelicula(Pelicula pelicula, MultipartFile archivo) throws IOException {	
		Integer id = pelicula.getId();		
		String separador = Pattern.quote(".");
		String[] imagen = archivo.getOriginalFilename().split(separador);
		String imgenSeparada =  imagen[1];
		byte[] entradaOriginal = archivo.getBytes();
	    String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal);
		if(imgenSeparada.equals("jpeg")) {			
		    pelicula.setImagen("data:image/jpeg;base64," + cadenaCodificada);
		}
		else if(imgenSeparada.equals("jpg")) {
		    pelicula.setImagen("data:image/png;base64," + cadenaCodificada);
		}
		else if(imgenSeparada.equals("png")) {
		    pelicula.setImagen("data:image/png;base64," + cadenaCodificada);
		}	   
		if(id == null) {
			pelicula.setFechaCreacion(LocalDateTime.now());
		}else {
			Pelicula peliculaDB = peliculaRepository.findById(pelicula.getId()).get();	
			pelicula.setFechaCreacion(peliculaDB.getFechaCreacion());
			pelicula.setFechaUltimaModificacion(LocalDateTime.now());
		}		
		return peliculaRepository.save(pelicula);
	}
	
	public List<Pelicula> getAllPeliculas() {
		return peliculaRepository.findAll();
	}
	
	public List<Pelicula> getAllPeliculasById(int usuarioId) {
		List<Pelicula> pelis = peliculaRepository.findAllByUsuarioId(usuarioId);
		return pelis;
	}
	
	public List<Pelicula> getByCategoria(String categoria){
		List<Pelicula> categoriaPeliculas = peliculaRepository.findAllByCategoria(categoria);
		return categoriaPeliculas;
}
}
