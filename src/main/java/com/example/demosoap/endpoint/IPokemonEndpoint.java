package com.example.demosoap.endpoint;

import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;

public interface IPokemonEndpoint {
	
	GetPokemonResponse getPokemonRequest(GetPokemonRequest request);

}
