package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.InetAddress;
import java.net.URI;

@SpringBootApplication
@RestController
public class CorpApplication {

    private final RestTemplate restTemplate;

    public CorpApplication(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CorpApplication.class, args);
    }

    @Value( "${gke_location}" )
    private String gke_location;

    @GetMapping("/api/japan")
    public String japan() throws Exception {
        System.out.println("japan");
        InetAddress ia = InetAddress.getLocalHost();
        String ip = ia.getHostAddress();
        URI url = new URI("http://127.0.0.1:5000/api/japan");
        String japan = null;
        try {
            japan = restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            e.getStackTrace();
            return "Corp " + ip + " " + gke_location;
        }
        return "Corp " + japan + " " + ip + " " + gke_location;
    }

    @GetMapping(value = "/api/france")
    public String france() throws Exception {
        System.out.println("france");
        InetAddress ia = InetAddress.getLocalHost();
        String ip = ia.getHostAddress();
        URI url = new URI("http://127.0.0.1:5000/api/france");
        String france = null;
        try {
            france = restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            e.getStackTrace();
            return "Corp " + ip + " " + gke_location;
        }
        return "Corp " + france + " " + ip + " " + gke_location;
    }
}