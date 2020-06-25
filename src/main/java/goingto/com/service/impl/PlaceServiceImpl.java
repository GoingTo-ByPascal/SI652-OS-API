package goingto.com.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.repository.geographic.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.geographic.Place;
import goingto.com.repository.geographic.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements goingto.com.service.PlaceService {

	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

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
	public List<Place> getAllPlacesByCategoryId(Integer categoryId) {
		return categoryRepository.findById(categoryId).map(category -> {
			List<Place> places = category.getPlaces();
			return places;
		}).orElseThrow(() -> new ResourceNotFoundException("Category", "Id",categoryId));
	}

	@Override
	public List<Place> getAllPlacesByCityId(Integer cityId) {
		return placeRepository.findAllByCityId(cityId);
	}

	@Override
	public Place getPlaceByLocatableId(Integer locatableId) {
		return placeRepository.findByLocatableId(locatableId);
	}

	@Override
	public List<Place> getByCategoryIdAndCityId(Integer categoryId, Integer cityId) {

		var placesCity = placeRepository.findAllByCityId(cityId);

		 var placesCategory = categoryRepository.findById(categoryId).map(category -> {
			List<Place> placesAux = category.getPlaces();
			return placesAux;
		}).orElseThrow(() -> new ResourceNotFoundException("Category", "Id",categoryId));

		List<Place> places = Stream.concat(placesCategory.stream(), placesCity.stream())
				.collect(Collectors.toList());

		var result = places.stream()
				.filter(e -> Collections.frequency(places, e) > 1)
				.distinct()
				.collect(Collectors.toList());

		return result;
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
