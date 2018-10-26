package gradeCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gradeCalculatorApp {
    //VARIABLESs
    private JPanel mainPanel;
    private JLabel descriptionLabel;
    private JLabel gradeLabel;
    private JLabel creditsLabel;
    private JTextField classTextField1;
    private JTextField classTextField2;
    private JTextField classTextField3;
    private JTextField classTextField4;
    private JComboBox gradeBox1;
    private JComboBox gradeBox2;
    private JComboBox gradeBox3;
    private JComboBox gradeBox4;
    private JSpinner creditsSpinner1;
    private JSpinner creditsSpinner2;
    private JSpinner creditsSpinner3;
    private JSpinner creditsSpinner4;
    private JButton calculateButton;
    private JButton eraseButton;
    private JButton exitButton;
    final int max = 4;
    private static JFrame frame = new JFrame("gradeCalculatorApp");

    public static void main(String[] args) {
        //VARIABLES
        ArrayList<String> descriptions = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();
        ArrayList<Integer> credits = new ArrayList<>();

        frame.setContentPane(new gradeCalculatorApp(descriptions, grades, credits, false, false, false).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }//end main

    //METHODS
    private gradeCalculatorApp(ArrayList<String> descriptions, ArrayList<String> grades, ArrayList<Integer> credits, boolean textError, boolean gradeError, boolean creditError) {

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean classTxt,gradeTxt,creditTxt;
                int finalGrade;

                calculateButton.setText("Calculating...");
                classTxt = getText(descriptions, textError);
                gradeTxt = getGrades(grades, gradeError);
                creditTxt = getCredits(credits, creditError);
                getErrorMessage(classTxt, gradeTxt, creditTxt);

                if ((!classTxt || !gradeTxt) || !creditTxt) {
                    finalGrade = setCalculus(grades);
                    getCalculusResult(descriptions, grades, credits, finalGrade);
                    descriptions.clear();
                    grades.clear();
                    credits.clear();
                    calculateButton.setText("Calculate");
                }
            }
        });//end calculateButton.addActionListener

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to erase everything?", "ERASE ALL FIELD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (choice == 0) {
                    classTextField1.setText(null);
                    classTextField2.setText(null);
                    classTextField3.setText(null);
                    classTextField4.setText(null);
                    gradeBox1.setSelectedIndex(0);
                    gradeBox2.setSelectedIndex(0);
                    gradeBox3.setSelectedIndex(0);
                    gradeBox4.setSelectedIndex(0);
                    creditsSpinner1.setValue(0);
                    creditsSpinner2.setValue(0);
                    creditsSpinner3.setValue(0);
                    creditsSpinner4.setValue(0);

                    descriptions.clear();
                    grades.clear();
                    credits.clear();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int closeProcess = JOptionPane.showConfirmDialog(null, "Do you want close the App?");
                if (closeProcess == 0)
                    frame.dispose();
            }
        });

    }//end constructor

    private boolean getText(ArrayList<String> descriptions, boolean textError) {
        if (!(classTextField1.getText().isEmpty() || classTextField2.getText().isEmpty())){
            descriptions.add(classTextField1.getText());
            descriptions.add(classTextField2.getText());
            descriptions.add(classTextField3.getText());
            descriptions.add(classTextField4.getText());
            textError = false;
        } else {
            textError = true;
        }

        return textError;
    }

    private boolean getGrades(ArrayList<String> grades, boolean gradeError) {
        if (gradeBox1.getSelectedIndex() != 0 || gradeBox2.getSelectedIndex() != 0 || gradeBox3.getSelectedIndex() != 0 || gradeBox4.getSelectedIndex() != 0) {
            grades.add(String.valueOf(gradeBox1.getSelectedItem()));
            grades.add(String.valueOf(gradeBox2.getSelectedItem()));
            grades.add(String.valueOf(gradeBox3.getSelectedItem()));
            grades.add(String.valueOf(gradeBox4.getSelectedItem()));
            gradeError = false;
        } else {
            gradeError = true;
        }

        return gradeError;
    }

    private boolean getCredits(ArrayList<Integer> credits, boolean creditError) {
        if (((int) creditsSpinner1.getValue() >= 1 || (int) creditsSpinner2.getValue() >= 1) || ((int) creditsSpinner3.getValue() >= 1 || (int) creditsSpinner4.getValue() >= 1)) {
            credits.add((Integer) creditsSpinner1.getValue());
            credits.add((Integer) creditsSpinner2.getValue());
            credits.add((Integer) creditsSpinner3.getValue());
            credits.add((Integer) creditsSpinner4.getValue());
            creditError = false;
        } else {
            creditError = true;
        }

        return creditError;
    }

    private Integer setCalculus(ArrayList<String> grades) {
        int finalGrade = 0;

        for (int i = 0; i < max; i++) {
            switch (grades.get(i)) {
                case "100% - 90% (A)":
                    finalGrade += (100 + 90) / 2;
                    break;
                case "89% - 80% (B)":
                    finalGrade += (89 + 80) / 2;
                    break;
                case "79% - 70% (C)":
                    finalGrade += (79 + 70) / 2;
                    break;
                case "69% - 60% (D)":
                    finalGrade += (69 + 60) / 2;
                    break;
                case "59% - 0% (F)":
                    finalGrade += (59) / 2;
                    break;
            }
        }

        finalGrade = finalGrade/4;

        return finalGrade;
    }

    private void getCalculusResult(ArrayList<String> descriptions, ArrayList<String> grades, ArrayList<Integer> credits, int finalGrade) {
        String finalTxt = "";

        for (int i = 0; i <max ; i++)
            finalTxt += descriptions.get(i) + "   " + grades.get(i) + "   " + credits.get(i) + "\n";

        finalTxt += "------------------------------\nFinal Grade:     " + finalGrade;

        JOptionPane.showConfirmDialog(null, "this is your result:\n" + finalTxt, "Total", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void getErrorMessage(boolean textError, boolean gradesError, boolean creditsError) {

        if (textError && gradesError && creditsError) {
            JOptionPane.showConfirmDialog(null, "You have error in the following fields\n- Description field\n- Grade field\n- Credit field", "Error Message", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else if (textError) {
            JOptionPane.showConfirmDialog(null, "You have error in the following fields\n- Description field", "Error Message", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else if (gradesError) {
            JOptionPane.showConfirmDialog(null, "You have error in the following fields\n- Grade field", "Error Message", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else if (creditsError) {
            JOptionPane.showConfirmDialog(null, "You have error in the following fields\n- Credit field", "Error Message", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

}//end gradeCalculator
