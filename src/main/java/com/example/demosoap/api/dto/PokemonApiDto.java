package com.example.demosoap.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PokemonApiDto implements Serializable {
	
	private static final long serialVersionUID = -3778681805156850991L;

	private List<AbilityItemApiDto> abilities;
	
	private int id;
	
	private String name;
	
	private boolean is_default;
	
	private String location_area_encounters;
	
	private int weight;
	
	private int base_experience;
	
	private CommonInfoApiDto species;
	
	private List<HeldItemApiDto> held_items;
}
