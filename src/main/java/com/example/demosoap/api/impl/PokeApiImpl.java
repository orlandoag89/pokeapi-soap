package com.example.demosoap.api.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demosoap.api.IPokeApi;
import com.example.demosoap.api.dto.PokemonApiDto;
import com.example.demosoap.api.mapper.PokemonApiMapper;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.utils.BusinessException;

@Service
public class PokeApiImpl implements IPokeApi {
	
	private static final Logger logger = LogManager.getLogger(PokeApiImpl.class);

	@Value("${pokeapi.url}")
	private String url;
	
	@Value("${pokeapi.name}")
	private String pokemon;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PokemonApiMapper mapper;

	@Override
	public PokemonResponseIntDto retrievePokemonByName(final String name) throws BusinessException {
		try {
			logger.info("searching pokemon");
			final String urlApi = url + pokemon.replace("{name}", name);
			final ResponseEntity<PokemonApiDto> pokemonResponse = restTemplate.getForEntity(urlApi, PokemonApiDto.class);
			logger.info("pokemon response " + pokemonResponse.getStatusCodeValue());
			return mapper.toOuter(pokemonResponse.getBody());
		} catch (final Exception e) {
			logger.error("Error " + e.getMessage());
			throw new BusinessException("Pokemon not found", "API_00", HttpStatus.NOT_FOUND);
		}
	}
}
