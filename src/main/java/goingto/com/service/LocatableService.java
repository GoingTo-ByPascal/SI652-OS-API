package goingto.com.service;

import java.util.List;

import com.sun.jdi.Locatable;


public interface LocatableService {
	Locatable getLocatable(Integer id);
	List<Locatable> listAllLocatable();
	
	
}
