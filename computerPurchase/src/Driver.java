import javax.net.ssl.HandshakeCompletedEvent;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        String userDecision = null;
        Integer userSelcetion = 0;
        Software softwareObject = new Software();
        Hardware hardwareObject = new Hardware();

        do {

            System.out.print("Do you want buy a computer? [Y/N]: ");
            userDecision = stringValidity();
            getDecision(userDecision, userSelcetion, hardwareObject, softwareObject);

        }while(userDecision.equalsIgnoreCase("y"));

    }//end main.

    //MOTHODS
    public static void getDecision(String userDecision, Integer userSelcetion, Hardware hardwareObject, Software softwareObject){


        if (userDecision.equalsIgnoreCase("y")){

            printComputers(softwareObject, hardwareObject);
            System.out.println(softwareObject.makes.size());
            printPurchase(softwareObject, hardwareObject, userSelcetion);

        }else if (userDecision.equalsIgnoreCase("n")) {

            System.exit(0);

        }else{

            getError("invalid");
            userDecision = stringValidity();
            getDecision(userDecision, userSelcetion, hardwareObject, softwareObject);

        }
    }

    public static void  printComputers(Software softwareObject, Hardware hardwareObject){
        for(int i=0;i<softwareObject.makes.size(); i++){
            System.out.println("\n["+(i+1)+"]");
            System.out.println("Make: " + softwareObject.makes.get(i));
            System.out.println("Model: " + softwareObject.models.get(i));
            System.out.println("Price: $" + softwareObject.prices.get(i));
            System.out.println("Operation System: " + softwareObject.operationSystem.get(i));
            System.out.println("CPU: " + hardwareObject.cpu.get(i));
            System.out.println("RAM: " + hardwareObject.ram.get(i));
            System.out.println("Graphic: " + hardwareObject.graphic.get(i));
        }
    }

    public static void printPurchase(Software softwareObject, Hardware hardwareObject, Integer userSelcetion){

        System.out.print("\nSelect the computer that you wish buy: ");
        userSelcetion = integerValidity();

        if (userSelcetion <= softwareObject.makes.size()) {
            System.out.println("Make: " + softwareObject.makes.get(userSelcetion));
            System.out.println("Model: " + softwareObject.models.get(userSelcetion));
            System.out.println("Price: $" + softwareObject.prices.get(userSelcetion));
            System.out.println("Operation System: " + softwareObject.operationSystem.get(userSelcetion));
            System.out.println("CPU: " + hardwareObject.cpu.get(userSelcetion));
            System.out.println("RAM: " + hardwareObject.ram.get(userSelcetion));
            System.out.println("Graphic: " + hardwareObject.graphic.get(userSelcetion)+ "\n");
        }else{
            getError("Invalid");
            printPurchase(softwareObject, hardwareObject, userSelcetion);
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

    private static void getError(String opt) {

        switch (opt){
            case "invalid":
                System.err.print("Error, invalid choice, try again: ");
                break;
            case "string":
                System.err.print("Error, do not type a string, try again: ");
                break;
            default:
                System.err.print("Error, default type, try again: ");
                break;

        }
    }

}
