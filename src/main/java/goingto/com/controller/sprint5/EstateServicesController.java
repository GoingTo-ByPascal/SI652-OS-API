package goingto.com.controller.sprint5;


import goingto.com.model.business.Estate;
import goingto.com.resource.business.SaveEstateServiceResource;
import goingto.com.resource.converter.EstateServiceConverter;
import goingto.com.resource.converter.FavouriteConverter;
import goingto.com.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EstateServicesController {

    @Autowired
    private EstateServiceService estateServiceService;

    @Autowired
    private EstateService estateService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private EstateServiceConverter mapper;

    @ApiOperation("Return Services by Estate id")
    @GetMapping("/estates/{estateId}/services")
    public ResponseEntity<?> getAllEstateServicesByEstateId(@PathVariable(name = "estateId") Integer estateId)
    {
        Estate existingEstate = estateService.getEstateById(estateId);
        if(existingEstate == null)
            return ResponseEntity.notFound().build();
        var result = existingEstate.getEstateServices();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/estates/{estateId}/services/{serviceId}")
    public goingto.com.model.business.EstateService getEstateServiceByEstateIdAndServiceId(@PathVariable(name = "estateId") Integer estateId, @PathVariable(name = "serviceId") Integer serviceId){
        return estateServiceService.getByEstateIdAndServiceId(estateId,serviceId);
    }

    @PostMapping("/estates/{estateId}/services/{serviceId}")
    public goingto.com.model.business.EstateService assignEstateService(@PathVariable(name = "estateId") Integer estateId,
                                                                        @PathVariable(name = "serviceId") Integer serviceId, @Valid @RequestBody SaveEstateServiceResource resource) {
        var existingEstate = estateService.getEstateById(estateId);
        var existingService = serviceService.getServiceById(serviceId);
        var estateService = mapper.convertToEntity(resource);
        estateService.setEstate(existingEstate);
        estateService.setService(existingService);
        return estateServiceService.createEstateService(estateService);
    }

    @DeleteMapping("/estates/{estateId}/services/{serviceId}")
    public void unassignEstateService(@PathVariable(name = "estateId") Integer estateId,
                                  @PathVariable(name = "serviceId") Integer serviceId) {

        var estateService = estateServiceService.getByEstateIdAndServiceId(estateId,serviceId);
        estateServiceService.deleteEstateService(estateService);

    }

}
