/*
    Francesco Limoni

    Description:
    take in input name & surname and run a validity check
    take in input how many test would like calculate
    take in input tests score (base on the previous step)
    calculate the average and assign appropriate letter
    display the result
    take in input decision (what start over?)

 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Var
        String name;
        String surname;
        String decision;
        double testNumb;
        double grade;
        char letter = 'F';


        System.out.printf("%S", "\ntest average program\n");

        do {

            //name & surname and validation.
            System.out.print("Type your name: ");
            name = stringValidate();
            System.out.print("Type your surname: ");
            surname = stringValidate();

            //how many test and validity, average score and validity.
            System.out.print(name.charAt(0) + ". " + surname + " how many tests to calculate? ");
            testNumb = doubleValidate();
            grade = averageCalc(testNumb);

            if (grade >= 90) {
                letter = 'A';
                grade = 100;
            } else if (grade >= 80) {
                letter = 'B';
            } else if (grade >= 70) {
                letter = 'C';
            } else if (grade >= 60) {
                letter = 'D';
            }//if-else if grade

            System.out.println("\n" + name.charAt(0) + ". " + surname + " your final grade is: " + grade + "% (" + letter + ") ");
            System.out.print("Do you want to start over? [Y/N] ");
            decision = stringValidate();
            System.out.println();

        }while(!(decision.equalsIgnoreCase("no")));

        System.out.printf("%S", "good bye");
    }

    //methods
    public static String stringValidate() {
        //Var
        Scanner input = new Scanner(System.in);
        String word = null;
        boolean isVerify = false;

        do {

            if (input.hasNextDouble() == true){
                System.err.printf("%S", "error. Please try again: ");
                input.next();//empty the scanner to avoid infinite loop
            }else{
                word = input.next();
                isVerify = true;
            }

        }while (isVerify == false);

    return word;

    }//stringValidation
    public static Double doubleValidate(){
        //Var
        Scanner input = new Scanner(System.in);
        double numb = 0;
        boolean isVerify = false;

        do{

            if (input.hasNextDouble() == true){
                numb = input.nextDouble();
                isVerify = true;
            }else{
                System.err.printf("%S", "error. Please try again: ");
                input.next();//empty the scanner to avoid infinite loop
            }

        }while (isVerify == false);


    return numb;
    }//doubleValidity
    public static Double averageCalc(double count){
        //Var
        Scanner input = new Scanner(System.in);
        double average = 0;

        System.out.println();

        for (int i = 0; i < count; i++){
            System.out.print("Enter your #" + (i+1) + " score: ");

            if (input.hasNextDouble() == true){
                average += input.nextDouble();
            }else{
                System.err.printf("%S", "error. Please type a number\n");
                input.next();//empty the scanner to avoid infinite loop
                i--;
            }//if-else input.hasNextDouble()
        }//for

        average /= count;

    return  average;
    }//averageCalc

}//class Main
