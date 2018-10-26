/*
    @author FrancescoLimoni

    Address Book Contact
    it's a contact library that contain for each of them:
    name, surname, DOB, email, address, city, state, and zip code.
*/

import java.util.Scanner;

public class AddressBookDriver {

    static final Integer max = 2;

    public static void main (String args[]){

        //LOCAL VARIABLES
        String choice;
        Integer index = 0;
        ContactFields[] contacts = new ContactFields[max];
        ContactFields[] contactsDoubled = new ContactFields[max*2];


        do {
            mainMenu();
            choice = stringValidity();

            switch (choice){
                case "add":
                    System.out.println("ADD CONTACT SECTION...");
                    index = addContact(contacts, contactsDoubled, index);
                    break;
                case "view":
                    System.out.println("VIEW CONTACT SECTION...");
                    viewContacts(contacts,contactsDoubled, index);
                    break;
                case "search":
                    System.out.println("SEARCH CONTACT SECTION...");
                    searchContact(contacts, index);
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }

        }while(!choice.equalsIgnoreCase("exit"));
    }//end main

    //METHODS
    private static void mainMenu() { System.out.print("\nMAIN MENU [ add / view / search / exit ]: ");}

    private static Integer addContact(ContactFields[] contacts, ContactFields[] contactsDoubled, Integer index) {

        String name, surname, DOB, email, address, city, state;
        int zipCode;

        if (index >= 0 && index < max ){
            System.out.print("              Enter Name: ");
                name = stringValidity();
            System.out.print("           Enter Surname: ");
                surname = stringValidity();
            System.out.print("   Birthday [MM/DD/YYYY]: ");
                DOB = stringValidity();
                //DOB = DOBValidity(DOB);
            System.out.print(" Email [email@gmail.com]: ");
                email = stringValidity();
                //email = emailValidity(email);
            System.out.print("Enter Address [##Street]: ");
                address = stringValidity();
            System.out.print("              Enter City: ");
                city = stringValidity();
            System.out.print("             Enter State: ");
                state = stringValidity();
            System.out.print("  Enter Zip Code [12345]: ");
                zipCode = integerValidity();
                //zipCode = zipCodeValidity(zipCode);

            contacts[index] = new ContactFields(name, surname, DOB, email, address, city, state, zipCode);
            index++;
        } else if (index >= max && index < max*2){

            if (index == max)
                setArrayDoubled(contacts, contactsDoubled, index);

            System.out.print("              Enter Name: ");
                name = stringValidity();
            System.out.print("           Enter Surname: ");
                surname = stringValidity();
            System.out.print("   Birthday [MM/DD/YYYY]: ");
                DOB = stringValidity();
                //DOB = DOBValidity(DOB);
            System.out.print(" Email [email@gmail.com]: ");
                email = stringValidity();
                //email = emailValidity(email);
            System.out.print("Enter Address [##Street]: ");
                address = stringValidity();
            System.out.print("              Enter City: ");
                city = stringValidity();
            System.out.print("             Enter State: ");
                state = stringValidity();
            System.out.print("  Enter Zip Code [12345]: ");
                zipCode = integerValidity();
                //zipCode = zipCodeValidity(zipCode);


            contactsDoubled[index] = new ContactFields(name, surname, DOB, email, address, city, state, zipCode);
            index++;
        }else{
            System.out.println("Address Book Full!");
        }

        return index;
    }
    private static void viewContacts(ContactFields[] contacts, ContactFields[] contactsDoubled, Integer index) {
        if (index <= max) {
            sortingArray(contacts, index);
            for (int i=0; i < index; i++){
                System.out.println("\nContact #"+(i+1));
                System.out.println("    Name: "+contacts[i].getName());
                System.out.println(" Surname: "+contacts[i].getSurname());
                System.out.println("Birthday: "+contacts[i].getDOB());
                System.out.println("   Email: "+contacts[i].getEmail());
                System.out.println(" Address: "+contacts[i].getAddress());
                System.out.println("    City: "+contacts[i].getCity());
                System.out.println("   State: "+contacts[i].getState());
                System.out.println("Zip Code: "+contacts[i].getZipCode());
            }

        } else if (index > max) {
            sortingArray(contactsDoubled, index);
            for (int i=0; i < index; i++){
                System.out.println("\nContact #"+(i+1));
                System.out.println("    Name: "+contactsDoubled[i].getName());
                System.out.println(" Surname: "+contactsDoubled[i].getSurname());
                System.out.println("Birthday: "+contactsDoubled[i].getDOB());
                System.out.println("   Email: "+contactsDoubled[i].getEmail());
                System.out.println(" Address: "+contactsDoubled[i].getAddress());
                System.out.println("    City: "+contactsDoubled[i].getCity());
                System.out.println("   State: "+contactsDoubled[i].getState());
                System.out.println("Zip Code: "+contactsDoubled[i].getZipCode());
            }
        }

    }//end viewContacts()
    private static void searchContact(ContactFields[] contacts, Integer index){

        String test;
        boolean isFound = false;

        System.out.print("Enter surname to search: ");
        test = stringValidity();

        for (int i=0; i < index; i++){
            if (contacts[i].getSurname().equalsIgnoreCase(test)){

               System.out.println("\nName: "+contacts[i].getName());
                System.out.println("Surname: "+contacts[i].getSurname());
                System.out.println("Birthday: "+contacts[i].getDOB());
                System.out.println("Email: "+contacts[i].getEmail());
                System.out.println("Name: "+contacts[i].getAddress()+", "+contacts[i].getCity()+", "+contacts[i].getState()+", "+contacts[i].getZipCode());
                isFound = true;
            }else{
                isFound = false;
            }//end if-else
        }//end for loop

        if (isFound  == false)
            System.out.println("Contact not found!");
    }
    private static void setArrayDoubled(ContactFields[] contacts, ContactFields[] contactsDoubled, Integer index){

        for (int i=0; i < index; i++){
            contactsDoubled[i] = contacts[i];
        }
    }
    private static void sortingArray(ContactFields[] contacts, Integer index){

        for (int i=0; i < index; i++){
            /*
            I founded out part of the issue. In order to prevent the crash i add this if statement that wont let make the check of the first character when the i is at the last position
            So, the last comparison will be between i and i+1 when i+1 will be at position i < index
            */
            if (i+1 < index) {
                /* Unfortunately here the issue is still present and I don't know how to get rid of it */
                if (contacts[i].getName().charAt(0) > contacts[i+1].getName().charAt(0)){
                    sortingSwap(contacts, i);
                }
            }//end if (i+1 < index)

        }//end for loop

    }
    private static void sortingSwap(ContactFields[] contacts, Integer index){

        ContactFields[] swap = new ContactFields[max*2];

        swap[index] = contacts[index];
        contacts[index] = contacts[index+1];
        contacts[index+1] = swap[index];
    }

