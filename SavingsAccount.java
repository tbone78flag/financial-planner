package financeManager;

import java.util.Random;

public abstract class SavingsAccount extends Income {
	protected double monthlyContributions;
	protected int retirementAge;
	protected int currentAge;
	protected double amountSaved;
	protected double totalSaved;
	protected double maxContribution;
	protected double annualInterestRate;
	
	public SavingsAccount(String firstName, String lastName, double income, 
			String employer, int retirementAge, int currentAge, double monthlyContributions,
			double totalSaved) {
		super(firstName, lastName, income, employer);
		this.monthlyContributions = monthlyContributions;
		this.retirementAge = retirementAge;
		this.currentAge = currentAge;
		this.totalSaved = totalSaved;
	}
	
	public abstract double estimatedSavings();
	
	public abstract void changeMonthlyContributions(double newMonthlyInvestment);
	
	public abstract void changeIntialSaved(double newSaved);

}
