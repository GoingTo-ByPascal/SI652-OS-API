package goingto.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jdi.Locatable;

import goingto.com.repository.LocatableRepository;
import org.springframework.stereotype.Service;

@Service
public class LocatableServiceImpl implements goingto.com.service.LocatableService {

	@Autowired
	private LocatableRepository locatableRepository;

	@Override
	public Locatable getLocatable(Integer id) {
		return locatableRepository.findById(id).orElse(null);
	}

	@Override
	public List<Locatable> listAllLocatable() {
		return locatableRepository.findAll();
	}

	
}
