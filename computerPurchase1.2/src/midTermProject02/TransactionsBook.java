package midTermProject02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TransactionsBook {

    ArrayList<String> transactions = new ArrayList<>();


    //METHODS
    public void setTransactions(String situation, ArrayList<Integer> desiredComponents, Desktop desktopOBJ, Laptop laptopOBJ, CreditCard creditCardOBJ) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String dateTxt;
        String transaction;
        Interface interfaceOBJ = new Interface();

        switch (situation) {
            case "desktop":
                dateTxt = format.format(date);
                transaction = "--------------------[" + dateTxt +  "]--------------------"
                        + "\nRAM: " + desktopOBJ.ram.get(desiredComponents.get(0))
                        + " $" + desktopOBJ.ramPrice.get(desiredComponents.get(0))
                        + "\nCPU: " + desktopOBJ.cpu.get(desiredComponents.get(1))
                        + " $" + desktopOBJ.cpuPrice.get(desiredComponents.get(1))
                        + "\nGraphic: " + desktopOBJ.graphic.get(desiredComponents.get(2))
                        + " $" + desktopOBJ.graphicPrice.get(desiredComponents.get(2))
                        + "\nTower: " + desktopOBJ.tower.get(desiredComponents.get(3))
                        + " $" + desktopOBJ.towerPrice.get(desiredComponents.get(3))
                        + "\nMonitor: " + desktopOBJ.monitor.get(desiredComponents.get(4))
                        + " $" + desktopOBJ.monitorPrice.get(desiredComponents.get(4))
                        + "\nOp.System: " + desktopOBJ.operatingSystem.get(desiredComponents.get(5))
                        + "\n--------------------CREDIT CARD INFO--------------------"
                        + "\nNumb: " + creditCardOBJ.cardNumb
                        + "\nExp: " + creditCardOBJ.expTxt
                        + "\nCcv: " + creditCardOBJ.ccv
                        + "\nName: " + creditCardOBJ.cardName;
                transactions.add(transaction);
                break;
            case "laptop":
                transaction = String.valueOf(interfaceOBJ.displayInvoice("laptop", desiredComponents, null, laptopOBJ));
                break;
        }//end switch (situation)

    }

    public void getTransactions(ArrayList<String> transactions) {

        for (int i = 0; i < transactions.size() ; i++) {
            System.out.println("TRANSACTION N°" + (i + 1) + transactions.get(i));
            System.out.println();
        }
    }//end getTransactions

}//end TransactionsBook
