package com.rabbitmq.producer.domain.web;

import com.rabbitmq.producer.domain.model.Laptop;
import com.rabbitmq.producer.domain.service.LaptopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/laptop")
@Slf4j
public class LaptopRequest {

    private final LaptopService laptopService;

    public LaptopRequest(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Laptop> createProduct(@RequestBody Laptop laptop){
        log.info("Request for laptop: {}", laptop);
        return laptopService.save(laptop);
    }
}
