package com.implementation.cache.Controllers;

import com.implementation.cache.Service.CachedPiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PiController {

    @Autowired
    private CachedPiService cachedPiService;

    @GetMapping("/pi")
    public ResponseEntity<BigDecimal> getPi(@RequestParam(defaultValue = "50") int precision) {
        BigDecimal pi = cachedPiService.computePi(precision);
        return new ResponseEntity<>(pi, HttpStatus.OK);
    }
}
