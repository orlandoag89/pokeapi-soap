package com.example.demosoap.endpoint.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.utils.IMapper;

@Component
public class GetPokemonRequestMapper implements IMapper<PokemonRequestIntDto, GetPokemonRequest> {
	
	@Autowired
	private DeviceInfoMapper deviceInfoMapper;
	
	@Override
	public PokemonRequestIntDto toInner(final GetPokemonRequest outer) {
		if (outer == null) {
			return null;
		}
		final PokemonRequestIntDto output = new PokemonRequestIntDto();
		output.setDeviceInfo(deviceInfoMapper.toInner(outer.getDevice()));
		output.setPokemonName(outer.getPokemonName());
		output.setMethod(MethodIntEnum.valueOf(outer.getMethod()));
		return output;
	}

	@Override
	public GetPokemonRequest toOuter(final PokemonRequestIntDto inner) {
		return null;
	}

	
}
