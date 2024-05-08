package com.example.demosoap.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.api.dto.PokemonApiDto;
import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.business.dto.HeldItemIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.utils.IToOuter;

@Component
public class PokemonApiMapper implements IToOuter<PokemonApiDto, PokemonResponseIntDto> {
	
	@Autowired
	private HeldItemApiMapper heldItemMapper;
	
	@Autowired
	private CommonInfoApiMapper commonInfoMapper;
	
	@Autowired
	private AbilityItemApiMapper abilityMapper;

	@Override
	public PokemonResponseIntDto toOuter(final PokemonApiDto inner) {
		if (inner == null) {
			return null;
		}
		final PokemonResponseIntDto p = new PokemonResponseIntDto();
		p.setBaseExperience(inner.getBase_experience());
		p.setDefault(inner.is_default());
		p.setId(inner.getId());
		p.setLocationAreaEncounters(inner.getLocation_area_encounters());
		p.setPokemonName(inner.getName());
		p.setSpecies(commonInfoMapper.toOuter(inner.getSpecies()));
		
		final List<AbilityItemIntDto> abilities = new ArrayList<AbilityItemIntDto>();
		if (inner.getAbilities() != null && !inner.getAbilities().isEmpty()) {
			inner.getAbilities().forEach(a -> {
				abilities.add(abilityMapper.toOuter(a));
			});
		}
		p.setAbilities(abilities);
				
		final List<HeldItemIntDto> items = new ArrayList<HeldItemIntDto>();
		if (inner.getHeld_items() != null && !inner.getHeld_items().isEmpty()) {
			inner.getHeld_items().forEach(h -> {
				items.add(heldItemMapper.toOuter(h));
			});
		}
		p.setHeldItems(items);
		return p;
	}

}
