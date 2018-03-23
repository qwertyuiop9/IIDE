package Math;

public class MathematicalFunctions {

    /**
     * Dato un polinomio del tipo a1 + a2x + a3x^2 + ... + anx^n
     * @param coefficients array of coefficients of the input polynomial
     * @param base of the polynomial
     * @return the evaluation of the polynomial in input with the specified base
     */
    public static long ValutaPolinomioTramiteBaseCoefficienti(int[] coefficients, int base) {

        long valore_valutazione = 0;
        int coefficient_index = coefficients.length-1;

        while (coefficient_index >= 0) {

            valore_valutazione = valore_valutazione * base + coefficients[coefficient_index];
            coefficient_index--;

        }

        return valore_valutazione;

    }

    /**
     * @param wordToConvert a word to convert in an integer number composed of only alphabetical characters (from a to z)
     * @return the integer that represents the key of the word in input
     */
    public static long convertWordIntoNumber(String wordToConvert) {

        long convertedWord = -1;

        if (wordToConvert.equals("")) {
            return convertedWord;
        } else {

            wordToConvert = wordToConvert.toLowerCase();

            convertedWord = 0;

            for (int i=0; i<wordToConvert.length(); i++) {

                convertedWord += (wordToConvert.charAt(i) - 96) * Math.pow(26, wordToConvert.length() - i -1);
            }
        }

        return convertedWord;
    }
}
