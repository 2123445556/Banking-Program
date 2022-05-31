package tut14.tut14;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


import static tut14.tut14.Main14.classList;

public class updatingTable extends JFrame {

    JFrame frame2 = new JFrame();
    public static Object[] dat;
    private ArrayList<BankAccount14> _lst;
    public static String name;
    public static String id;
    public static String balance;
    public static JTable table;
    JButton button;
    JScrollPane scroll;
    DefaultTableModel model;
    JPanel panel;
    JTextField field;
    JTextField field3;
    JTextField field4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JButton button2;






   // Constructs the frame and  table that is used to display the users bank accounts.
    /* In addition, it also sets what action the button should perform when clicked on.
     */
    public updatingTable(ArrayList<BankAccount14> lst){
        _lst = lst;
        Object[] columns = {"Name", "ID", "Balance", "Status", "EST"};

        final Object[] dat = new Object[7];

        frame2.setBounds(100,100,600, 500);
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.getContentPane().setLayout(null);
        frame2.getContentPane().setBackground(Color.black);

        Bank14 ban = new Bank14(classList());

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,600,500);
        frame2.getContentPane().add(panel);
        panel.setLayout(null);
        scroll = new JScrollPane();
        scroll.setBounds(224,48,297,339);
        panel.add(scroll);

        table = new JTable();
        table.setForeground(Color.GREEN);
        table.setBackground(Color.DARK_GRAY);
        model = new DefaultTableModel();

        table.setModel(model);
        model.setColumnIdentifiers(columns);
        scroll.setViewportView(table);

        for(int i = 0; i < classList().size(); i++){
            String na = _lst.get(i).getName();
            int id = _lst.get(i).getID();
            double bal = _lst.get(i).getBalance();
            boolean fre = _lst.get(i).getFreezeStatus();
            String date = _lst.get(i).creationDate();
            Object[] row = {na, id, "$"+bal, fre, date};
            model.addRow(row);

        }




        label5 = new JLabel("Name: ");
        label5.setForeground(Color.GREEN);
        label5.setBounds(20,91,100,17);
        panel.add(label5);


        label6 = new JLabel("ID: ");
        label6.setForeground(Color.GREEN);
        label6.setBounds(40,124,100,17);
        panel.add(label6);


        label7 = new JLabel("Deposit: ");
        label7.setForeground(Color.GREEN);
        label7.setBounds(15,145,150,17);
        panel.add(label7);


        field = new JTextField();
        field.setBackground(Color.lightGray);
        field.setColumns(10);
        field.setBounds(67,91,150,17);
        panel.add(field);

        field3 = new JTextField();
        field3.setBackground(Color.lightGray);
        field3.setColumns(10);
        field3.setBounds(67,124,150,17);
        panel.add(field3);

        field4 = new JTextField();
        field4.setBackground(Color.lightGray);
        field4.setColumns(10);
        field4.setBounds(67,145,150,17);
        panel.add(field4);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                field.setText(model.getValueAt(i, 0).toString());
                field3.setText(model.getValueAt(i, 1).toString());
                field4.setText(model.getValueAt(i, 2).toString());

            }
        });

        button = new JButton("Create Account");
        button.setForeground(Color.darkGray);
        button.setBackground(Color.DARK_GRAY);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(field.getText().equals("") || field3.getText().equals("") || field4.getText().equals("")) {
                        Msg.msg("You must completely fill in the information!");
                    }
                    else {
                        if(isAlpha(field.getText()) && !ban.findByName(field.getText()) && !ban.findByID(Integer.valueOf(field3.getText())) && Double.valueOf(field4.getText()) >= 0) {

                            dat[0] = field.getText();
                            name = field.getText();


                            dat[1] = field3.getText();
                            id = field3.getText();

                            dat[2] = "$"+field4.getText();
                            balance = field4.getText();
                            dat[3] = "false";

                            dat[4] = date();
                            //lst.add(new BankAccount14(name, Integer.valueOf(id), Double.valueOf(balance), false, date(), Double.valueOf(balance)));
                            model.addRow(dat);



                            Msg.msg("Account has been created!");
                        }
                        else{
                            if(!isAlpha(field.getText())){
                                Msg.msg("Enter a valid Name");
                            }
                            if(ban.findByName(field.getText())){
                                Msg.msg("Name already Exists!");
                            }
                            if(ban.findByID(Integer.valueOf(field3.getText()))){
                                Msg.msg("ID already Exists!");
                            }
                            if(Double.valueOf(field4.getText()) < 0.0){
                                Msg.msg("You can't create a bank account if your broke!");
                            }
                        }
                    }

            }
        }) ;
        button.setBounds(10,280,200,23);
        panel.add(button);

        button2 = new JButton("Remove Account");
        button2.setBackground(Color.DARK_GRAY);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0) {
                    model.removeRow(i);
                    _lst.remove(i);
                    Msg.msg("Account has been Removed!");
                }
                else{
                    Msg.msg("Please select an Account to delete");
                }
            }
        });
        button2.setBounds(10,324,200,23);
        panel.add(button2);

        frame2.setVisible(true);

    }
    // Checks if name inputed contains any numbers of characters.
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    // Returns the current date of when the person created the account.
    public static String date(){
        String dateString = "";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateString += formatter.format(date);
    }


}