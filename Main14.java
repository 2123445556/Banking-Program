package tut14.tut14;

import java.util.ArrayList;


import tut14.tut14.Accounts;


/*
 * Tutorial 14: Advanced ArrayList
 * 
 */
public class Main14 {

	public static void main(String[] args0) {

		new Frame();
	}

	public static void Account(String name) {
		Bank14 bank = new Bank14(classList());
		for(BankAccount14 act : bank.getList()) {
			if(act.getName().equals(name)) {
				act.freeze(false);
				act.menu();
			}
			
		}
		
	}

	public static ArrayList<BankAccount14> classList() {
		ArrayList<BankAccount14> lst = new ArrayList<BankAccount14>();
		lst.add(new BankAccount14("Rico", 123456, 1000.00, false, "4/20/20",1000.00));
		lst.add(new BankAccount14("Rodrigo", 222222, 1000000.00, false, "12/20/21", 1000000.00));
		lst.add(new BankAccount14("Atlas", 333333, 1000000.00, true, "1/3/01", 1000000.00));
		lst.add(new BankAccount14("Connor", 444444, 1000000.00, false, "6/2/8", 1000000.00));
		lst.add(new BankAccount14("Evelyn", 555555, 200000.00, false, "5/8/29", 200000.00));
		lst.add(new BankAccount14("Victoria", 666666, 100000.00, false, "4/1/28", 100000.00));
		lst.add(new BankAccount14("Nichole", 777777, 30000.00, false, "2/20/27",30000.00));
		lst.add(new BankAccount14("Marcelo", 888888, 4.00, true, "2/10/21", 4.00));
		lst.add(new BankAccount14("Dylan", 212344, 400000.00, true, "0/00/00", 400000.00));
		lst.add(new BankAccount14("Jaden", 12345678, 0.00, true, "2/10/21", 0.00));



		return lst;
	}

}
