package InventoryGUI;

import javax.swing.*;
import java.util.MissingFormatArgumentException;

public class Controller {

    //METHODS
    public static String isStringTextField(JTextField textField){
        String test = "";

        try {
            test = textField.getText();
        } catch (MissingFormatArgumentException mfae) {
            System.err.println("isStringTextField Error: " + mfae.getMessage());
        }

        return test;
    }

    public static Integer isInteger(int numb) {
        int test = 0;

        try {
            test = numb;
        } catch (MissingFormatArgumentException mfae) {
            System.err.println("isIntegerTextField Error: " + mfae.getMessage());
        }

        return test;
    }

    public static Double isDoubleTextField(JTextField textField) {
        double test = 0.0;

        try {
            test = Double.valueOf(textField.getText());
        } catch (MissingFormatArgumentException mfae) {
            System.err.println("isDoubleTextField Error: " + mfae.getMessage());
        }

        return test;
    }

    public static Integer isIntegerTextField(JTextField textField) {
        int test = 0;

        try {
            test = Integer.valueOf(textField.getText());
        } catch (MissingFormatArgumentException mfae) {
            System.err.println("isIntegerTextField Error: " + mfae.getMessage());
        }

        return test;
    }
}
