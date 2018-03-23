package WordAnalysis;

import File.KeyboardInputHandler;

public class ClassificatoreECodificatoreParole {

    private static final int maxGrammaticalAnalysisFieldNumber = 10;

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     * @return a valid number of word category ( such that 0<n<10 )
     */
    private static int getWordCategory(String chosenLanguage) {

        System.out.format("Categorie possibili:\n");
        printSelectWordCategory(chosenLanguage);
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

    /**
     @param chosenLanguage:
      *                    ita = italiano
      *                    en = english
      *                    default = english
     * @return an array that represent the grammatical analysis of an input word given by the user
     *         (based on the rules contained in the file 'Struttura analisi grammaticale.pdf')
     */
    public static int[] doWordGrammaticalAnalysis(String chosenLanguage) {

        printInsertWord(chosenLanguage);

        String wordToAnalyze = KeyboardInputHandler.getStringInputFromKeyboard();

        printInstructionsForAddWordGrammaticalAnalysis(chosenLanguage);

        int[] encodingArray = new int[maxGrammaticalAnalysisFieldNumber];

        for (int i=0; i<encodingArray.length; i++) {
            encodingArray[i] = 0;
        }

        int wordCategory = getWordCategory(chosenLanguage);
        setWordCategory(encodingArray, wordCategory);

        switch (wordCategory) {

            case 1:
                // Verbo
                break;

            case 2:
                makeArticleCoding(encodingArray, wordToAnalyze, chosenLanguage);
                break;

            case 3:
                makeNameCoding(encodingArray, wordToAnalyze, chosenLanguage);
                break;

            case 4:
                makePronounCoding(encodingArray, wordToAnalyze, chosenLanguage);
                break;

            case 5:
                makeAdjectiveCoding(encodingArray, wordToAnalyze, chosenLanguage);
                break;

            case 6:
                makePrepositionCoding(encodingArray, chosenLanguage);
                break;

            case 7:
                // Congiunzione
                break;

            case 8:
                makeAdverbCoding(encodingArray, chosenLanguage);
                break;

            case 9:
                // Esclamazione
                break;

            default:
                // Caso di default da definire
                break;
        }

        return encodingArray;

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
    private static void makeNameCoding(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {

        printIsPersonal(wordToAnalyze, chosenLanguage);
        boolean isPersonal = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isNamePersonal(encodingArray, isPersonal);

        printWhichNameCategory(wordToAnalyze, chosenLanguage);
        printSelectNameCategories(chosenLanguage);
        int categoryType = KeyboardInputHandler.getIntInputFromKeyboard();

        while (!( 4 < categoryType && categoryType < 8)) {
            printInvalidCategoryChosen(chosenLanguage);
            printWhichNameCategory(wordToAnalyze, chosenLanguage);
            printSelectNameCategories(chosenLanguage);
            categoryType = KeyboardInputHandler.getIntInputFromKeyboard();
        }

        setNameCategory(encodingArray, categoryType);

        getAndSetWordGender(encodingArray, wordToAnalyze, chosenLanguage);

        getAndSetWordPlurality(encodingArray, wordToAnalyze, chosenLanguage);

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
            printInvalidCategoryChosen(chosenLanguage);
            printNameAlterationsCategories(chosenLanguage);
            selectedAlterationCategory = KeyboardInputHandler.getIntInputFromKeyboard();
        }

        setNameAlteration(encodingArray, selectedAlterationCategory);

    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage: {ita, en}
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void getAndSetWordPlurality(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {
        printIsSingular(wordToAnalyze, chosenLanguage);
        boolean isSingular = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isWordSingular(encodingArray, isSingular);
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void makePronounCoding(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {

        getAndSetWordGender(encodingArray, wordToAnalyze, chosenLanguage);

        getAndSetWordPlurality(encodingArray, wordToAnalyze, chosenLanguage);

        printPronounCategories(chosenLanguage);
        printSelectCategoryPronoun(chosenLanguage);
        int pronounCategory = KeyboardInputHandler.getIntInputFromKeyboard();

        while (!( 1 < pronounCategory && pronounCategory < 8)) {
            printInvalidCategoryChosen(chosenLanguage);
            printPronounCategories(chosenLanguage);
            printSelectCategoryPronoun(chosenLanguage);
            pronounCategory = KeyboardInputHandler.getIntInputFromKeyboard();
        }

        setPronounType(encodingArray, pronounCategory);
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void getAndSetWordGender(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {
        printIsMale(wordToAnalyze, chosenLanguage);
        boolean isMale = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isWordMale(encodingArray, isMale);
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param wordToAnalyze object of the current analysis
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void makeAdjectiveCoding(int[] encodingArray, String wordToAnalyze, String chosenLanguage) {

        getAndSetWordGender(encodingArray, wordToAnalyze, chosenLanguage);

        getAndSetWordPlurality(encodingArray, wordToAnalyze, chosenLanguage);

        printIsAdjectiveDefinite(wordToAnalyze, chosenLanguage);
        boolean isAdjectiveDefinite = KeyboardInputHandler.getIntInputFromKeyboard() == 1;
        isAdjectiveDefinite(encodingArray, isAdjectiveDefinite);

        printPossibleAdjectiveDegrees(chosenLanguage);
        int adjectiveType = KeyboardInputHandler.getIntInputFromKeyboard();
        printSelectAdjectiveType(chosenLanguage);

        while (adjectiveType < 0 || adjectiveType > 12) {
            printInvalidCategoryChosen(chosenLanguage);
            printPossibleAdjectiveDegrees(chosenLanguage);
            adjectiveType = KeyboardInputHandler.getIntInputFromKeyboard();
            printSelectAdjectiveType(chosenLanguage);
        }

        setAdjectiveDegree(encodingArray, adjectiveType);
    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void makePrepositionCoding(int[] encodingArray, String chosenLanguage) {

        printIsPrepositionSimple(chosenLanguage);
        boolean isPrepositionSimple = KeyboardInputHandler.getIntInputFromKeyboard()==1;
        isPrepositionSimple(encodingArray, isPrepositionSimple);

    }

    /**
     * @param encodingArray an array (composed of 10 items) that memorizes the grammatical analysis of a word
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      (default = english)
     */
    private static void makeAdverbCoding(int[] encodingArray, String chosenLanguage) {

        printSelectAdverbCategory(chosenLanguage);
        printAdverbCategories(chosenLanguage);
        int adverbCategorySelected = KeyboardInputHandler.getIntInputFromKeyboard();

        while (adverbCategorySelected < 0 || adverbCategorySelected > 7) {

            printInvalidCategoryChosen(chosenLanguage);
            printSelectAdverbCategory(chosenLanguage);
            printAdverbCategories(chosenLanguage);
            adverbCategorySelected = KeyboardInputHandler.getIntInputFromKeyboard();
        }

        setAdverbCategory(encodingArray, adverbCategorySelected);

    }

    /**
     * @param encodingArray the array that contains the values obtained from the grammatical analysis of a word
     * @return a two-way integer that represents the grammatical analysis of a particular word
     */
    public static long obtainValueOfGrammaticalAnalysisEncoding(int[] encodingArray) {

        double result = 0;

        for (int i=0; i<encodingArray.length; i++) {
            result = result + encodingArray[i] * Math.pow(10, encodingArray.length - 1 - i);
        }

        return (long) result;

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
                        "\n- Un numero corrispondente a una delle opzioni proposte.\n\n");
                break;

            case "en":
                System.out.format("%s" , "Based on the questions asked, type:" +
                        "\n- 1 to answer 'True'" +
                        "\n- 0 to answer 'False'" +
                        "\n - The corresponding number to one of the proposed options.\n\n");
                break;

            default:
                System.out.format("%s" , "Based on the questions asked, type:" +
                        "\n- 1 to answer 'True'" +
                        "\n- 0 to answer 'False'" +
                        "\n - The corresponding number to one of the proposed options\n\n.");
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

        switch (chosenLanguage) {

            case "ita":
                System.out.format("\n%s '%s' %s:\n ", "Categoria a cui la parola", wordToAnalyze, "appartiene");
                break;

            case "en":
                System.out.format("\n%s '%s' %s:\n ", "Category to which the word",  wordToAnalyze, "belongs");
                break;

            default:
                System.out.format("\n%s '%s' %s:\n ", "Category to which the word",  wordToAnalyze, "belongs");
                break;
        }
    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectNameCategories(String chosenLanguage) {

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
                System.out.format("%s '%s': \n\n", "Selezionare il tipo di alterazione della parola", wordToAnalyze);
                break;

            case "en":
                System.out.format("%s '%s': \n\n", "Select the alteration type of the word", wordToAnalyze);
                break;

            default:
                System.out.format("%s '%s': \n\n", "Select the alteration type of the word", wordToAnalyze);
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printInvalidCategoryChosen(String chosenLanguage) {

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

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printPronounCategories(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n\n%s\n%s\n%s\n%s\n%s\n%s\n", "Selezionare il tipo di pronome", "2 - Personale",
                        "3 - Possessivo", "4 - Indefinito", "5 - Relativo", "6 - Dimostrativo", "7 - Numerale");
                break;

            case "en":
                System.out.format("%s\n\n%s\n%s\n%s\n%s\n%s\n%s\n", "Select the pronoun type", "2 - Personal",
                        "3 - Possessive", "4 - Indefinite", "5 - Relative", "6 - Demo", "7 - Numeral");
                break;

            default:
                System.out.format("%s\n\n%s\n%s\n%s\n%s\n%s\n%s\n", "Select the pronoun type", "2 - Personal",
                        "3 - Possessive", "4 - Indefinite", "5 - Relative", "6 - Demo", "7 - Numeral");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectCategoryPronoun(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s: ", "Categoria del pronome");
                break;

            case "en":
                System.out.format("%s: ", "Pronoun category type");
                break;

            default:
                System.out.format("%s: ", "Pronoun category type");
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
    private static void printIsAdjectiveDefinite(String wordToAnalyze, String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("'%s' %s\n", wordToAnalyze, "è qualificativo?");
                break;

            case "en":
                System.out.format("'%s' %s\n", wordToAnalyze, "is definite?");
                break;

            default:
                System.out.format("'%s' %s\n", wordToAnalyze, "is definite?");
                break;
        }
    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printPossibleAdjectiveDegrees(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        "0 - Positivo", "1 - Comparativo di maggioranza", "2 - Comparativo di uguaglianza",
                        "3 - Comparativo di minoranza", "4 - Superlativo relativo", "5 - Superlativo assoluto",
                        "6 - Possessivo", "7 - Dimostrativo", "8 - Indefinito", "9 - Numerale cardinale",
                        "10 - Numerale ordinale", "11 - Esclamativo", "12 - Interrogativo");
                break;

            case "en":
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        "0 - Positive", "1 - Comparative majority", "2 - Comparative analysis of equality",
                        "3 - Comparative minority", "4 - Relative superlative\n", "5 - Absolute superlative\n",
                        "6 - Possessive", "7 - Demo", "8 - Indefinite", "9 - Numeral cardinal",
                        "10 - Numeral ordinal", "11 - Exclamation", "12 - Interrogative");
                break;

            default:
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        "0 - Positive", "1 - Comparative majority", "2 - Comparative analysis of equality",
                        "3 - Comparative minority", "4 - Relative superlative\n", "5 - Absolute superlative\n",
                        "6 - Possessive", "7 - Demo", "8 - Indefinite", "9 - Numeral cardinal",
                        "10 - Numeral ordinal", "11 - Exclamation", "12 - Interrogative");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectAdjectiveType(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s \n", "Qual'è il tipo dell'aggettivo?");
                break;

            case "en":
                System.out.format("%s \n", "What is the adjective type?");
                break;

            default:
                System.out.format("%s \n", "What is the adjective type?");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printIsPrepositionSimple(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s \n", "La preposizione è semplice");
                break;

            case "en":
                System.out.format("%s \n", "Is the preposition simple?");
                break;

            default:
                System.out.format("%s \n", "Is the preposition simple?");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printAdverbCategories(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "0 - Modo", "1 - Tempo", "2 - Luogo", "3 - Quantità",
                        "4 - Dubbio", "5 - Affermazione", "6 - Negazione", "7 - Locuzione avverbiale");
                break;

            case "en":
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "0 - Mode", "1 - Time", "2 - Place", "3 - Quantity",
                        "4 - Dubt", "5 - Affirmation", "6 - Denial", "7 - Adverbial place");
                break;

            default:
                System.out.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "0 - Mode", "1 - Time", "2 - Place", "3 - Quantity",
                        "4 - Dubt", "5 - Affirmation", "6 - Denial", "7 - Adverbial place");
                break;
        }

    }

    /**
     * @param chosenLanguage:
     *                      ita = italian
     *                      en = english
     *                      default = english
     */
    private static void printSelectAdverbCategory(String chosenLanguage) {

        switch (chosenLanguage) {

            case "ita":
                System.out.format("%s\n", "A che tipo di categoria appartiene l'avverbio?");
                break;

            case "en":
                System.out.format("%s\n", "What type of category the adverb belongs to");
                break;

            default:
                System.out.format("%s\n", "What type of category the adverb belongs to");
                break;
        }

    }

}