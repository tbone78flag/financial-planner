package financeManager;
/** 
 * Creates the superclass of financeManager. The class
 * take in a name and income. This will allow for the program
 * to calculate the tax bracket.
 */
public class Finances {
	protected String firstName;
	protected String lastName;
	protected double income;

	public Finances(String firstName, String lastName, double income) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.income = income;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getIncome() {
		return income;
	}

	/**
	 * Calculates the tax bracket of the object based off of 
	 * income.
	 * @return Tax rate as a decimal
	 */
	public double calculateTaxBracket() {
		if (income <= 10000) {
            return 0.0; // 0% tax rate
        } else if (income <= 40000) {
            return 0.12; // 10% tax rate
        } else if (income <= 90000) {
            return 0.2; // 20% tax rate
        } else if (income <= 200000) {
            return 0.3; // 30% tax rate
        } else {
            return 0.4; // 40% tax rate
        }
	}

}
