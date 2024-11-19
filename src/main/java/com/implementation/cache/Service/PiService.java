package com.implementation.cache.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class PiService {

    private final CachedPiService cachedPiService;

    public PiService(CachedPiService cachedPiService) {
        this.cachedPiService = cachedPiService;
    }

    @Scheduled(fixedRate = 2500)
    public void printPi() {

        List<Integer> toCompute = Arrays.asList(100, 1000, 1500, 900, 750);

        // Benchmark Linear Execution
        //Duration linearTime = benchmarkLinear(toCompute);
        //System.out.println("Linear Benchmark: " + linearTime.toMillis() + " ms");

        // Benchmark Parallel Execution
        Duration parallelTime = benchmarkParallel(toCompute);
        System.out.println("Parallel Benchmark: " + parallelTime.toMillis() + " ms");
    }

    private Duration benchmarkLinear(List<Integer> toCompute) {
        Instant beginTime = Instant.now();

        // Linear programming
        toCompute.forEach(e -> {
            BigDecimal result = cachedPiService.computePi(e);
            System.out.println("Pi (linear): " + result);
        });

        return Duration.between(beginTime, Instant.now());
    }

    private Duration benchmarkParallel(List<Integer> toCompute) {
        Instant beginTime = Instant.now();

        // Parallel programming
        List<CompletableFuture<BigDecimal>> futures = toCompute.stream()
                .map(e -> CompletableFuture.supplyAsync(() -> cachedPiService.computePi(e)))
                .collect(Collectors.toList());

        List<BigDecimal> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Print results
        results.forEach(result -> System.out.println("Pi (parallel): " + result));

        return Duration.between(beginTime, Instant.now());
    }
}
