package tut14.tut14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import static tut14.tut14.Main14.classList;

public class Frame extends JFrame implements ActionListener {
    public static JLabel label3;
    JMenuBar menuBar;
    JMenuItem unfreezeItem;
    JMenu menuMenu;
    JMenu search;
    JMenuItem accountsItem;
    JMenuItem withdrawItem;
    JMenuItem depositItem;
    JMenuItem freezeItem;
    JMenuItem searchItem;
    JMenuItem searchItem2;
    BankAccount14 bank;
    Accounts act;
    JLabel label;
    JLabel label2;
    JLabel label4;
    JLabel label5;
    JLabel label8;
    public static JLabel label9;
    JPanel panel2;

    // Constructor that creates a new JFrame that will be used as the main frame where the Menu bar will be
    /* and text is displayed.
     */
    public Frame() {
        JFrame frame = new JFrame();
        label = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        panel2 = new JPanel();
        act = new Accounts(classList());
        bank = new BankAccount14();

        frame.setTitle( "Legion's Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(null);
        frame.add(panel2);
        frame.setBackground(Color.DARK_GRAY);
        panel2.setLayout(null);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.setBounds(0,0,600,600);


        label8.setText("Welcome to Legions's, Bank the most original name of all time!");
        label8.setForeground(Color.GREEN);
        label.setText("Account: " + Accounts._lst.get(0).getName());
        label.setForeground(new Color(0x00FF00));
        label2.setText("ID: "+Accounts._lst.get(0).getID());
        label2.setForeground(Color.green);
        label3.setText("Balance: "+Accounts._lst.get(0).getBalance());
        label3.setForeground(Color.GREEN);
        label4.setText("Frozen: "+Accounts._lst.get(0).getFreezeStatus());
        label4.setForeground(Color.GREEN);
        label5.setText("Created on: "+Accounts._lst.get(0).creationDate());
        label5.setForeground(Color.GREEN);
        label9.setText("Total Amount Deposited: "+Accounts._lst.get(0).getTotal());
        label9.setForeground(Color.GREEN);



        menuBar = new JMenuBar();
        menuMenu = new JMenu("Menu");
        search = new JMenu("Search");

        searchItem = new JMenuItem("Search By Name");
        searchItem2 = new JMenuItem("Search By ID");

        accountsItem = new JMenuItem("Accounts");
        withdrawItem = new JMenuItem("Withdraw");
        depositItem = new JMenuItem("Deposit");
        freezeItem = new JMenuItem("Freeze");
        unfreezeItem = new JMenuItem("Unfreeze");

        menuMenu.add(accountsItem);
        menuMenu.add(withdrawItem);
        menuMenu.add(depositItem);
        menuMenu.add(freezeItem);
        menuMenu.add(unfreezeItem);
        search.add(searchItem);
        search.add(searchItem2);

        accountsItem.addActionListener(this);
        withdrawItem.addActionListener(this);
        depositItem.addActionListener(this);
        freezeItem.addActionListener(this);
        unfreezeItem.addActionListener(this);
        searchItem.addActionListener(this);
        searchItem2.addActionListener(this);


        menuBar.add(menuMenu);
        menuBar.add(search);
        label8.setBounds(200, 80,400,100);
        panel2.add(label8);
        label.setBounds(250, 120, 100, 100);
        panel2.add(label);
        label2.setBounds(250, 160, 100,100);
        panel2.add(label2);
        label3.setBounds(250, 200, 200,100);
        panel2.add(label3);
        label4.setBounds(250,240,200,100);
        panel2.add(label4);
        label5.setBounds(250,280,200,100);
        panel2.add(label5);
        label9.setBounds(200,320,300,100);
        panel2.add(label9);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }

    // Controls what to display or action to perform based on the button that was clicked by the user.
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == searchItem) {
                label.setText("Account: " + act.giveAct().getName());
                label2.setText("ID: " + act.l.getID());
                label3.setText("Balance: $" + act.l.getBalance());
                label4.setText("Frozen: " + act.l.getFreezeStatus());
                label5.setText("Created on: " + act.l.creationDate());
                label9.setText("Total Amount Deposited: $" + act.l.getTotal());
                bank = new BankAccount14(act.l.getName(), act.l.getID(), act.l.getBalance(), act.l.getFreezeStatus(), act.l.creationDate(), act.l.getTotal());
            }
            if(e.getSource() == searchItem2) {
                bank = new BankAccount14(act.giveActID().getName(), act.b.getID(), act.b.getBalance(), act.b.getFreezeStatus(), act.b.creationDate(), act.b.getTotal());
                label.setText("Account: " + act.b.getName());
                label2.setText("ID: " + act.b.getID());
                label3.setText("Balance: $" + act.b.getBalance());
                label4.setText("Frozen: " + act.b.getFreezeStatus());
                label5.setText("Created on: " + act.b.creationDate());
                label9.setText("Total Amount Deposited: $" + act.b.getTotal());

            }
            if(e.getSource() == accountsItem){
                new updatingTable(classList());
                Accounts._lst.add(new BankAccount14(updatingTable.name, Integer.valueOf(updatingTable.id), Double.valueOf(updatingTable.balance), false, updatingTable.date(), Double.valueOf(updatingTable.balance)));

            }
            if(e.getSource() == withdrawItem) {
                bank.withdraw();

            }
            if(e.getSource() == depositItem) {
                bank.deposit();

            }
            if(e.getSource() == freezeItem) {
                bank.freeze(true);
                label4.setText("Frozen: " + act.getFreezeStatus());

            }
            if(e.getSource() == unfreezeItem) {
                bank.freeze(false);
                label4.setText("Frozen: " + act.getFreezeStatus());

            }
    }

}

