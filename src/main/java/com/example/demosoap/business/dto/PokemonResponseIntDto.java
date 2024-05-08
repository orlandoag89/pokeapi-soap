package com.example.demosoap.business.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PokemonResponseIntDto implements Serializable {
	
	private static final long serialVersionUID = 8878783607171317451L;

	private String pokemonName;
	
	private CommonDataIntDto species;
	
	private int baseExperience;
	
	private int id;
	
	private boolean isDefault;
	
	private String locationAreaEncounters;
	
	private List<HeldItemIntDto> heldItems;
	
	private List<AbilityItemIntDto> abilities;

}
