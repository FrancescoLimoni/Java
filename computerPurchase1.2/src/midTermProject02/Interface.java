package midTermProject02;
import java.util.ArrayList;

public class Interface {

    Controller controllerOBJ = new Controller();

    //METHODS
    public void displayMainMenu() {
        System.out.printf("%S", "[ 1) build a computer 2) view inventory 3) transactions 4) exit ] ");
    }//end displayMainMenu()

    public void displayBuildMenu() {

        System.out.printf("%S", "[ 1) laptop 2) desktop ] ");

    }//end displayBuildMenu()

    public void displayCheckoutMenu() {
        System.out.print("Proceed with the purchase [ 1) Check-out 2) Cancel ] ");
    }

    public void displayInventory(Integer situation) {

        Desktop desktopOBJ = new Desktop();
        Laptop laptopOBJ = new Laptop();

        switch (situation) {
            case 1:

                if (laptopOBJ.ram.size() == 0){
                    System.out.println("Inventory empty");
                }else {
                    System.out.format("\n%11s %13s %7s %17s %16s %13s %12s %18s %10s %15s %8s\n", "[RAM]", "[PRICE] |", "[CPU]", "[PRICE] |", "[GRAPHIC BOARD]", "[PRICE] |", "[TOWER]", "[PRICE] |", "[MONITOR]", "[PRICE] |", "[OPERATING SYSTEM]");
                    for (int i = 0; i < laptopOBJ.ram.size(); i++) {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
                                + "[" + (i + 1) + "]  " + laptopOBJ.ram.get(i) + "   $" + laptopOBJ.ramPrice.get(i)
                                + " | " + laptopOBJ.cpu.get(i) + "   $" + laptopOBJ.cpuPrice.get(i)
                                + " | " + laptopOBJ.graphic.get(i) + "   $" + laptopOBJ.graphicPrice.get(i)
                                + " | " + laptopOBJ.operatingSystem.get(i));
                    }//end for loop
                    System.out.println();
                }//end if-else
            break;
            case 2:
                System.out.format("\n%11s %13s %7s %17s %16s %13s %12s %18s %10s %15s %8s\n", "[RAM]", "[PRICE] |", "[CPU]", "[PRICE] |", "[GRAPHIC BOARD]", "[PRICE] |", "[TOWER]", "[PRICE] |", "[MONITOR]", "[PRICE] |", "[OPERATING SYSTEM]");
                for (int i = 0; i < desktopOBJ.ram.size(); i++) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
                            + "[" + (i + 1) + "]  " + desktopOBJ.ram.get(i) + "   $" + desktopOBJ.ramPrice.get(i)
                            + " | " + desktopOBJ.cpu.get(i) + "   $" + desktopOBJ.cpuPrice.get(i)
                            + " | " + desktopOBJ.graphic.get(i) + "   $" + desktopOBJ.graphicPrice.get(i)
                            + " | " + desktopOBJ.tower.get(i) + "   $" + desktopOBJ.towerPrice.get(i)
                            + " | " + desktopOBJ.monitor.get(i) + "   $" + desktopOBJ.monitorPrice.get(i)
                            + " | " + desktopOBJ.operatingSystem.get(i));
                }//end for loop
                System.out.println();
            break;
            default:
                System.out.println("Error: Invalid selection");
            break;
        }//end switch(situation)

    }//end displayInventory()

    public ArrayList<Integer> getDesiredComponents(Integer situation) {

        int numb;
        ArrayList<Integer> desiredComponents = new ArrayList<>();

        System.out.print("Desired RAM: ");
        numb = controllerOBJ.isInteger(1, 4);
        desiredComponents.add(numb-1);

        System.out.print("Desired CPU: ");
        numb = controllerOBJ.isInteger(1,4);
        desiredComponents.add(numb-1);

        System.out.print("Desired Graphic: ");
        numb = controllerOBJ.isInteger(1,4);
        desiredComponents.add(numb-1);

        if (situation == 2){
            System.out.print("Desired Tower: ");
            numb = controllerOBJ.isInteger(1,4);
            desiredComponents.add(numb-1);

            System.out.print("Desired Monitor: ");
            numb = controllerOBJ.isInteger(1,4);
            desiredComponents.add(numb-1);
        }

        System.out.print("Desired Operating System: ");
        numb = controllerOBJ.isInteger(1,4);
        desiredComponents.add(numb-1);

        return desiredComponents;
    }//end getDesiredComponents()

    public double displayInvoice(String situation, ArrayList<Integer> desiredComponents, Desktop desktopOBJ, Laptop laptopOBJ) {

        Double totalPrice = 0.0;

        if (situation.equals("laptop")) {
            //LAPTOP SECTION
        }else if (situation.equals("desktop")) {
            System.out.println("----------------------------------");
            System.out.print("[" + 1 + "] ");
            System.out.format("%-20s $ %5s\n", desktopOBJ.ram.get(desiredComponents.get(0)), desktopOBJ.ramPrice.get(desiredComponents.get(0)));
            System.out.print("[" + 2 + "] ");
            System.out.format("%-20s $ %5s\n", desktopOBJ.cpu.get(desiredComponents.get(1)), desktopOBJ.cpuPrice.get(desiredComponents.get(1)));
            System.out.print("[" + 3 + "] ");
            System.out.format("%-20s $ %5s\n", desktopOBJ.graphic.get(desiredComponents.get(2)), desktopOBJ.graphicPrice.get(desiredComponents.get(2)));
            System.out.print("[" + 4 + "] ");
            System.out.format("%-20s $ %5s\n", desktopOBJ.tower.get(desiredComponents.get(3)), desktopOBJ.towerPrice.get(desiredComponents.get(3)));
            System.out.print("[" + 5 + "] ");
            System.out.format("%-20s $ %5s\n", desktopOBJ.monitor.get(desiredComponents.get(4)), desktopOBJ.monitorPrice.get(desiredComponents.get(4)));
            System.out.print("[" + 6 + "] ");
            System.out.format("%-20s $ %6s\n", desktopOBJ.operatingSystem.get(desiredComponents.get(5)), 0);
            System.out.println("----------------------------------");

            totalPrice = desktopOBJ.ramPrice.get(desiredComponents.get(0))
                    + desktopOBJ.cpuPrice.get(desiredComponents.get(1))
                    + desktopOBJ.graphicPrice.get(desiredComponents.get(2))
                    + desktopOBJ.towerPrice.get(desiredComponents.get(3))
                    + desktopOBJ.monitorPrice.get(desiredComponents.get(4));

            System.out.format("%-23s $ %1s\n", "TOTAL TO PAY", totalPrice);
            System.out.println();
        }


        return totalPrice;
    }

}//end Interface