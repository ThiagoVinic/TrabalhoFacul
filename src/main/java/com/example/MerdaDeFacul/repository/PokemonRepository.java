package com.example.MerdaDeFacul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MerdaDeFacul.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
