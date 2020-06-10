package goingto.com.controller;


import goingto.com.resource.converter.PromoConverter;
import goingto.com.service.PartnerService;
import goingto.com.service.PromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartnerPromosController {

    @Autowired
    PartnerService partnerService;

    @Autowired
    PromoService promoService;

    @Autowired
    PromoConverter mapper;
}
