 package org.CDU3;

import java.util.Arrays;

public class Statistics {

	

	public Statistics(double avgTakingOrdersTime, double avgPreparingTime, double avgBillTime, double avgFreeTableTime,
			int[] takingOrdersTimes, int[] preparingTimes, int[] billTimes) {
		super();
		this.avgTakingOrdersTime = avgTakingOrdersTime;
		this.avgPreparingTime = avgPreparingTime;
		this.avgBillTime = avgBillTime;
		this.avgFreeTableTime = avgFreeTableTime;
		this.takingOrdersTimes = takingOrdersTimes;
		this.preparingTimes = preparingTimes;
		this.billTimes = billTimes;
	}

	/**
	 * average taking orders time
	 */
	private double avgTakingOrdersTime = 0;
	private double avgPreparingTime = 0;
	private double avgBillTime = 0;
	private double avgFreeTableTime = 0;
	/**
	 * Array/list containing all the taking orders times
	 */
	private int[] takingOrdersTimes;
	/**
	 * Array/list containing all the meal preparation times.
	 */
	private int[] preparingTimes;
	/**
	 * Array/list containing all the bill waiting times.
	 *  
	 */
	private int[] billTimes;
	/**
	 * Array/list containing all the breaking free table times.
	 */
	private int[] freeTableTimes;
	/**
	 * current times of taking orders according to each of the tables.
	 */
	private int[] currentTakingOrdersTimes;
	/**
	 * current times of meal preparation according to the tables
	 */
	private int[] currentPreparingTimes;
	/**
	 * current times of bill waiting according to the tables
	 */
	private int[] currentBillTimes;
	/**
	 * current times of breaking free table according to the tables
	 */
	private int[] currentFreeTableTimes;

	public double getAvgTakingOrdersTime() {
		return this.avgTakingOrdersTime;
	}

	public double getAvgPreparingTime() {
		return this.avgPreparingTime;
	}

	public double getAvgBillTime() {
		return this.avgBillTime;
	}

	public double getAvgFreeTableTime() {
		return this.avgFreeTableTime;
	}

	/**
	 * 
	 * @param times a array/list containing the all the times
	 */
	public double CalculateAvg(int[] times) {
		
		int sum = 0;
		for (int i=0; i<times.length; i++) {
			sum += times[i];
		}
		return sum/times.length;

	}

	/**
	 * save the time elapsed for the taking order of the given table and recalculate the avgTakingOrdersTime and save it.
	 * @param tableNumber
	 */
	public void SetTakingOrderTime(int tableNumber) {
		
		takingOrdersTimes = Arrays.copyOf(takingOrdersTimes, takingOrdersTimes.length + 1);
		takingOrdersTimes[takingOrdersTimes.length - 1] = (int) (System.currentTimeMillis() - currentTakingOrdersTimes[(int) tableNumber]);
		avgTakingOrdersTime = CalculateAvg(takingOrdersTimes);

	}

	/**
	 * save the time elapsed for the meal preparation of the given table and recalculate the avgPreparingTime and save it.
	 * @param tableNumber
	 */
	public void SetPreparingTime(int tableNumber) {
		
		preparingTimes = Arrays.copyOf(preparingTimes, preparingTimes.length + 1);
		preparingTimes[preparingTimes.length - 1] = (int) (System.currentTimeMillis() - currentPreparingTimes[tableNumber]);
		avgPreparingTime = CalculateAvg(preparingTimes);

	}

	/**
	 * save the time elapsed for the bill waiting of the given table and recalculate the avgBillTime and save it.
	 * @param tableNumber
	 */
	public void SetBillTime(int tableNumber) {
		
		billTimes = Arrays.copyOf(billTimes, billTimes.length + 1);
		billTimes[billTimes.length - 1] = (int) (System.currentTimeMillis() - currentBillTimes[tableNumber]);
		avgBillTime = CalculateAvg(billTimes);

	}

	/**
	 * save the time elapsed for the bill waiting of the given table and recalculate the avgFreeTableTime and save it.
	 * @param tableNumber
	 */
	public void SetFreeTableTime(int tableNumber) {
		
		freeTableTimes = Arrays.copyOf(freeTableTimes, freeTableTimes.length + 1);
		freeTableTimes[freeTableTimes.length - 1] = (int) (System.currentTimeMillis() - currentFreeTableTimes[tableNumber]);
		avgFreeTableTime = CalculateAvg(freeTableTimes);
		
	}

	/**
	 * 
	 * @param tableNumber
	 */
	public void ResetTableTimes(int tableNumber) {
		
		currentTakingOrdersTimes[tableNumber-1] = (int) System.currentTimeMillis();
		currentPreparingTimes[tableNumber-1] = (int) System.currentTimeMillis();
		currentBillTimes[tableNumber-1] = (int) System.currentTimeMillis();
		currentFreeTableTimes[tableNumber-1] = (int) System.currentTimeMillis();

	}
	public void initializeCurrentVector(int tableNumber) {
		currentTakingOrdersTimes = new int[tableNumber];
		currentPreparingTimes = new int[tableNumber];
		currentBillTimes = new int[tableNumber];
		currentFreeTableTimes = new int[tableNumber];
	}

	public int[] getCurrentTakingOrdersTimes() {
		return currentTakingOrdersTimes;
	}

	public void setCurrentTakingOrdersTimes(int[] currentTakingOrdersTimes) {
		this.currentTakingOrdersTimes = currentTakingOrdersTimes;
	}

	public int[] getCurrentPreparingTimes() {
		return currentPreparingTimes;
	}

	public void setCurrentPreparingTimes(int[] currentPreparingTimes) {
		this.currentPreparingTimes = currentPreparingTimes;
	}

	public int[] getCurrentBillTimes() {
		return currentBillTimes;
	}

	public void setCurrentBillTimes(int[] currentBillTimes) {
		this.currentBillTimes = currentBillTimes;
	}

	public int[] getCurrentFreeTableTimes() {
		return currentFreeTableTimes;
	}

	public void setCurrentFreeTableTimes(int[] currentFreeTableTimes) {
		this.currentFreeTableTimes = currentFreeTableTimes;
	}
}