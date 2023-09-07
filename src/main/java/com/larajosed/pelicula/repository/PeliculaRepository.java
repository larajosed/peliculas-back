package com.larajosed.pelicula.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.larajosed.pelicula.model.Pelicula;



public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
	  
}
