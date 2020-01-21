package cz.horvath.sample.rest.controller;

import cz.horvath.sample.rest.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes REST API for number scrambling service.
 * 
 */
@RestController
@RequestMapping(value = "number")
public class NumberResource {
    
    @Autowired
    NumberService numberService;
    
    @GetMapping("/{number}")
    public long reverse(@PathVariable long number) {
        return numberService.scramble(number);
    }
    
}
