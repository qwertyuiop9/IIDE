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

    public int getWordCategory() {

        return word_category;
    }

    CategorieAnalisiGrammaticale(int i) {

        this.word_category = i;

    }
}
