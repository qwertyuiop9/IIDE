package WordAnalysis;

public enum CategorieAnalisiGrammaticale {

    VERBO(1),
    ARTICOLO(2),
    NOME(3),
    PRONOME(4),
    AGGETTIVO(5),
    PREPOSIZIONE(6),
    CONGIUNZIONE(7),
    AVVERBIO(8),
    ESCLAMAZIONE(9);

    private int word_category;

    /**
     * @return the number (int in range [ 1 - 9] corresponding to the chosen category
     */
    public int getWordCategory() {

        return this.word_category;
    }

    /**
     * Constructor of the class
     * @param i = number corresponding to one of the possible categories in range [ 1-9 ]
     */
    CategorieAnalisiGrammaticale(int i) {

        this.word_category = i;

    }
}
