package com.larajosed.pelicula.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.larajosed.pelicula.view.Views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "peliculas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.DataFilm.class)
	private Integer id;

	@Column
	@JsonView(Views.DataFilm.class)
	private String nombre;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaCreacion;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaUltimaModificacion;
	
	@Column
	private String descripcion;
	
	@JsonView(Views.DataFilm.class)
	@Column
	private String puntuacion;
	
	@JsonView(Views.DataFilm.class)
	@Column
	private String imagen;
	
	@Column
	private Integer usuarioId;
	
	@Column
	private String categoria;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime localDateTime) {
		this.fechaCreacion = localDateTime;
	}
	
	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}