    private static String stringValidity() {

        String test="";
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt() || input.hasNextDouble()){
            getError("number");
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
            test = integerValidity();
        }else{
            test = input.nextInt();
        }

        return test;
    }//end integerValidity()
    private static String DOBValidity(String BOD) {

        if (BOD.length() != 10){
            getError("DOB");
            BOD = stringValidity();
            BOD = DOBValidity(BOD);
        }else{
            if (BOD.charAt(2) != '/'){
                getError("DOB");
                BOD = stringValidity();
                BOD = DOBValidity(BOD);
            }

            if (BOD.charAt(5) != '/'){
                getError("DOB");
                BOD = stringValidity();
                BOD = DOBValidity(BOD);
            }
        }

        return BOD;
    } //end DOBValidity
    private static String emailValidity(String email) {

        if (!email.contains("@gmail.com")) {
            getError("email");
            email = stringValidity();
            email = emailValidity(email);
        }

        return email;
    }//end emailValidity()
    private static int zipCodeValidity(Integer zipCode) {

        if (String.valueOf(zipCode).length() != 5){
            getError("zipCode");
            zipCode = integerValidity();
            zipCode = zipCodeValidity(zipCode);
        }

        return zipCode;
    }//end zipCodeValidity
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
            case "full":
                System.err.print("Array has been fulled impossible storage more contact");
                break;
            case "email":
                System.err.print("Error, incorrect email, try again: ");
            case "DOB":
                System.err.print("Error, incorrect birthday, try again: ");
                break;
            case "zipCode":
                System.err.print("Error, incorrect zip code, try again: ");
                break;
        }

    }//end getError()

}//end AddressBookDriver