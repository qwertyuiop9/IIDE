package Math;

public class MathematicalFunctions {

    /**
     * Dato un polinomio del tipo a1 + a2x + a3x^2 + ... + anx^n
     * @param coefficients array of coefficients of the input polynomial
     * @param base of the polynomial
     * @return the evaluation of the polynomial in input with the specified base
     */
    public static int ValutaPolinomioTramiteBaseCoefficienti(int[] coefficients, int base) {

        int valore_valutazione = 0;
        int coefficient_index = coefficients.length-1;

        while (coefficient_index >= 0) {

            valore_valutazione = valore_valutazione * base + coefficients[coefficient_index];
            coefficient_index--;

        }

        return valore_valutazione;

    }
}
