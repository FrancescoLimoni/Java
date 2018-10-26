package midTermProject02;

import java.util.ArrayList;
import java.util.Date;

public class Driver {
    public static void main(String[] args) throws Exception {

        //VARIABLES
        long cardNumb;
        int cardMonth;
        int cardYear;
        String expTxt;
        Double totalPrice;
        int ccv;
        String cardName;
        int userDecision;
        int buildMenuDecision;
        CreditCard creditCardOBJ;
        Laptop laptopOBJ = new Laptop();
        Desktop desktopOBJ = new Desktop();
        Interface interfaceOBJ = new Interface();
        Controller controllerOBJ = new Controller();
        ArrayList<Integer> desiredComponents = new ArrayList<>();
        TransactionsBook transactionsBookOBJ = new TransactionsBook();

        System.out.printf("%S", "\nbuild your computer processing...\n");

        do {
            interfaceOBJ.displayMainMenu();
            userDecision = controllerOBJ.isInteger(1, 4);

            switch (userDecision) {
                case 1:
                    interfaceOBJ.displayBuildMenu();
                    buildMenuDecision = controllerOBJ.isInteger(1, 2);

                    switch (buildMenuDecision) {
                        case 1:
                            //LAPTOP SECTION
                            interfaceOBJ.displayInventory(1);
                            desiredComponents = interfaceOBJ.getDesiredComponents(1);
                            System.out.println();
                            System.out.printf("%20s", "INVOICE\n");
                            totalPrice = interfaceOBJ.displayInvoice("laptop", desiredComponents, desktopOBJ, laptopOBJ);
                            interfaceOBJ.displayCheckoutMenu();
                            userDecision = Controller.isInteger(null, null);

                            if (userDecision == 1){
                                System.out.println("\nCREDIT CARD SECTION");
                                System.out.print("Credit card number: ");
                                cardNumb = controllerOBJ.isLong();
                                System.out.print("Expiration month: ");
                                cardMonth = controllerOBJ.isInteger(0, 12);
                                System.out.print("Expiration year: ");
                                cardYear = controllerOBJ.isInteger(0, null);
                                expTxt = controllerOBJ.isDate(cardMonth, cardYear);
                                System.out.print("CCV: ");
                                ccv = controllerOBJ.isInteger(0, 999);
                                System.out.print("Name: ");
                                cardName = controllerOBJ.isString();
                                creditCardOBJ = new CreditCard(cardNumb, expTxt, ccv, cardName);
                                transactionsBookOBJ.setTransactions("laptop", desiredComponents, null, laptopOBJ, creditCardOBJ);
                                System.out.println("\nTRANSACTION EXECUTED...\n");
                            }else{
                                System.out.println("Payment canceled...");
                            }
                            break;
                        case 2:
                            //DESKTOP SECTION
                            interfaceOBJ.displayInventory(2);
                            desiredComponents = interfaceOBJ.getDesiredComponents(2);
                            System.out.println();
                            System.out.printf("%20s", "INVOICE\n");
                            totalPrice = interfaceOBJ.displayInvoice("desktop", desiredComponents, desktopOBJ, laptopOBJ);
                            interfaceOBJ.displayCheckoutMenu();
                            userDecision = Controller.isInteger(null, null);

                            //CREDIT CARD INFO
                            if (userDecision == 1){
                                System.out.println("\nCREDIT CARD SECTION");
                                System.out.print("Credit card number: ");
                                cardNumb = controllerOBJ.isLong();
                                System.out.print("Expiration month: ");
                                cardMonth = controllerOBJ.isInteger(0, 12);
                                System.out.print("Expiration year: ");
                                cardYear = controllerOBJ.isInteger(0, null);
                                expTxt = controllerOBJ.isDate(cardMonth, cardYear);
                                System.out.print("CCV: ");
                                ccv = controllerOBJ.isInteger(0, 999);
                                System.out.print("Name: ");
                                cardName = controllerOBJ.isString();
                                creditCardOBJ = new CreditCard(cardNumb, expTxt, ccv, cardName);
                                transactionsBookOBJ.setTransactions("desktop", desiredComponents, desktopOBJ, null, creditCardOBJ);
                                System.out.println("\nTRANSACTION EXECUTED...\n");
                            }else{
                                System.out.println("Payment canceled...");
                            }
                            break;
                        default:
                            System.out.println("Error: Invalid selection!\n");
                            break;
                    }//end switch (buildMenuDecision)
                    break;
                case 2:
                    System.out.println("\nInventory section\n");
                    interfaceOBJ.displayInventory(2);
                    break;
                case 3:
                    System.out.println("\nTransactions history");
                    transactionsBookOBJ.getTransactions(transactionsBookOBJ.transactions);
                    break;
                case 4:
                    System.out.print("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: Invalid selection!\n");
                    break;
            }//end switch(userDecision)

        }while (userDecision != 4);

    }//end main


}//end Driver