package com.larajosed.pelicula.repository;


import org.springframework.data.repository.CrudRepository;

import com.larajosed.pelicula.model.Pelicula;



public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {

	 Pelicula getById(int id);
	 
	 Pelicula save(Pelicula pelicula);
	 
	
	 
}
