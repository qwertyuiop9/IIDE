package WordAnalysis;

import File.KeyboardInputHandler;

public class ClassificatoreECodificatoreParole {

    private static final int maxGrammaticalAnalysisFieldNumber = 10;
    private static final String currentSelectedLanguage = "ita";

    /**
     * @return a valid number of word category ( such that 0<n<10 )
     */
    private static int getWordCategory() {

        System.out.format("Categorie possibili:\n");
        printWordCategories();
        System.out.format("\nNumero corrispondente alla categoria: ");

        int category_number_inserted;

        do {

            category_number_inserted = KeyboardInputHandler.getIntInputFromKeyboard();

        } while (!isValidWordCategory(category_number_inserted));

        return category_number_inserted;
    }

    /**
     *  Print the available word categories
     */
    private static void printWordCategories() {

        int counter = 1;

        for ( CategorieAnalisiGrammaticale category : CategorieAnalisiGrammaticale.values() ) {

            System.out.format("%d - %s\n", counter, category);
            counter++;
        }
    }

    /**
     * @param category_number of the word considered (such that 0<category_number<10)
     * @return true if the category_number is a valid word category, false otherwise
     */
    private static boolean isValidWordCategory(int category_number) {

        return category_number > 0 && category_number < 10;
    }

    public static void obtainWordGrammaticalAnalysis() {

        printInsertWord(currentSelectedLanguage);

        String wordToAnalyze = KeyboardInputHandler.getStringInputFromKeyboard();

        printInstructionsForAddWordGrammaticalAnalysis(currentSelectedLanguage);

        int[] encodingArray = new int[maxGrammaticalAnalysisFieldNumber];

        int wordCategory = getWordCategory();
        setWordCategory(encodingArray, wordCategory);

        switch (wordCategory) {

            case 1:
                // Da definire
                break;

            case 2:
                makeArticleCoding(encodingArray, wordToAnalyze, currentSelectedLanguage);
                break;

            default:
                break;
        }

        for (int i=0; i<encodingArray.length; i++) {
            System.out.format("Posizione %d: %d\n", i, encodingArray[i]);
        }

    }



    //--------------------------------METHODS THAT MODIFY THE ARRAY's VALUES------------------------------------//

    //--------------------------------------------------CELL 0--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordCategory int in range [1-9]
     */
    private static void setWordCategory(int[] encodingArray, int wordCategory) {

        encodingArray[0] = wordCategory;

    }

    //--------------------------------------------------CELL 1--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param male true if it is male, false to say female
     */
    private static void isWordMale(int[] encodingArray, boolean male) {

        if (male) {
            encodingArray[1] = 1;
        } else {
            encodingArray[1] = 0;
        }

    }

    //--------------------------------------------------CELL 2--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param singular true if the word is singular, false otherwise
     */
    private static void isWordSingular(int[] encodingArray, boolean singular) {

        if (singular) {
            encodingArray[2] = 1;
        } else {
            encodingArray[2] = 0;
        }

    }

