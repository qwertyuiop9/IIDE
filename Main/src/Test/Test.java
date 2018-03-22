package Test;

import WordAnalysis.ClassificatoreECodificatoreParole;

public class Test {

    public static void main(String[] args) {

        int[] analysis = ClassificatoreECodificatoreParole.doWordGrammaticalAnalysis("ita");
        long encodedAnalysis = ClassificatoreECodificatoreParole.obtainValueOfGrammaticalAnalysisEncoding(analysis);
        System.out.format("%s: "+ encodedAnalysis, "Numero intero corrispondente alla codifica della parola");

    }
}
