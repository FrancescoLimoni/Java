/*
    with ArrayList we do not need to provide how large the array must be.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreArrayList {

    public static void main (String[] args){
        int choice;
        boolean startOver;
        Scanner input = new Scanner(System.in);
        ArrayList<Double> testScore = new ArrayList<Double>();

        do {
            System.out.print("MENU type [1 to add, 2 to promp]: ");
            choice = input.nextInt();

            if (choice == 1){
                System.out.print("Add your test score: ");
                testScore.add(numbValidity());
            }else if (choice == 2){
                for (int i = 0; i<testScore.size(); i++){
                    System.out.print("\nYour test #" + (i+1) + " is: " + testScore.indexOf(i));
                }
            }

            System.out.print("\nDo you want continue? [y/n]: ");
             if (input.nextInt() == 1){
                 startOver = true;
             }else{
                 startOver = false;
             }


        }while(startOver == true);

    }//end main

    //methods
    public static String stringValidity(){
        Scanner input = new Scanner(System.in);
        String test = null;
        boolean startOver;

        do {
            if (input.hasNextLine()){
                test = input.nextLine();
                startOver = false;
            }else{
                System.out.print("error, do not type a number.");
                System.out.print("\nTry again: ");
                input.nextLine();
                startOver = true;
            }

        }while(startOver == true);

        return test;
    }
    public static Double numbValidity(){
        Scanner input = new Scanner(System.in);
        double test = 0;
        boolean startOver;

        do {
            if (input.hasNextDouble()){
                test = input.nextDouble();
                startOver = false;
            }else{
                System.out.print("error, do not type a letter.");
                System.out.print("\nTry again: ");
                input.next();
                startOver = true;
            }

        }while(startOver == true);

        return test;
    }

}//ScoreArrayList

