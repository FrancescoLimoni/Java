/*
    @author FrancescoLimoni

    Final project CSC160 Summer 2018
    simulate a vending machine software that keep tracks of date and time of any transaction occurred
*/

import java.util.Scanner;

public class VendingMachine {

    public static void main (String[] args){
        //LOCAL VARIABLES
        String choice;
        String pw;
        itemFields items = new itemFields();

        do {
            mainMenu();
            choice = stringValidity();

            switch (choice){
                case "buy":
                    System.out.println();
                    getViewItems(items);
                    buyItem(items);
                    break;
                case "view":
                    getViewItems(items);
                    break;
                case "admin":
                    System.out.print("Enter password: ");
                    do {
                        pw = stringValidity();

                        if (pw.matches("cancel")) {
                            break;
                        }else if(!pw.matches("admin")) {
                            getError("pw");
                        }

                    }while (!pw.matches("admin"));

                    if (pw.matches("admin")) {
                        adminMenu();
                        choice = stringValidity();
                    }

                    if (choice.equalsIgnoreCase("transactions")){
                        if (items.getItemTransaction().size() == 0) {
                                System.out.println("Transactions History Empty");
                        }else{
                            System.out.println("Transactions History");
                            for ( int i=0; i<items.itemTransaction.size(); i++)
                                System.out.println("#" + (i+1) + "\t" + items.getItemTransaction().get(i));
                        }
                    }//end if (choice = transactions)

                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    getError("invalid");
                    break;
            }
        }while(!choice.equalsIgnoreCase("exit"));

    }//end main

    //METHODS
    private static void mainMenu(){
        System.out.print("\nVENDING MACHINE MAIN MENU [ buy / view / admin / exit]: ");
    }

    private static void adminMenu() {
        System.out.print("\nADMIN MENU [ transactions / cancel ]: ");
    }

    private static void buyItem(itemFields items) {

        final int max = 5;
        int digit;
        int index;
        double amount = 0;
        double founds = 0;
        String choice;
        Integer[] selections = new Integer[max];
        Integer[] newInventory = new Integer[max];

        System.out.println();

        for (int i=0; i < max; i++) {

            System.out.print("Make a selection [0-" + items.itemName.size() + "]: ");
            digit = integerValidity();
            digit = validSelection(items.itemName.size(), digit, items);
            selections[i] = digit;
            System.out.println(items.getItemName().get(selections[i]) + " $" + items.getItemPrice().get(selections[i]));

            if (i == max-1){
                System.out.print("[ check cut / cancel]: ");
                choice = shoppingCheckOut("last");

                if (choice.equalsIgnoreCase("check out")){
                    index = i;
                    amount = reviewOrder(items, selections, index, amount);
                    System.out.print(" [ Pay / Cancel ]: ");
                    choice = stringValidity();
                    if (choice.equalsIgnoreCase("cancel")){
                        break;
                    }else if (choice.equalsIgnoreCase("pay")){
                        payProcess(amount, founds);
                        transactionRecord(index, items, selections);
                        break;
                    }

                }else if (choice.equalsIgnoreCase("cancel")){
                    System.out.println("Canceled Sale!");
                    break;
                }//end if (choice = check out)

            }else {
                System.out.print("[ keep shopping / check out / cancel ]: ");
                choice = shoppingCheckOut("notLast");

                if (choice.equalsIgnoreCase("check out")){
                    index = i;
                    amount = reviewOrder(items, selections, index, amount);
                    System.out.print(" [ Pay / Cancel ]: ");
                    choice = stringValidity();
                    if (choice.equalsIgnoreCase("cancel")){
                        break;
                    }else if (choice.equalsIgnoreCase("pay")){
                        payProcess(amount, founds);
                        transactionRecord(index, items, selections);
                        withdrawItem(index, items, selections, newInventory);
                        break;
                    }else{
                        System.out.println();
                    }

                } else if (choice.equalsIgnoreCase("cancel")){
                    System.out.println("Canceled Sale!");
                    break;
                }//end if(choice = "check out") - else if(choice = "keep shopping")
            }//end if (i = max-1)
        }//end for i loop

    }//end buyItem()

