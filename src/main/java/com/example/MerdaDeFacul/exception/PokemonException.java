package com.example.MerdaDeFacul.exception;

public class PokemonException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PokemonException(String msg, Throwable ex) {
       super(msg, ex);		
	}
	
	public PokemonException(String msg) {
	       super(msg);		
	}

}
