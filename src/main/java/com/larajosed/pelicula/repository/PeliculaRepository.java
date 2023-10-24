package com.larajosed.pelicula.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larajosed.pelicula.model.Pelicula;



public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

	public List<Pelicula> findAllByUsuarioId(int usuarioId);
	
	public List<Pelicula> findAllByCategoria(String categoria);
}
