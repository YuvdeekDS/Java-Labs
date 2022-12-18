package lab5_exercise1;

import java.time.Month;
import java.util.Arrays;

public class RainfallYear {
	private int year;
	private double rainfallMonths[];
	
	public RainfallYear(int yr) {
		this.year = yr;
		rainfallMonths = new double[12];
	}
	public double calculateMeanRainfall() {
				
		return Arrays.stream(rainfallMonths).sum() / 12.0;
	}
	
	public double calculateHighestRainfall() {
		return Arrays.stream(rainfallMonths).max().getAsDouble();
	}
	
	public void enterData(double rainfall[]) {
		this.rainfallMonths = rainfall;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getRainfallMonth(String month) {
		
		return rainfallMonths[Month.valueOf(month).getValue()-1];
	}
}
