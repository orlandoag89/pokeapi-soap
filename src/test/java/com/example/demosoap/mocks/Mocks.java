package com.example.demosoap.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demosoap.api.dto.AbilityItemApiDto;
import com.example.demosoap.api.dto.CommonInfoApiDto;
import com.example.demosoap.api.dto.HeldItemApiDto;
import com.example.demosoap.api.dto.PokemonApiDto;
import com.example.demosoap.api.dto.VersionDetailApiDto;
import com.example.demosoap.business.dto.AbilityItemIntDto;
import com.example.demosoap.business.dto.CommonDataIntDto;
import com.example.demosoap.business.dto.DeviceInfoIntDto;
import com.example.demosoap.business.dto.HeldItemIntDto;
import com.example.demosoap.business.dto.PokemonRequestIntDto;
import com.example.demosoap.business.dto.PokemonResponseIntDto;
import com.example.demosoap.business.dto.VersionDetailIntDto;
import com.example.demosoap.business.dto.WrapperRequestSaveIntDto;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.dao.entites.RequestEntity;
import com.example.demosoap.dao.entites.enums.MethodEnum;
import com.example.demosoap.gen.AbilityItem;
import com.example.demosoap.gen.CommonData;
import com.example.demosoap.gen.DeviceInfo;
import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.gen.HeldItem;
import com.example.demosoap.gen.PokemonData;
import com.example.demosoap.gen.VersionDetail;

public class Mocks {
	
	private static final String ANY_STRING = "ANY_STRING";
	private static final String CLEFAIRY = "clefairy";
	private static final boolean ANY_BOOLEAN = true;
	private static final int ANY_INT = 1;
	private static final MethodIntEnum ANY_METHOD_INT_ENUM = MethodIntEnum.GET_POKEMON_BY_NAME;
	private static final MethodEnum ANY_METHOD_ENUM = MethodEnum.GET_POKEMON_BY_NAME;
	private static final Date ANY_DATE = new Date();

	private static Mocks instance;
	
	private Mocks() { }
	
	public static Mocks getInstance() {
		if (instance == null) {
			instance = new Mocks();
		}
		return instance;
	}
	
	public String getPokemonName() {
		return CLEFAIRY;
	}
	
	public CommonInfoApiDto getCommonInfoApiDto() {
		final CommonInfoApiDto commonInfoApiDto = new CommonInfoApiDto();
		commonInfoApiDto.setName(ANY_STRING);
		commonInfoApiDto.setUrl(ANY_STRING);
		return commonInfoApiDto;
	}
	
	public AbilityItemApiDto getAbilityItemApiDto() {
		final AbilityItemApiDto abilityItemApiDto = new AbilityItemApiDto();
		abilityItemApiDto.set_hidden(ANY_BOOLEAN);
		abilityItemApiDto.setAbility(getCommonInfoApiDto());
		abilityItemApiDto.setSlot(ANY_INT);
		return abilityItemApiDto;
	}
	
	public CommonDataIntDto getCommonDataIntDto() {
		final CommonDataIntDto commonDataIntDto = new CommonDataIntDto();
		commonDataIntDto.setName(ANY_STRING);
		commonDataIntDto.setUrl(ANY_STRING);
		return commonDataIntDto;
	}
	
	public CommonData getCommonData() {
		final CommonData commonData = new CommonData();
		commonData.setName(ANY_STRING);
		commonData.setUrl(ANY_STRING);
		return commonData;
	}
	
	public AbilityItem getAbilityItem() {
		final AbilityItem abilityItem = new AbilityItem();
		abilityItem.setAbility(getCommonData());
		abilityItem.setIsHidden(ANY_BOOLEAN);
		abilityItem.setSlot(ANY_INT);
		return abilityItem;
	}
	
	public VersionDetailApiDto getVersionDetailApiDto() {
		final VersionDetailApiDto versionDetailApiDto = new VersionDetailApiDto();
		versionDetailApiDto.setRarity(ANY_INT);
		versionDetailApiDto.setVersion(getCommonInfoApiDto());
		return versionDetailApiDto;
	}
	
	public VersionDetailIntDto getVersionDetailIntDto() {
		final VersionDetailIntDto versionDetailIntDto = new VersionDetailIntDto();
		versionDetailIntDto.setRarity(ANY_INT);
		versionDetailIntDto.setVersion(getCommonDataIntDto());
		return versionDetailIntDto;
	}
	
