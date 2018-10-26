import java.util.Scanner;

public class Drive {

    public static void main (String[] args){

        int max;
        int convertedString;
        String word = null;
        Integer[] ascii;
        boolean matched = false;
        boolean check = false;

        do {

            System.out.print("\nType a word or exit to quit:  ");
                word = stringValidation(word);
                max = word.length();

            ascii = asciiConverter(word);
            convertedString = asciiSummed(ascii, max);

            if (convertedString != 442) {

                Character[] flippedWord;
                flippedWord = flipWord(word, max);

                System.out.println();
                printFlippedWord(flippedWord, max);

                System.out.println();
                check = isPalindrome(word, flippedWord, (max - 1), check);
                printResult(check);

            } else {

                System.out.println("Good Bye");
            }

        }while (convertedString != 442);

    }//end main

    //METHODS
    public static String stringValidation(String test){

        Scanner input = new Scanner(System.in);


        if (input.hasNextDouble() || input.hasNextInt() || input.hasNextFloat()){

            getError("string");
            input.next();
            stringValidation(test);

         }else{

            test = input.nextLine();

        }

        return test;
    }//end stringValidation

    public static void getError(String opt){

        switch (opt){
            case "string":
                System.err.print("Do not type a number, please try again: ");
            break;
            case "number":
                System.err.print("Do not type a string, please try again: ");
            break;
            default:
                System.err.print("Invalid selection, please try again: ");
            break;

        }//end switch
    }//end getError

    public static Character[] flipWord(String word, int max){

        Character[] flippedWord = new Character[max];

        max--;

        for (int i = max; i >= 0; i-- ){
            flippedWord[(max-i)] = word.charAt(i);
        }

        return flippedWord;
    }//end flipWord

    public static void printFlippedWord(Character[] flippedWord, int max){

        System.out.printf( "%29s", "Flipped word:  ");

        for (int i=0; i < max; i++)
            System.out.print(flippedWord[i]);
    }//end printFlippedWord

    public static Boolean isPalindrome(String word, Character[] flippedWord, int index, boolean check) {

        if (index != 0){

            if (word.charAt(index) == flippedWord[index]) {
                index--;
                check = true;
                isPalindrome(word, flippedWord, index, check);
            }else{
                check = false;
            }

        }else{
            check = true;
        }//end if(index != 0)

        return check;
    }//end isPalindrome

    public static void printResult(Boolean check){

        if (check == true){
            System.out.printf("%52s", "Result:  is a palindrome word!\n");
        }else{
            System.out.printf("%55s", "Result:  is not a palindrome word!\n");
        }
    }

    private static Integer[] asciiConverter(String word){

        int length;
        Character[] chars;
        Integer[] ascii;

        length = word.length();
        chars = new Character[length];
        ascii = new Integer[length];

        for (int i=0; i<length; i++){
            chars[i] = word.charAt(i);
            ascii[i] = (int)chars[i];
        }

        return ascii;
    }

    private static Integer asciiSummed(Integer[] ascii, int max){

        int numb = 0;

        for (int i=0; i < max; i++)
            numb += ascii[i];


        return numb;
    }

    /*private static Boolean asciiMatched(Integer[] ascii, String word, int max){

        boolean isMatched = false;

        for (int i=0; i<max; i++){

            if(ascii[i] != (int)word.charAt(i)){

                isMatched = false;

            }else{

                isMatched = true;

            }//end if loop
        }//end for loop

        return isMatched;

    }//end asciiMatched
    */

}//end Drive
