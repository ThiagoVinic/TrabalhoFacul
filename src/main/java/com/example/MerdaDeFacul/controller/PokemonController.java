package com.example.MerdaDeFacul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MerdaDeFacul.entity.Pokemon;
import com.example.MerdaDeFacul.services.PokemonServices;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
	
	private static final String BASE_URI_V1 = "/api/v1/";

	@Autowired
	private PokemonServices services;
	
	@GetMapping(value=BASE_URI_V1+"/")
	public ResponseEntity<List<Pokemon>> findAll(){
		return ResponseEntity.ok().body(services.findAll());
	}
	
	@GetMapping(value=BASE_URI_V1+"{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(services.findById(id));
	}
	
	@PostMapping(value=BASE_URI_V1+"/")
	public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon){
		return ResponseEntity.ok().body(services.create(pokemon));
	}
	
	@PutMapping(value=BASE_URI_V1+"/{id}")
	public ResponseEntity<Pokemon> update(@RequestBody Pokemon pokemon, @PathVariable("id") Long id){
		return ResponseEntity.ok().body(services.update(pokemon, id));
	}
	
	@DeleteMapping(value=BASE_URI_V1+"/{id}")
	public void delete(@PathVariable("id") Long id){
		services.delete(id);
	}
	
}
