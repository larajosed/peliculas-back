package com.larajosed.pelicula.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.larajosed.pelicula.model.Pelicula;
import com.larajosed.pelicula.service.PeliculaService;



@RestController
@RequestMapping("/pelicula")
public class PeliculasController {
	@Autowired
	PeliculaService peliculaService;


	@GetMapping("/{id}")
	public Optional<Pelicula> idPeli(@PathVariable Integer id){
		return peliculaService.getById(id);
	}
		
	@PostMapping
	public Pelicula addPelicula(@RequestBody Pelicula pelicula) {
		return  peliculaService.savePelicula(pelicula);
	}
	
	
	

	
}
