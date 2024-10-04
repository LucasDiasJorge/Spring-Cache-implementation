package com.implementation.cache.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class PiService {

    @Cacheable("piDecimals")
    public BigDecimal computePi(int precision) {
        MathContext mc = new MathContext(precision);
        BigDecimal C = new BigDecimal(426880).multiply(BigDecimal.valueOf(Math.sqrt(10005)));
        BigDecimal M = BigDecimal.ONE;
        BigDecimal L = new BigDecimal(13591409);
        BigDecimal X = BigDecimal.ONE;
        BigDecimal K = new BigDecimal(6);
        BigDecimal pi = BigDecimal.ZERO;

        for (int n = 0; n < precision; n++) {
            BigDecimal term = M.multiply(L).divide(X, mc);
            pi = pi.add(term);

            // Update M, L, X for next iteration
            M = M.multiply(K).multiply(K.add(BigDecimal.ONE)).multiply(K.add(new BigDecimal("2")));
            L = L.add(new BigDecimal(545140134));
            X = X.multiply(new BigDecimal(-262537412640768000L));
            K = K.add(new BigDecimal(12));
        }

        pi = C.divide(pi, mc);
        return pi;
    }


}
