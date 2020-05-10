package goingto.com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.City;
import goingto.com.model.Place;
import goingto.com.repository.IPlaceRepository;
import goingto.com.service.IPlaceService;

public class PlaceService implements IPlaceService{

	@Autowired
	private IPlaceRepository placeRepository;
	
	
	@Override
	public Place getPlace(Long id) {
		return placeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Place> listAllPlaces() {
		return placeRepository.findAll();
	}

	@Override
	public List<Place> listAllCitiesByCity(City city) {
		return placeRepository.findAllByCity(city);
	}

	@Override
	@Transactional
	public Place save(Place place) {
		return placeRepository.save(place);
	}

	@Override
	@Transactional
	public Place edit(Place place, Long id) {
		return placeRepository.findById(id).map(p->{
			p.setName(place.getName());
			return placeRepository.save(p);
		}).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		placeRepository.deleteById(id);
	}

}
