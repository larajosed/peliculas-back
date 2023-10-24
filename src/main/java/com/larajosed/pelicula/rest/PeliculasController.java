package com.larajosed.pelicula.rest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.larajosed.pelicula.model.Pelicula;
import com.larajosed.pelicula.service.PeliculaService;
import com.larajosed.pelicula.view.Views;


@CrossOrigin
@RestController
@RequestMapping("/pelicula")
public class PeliculasController {
	@Autowired
	PeliculaService peliculaService;


	@GetMapping("/{id}")
	public Optional<Pelicula> idPeli(@PathVariable Integer id){
		return peliculaService.getById(id);
	}
	
	@GetMapping("/lista")
	public List<Pelicula> allPeliculas() {		 
		return peliculaService.getAllPeliculas();
	}
	
	@GetMapping("/usuario/{usuarioId}")
	@JsonView(Views.DataFilm.class)
	public List<Pelicula> getAllPeliculasById(@PathVariable Integer usuarioId){
		return peliculaService.getAllPeliculasById(usuarioId);
	}
	
	@GetMapping("/categoria/{categoria}")
	public List<Pelicula> peliculasByCategoria(@PathVariable String categoria){
		return peliculaService.getByCategoria(categoria);
	}
		
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Pelicula addPelicula(@RequestPart Pelicula pelicula, @RequestPart(required = false) MultipartFile archivo) throws IOException {
		return  peliculaService.savePelicula(pelicula, archivo);
	}
	
	
	

	
}
