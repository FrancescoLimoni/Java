import java.util.Scanner;

public class Driver {

    public static void main (String args[]){

        String word = null;
        final String exit = "exit";
        int length;
        Character[] chars;
        Integer[] ascii;
        boolean isPalindrome;

        do {

            System.out.print("\nType a word or exit to quit: ");
                word = stringValidation(word);
                length = word.length();

            if (!word.equalsIgnoreCase(exit)) {

                chars = new Character[length];
                ascii = new Integer[length];

                chars = charsArray(word, length);
                ascii = asciiArray(chars, length);
                isPalindrome = palindrome(chars, ascii, length);

                getResult(isPalindrome);
            }

        }while(!word.equalsIgnoreCase(exit));

        System.out.println("Good Bye!");

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
    }//end

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

    private static Character[] charsArray(String word, int length){

        Character[] chars = new Character[length];
        length--;

        for (int i=0; i<=length; i++){
            chars[i] = word.charAt(length-i);
            //System.out.print("chars: " + chars[i] + " ");
        }

    return chars;
    }

    private static Integer[] asciiArray(Character[] chars, int lenght){

        Integer[] asciiArray = new Integer[lenght];

        for (int i=0; i < lenght; i++){
            asciiArray[i] = (int)chars[i];
        }

        return asciiArray;
    }

    private static Boolean palindrome(Character[] chars, Integer[] ascii, int length){

        int index=0;
        boolean isPalindrome = false;

        length--;

        if (index != length){

            if ((int)chars[index] == ascii[length]){
                isPalindrome = true;
                palindrome(chars, ascii, length);
            }else{
                isPalindrome = false;
            }

        }

        return isPalindrome;
    }

    public static void getResult(Boolean isPalindrome){

        if (isPalindrome == true){
            System.out.println("Result: the word is palindrome!");
        }else{
            System.out.println("Result: the word is not palindrome!");
        }

    }

}//end driver
