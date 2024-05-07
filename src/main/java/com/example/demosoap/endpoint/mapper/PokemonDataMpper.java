package com.example.demosoap.endpoint.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.HeldItemIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.business.dto.VersionDerailIntDto;
import com.example.demosoap.gen.PokemonData;
import com.example.demosoap.utils.IMapper;

@Component
public class PokemonDataMpper implements IMapper<PokemonResponseIntDto, PokemonData> {
	
	@Autowired
	private CommonDataMapper commonDataMapper;
	
	@Autowired
	private VersionDetailMapper versionDetailMapper;

	@Override
	public PokemonResponseIntDto toInner(final PokemonData outer) {
		if (outer == null) {
			return null;
		}
		final PokemonResponseIntDto out = new PokemonResponseIntDto();
		out.setBaseExperience(outer.getBaseExperience());
		out.setDefault(outer.isIsDefault());
		out.setId(outer.getId());
		out.setLocationAreaEncounters(outer.getLocationAreaEncounters());
		out.setPokemonName(outer.getName());
		out.setSpecies(commonDataMapper.toInner(outer.getSpecies()));
		
		final List<HeldItemIntDto> items = new ArrayList<>();
		if (outer.getHeldItems() != null && !outer.getHeldItems().isEmpty()) {
			outer.getHeldItems().forEach(e -> {
				final HeldItemIntDto item = new HeldItemIntDto();
				item.setItem(commonDataMapper.toInner(e.getItem()));
				
				final List<VersionDerailIntDto> versions = new ArrayList<>();
				if (e.getVersionDetails() != null && !e.getVersionDetails().isEmpty()) {
					e.getVersionDetails().forEach(v -> {
						versions.add(versionDetailMapper.toInner(v));
					});
				}
				item.setVersionDetails(versions);
				items.add(item);
			});
		}
		out.setHeldItems(items);
		return out;
	}

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
		return out;
	}

}
