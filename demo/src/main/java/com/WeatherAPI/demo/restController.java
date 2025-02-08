package com.WeatherAPI.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class restController {
    private static final String API_KEY = "5fca260eb175bd7ce467c32aa46633dc";
    private static final String BASE_URL = "http://api.weatherstack.com/current";

    @GetMapping
    public ResponseEntity<String> getWeather(@RequestParam String city) {
        String url = BASE_URL + "?access_key=" + API_KEY + "&query=" + city;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
