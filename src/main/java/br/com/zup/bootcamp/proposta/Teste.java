package br.com.zup.bootcamp.proposta;

import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal(0);
        BigDecimal d2 = new BigDecimal(1);
        BigDecimal maximo = BigDecimal.ONE;
        BigDecimal minimo = BigDecimal.TEN;

        System.out.println(d1.equals(d2));
        System.out.println(maximo.compareTo(minimo) < 0);
    }
}
