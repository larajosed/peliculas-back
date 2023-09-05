package com.larajosed.pelicula.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service {

	@GetMapping("/id")
	public String idPeli(){
		return "hola";
	}
}
