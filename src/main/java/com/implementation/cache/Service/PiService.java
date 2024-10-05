package com.implementation.cache.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PiService {

    private final CachedPiService cachedPiService;

    public PiService(CachedPiService cachedPiService) {
        this.cachedPiService = cachedPiService;
    }

    @Scheduled(fixedRate = 1000)
    public void printPi() {
        System.out.println("Pi: " + cachedPiService.computePi(1500));
    }
}
