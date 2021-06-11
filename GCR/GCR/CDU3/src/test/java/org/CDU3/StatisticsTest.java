package org.CDU3;

import junit.framework.TestCase;

public class StatisticsTest extends TestCase {
	int[] takingOrdersT = { 1, 2, 3 };
	int[] preparingT = { 1, 2, 3 };
	int[] billT = { 1, 2, 3 };
	int[] freeT = {1,2,3};
	Statistics s = new Statistics(50.00, 50.00, 50.00, 50.00, takingOrdersT, preparingT, billT);

	public void testGetAvgTakingOrdersTime() throws Exception {

		assertTrue(s.getAvgTakingOrdersTime() == 50.00);
	}

	public void testGetAvgPreparingTime() throws Exception {
		assertTrue(s.getAvgPreparingTime() == 50.00);
	}

	public void testGetAvgBillTime() throws Exception {
		assertTrue(s.getAvgBillTime() == 50.00);
	}

	public void testGetAvgFreeTableTime() throws Exception {
		assertTrue(s.getAvgFreeTableTime() == 50.00);
	}

	public void testCalculateAvg() throws Exception {
		double valorEsperado = 2;
		double valorMetodo = s.CalculateAvg(billT);
		assertTrue(valorMetodo == valorEsperado);
	}
	public void testCurrentTakingOrdersTimes() {
		s.setCurrentTakingOrdersTimes(billT);
		assertTrue(billT == s.getCurrentTakingOrdersTimes());
	}
	public void testCurrentPreparingTimes() {
		s.setCurrentPreparingTimes(billT);
		assertTrue(billT == s.getCurrentPreparingTimes());
	}
	public void testCurrentBillTimes() {
		s.setCurrentBillTimes(billT);
		assertTrue(billT == s.getCurrentBillTimes());
	}
	public void testCurrentFreeTableTimes() {
		s.setCurrentFreeTableTimes(billT);
		assertTrue(billT == s.getCurrentFreeTableTimes());
	}
	public void testSetTakingOrderTime() throws Exception {
		int numero = 2;
		 s.initializeCurrentVector(takingOrdersT.length);
		s.setCurrentTakingOrdersTimes(takingOrdersT);
		s.SetTakingOrderTime(numero);
		assertTrue(true);
	}

	public void testSetPreparingTime() throws Exception {
		int numero = 2;
		s.initializeCurrentVector(preparingT.length);
		s.setCurrentPreparingTimes(preparingT);
		s.SetPreparingTime(numero);
		assertTrue(true);
	}

	public void testSetBillTime() throws Exception {
		int numero = 2;
		s.initializeCurrentVector(preparingT.length);
		s.setCurrentBillTimes(billT);
		s.SetBillTime(numero);
		assertTrue(true);
	}

	public void testSetFreeTableTime() throws Exception {
		int numero = 2;
		s.initializeCurrentVector(billT.length);
		s.setCurrentFreeTableTimes(freeT);
		s.SetFreeTableTime(numero);
		assertTrue(true);
	}

	public void testResetTableTimes() throws Exception {
		int numero = 2;
		s.initializeCurrentVector(2);
		s.ResetTableTimes(numero);
		assertTrue(true);
	}

}
