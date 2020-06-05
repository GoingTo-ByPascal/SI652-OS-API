package goingto.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goingto.com.model.City;
import goingto.com.model.Country;
import goingto.com.repository.ICityRepository;
import goingto.com.service.ICityService;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICityRepository cityRepository;
	
	
	@Override
	public City getCity(Integer id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public List<City> listAllCities()
	{
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByCountry(Country country) {
		return cityRepository.findByCountryId(country);
	}

	

}
