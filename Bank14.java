package tut14.tut14;

import java.util.ArrayList;
import tut14.tut14.BankAccount14;

public class Bank14 {

	private ArrayList<BankAccount14> _lst;
	
	// Getter for the list
	public ArrayList<BankAccount14> getList() { return _lst; }
	
	public BankAccount14 getBankAccount(int ind) { return _lst.get(ind); }
	
	// A constructor that will get the list
	// from somewhere else.
	public Bank14(ArrayList<BankAccount14> lst) {
		_lst = lst;
	}
	
	// A method to find a bank account given
	// the ID number of that bank account.
	public boolean findByID(int ID) {
		for(int i = 0; i < _lst.size(); i++) {
			if(_lst.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}

	public boolean findByName(String name) {
		for(int i = 0; i < _lst.size(); i++) {
			if(_lst.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