	public HeldItemApiDto getHeldItemApiDto() {
		final HeldItemApiDto heldItemIntDto = new HeldItemApiDto();
		heldItemIntDto.setItem(getCommonInfoApiDto());
		heldItemIntDto.setVersion_details(createListVersionDetailIntDto());
		return heldItemIntDto;
	}
	
	public HeldItemApiDto getHeldItemApiDtoNullList() {
		final HeldItemApiDto heldItemIntDto = new HeldItemApiDto();
		heldItemIntDto.setItem(getCommonInfoApiDto());
		heldItemIntDto.setVersion_details(null);
		return heldItemIntDto;
	}
	
	public HeldItemApiDto getHeldItemApiDtoEmptyList() {
		final HeldItemApiDto heldItemIntDto = new HeldItemApiDto();
		heldItemIntDto.setItem(getCommonInfoApiDto());
		heldItemIntDto.setVersion_details(new ArrayList<VersionDetailApiDto>());
		return heldItemIntDto;
	}
	
	public HeldItemIntDto getHeldItemIntDto() {
		final HeldItemIntDto heldItemIntDto = new HeldItemIntDto();
		heldItemIntDto.setItem(getCommonDataIntDto());
		heldItemIntDto.setVersionDetails(createVersionDetailIntDto());
		return heldItemIntDto;
	}
	
	public AbilityItemIntDto getAbilityItemIntDto() {
		final AbilityItemIntDto abilityItemIntDto = new AbilityItemIntDto();
		abilityItemIntDto.setAbility(getCommonDataIntDto());
		abilityItemIntDto.setHidden(ANY_BOOLEAN);
		abilityItemIntDto.setSlot(ANY_INT);
		return abilityItemIntDto;
	}
	
	public PokemonApiDto getPokemonApiDto() {
		final PokemonApiDto pokemonApiDto = new PokemonApiDto();
		pokemonApiDto.set_default(ANY_BOOLEAN);
		pokemonApiDto.setAbilities(createListAtbilityItemApiDto());
		pokemonApiDto.setBase_experience(ANY_INT);
		pokemonApiDto.setHeld_items(createHeldItemApiDto());
		pokemonApiDto.setId(ANY_INT);
		pokemonApiDto.setLocation_area_encounters(ANY_STRING);
		pokemonApiDto.setName(ANY_STRING);
		pokemonApiDto.setSpecies(getCommonInfoApiDto());
		pokemonApiDto.setWeight(ANY_INT);
		return pokemonApiDto;
	}
	
	public PokemonApiDto getPokemonApiDtoAbilitiesNull() {
		final PokemonApiDto pokemonApiDto = new PokemonApiDto();
		pokemonApiDto.set_default(ANY_BOOLEAN);
		pokemonApiDto.setAbilities(null);
		pokemonApiDto.setBase_experience(ANY_INT);
		pokemonApiDto.setHeld_items(createHeldItemApiDto());
		pokemonApiDto.setId(ANY_INT);
		pokemonApiDto.setLocation_area_encounters(ANY_STRING);
		pokemonApiDto.setName(ANY_STRING);
		pokemonApiDto.setSpecies(getCommonInfoApiDto());
		pokemonApiDto.setWeight(ANY_INT);
		return pokemonApiDto;
	}
	
	public PokemonApiDto getPokemonApiDtoAbilitiesEmpty() {
		final PokemonApiDto pokemonApiDto = new PokemonApiDto();
		pokemonApiDto.set_default(ANY_BOOLEAN);
		pokemonApiDto.setAbilities(new ArrayList<AbilityItemApiDto>());
		pokemonApiDto.setBase_experience(ANY_INT);
		pokemonApiDto.setHeld_items(createHeldItemApiDto());
		pokemonApiDto.setId(ANY_INT);
		pokemonApiDto.setLocation_area_encounters(ANY_STRING);
		pokemonApiDto.setName(ANY_STRING);
		pokemonApiDto.setSpecies(getCommonInfoApiDto());
		pokemonApiDto.setWeight(ANY_INT);
		return pokemonApiDto;
	}
	
	public PokemonApiDto getPokemonApiDtoHeldItemsNull() {
		final PokemonApiDto pokemonApiDto = new PokemonApiDto();
		pokemonApiDto.set_default(ANY_BOOLEAN);
		pokemonApiDto.setAbilities(createListAtbilityItemApiDto());
		pokemonApiDto.setBase_experience(ANY_INT);
		pokemonApiDto.setHeld_items(null);
		pokemonApiDto.setId(ANY_INT);
		pokemonApiDto.setLocation_area_encounters(ANY_STRING);
		pokemonApiDto.setName(ANY_STRING);
		pokemonApiDto.setSpecies(getCommonInfoApiDto());
		pokemonApiDto.setWeight(ANY_INT);
		return pokemonApiDto;
	}
	
