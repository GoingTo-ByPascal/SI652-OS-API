package goingto.com.service.impl;

import java.util.List;

import goingto.com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;
import goingto.com.repository.geographic.CityRepository;

@Service
public class CityServiceImpl implements goingto.com.service.CityService {
	@Autowired
	private CityRepository cityRepository;
	
	
	@Override
	public City getCity(Integer cityId) {
		return cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City", "Id", cityId));
	}

	@Override
	public List<City> listAllCities()
	{
		return cityRepository.findAll();
	}

	@Override
	public List<City> getAllCitiesByCountryId(Integer countryId) {
		return cityRepository.findByCountryId(countryId);
	}

	@Override
	public City getCityByLocatableId(Integer locatableId) {
		return cityRepository.findByLocatableId(locatableId);
	}
}
