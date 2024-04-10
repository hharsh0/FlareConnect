package org.example.socialmedia.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductServiceController {

    private static final Logger logger = ( Logger )LoggerFactory.getLogger( ProductServiceController.class);
    @GetMapping(value = "/hello")
    public String sayingHello() {

        return "Hello there " ;
    }


}