package tut14.tut14;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Accounts {

    private String s;
    private String d;
    public static ArrayList<BankAccount14> _lst;
    BankAccount14 b;
    BankAccount14 l;

    // Constructor that initializes the arraylist filled with all the Bank Accounts
    public Accounts(ArrayList<BankAccount14> lst) {
        _lst = lst;
    }

    // A getter method for the arraylist of the bank accounts.
    private ArrayList<BankAccount14> getList() { return _lst; }


    // Makes a JOptionPane appear that asks you to input the accounts name
    /* then it will output the account based on the name you gave it.
     */
    public BankAccount14 giveAct(){
        s = Msg.in("Enter Name of Account:");
        for(int i = 0; i < _lst.size(); i++){
            if(s.matches(_lst.get(i).getName())){
                l = _lst.get(i);
                return l;
            }
        }
        return null;
    }
    // displays a JOptionPane that displays the bank account depending on what ID you input.
    public BankAccount14 giveActID(){
        d = Msg.in("Enter the ID of Account:");
        int c = Integer.valueOf(d);
        for (int i = 0; i < _lst.size(); i++) {
            if (c == _lst.get(i).getID()) {
                b = _lst.get(i);
                return b;
            }
        }
        return null;
    }

}
