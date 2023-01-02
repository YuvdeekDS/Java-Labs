package lab10_exercise2;

public enum VATRate {
	ZERO(0),
	LOW(5),
	STANDARD(17.5);
	
	private double numVal;

    VATRate(double numVal) {
        this.numVal = numVal;
    }

    public double getNumVal() {
        return numVal;
    }
}