    private static String shoppingCheckOut(String opt) {
        String choice;
        choice = stringValidity();

        if (!choice.equalsIgnoreCase("keep shopping")) {
            if (!choice.equalsIgnoreCase("check out")) {
                if (!choice.equalsIgnoreCase("cancel")) {
                    getError("invalid");
                    choice = shoppingCheckOut(opt);
                }
            }
        }

        if (opt.equals("last")){
            if (!choice.equalsIgnoreCase("check out")) {
                if (!choice.equalsIgnoreCase("cancel"))
                getError("invalid");
                choice = shoppingCheckOut(opt);
            }
        }

        return choice;
    }

    private static void getViewItems(itemFields items){

        for (int i=0; i<items.itemName.size(); i++){
            System.out.println("["+items.getItemInventory().get(i)+"] #"+(i+1)+" "+items.getItemName().get(i)+" $"+items.getItemPrice().get(i));
        }
    }

    private static Double reviewOrder (itemFields items, Integer[] selections, Integer index, Double amount){

        System.out.println("\nYOUR SELECTIONS:");

        for (int i=0; i <= index; i++){
            System.out.println("#" + (i+1) + "\t" + items.getItemName().get(selections[i]) + " $" + items.getItemPrice().get(selections[i]));
            amount += items.getItemPrice().get(selections[i]);
        }//end for j loop

        System.out.print("Your amount due: $");
        System.out.printf("%.2f", amount);

        return amount;
    }

    private static void payProcess (Double amount, Double founds){

        do {
            System.out.print("Insufficient founds enter money ($");
            System.out.printf("%.2f", (amount - founds));
            System.out.print("): $");
            founds += doubleValidity();
        } while (founds < amount);

        founds -= amount;
        System.out.println("Successful Payment!");
        System.out.print("Return of $");
        System.out.printf("%.2f", founds);
        System.out.println();

    }

    private static void transactionRecord (Integer index, itemFields items, Integer[] selections){

        for (int i = 0; i <= index; i++) {
            items.setTransaction(items.getItemName().get(selections[i]), items.getItemPrice().get(selections[i]));
        }

    }

    private static void withdrawItem (Integer index, itemFields items, Integer[] selections, Integer[] newInventory){

        int digit;

        for (int i=0; i <= index; i++){
            newInventory[i] = items.itemInventory.get(selections[i]);
            digit = newInventory[i];
            digit--;
            newInventory[i] = digit;
            items.itemInventory.set(selections[i], digit);
        }
    }

    private static String stringValidity() {

        String test;
        Scanner input = new Scanner(System.in);

        if (!(input.hasNext() || input.hasNextLine())){
            getError("number");
            input.next();
            test = stringValidity();
        }else{
            test = input.nextLine();
        }

        return test;
    }//end stringValidity()

    private static Integer integerValidity() {

        int test;
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()){
            getError("string");
            input.next();
            test = integerValidity();
        }else{
            test = input.nextInt();
            test--;
        }

        return test;
    }

    private static Double doubleValidity() {
        double test;
        Scanner input = new Scanner(System.in);

        if (!input.hasNextDouble()){
            getError("string");
            input.next();
            test = integerValidity();
        }else{
            test = input.nextDouble();
        }

        return test;
    }

    private static Integer validSelection(Integer sizeArray, Integer digit, itemFields items) {

        if (digit > sizeArray){
            getError("invalid");
            digit = integerValidity();
            digit = validSelection(sizeArray, digit, items);
        }else{
            if (items.itemInventory.get(digit) == 0) {
                getError("noMore");
                digit = integerValidity();
                digit = validSelection(sizeArray, digit, items);
            }
        }

        return  digit;
    }

    private static void getError(String opt) {

        switch (opt){
            case "invalid":
                System.err.print("Error, invalid choice, try again: ");
                break;
            case "string":
                System.err.print("Error, do not type a string, try again: ");
                break;
            case "number":
                System.err.print("Error, do not type a number, try again: ");
                break;
            case "pw":
                System.err.print("Error, password incorrect, try again [cancel]: ");
                break;
            case "noMore":
                System.err.print("Error, item selected is not present, try again [cancel]: ");
                break;

        }
    }

}//end vendingMachine
