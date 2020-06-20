package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.repository.business.ServiceRepository;
import goingto.com.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<goingto.com.model.business.Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public goingto.com.model.business.Service getServiceById(Integer serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service","ID",serviceId));

    }
}