    //--------------------------------------------------CELL 3--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param definite true if the article is definite, false otherwise
     */
    private static void isArticleDefinite(int[] encodingArray, boolean definite) {

        if (definite) {
            encodingArray[3] = 1;
        } else {
            encodingArray[3] = 0;
        }

    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param collective true if the name is collective, false otherwise
     */
    private static void isNameCollective(int[] encodingArray, boolean collective) {

        if (collective) {
            encodingArray[3] = 2;
        } else {
            encodingArray[3] = 3;
        }

    }

    //--------------------------------------------------CELL 4--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param personal true if the name is personal, false otherwise ( = common)
     */
    private static void isNamePersonal(int[] encodingArray, boolean personal) {

        if (personal) {
            encodingArray[4] = 1;
        } else {
            encodingArray[4] = 0;
        }

    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param definite true if the adjective is definite, false otherwise
     */
    private static void isAdjectiveDefinite(int[] encodingArray, boolean definite) {

        if (definite) {
            encodingArray[4] = 3;
        } else {
            encodingArray[4] = 2;
        }
    }

    //--------------------------------------------------CELL 5--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param composed true if the name is composed, false otherwise
     */
    private static void isNameComposed(int[] encodingArray, boolean composed) {

        if(composed) {
            encodingArray[5] = 0;
        } else {
            encodingArray[5] = 1;
        }

    }

    //--------------------------------------------------CELL 6--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param categoryType an int in the range [5-7];
     *                     5 = person
     *                     6 = animal
     *                     7 = thing
     */
    private static void setNameCategory(int[] encodingArray, int categoryType) {

        encodingArray[6] = categoryType;
    }

    //--------------------------------------------------CELL 7--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param concrete true if the name is concrete, false otherwise
     */
    private static void isNameConcrete(int[] encodingArray, boolean concrete) {

        if (concrete) {
            encodingArray[7] = 1;
        } else {
            encodingArray[7] = 0;
        }
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param simple true if the preposition is simple, false otherwise
     */
    private static void isPrepositionSimple(int[] encodingArray, boolean simple) {

        if(simple) {
            encodingArray[7] = 2;
        } else {
            encodingArray[7] = 3;
        }
    }

    //--------------------------------------------------CELL 8--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param primitive true if the name is primitive, false otherwise
     */
    private static void isNamePrimitive(int[] encodingArray, boolean primitive) {

        if (primitive) {
            encodingArray[8] = 1;
        } else {
            encodingArray[8] = 0;
        }
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param pronounType int in the range [2-7]:
     *                    2 = personal
     *                    3 = possessive
     *                    4 = indefinite
     *                    5 = relative
     *                    6 = demo
     *                    7 = numeral
     */
    private static void setPronounType(int[] encodingArray, int pronounType) {

        encodingArray[8] = pronounType;
    }

    //--------------------------------------------------CELL 9--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param alterationType an int in the range [0-4]:
     *                       0 = no alteration
     *                       1 = augmentative
     *                       2 = diminutive
     *                       3 = term of endearment
     *                       4 = derogatory
     */
    private static void setNameAlteration(int[] encodingArray, int alterationType) {

        encodingArray[9] = alterationType;
    }

    //--------------------------------------------------MIXED CELLS--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param degreeType int in range [0-12]:
     *                   0 = positive
     *                   1 = comparative majority
     *                   2 = comparative analysis of equality
     *                   3 = comparative minority
     *                   4 = absolute superlative degree
     *                   5 = relative superlative degree
     *                   6 = possessive
     *                   7 = demo
     *                   8 = indefinite
     *                   9 = numeral (cardinal)
     *                   10 = numeral (ordinal)
     *                   11 = interrogative
     *                   12 = exclamation
     */
    private static void setAdjectiveDegree(int[] encodingArray, int degreeType) {

        switch (degreeType) {

            case 0:
                encodingArray[5] = 2;
                break;

            case 1:
                encodingArray[5] = 3;
                break;

            case 2:
                encodingArray[5] = 4;
                break;

            case 3:
                encodingArray[5] = 5;
                break;

            case 4:
                encodingArray[5] = 6;
                break;

            case 5:
                encodingArray[5] = 7;
                break;

            case 6:
                encodingArray[6] = 0;
                break;

            case 7:
                encodingArray[6] = 1;
                break;

            case 8:
                encodingArray[6] = 2;
                break;

            case 9:
                encodingArray[6] = 3;
                break;

            case 10:
                encodingArray[6] = 4;
                break;

            case 11:
                encodingArray[7] = 4;
                break;

            case 12:
                encodingArray[7] =5;

        }
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param adverbType int in range [0-7]:
     *                   0 = mode
     *                   1 = time
     *                   2 = place
     *                   3 = quantity
     *                   4 = dubt
     *                   5 = affirmation
     *                   6 = denial
     *                   7 = adverbial term
     */
    private static void setAdverbCategory(int[] encodingArray, int adverbType) {

        switch (adverbType) {

            case 0:
                encodingArray[1] = 2;
                break;

            case 1:
                encodingArray[1] = 3;
                break;

            case 2:
                encodingArray[1] = 4;
                break;

            case 3:
                encodingArray[1] = 5;
                break;

            case 4:
                encodingArray[1] = 6;
                break;

            case 5:
                encodingArray[1] = 7;
                break;

            case 6:
                encodingArray[2] = 2;
                break;

            case 7:
                encodingArray[2] = 3;
                break;
        }
    }

    //--------------------------------------------------CATEGORY METHODS--------------------------------------------------//

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void makeArticleCoding(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {

        printIsDefinite(wordToAnalyze, chosenLanguage);
        int definite = KeyboardInputHandler.getIntInputFromKeyboard();
        isArticleDefinite(encodingArray, (definite == 1));

        printIsMale(wordToAnalyze, chosenLanguage);
        int male = KeyboardInputHandler.getIntInputFromKeyboard();
        isWordMale(encodingArray, (male == 1));

        printIsSingular(wordToAnalyze, chosenLanguage);
        int singular = KeyboardInputHandler.getIntInputFromKeyboard();
        isWordSingular(encodingArray, (singular == 1));

    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    public static void makeNameCoding(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {

        printIsPersonal(wordToAnalyze, chosenLanguage);
        boolean isPersonal = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNamePersonal(encodingArray, isPersonal);

        printWhichNameCategory(wordToAnalyze, chosenLanguage);
        int categoryType = KeyboardInputHandler.getIntInputFromKeyboard();

        while (!( 4 < categoryType && categoryType < 8)) {
            printInvalidNameCategoryChosen(chosenLanguage);
            printWhichNameCategory(wordToAnalyze, chosenLanguage);
            categoryType = KeyboardInputHandler.getIntInputFromKeyboard();
        }

        printIsMale(wordToAnalyze, chosenLanguage);
        boolean isMale = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isWordMale(encodingArray, isMale);

        printIsSingular(wordToAnalyze, chosenLanguage);
        boolean isSingular = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isWordSingular(encodingArray, isSingular);

        printIsNameConcrete(wordToAnalyze, chosenLanguage);
        boolean isConcrete = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNameConcrete(encodingArray, isConcrete);

        printIsNameComposed(wordToAnalyze, chosenLanguage);
        boolean isComposed = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNameComposed(encodingArray, isComposed);

        printIsNameCollective(wordToAnalyze, chosenLanguage);
        boolean isCollective = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNameCollective(encodingArray, isCollective);

        printIsNamePrimitive(wordToAnalyze, chosenLanguage);
        boolean isPrimitive = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNamePrimitive(encodingArray, isPrimitive);

        printSelectNameAlteration(wordToAnalyze, chosenLanguage);
        printNameAlterationsCategories(chosenLanguage);
        int selectedAlterationCategory = KeyboardInputHandler.getIntInputFromKeyboard();

        while ( selectedAlterationCategory < 0 || selectedAlterationCategory > 4 ) {
            printInvalidNameCategoryChosen(chosenLanguage);
            printNameAlterationsCategories(chosenLanguage);
            selectedAlterationCategory = KeyboardInputHandler.getIntInputFromKeyboard();
        }

    }

    //--------------------------------------------------PRINT METHODS--------------------------------------------------//

    /**
     * @param language in which to print the instructions:
     *                 ita = italian
     *                 en = english
     */
    private static void printInstructionsForAddWordGrammaticalAnalysis(String language) {

        switch (language) {

            case "ita":
                System.out.format("%s", "In base alle domande poste digitare:" +
                        "\n- 1 per rispondere 'Vero';" +
                        "\n- 0 per rispondere 'Falso'" +
                        "\n- Un numero corrispondente a una delle opzioni proposte.");
                break;

            case "en":
                System.out.format("%s" , "Based on the questions asked, type:" +
                        "\n- 1 to answer 'True'" +
                        "\n- 0 to answer 'False'" +
                        "\n - The corresponding number to one of the proposed options.");
                break;

            default:
                System.out.format("%s" , "Based on the questions asked, type:" +
                        "\n- 1 to answer 'True'" +
                        "\n- 0 to answer 'False'" +
                        "\n - The corresponding number to one of the proposed options.");
                break;

        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsMale(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s %s\n", wordToAnalyze, "è maschile?");
                break;

            case "en":
                System.out.format("%s %s\n", wordToAnalyze, "is male?");
                break;

            default:
                System.out.format("%s %s\n", wordToAnalyze, "is male?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsSingular(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s %s\n", wordToAnalyze, "è singolare?");
                break;

            case "en":
                System.out.format("%s %s\n", wordToAnalyze, "is singular?");
                break;

            default:
                System.out.format("%s %s\n", wordToAnalyze, "is singular?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsDefinite(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s %s\n", wordToAnalyze, "è determinativo?");
                break;

            case "en":
                System.out.format("%s %s\n", wordToAnalyze, "is definite?");
                break;

            default:
                System.out.format("%s %s\n", wordToAnalyze, "is definite?");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectWordCategory(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                printWordCategories();
                break;

            case "en":
                System.out.format("%s", "STRINGHE IN INGLESE ANCORA DA DEFINIRE");
                break;

                default:
                    System.out.format("%s", "STRINGHE IN INGLESE ANCORA DA DEFINIRE");
                    break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printInsertWord(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n", "Di che parola desideri fare l'analisi grammaticale? ");
                break;

            case "en":
                System.out.format("%s\n", "What word do you want to do the grammatical analysis?");
                break;

            default:
                System.out.format("%s\n", "What word do you want to do the grammatical analysis?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsPersonal(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è un nome proprio?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is a personal name?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is a personal name?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printWhichNameCategory(String wordToAnalyze, String chosenLanguage) {

        printNameCategories(chosenLanguage);

        switch (chosenLanguage) {

            case "ita":
                System.out.format("\n%s '%s' %s:\n\n ", "Categoria a cui la parola appartiene",  wordToAnalyze, "appartiene");
                break;

            case "en":
                System.out.format("\n%s '%s' %s:\n\n ", "Category to which the word",  wordToAnalyze, "belongs");
                break;

            default:
                System.out.format("\n%s '%s' %s:\n\n ", "Category to which the word",  wordToAnalyze, "belongs");
                break;
        }
    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printNameCategories(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("\n%s\n%s\n%s\n", "5 - Persona", "6 - Animale", "7 - Cosa");
                break;

            case "en":
                System.out.format("\n%s\n%s\n%s\n", "5 - Person", "6 - Animal", "7 - Thing");
                break;

            default:
                System.out.format("\n%s\n%s\n%s\n", "5 - Person", "6 - Animal", "7 - Thing");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsNameConcrete(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è concreto?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is concrete?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is concrete?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsNameComposed(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è composto?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is composed?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is composed?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsNameCollective(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è collettivo?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is collective?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is collective?");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsNamePrimitive(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è primitivo?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is primitive?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is primitive?");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printNameAlterationsCategories(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n%s\n%s\n%s\n%s\n\n", "0 - Nessuna alterazione", "1 - Accrescitivo", "2 - Diminutivo", "3 - Vezzeggiativo", "4 - Dispregiativo");
                break;

            case "en":
                System.out.format("%s\n%s\n%s\n%s\n%s\n\n", "0 - No alteration", "1 - Augmentative", "2 - Diminutive", "3 - Term of endearment", "4 - Derogatory");
                break;

            default:
                System.out.format("%s\n%s\n%s\n%s\n%s\n\n", "0 - No alteration", "1 - Augmentative", "2 - Diminutive", "3 - Term of endearment", "4 - Derogatory");
                break;
        }

    }

    /**
     * @param wordToAnalyze (object of the question)
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectNameAlteration(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s '%s': ", "Selezionare il tupo di alterazione della parola", wordToAnalyze);
                break;

            case "en":
                System.out.format("%s '%s': ", "Select the alteration type of the word", wordToAnalyze);
                break;

            default:
                System.out.format("%s '%s': ", "Select the alteration type of the word", wordToAnalyze);
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printInvalidNameCategoryChosen( String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("\n%s\n", "Categoria disponibile, scegliere un'alternativa valida");
                break;

            case "en":
                System.out.format("\n%s\n", "Category not available. Choose another category");
                break;

            default:
                System.out.format("\n%s\n", "Category not available. Choose another category");
                break;
        }

    }

}
