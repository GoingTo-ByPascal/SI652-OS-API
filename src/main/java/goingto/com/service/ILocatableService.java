package goingto.com.service;

import java.util.List;

import com.sun.jdi.Locatable;


public interface ILocatableService {
	Locatable getLocatable(Long id);
	List<Locatable> listAllLocatables();
	
	
}
