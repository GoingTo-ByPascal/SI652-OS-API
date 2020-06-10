package goingto.com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import goingto.com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Place;
import goingto.com.repository.geographic.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements goingto.com.service.PlaceService {

	@Autowired
	private PlaceRepository placeRepository;
	
	
	@Override
	public Place getPlace(Integer placeId) {
		return placeRepository.findById(placeId)
				.orElseThrow(() -> new ResourceNotFoundException("City", "Id", placeId));
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
	public Place edit(Place place, Integer id) {
		return placeRepository.findById(id).map(p->{
			p.setName(place.getName());
			return placeRepository.save(p);
		}).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		placeRepository.deleteById(id);
	}

}
