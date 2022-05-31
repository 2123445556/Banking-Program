package tut14.tut14;

import tut14.tut14.Msg;

public class BankAccount14 {

	private String _name;
	private int _actID;
	private double _balance;
	private boolean _isFrozen;
	private String _creation;
	private double total;


	// Getters
	public String getName() {
		return _name;
	}

	public int getID() {
		return _actID;
	}

	public double getBalance() {
		return _balance;
	}

	public boolean getFreezeStatus() {
		return _isFrozen;
	}

	public double getTotal(){ return total; }

	// Setters
	public void freeze(boolean b) {
		_isFrozen = b;
	}

	public String creationDate(){ return _creation; }



	// Constructor(s)
	public BankAccount14() {
		_name = "default";
		_actID = 0;
		_balance = 1000.00;
		_isFrozen = false;
		_creation = "";
		total = 1000.0;


	}

	public BankAccount14(String name, int id, double amt, boolean freeze, String date, double m) {
		_name = name;
		_actID = id;
		_balance = amt;
		_isFrozen = freeze;
		_creation = date;
		total = m;
	}

	// Methods
	public void deposit(double amt) {
		if (!_isFrozen) {
			_balance += amt;
			 total += amt;
			 Frame.label9.setText("Total Amount Deposited: $" + total);
			Frame.label3.setText("Balance: " + _balance);
		} else
			Msg.msg("Your account is frozen! Call the bank immediately!");

	}

	/*
	 * The withdraw method now checks to see if the withdrawal amount exceeds the
	 * balance.
	 */
	public void withdraw(double amt) {
		if (!_isFrozen) {
			if (amt < _balance) {
				_balance -= amt;
				total -= amt;
				Frame.label3.setText("Balance: " + _balance);
			}
			else {
				Msg.msg("Withdrawal amount exceeds balance!");
			}
		} else
			Msg.msg("Your account is frozen! Call the bank immediately!");
	}

	public void printInfo() {
		System.out.println(_name);
		System.out.println(_actID);
		System.out.println(_balance);
		System.out.println(_isFrozen);
		System.out.println();
	}

	public void msgInfo() {
		Msg.msg("Name: " + getName() + "\n" + "Account Number: " + getID() + "\n" + "Amount: " + getBalance() + "\n"
				+ "Account Frozen?: " + getFreezeStatus());
	}

	public void socialCredit(){
		int cnt = 0;
		boolean f = false;
		while(!f){
			//Msg.msg("You Have commited an atrocious crime your execution date is today")
		}
	}

	/*
	 * A new deposit method using while loops, try catch and JOptionPane's input
	 * dialog that will continuously loop until the user inputs a valid deposit
	 * amount >= 0. This amount must be a valid number.
	 * 
	 */
	public void deposit() {
		String s = "";
		boolean b = false;
		while (!b) {
			try {
				s = Msg.in("Enter an amount to deposit.");
				double d = Double.valueOf(s);
				if (d >= 0) {
					deposit(d);
					b = true;
				} else {
					Msg.msg("You must deposit an amount > 0!");
				}
			} catch (Exception e) {
				Msg.msg("Not a valid number! Please input again.");
			}
		}
	}

	/*
	 * A new withdraw method using while loops, try catch and JOptionPane's input
	 * dialog that will continuously loop until the user inputs a valid deposit
	 * amount >= 0. This amount must be a valid number.
	 * 
	 */
	public void withdraw() {
		String s = "";
		boolean b = false;
		while (!b) {
			try {
				s = Msg.in("Enter an amount to withdraw.");
				double d = Double.valueOf(s);
				if (d >= 0) {
					withdraw(d);
					b = true;
				} else {
					Msg.msg("You must withdraw an amount > 0!");
				}
			} catch (Exception e) {
				Msg.msg("Not a valid number! Please input again.");
			}
		}
	}


	/*
	 * A simple menu system that allows the user to deposit, withdraw, freeze,
	 * unfreeze and exit the menu system. It uses an internal loop to determine
	 * when to close.
	 */
	public void menu() {
		String[] options = { "deposit", "withdraw", "freeze", "unfreeze", "exit" };
		boolean loop = true;
		int opt = 0;
		
		while (loop) {
			opt = Msg.opt(options, "Select an option", "Name: " + _name + "| Bal: " + _balance + "| Frz?: " + _isFrozen);
			if (opt == 0) {
				deposit();
			} else if (opt == 1) {
				withdraw();
			} else if (opt == 2) {
				freeze(true);
				Msg.msg("Account frozen!");
			} else if (opt == 3) {
				freeze(false);
				Msg.msg("Account unfrozen.");
			} else {
				Msg.msg("Bank application closed.");
				loop = false;
			}
		}
	}

}