	public PokemonApiDto getPokemonApiDtoHeldItemsEmpty() {
		final PokemonApiDto pokemonApiDto = new PokemonApiDto();
		pokemonApiDto.set_default(ANY_BOOLEAN);
		pokemonApiDto.setAbilities(createListAtbilityItemApiDto());
		pokemonApiDto.setBase_experience(ANY_INT);
		pokemonApiDto.setHeld_items(new ArrayList<HeldItemApiDto>());
		pokemonApiDto.setId(ANY_INT);
		pokemonApiDto.setLocation_area_encounters(ANY_STRING);
		pokemonApiDto.setName(ANY_STRING);
		pokemonApiDto.setSpecies(getCommonInfoApiDto());
		pokemonApiDto.setWeight(ANY_INT);
		return pokemonApiDto;
	}
	
	public PokemonRequestIntDto getPokemonRequestIntDto() {
		final PokemonRequestIntDto pokemonRequestIntDto = new PokemonRequestIntDto();
		pokemonRequestIntDto.setDeviceInfo(createDeviceInfoIntDto());
		pokemonRequestIntDto.setMethod(ANY_METHOD_INT_ENUM);
		pokemonRequestIntDto.setPokemonName(ANY_STRING);
		return pokemonRequestIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(createListAbilityItemDto());
		pokemonResponseIntDto.setHeldItems(createListHeldItemIntDto());
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseAbilitiesNullIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(null);
		pokemonResponseIntDto.setHeldItems(createListHeldItemIntDto());
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseAbilitiesEmptyIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(new ArrayList<AbilityItemIntDto>());
		pokemonResponseIntDto.setHeldItems(createListHeldItemIntDto());
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseHeldItemsNullIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(createListAbilityItemDto());
		pokemonResponseIntDto.setHeldItems(null);
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseHeldItemsEmptyIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(createListAbilityItemDto());
		pokemonResponseIntDto.setHeldItems(new ArrayList<HeldItemIntDto>());
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseVersionDetailsIsEmptyIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(createListAbilityItemDto());
		
		final List<HeldItemIntDto> helds = new ArrayList<HeldItemIntDto>();
		final HeldItemIntDto heldItemIntDto = new HeldItemIntDto();
		heldItemIntDto.setItem(getCommonDataIntDto());
		heldItemIntDto.setVersionDetails(new ArrayList<VersionDetailIntDto>());
		helds.add(heldItemIntDto);
		
		pokemonResponseIntDto.setHeldItems(helds);
		return pokemonResponseIntDto;
	}
	
	public PokemonResponseIntDto getPokemonResponseVersionDetailsIsNullIntDto() {
		final PokemonResponseIntDto pokemonResponseIntDto = new PokemonResponseIntDto();
		pokemonResponseIntDto.setBaseExperience(ANY_INT);
		pokemonResponseIntDto.setDefault(ANY_BOOLEAN);
		pokemonResponseIntDto.setId(ANY_INT);
		pokemonResponseIntDto.setLocationAreaEncounters(ANY_STRING);
		pokemonResponseIntDto.setPokemonName(ANY_STRING);
		pokemonResponseIntDto.setSpecies(getCommonDataIntDto());
		pokemonResponseIntDto.setAbilities(createListAbilityItemDto());
		
		final List<HeldItemIntDto> helds = new ArrayList<HeldItemIntDto>();
		final HeldItemIntDto heldItemIntDto = new HeldItemIntDto();
		heldItemIntDto.setItem(getCommonDataIntDto());
		heldItemIntDto.setVersionDetails(null);
		helds.add(heldItemIntDto);
		
		pokemonResponseIntDto.setHeldItems(helds);
		return pokemonResponseIntDto;
	}
	
	public ResponseEntity<PokemonApiDto> createResponseEntity() {
		return new ResponseEntity<PokemonApiDto>(getPokemonApiDto(), HttpStatus.OK);
	}
		
	public WrapperRequestSaveIntDto getWrapperRequestSaveIntDto() {
		final WrapperRequestSaveIntDto wrapperRequestSaveIntDto = new WrapperRequestSaveIntDto();
		wrapperRequestSaveIntDto.setId(ANY_INT);
		wrapperRequestSaveIntDto.setIp(ANY_STRING);
		wrapperRequestSaveIntDto.setMethod(ANY_METHOD_INT_ENUM);
		wrapperRequestSaveIntDto.setRequestDate(ANY_DATE);
		return wrapperRequestSaveIntDto;
	}
	
