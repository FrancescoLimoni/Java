package midTermProject02;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Controller {

    //METHODS
    public static String isString() {

        String test;
        Scanner input = new Scanner(System.in);

        if (!(input.hasNext() || input.hasNextLine())){
            System.err.print("Error, invalid choice, try again: ");
            input.next();
            test = isString();
        }else{
            test = input.nextLine();
        }

        return test;
    }//end isString

    public static Integer isInteger(Integer notSmallerThan, Integer notBiggerThan) {

        int test = 0;
        Scanner input = new Scanner(System.in);


        if (notSmallerThan == null && notBiggerThan == null){
            try {

                test = input.nextInt();

            } catch (InputMismatchException ime) {

                System.err.print("Error: " + ime.getMessage());
                test = isInteger(null, null);
            }//end try-catch
        }//end if notSmallerThan && notBiggerThan

        if (notSmallerThan != null && notBiggerThan == null) {
            try {
                test = input.nextInt();
                if (notSmallerThan > test) {
                    System.err.println("Error input smaller than " + notSmallerThan + ": ");
                    test = isInteger(notSmallerThan, null);
                }
            } catch (InputMismatchException ime) {

                System.err.print("Error: " + ime.getMessage());
                test = isInteger(notSmallerThan, null);
            }//end try-catch
        }//end if notBiggerThan != null

        if (notSmallerThan == null && notBiggerThan != null) {
            try {
                test = input.nextInt();
                if (notBiggerThan < test) {
                    System.err.print("Error input bigger than " + notBiggerThan);
                    test = isInteger(null, notBiggerThan);
                }
            } catch (InputMismatchException ime) {

                System.err.print("Error " + ime.getMessage());
            }//end try-catch
        }//end if notBiggerThan != null

        if (notSmallerThan != null && notBiggerThan != null) {

            try {
                test  = input.nextInt();
                if (test < notSmallerThan && test > notBiggerThan){
                    System.err.print("Error input too big or small");
                    test =  isInteger(notSmallerThan, notBiggerThan);
                }
            }catch (InputMismatchException ime) {
                System.err.print("Error: " + ime.getMessage());
            }
        }//end if

        return test;
    }//end isInteger

    public static Long isLong() {

        long test = 0L;
        String testTxt;
        Scanner input = new Scanner(System.in);

        testTxt = Long.toString(input.nextLong());

        if (testTxt.length() != 16){
            System.err.print("Error type a long number: ");
            test = isLong();
        }else {
            test = Long.valueOf(testTxt);
        }//end if-else

        return test;
    }//end isLong

    public static String isDate(Integer cardMonth, Integer cardYear) throws ParseException {

        String dateTxt;
        Date date = null;

        try {
            dateTxt = cardMonth + "/" + cardYear;
            date = new SimpleDateFormat("MM/yyyy").parse(dateTxt);
        } catch (ParseException pe) {
            System.err.println("Error " + pe.getMessage());
            cardMonth = isInteger(0, 12);
            cardYear = isInteger(0, null);
            dateTxt = isDate(cardMonth, cardYear);
        }

        return dateTxt;
    }//end isDate


}
