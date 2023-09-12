package com.larajosed.pelicula.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larajosed.pelicula.model.Pelicula;
import com.larajosed.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaService {
	@Autowired
	PeliculaRepository peliculaRepository;
	
	public Optional<Pelicula> getById(int id){
		return peliculaRepository.findById(id);
	}
	
	public Pelicula savePelicula(Pelicula pelicula) {		
		Integer id = pelicula.getId();
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
}