	public RequestEntity getRequestEntity() {
		final RequestEntity requestEntity = new RequestEntity();
		requestEntity.setIdRequest(ANY_INT);
		requestEntity.setIp(ANY_STRING);
		requestEntity.setMethod(ANY_METHOD_ENUM);
		requestEntity.setRequestDate(ANY_DATE);
		return requestEntity;
	}
	
	public DeviceInfo getDeviceInfo() {
		final DeviceInfo deviceInfo = new DeviceInfo();
		deviceInfo.setIp(ANY_STRING);
		deviceInfo.setRequestDate(createGregorianCalendar());
		return deviceInfo;
	}
	
	public DeviceInfoIntDto getDeviceInfoIntDto() {
		final DeviceInfoIntDto deviceInfo = new DeviceInfoIntDto();
		deviceInfo.setIp(ANY_STRING);
		deviceInfo.setRequestDate(ANY_DATE);
		return deviceInfo;
	}
	
	public GetPokemonRequest getGetPokemonRequest() {
		final GetPokemonRequest getPokemonRequest = new GetPokemonRequest();
		getPokemonRequest.setDevice(getDeviceInfo());
		getPokemonRequest.setMethod(ANY_METHOD_ENUM.name());
		getPokemonRequest.setPokemonName(ANY_STRING);
		return getPokemonRequest;
	}
	
	public GetPokemonResponse getGetPokemonResponse() {
		final GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
		getPokemonResponse.setPokemon(getPokemonData());
		return getPokemonResponse;
	}
	
	public VersionDetail getVersionDetail() {
		final VersionDetail versionDetail = new VersionDetail();
		versionDetail.setRarity(ANY_INT);
		versionDetail.setVersion(getCommonData());
		return versionDetail;
	}
	
	public PokemonData getPokemonData() {
		final PokemonData pokemonData = new PokemonData();
		pokemonData.setBaseExperience(ANY_INT);
		pokemonData.setId(ANY_INT);
		pokemonData.setIsDefault(ANY_BOOLEAN);
		pokemonData.setLocationAreaEncounters(ANY_STRING);
		pokemonData.setName(ANY_STRING);
		pokemonData.setSpecies(getCommonData());
		pokemonData.getAbilities().add(getAbilityItem());
		pokemonData.getHeldItems().add(createHeldItem());
		return pokemonData;
	}
	
	public XMLGregorianCalendar getGregorianCalendar() {
		return createGregorianCalendar();
	}
	
	private List<AbilityItemIntDto> createListAbilityItemDto() {
		final List<AbilityItemIntDto> abilityItemIntDtos = new ArrayList<AbilityItemIntDto>();
		abilityItemIntDtos.add(getAbilityItemIntDto());
		return abilityItemIntDtos;
	}
	
	private List<HeldItemIntDto> createListHeldItemIntDto() {
		final List<HeldItemIntDto> heldItemIntDtos = new ArrayList<HeldItemIntDto>();
		heldItemIntDtos.add(getHeldItemIntDto());
		return heldItemIntDtos;
	}
	
	private List<VersionDetailIntDto> createVersionDetailIntDto() {
		final List<VersionDetailIntDto> detailIntDtos = new ArrayList<VersionDetailIntDto>();
		detailIntDtos.add(getVersionDetailIntDto());
		return detailIntDtos;
	}
	
	private List<VersionDetailApiDto> createListVersionDetailIntDto() {
		final List<VersionDetailApiDto> out = new ArrayList<VersionDetailApiDto>();
		out.add(getVersionDetailApiDto());
		return out;
	}
	
	private List<AbilityItemApiDto> createListAtbilityItemApiDto() {
		final List<AbilityItemApiDto> out = new ArrayList<AbilityItemApiDto>();
		out.add(getAbilityItemApiDto());
		return out;
	}
	
	private List<HeldItemApiDto> createHeldItemApiDto() {
		final  List<HeldItemApiDto> out = new ArrayList<HeldItemApiDto>();
		out.add(getHeldItemApiDto());
		return out;
	}
	
	private DeviceInfoIntDto createDeviceInfoIntDto() {
		final DeviceInfoIntDto out = new DeviceInfoIntDto();
		out.setIp(ANY_STRING);
		out.setRequestDate(ANY_DATE);
		return out;
	}
	
	private HeldItem createHeldItem() {
		final HeldItem out = new HeldItem();
		out.setItem(getCommonData());
		return out;
	}
	
	private XMLGregorianCalendar createGregorianCalendar() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) { }
		return null;
	}
}
