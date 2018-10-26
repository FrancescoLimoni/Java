import java.util.Scanner;

public class Driver {

        public static void main(String[] args) {
            //Var
            Scanner input = new Scanner(System.in);
            String word;
            String decision;
            int lenght;
            boolean palindrome = false;

            System.out.print(" - - - - PALINDROME PROGRAM - - - - \n");

            do {
                //Take user input into word with space
                System.out.printf("%22s", "Type a word: ");
                word = input.nextLine();
                //Get rid of space comma and dot
                word = word.replaceAll(" ", "");
                //Take word lenght after been trimmed & decrease it by 1
                lenght = word.length();
                lenght--;

                for (int i = 0; i <= lenght; i++) {

                    if ((word.charAt(i)) == word.charAt(lenght)) {
                        palindrome = true;
                        lenght--;
                    } else{
                        System.out.printf("%22s", "Your word is not palindrome");
                        //System.out.println("Your word is not palindrome");
                        palindrome = false;
                        break;
                    }//end if.
                }//end for.

                if (palindrome){
                    System.out.printf("%20s", "Your word is palindrome");
                    //System.out.println("Your word is palindrome");
                }

                System.out.print("\nDo you want to compare another word? [yes/no] ");
                decision = input.nextLine();

            }while(decision.equals("yes"));//end do.

            System.out.print("- - - PALINDROME PROGRAM ENDED - - -\n");
        }//end main
}//end Driver
