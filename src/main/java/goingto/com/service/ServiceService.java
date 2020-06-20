package goingto.com.service;

import goingto.com.model.business.Service;

import java.util.List;

public interface ServiceService {

    List<Service> getAll();
    Service getServiceById(Integer serviceId);
}
