package com.example.MerdaDeFacul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MerdaDeFacul.entity.Pokemon;
import com.example.MerdaDeFacul.exception.PokemonException;
import com.example.MerdaDeFacul.repository.PokemonRepository;

@Service
public class PokemonServices {

	@Autowired
	private PokemonRepository repository;
	
	public List<Pokemon> findAll(){
		return repository.findAll();
	}
	
	public Pokemon create(Pokemon pokemon) {
		return repository.save(pokemon);
	}
	
	public Pokemon update(Pokemon pokemon, Long id) {
		Pokemon pokemonAtualizar = repository.findById(id).orElseThrow(()-> new  PokemonException("Pokemon não foi localizada."));
		pokemonAtualizar.setNome(pokemon.getNome());
		return repository.save(pokemonAtualizar);
	}
	
	public Pokemon findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new  PokemonException("Pokemon não foi localizada."));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
