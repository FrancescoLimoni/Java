import java.util.Scanner;

public class MusicLibrary {

    public static void main (String[] args){

        int cdChoice;
        int songChoice;
        String startOver;
        CD cds = new CD();
        String[] cd;

        System.out.println("\nMUSIC LIBRARY [ Name, Artist, Album, Duration, Genres ]");
        printCDs(cds);

        do {
            System.out.print("\nCD to listen? ");
            cdChoice = integerValidity();
            cdChoice = cdValidation(cds, cdChoice);
            cd = getCD(cds, cdChoice);

            System.out.print("Song to listen? ");
            songChoice = integerValidity();
            songChoice = songValidation(songChoice);
            getSong(cd, songChoice);

            System.out.print("\nDo you want listen another song? [y/n]: ");
            startOver = stringValidity();

        }while(startOver.equalsIgnoreCase("y"));

        System.exit(0);

    }//end main

    public static void printCDs(CD cds){
        int cdNumber = 0;
        int count = 1;

        for (int i=0; i<cds.name.size(); i++){

            if (i % 5 == 0){
                System.out.println("\nCD" + (cdNumber+1));
                cdNumber++;
                count = 1;
            }
            System.out.println("#" + count + " " + cds.name.get(i) + ", " + cds.artist.get(i) + ", " + cds.album.get(i) + ", " + cds.time.get(i));
            count++;
        }//end for
    }//end printCDs

    public static String[] getCD (CD cds, Integer cdChoice){
        int index = 0;
        String[] cd = new String[5];

        switch (cdChoice){
            case 1:
                for (int i=0; i<5; i++){
                    cd[i] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                }
            break;
            case 2:
                for (int i=5; i<10; i++){
                    cd[index] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                    index++;
                }
            break;
            case 3:
                for (int i=10; i<15; i++){
                    cd[index] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                    index++;
                }
            break;
            case 4:
                for (int i=15; i<20; i++){
                    cd[index] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                    index++;
                }
            break;
            case 5:
                for (int i=20; i<25; i++){
                    cd[index] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                    index++;
                }
            break;
            case 6:
                for (int i=25; i<30; i++){
                    cd[index] = cds.name.get(i) +", "+ cds.artist.get(i) +", "+ cds.album.get(i) +", "+ cds.time.get(i);
                    index++;
                }
        }//end switch

        return cd;
    }//end getCD

    public static void getSong(String[] cd, Integer songChoice){

        songChoice--;
        System.out.println("Playing...\n" + cd[songChoice]);

    }//end getSong

    public static Integer cdValidation (CD cds, Integer cdChoice) {

        if (cdChoice > 6 || cdChoice <= 0){
            getError("invalid");
            cdChoice = integerValidity();
            cdValidation(cds, cdChoice);
        }else{
            return  cdChoice;
        }

        return cdChoice;
    }

    public static Integer songValidation (Integer songChoice) {

        if (songChoice > 5){
            getError("invalid");
            songChoice = integerValidity();
            songValidation(songChoice);
        }

        return songChoice;
    }

    private static Integer integerValidity() {

        int test;
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()){
            getError("string");
            input.next();
            test = integerValidity();
        }else{
            test = input.nextInt();
        }

        return test;
    }//end integerValidity

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
    }//end getError
}
