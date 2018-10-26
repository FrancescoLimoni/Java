package InventoryGUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class InventoryApp extends JTable {
    private JPanel mainPanel;
    private JTable inventoryTable;
    private JButton searchButton;
    private JButton exitButton;
    private JButton editButton;
    private JButton editStopButton;
    private JTextField searchTextField;
    private JLabel searchLabel;
    private JButton searchInputButton;
    private JButton searchCloseButton;
    private JLabel totalLabel;
    private JLabel totalPriceLabel;
    private JLabel totalQuantityLabel;
    private static JFrame frame = new JFrame("InventoryApp");
    private static DefaultTableModel tableModel;
    private static DataBase dataBaseOBJ = new DataBase();
    private static Controller controllerOBJ = new Controller();

    public static void main(String[] args) {
        frame.setContentPane(new InventoryApp().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(550,450);
    }

    //CONSTRUCTOR
    private InventoryApp() {
        tableModel = new DefaultTableModel(dataBaseOBJ.data, dataBaseOBJ.columns);
        inventoryTable.setModel(tableModel);
        inventoryTable.setEnabled(false);
        editStopButton.setVisible(false);
        searchLabel.setVisible(false);
        searchTextField.setVisible(false);
        searchInputButton.setVisible(false);
        searchCloseButton.setVisible(false);
        totalLabel.setText(" TOTAL INVENTORY:");
        totalPriceLabel.setText("$ " + getTotalPrice(inventoryTable));
        totalQuantityLabel.setText("Qt. " + String.valueOf(getTotalQuantity(inventoryTable)));

        //ACTION LISTENER
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLabel.setVisible(true);
                searchTextField.setVisible(true);
                searchInputButton.setVisible(true);
                searchCloseButton.setVisible(true);

                searchTextField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getMatchedRow(inventoryTable.getRowCount(), inventoryTable.getColumnCount(), inventoryTable, tableModel, searchTextField);
                    }//end actionPerformed (press enter JTextField)
                });//end ActionListener JTextField
            }//end actionPerformed

        });//end addActionListener

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int decision;
                decision = JOptionPane.showConfirmDialog(null, "Do you want edit the table?", "UNABLE EDITING TABLE", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (decision == 0) {
                    inventoryTable.setEnabled(true);
                    editButton.setText("Editing..");
                    editStopButton.setVisible(true);
                }
            }
        });

        editStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int decision;
                decision =  JOptionPane.showConfirmDialog(null, "Do you want save the change made\nand exit from the edit mode?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (decision == 0) {
                    editButton.setText("Edit");
                    editStopButton.setVisible(false);
                    inventoryTable.setEnabled(false);

                    totalPriceLabel.setText("$ " + getTotalPrice(inventoryTable));
                    totalQuantityLabel.setText("Qt. " + String.valueOf(getTotalQuantity(inventoryTable)));
                }
                //SAVE PROCESS.
            }
        });

        searchInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMatchedRow(inventoryTable.getRowCount(), inventoryTable.getColumnCount(), inventoryTable, tableModel, searchTextField);
            }
        });

        searchCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLabel.setVisible(false);
                searchTextField.setVisible(false);
                searchInputButton.setVisible(false);
                searchCloseButton.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int decision;
                decision = JOptionPane.showConfirmDialog(null, "Do you want close the App?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (decision == 0) {
                    JComponent component = (JComponent) e.getSource();
                    Window window = SwingUtilities.getWindowAncestor(component);
                    window.dispose();
                }
            }
        });


    }//end inventoryApp Constructor

    //METHODS
    private static String getTotalPrice(JTable table) {
        int quantity;
        double price;
        double unitTotal;
        double totalPrice = 0.0;
        String totalPriceTxt = "";

        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                quantity = Integer.valueOf((String) table.getValueAt(i, 3));
                price = Double.valueOf((String) table.getValueAt(i, 2));
                unitTotal = (price * quantity);
                totalPrice += unitTotal;

                totalPriceTxt = String.format("%.2f", totalPrice);
            } catch (InputMismatchException ime) {
                System.err.println(ime.getMessage());
            }
        }

        return totalPriceTxt;
    }

    private static Integer getTotalQuantity(JTable table) {
        int totalQuantity = 0;

        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                totalQuantity += Integer.valueOf((String) table.getValueAt(i, 3));
            }catch (InputMismatchException ime) {
                System.err.println(ime.getMessage());
            }
        }

        return totalQuantity;
    }

    private static void getMatchedRow(int rowsCount, int columnsCount, JTable table, TableModel tableModel, JTextField textField) {
        int z = 0 ;
        String textCapitalized;
        int rowsMatched[] = new int[20];
        int columnsMatched[] = new int[20];
        boolean searchMatched = false;

        rowsMatched = setArrayDataToNull(rowsMatched);
        columnsMatched = setArrayDataToNull(columnsMatched);
        textCapitalized = controllerOBJ.isStringTextField(textField);
        textCapitalized = textCapitalized.substring(0,1).toUpperCase() + textCapitalized.substring(1);

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                if (tableModel.getValueAt(i,j).equals(textCapitalized)) {
                    rowsMatched[z] = controllerOBJ.isInteger(i);
                    columnsMatched[z] = controllerOBJ.isInteger(j);
                    searchMatched = true;
                    z++;
                }//end if
            }//end for j
        }//end for i

        if (!(searchMatched) && !(textField.getText().isEmpty()))
            JOptionPane.showMessageDialog(null, "Item not found: " + textCapitalized, null, JOptionPane.ERROR_MESSAGE);

        selectMultipleElements(table, rowsMatched, columnsMatched);
    }

    private static int[] setArrayDataToNull (int[] array) {

        for (int i = 0; i < array.length; i++)
            array[i] = -1;

        return array;
    }

    private static void selectMultipleElements (JTable table, int[] rowsMatched, int[] columnsMatched) {
        int stop = 0;

        for (int i = 0; i < rowsMatched.length ; i++) {
            if (rowsMatched[i] > -1 && columnsMatched[i] > -1){
                stop = rowsMatched[i];
                table.setRowSelectionInterval(rowsMatched[0], stop);
                System.out.println("["+i+"] row: " + rowsMatched[i] + " column: " + columnsMatched[i]);
            }
        }
    }

}//end inventoryApp Class
