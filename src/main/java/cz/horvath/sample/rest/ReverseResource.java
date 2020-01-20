package cz.horvath.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes reverse service as REST service.
 */
@RestController
@RequestMapping(value = "reverse")
public class ReverseResource {
    
    @Autowired
    ReverseService reverseService;
    
    @GetMapping("/{sentence}")
    public String reverse(@PathVariable String sentence) {
        return reverseService.reverseString(sentence);
    }
    
}
