package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Seller extends JFrame {
    private JTextField SellID;
    private JTextField SellPass;
    private JButton editBtn;
    private JButton addBtn;
    private JButton clearBtn;
    private JButton delBtn;
    private JComboBox GenderCB;
    private JTextField SellName;
    private JPanel mainPanel;
    private JTable sellersTable;

    public static void main(String[] args) {
        Seller page = new Seller();
        page.setVisible(true);

    }


    public Seller() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        pack();

        String[] columnIdentifiers = new String[]{"ID", "Name", "Password", "Gender"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        sellersTable.setModel(model);
        sellersTable.getTableHeader().setReorderingAllowed(false);


        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);




                if (SellID.getText().isEmpty() || SellName.getText().isEmpty() || SellPass.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Missing information");
                }
                else{

                    try {

                        //Insert the values into the text file
                        model.addRow(new Object[]{SellID.getText(), SellName.getText(), SellPass.getText(), GenderCB.getSelectedItem().toString()});
                        File file = new File("C:\\Users\\User\\Documents\\GitHub\\COMP2000\\SellerTbl.txt");
                        Scanner scan = new Scanner(file);

                        JOptionPane.showMessageDialog(null, "Added successfully");
                    } catch (Exception event) {
                        event.printStackTrace();
                    }
                }
            }
        });
    }
}
