package io.github.hevener10.clientes.utilitarios;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class geradorDeCpf {


    public String fakeCPFFormatado() {
        Random rn = new Random();
        List<Integer> baseDigits = rn.ints(9, 0, 10)
                .mapToObj(d -> Integer.valueOf(d))
                .collect(Collectors.toList());
        return gerarCPFFormatado(baseDigits);
    }

    public String fakeCPFSemFormatacao() {
        Random rn = new Random();
        List<Integer> baseDigits = rn.ints(9, 0, 10)
                .mapToObj(d -> Integer.valueOf(d))
                .collect(Collectors.toList());
        return gerarCPF(baseDigits);
    }

    private void generateVerifyDigits(List<Integer> baseNumbers) {
        //Create first verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
        //Create second verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
    }

    private String gerarCPFFormatado(List<Integer> digits) {

        if (baseNumberIsValid(digits)) {
            generateVerifyDigits(digits);
            return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", digits.toArray());
        }

        return null;
    }

    private String gerarCPF(List<Integer> digits) {

        if (baseNumberIsValid(digits)) {
            generateVerifyDigits(digits);
            return String.format("%d%d%d%d%d%d%d%d%d%d%d", digits.toArray());
        }

        return null;
    }

    private boolean baseNumberIsValid(List<Integer> baseNumber) {
        return !baseNumber.stream()
                .allMatch(x -> x == baseNumber.get(0));
    }


    private int createVerifyDigit(List<Integer> baseNumber) throws IllegalArgumentException {
        if (baseNumber.size() != 9 && baseNumber.size() != 10) {
            throw new IllegalArgumentException("baseNumber argument must have 9 ou 10 values");
        }

        int sum = 0;
        for (int i = 0; i < baseNumber.size(); i++) {
            sum += baseNumber.get(i) * (baseNumber.size() + 1 - i);
        }

        int digito = 11 - (sum % 11);

        return digito > 9 ? 0 : digito;
    }
}
