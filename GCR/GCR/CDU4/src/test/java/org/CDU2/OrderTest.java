package org.CDU2;

import junit.framework.TestCase;

public class OrderTest extends TestCase {

	public OrderTest() throws Exception {
		Order o = new Order("Red velvet",(short) 5);
		assertTrue(o.getDishID()== "Red velvet" && o.getAmount() == (short) 5);
	}
	public void getDishIDTest() throws Exception{
		Order o = new Order("Red velvet",(short) 5);
		assertTrue(o.getDishID() == "Red velvet");
	}
	public void setDishIDTest() throws Exception{
		Order o = new Order("Red velvet", (short)5);
		o.setDishID("Tres Chocolates");
		assertTrue(o.getDishID() == "Tres Chocolates");
	}
	public void getAmountTest() throws Exception {
		Order o = new Order("Red velvet", (short)5);
		assertTrue(o.getAmount() == (short) 5);
	}
	public void setAmountTest() throws Exception{
		Order o = new Order("Red velvet", (short)5);
		o.setAmount((short)4);
		assertTrue(o.getAmount() == (short) 4);
	}
	
}
	