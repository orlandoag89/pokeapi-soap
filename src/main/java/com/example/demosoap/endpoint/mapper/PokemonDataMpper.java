package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.gen.HeldItem;
import com.example.demosoap.gen.PokemonData;
import com.example.demosoap.utils.IToOuter;

@Component
public class PokemonDataMpper implements IToOuter<PokemonResponseIntDto, PokemonData> {
	
	@Autowired
	private CommonDataMapper commonDataMapper;
	
	@Autowired
	private VersionDetailMapper versionDetailMapper;
	
	@Autowired
	private AbilityItemMapper abilityItemMapper;
	
	@Override
	public PokemonData toOuter(final PokemonResponseIntDto inner) {
		if (inner == null) {
			return null;
		}
		final PokemonData out = new PokemonData();
		out.setBaseExperience(inner.getBaseExperience());
		out.setId(inner.getId());
		out.setIsDefault(inner.isDefault());
		out.setLocationAreaEncounters(inner.getLocationAreaEncounters());
		out.setName(inner.getPokemonName());
		out.setSpecies(commonDataMapper.toOuter(inner.getSpecies()));
		
		if (inner.getAbilities() != null && !inner.getAbilities().isEmpty()) {
			inner.getAbilities().forEach(a -> {
				out.getAbilities().add(abilityItemMapper.toOuter(a));
			});
		}
		
		if (inner.getHeldItems() != null && !inner.getHeldItems().isEmpty()) {
			inner.getHeldItems().forEach(h -> {
				final HeldItem item = new HeldItem();
				item.setItem(commonDataMapper.toOuter(h.getItem()));
				
				if (h.getVersionDetails() != null && !h.getVersionDetails().isEmpty()) {
					h.getVersionDetails().forEach(v -> {
						item.getVersionDetails().add(versionDetailMapper.toOuter(v));
					});
				}
				
				out.getHeldItems().add(item);
			});
		}
		
		return out;
	}

}
