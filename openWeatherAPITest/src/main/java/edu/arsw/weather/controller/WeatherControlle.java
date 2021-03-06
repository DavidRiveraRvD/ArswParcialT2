package edu.arsw.weather.controller;

import edu.arsw.weather.service.WeatherServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/weather")
public class WeatherControlle {

    @Autowired
    WeatherServices service;

    @RequestMapping(value="/city/{city}", method = RequestMethod.GET)
    public ResponseEntity<?> GetEventById(@PathVariable("city") String city){
        try {
            return new ResponseEntity<>(service.getWeatherByCity(city),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(WeatherControlle.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
