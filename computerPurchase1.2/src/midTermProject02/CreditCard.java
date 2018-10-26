package midTermProject02;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.MissingFormatArgumentException;

public class CreditCard {

    long cardNumb;
    String expTxt;
    Date exp;
    int ccv;
    String cardName;
    boolean valid;


    //CONSTRUCTOR
    public CreditCard(long cardNumb, String expTxt, int ccv, String cardName) throws ParseException {
        this.cardNumb = cardNumb;
        this.expTxt = expTxt;
        this.ccv = ccv;
        this.cardName = cardName;

        exp = new SimpleDateFormat("MM/yyyy").parse(expTxt);

        valid = isCardNumberValid(cardNumb);
        valid = isCardDateValid(exp);
        valid = isCcvValid(ccv);
    }

    //METHODS
    public static boolean isCardNumberValid(Long cardNumb) throws MissingFormatArgumentException {
        if (cardNumb.toString().length() != 16)
            throw new MissingFormatArgumentException("Card number not valid. must be 16 digits:");

        return true;
    }

    public static boolean isCardDateValid(Date exp) throws DateTimeException {
        Date today = new Date();
        if (exp.before(today))
            throw new DateTimeException("Error date not valid");

        return true;
    }

    public static boolean isCcvValid(Integer ccv) throws MissingFormatArgumentException {
        if (ccv.toString().length() != 3)
            throw new MissingFormatArgumentException("Error cvv not valid");

        return true;
    }

}
