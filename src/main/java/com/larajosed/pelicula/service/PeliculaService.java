package com.larajosed.pelicula.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larajosed.pelicula.model.Pelicula;
import com.larajosed.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaService {
	@Autowired
	PeliculaRepository peliculaRepository;
	
	public Pelicula getById(int id){
		return peliculaRepository.getById(id);
	}
	
	public Pelicula savePelicula(Pelicula pelicula) {
		
		Integer id = pelicula.id;
		if(pelicula.id != id) {
			pelicula.setFecha(LocalDateTime.now());
		}else {
			pelicula.getFecha();
			pelicula.setFecha_ultima_modificacion(LocalDateTime.now());
		}		
		return peliculaRepository.save(pelicula);
	}
}
