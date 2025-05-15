package com.corhuila.app_movil_g2.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.app_movil_g2.Entity.Country;
import com.corhuila.app_movil_g2.IService.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/country")
public class CountryController extends ABaseController<Country, ICountryService> {
    public CountryController(ICountryService service) {
        super(service, "Country");
    }
}