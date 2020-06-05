package goingto.com.service;

import java.util.List;

import com.sun.jdi.Locatable;


public interface ILocatableService {
	Locatable getLocatable(Integer id);
	List<Locatable> listAllLocatables();
	
	
}
