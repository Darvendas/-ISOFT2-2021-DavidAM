package org.CDU2;


import java.time.LocalDate;

public class Order {
	private String _dishID;
	private short _amount;

	public Order(String _dishID, short _amount) {
		this.setDishID(_dishID);
		this.setAmount(_amount);
	}
	
	public String getDishID() {
		return this._dishID;
	}
	public void setDishID(String aDishID) {
		this._dishID = aDishID;
	}


	public short getAmount() {
		return this._amount;
	}
	public void setAmount(short aAmount) {
		this._amount = aAmount;
	}
}