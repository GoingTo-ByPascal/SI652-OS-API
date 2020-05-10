package goingto.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jdi.Locatable;

import goingto.com.repository.ILocatableRepository;
import goingto.com.service.ILocatableService;

public class LocatableService implements ILocatableService{

	@Autowired
	private ILocatableRepository locatableRepository;
	
	@Override
	public Locatable getLocatable(Long id) {
		return locatableRepository.findById(id).orElse(null);
	}

	@Override
	public List<Locatable> listAllLocatables() {
		return locatableRepository.findAll();
	}

	
}
