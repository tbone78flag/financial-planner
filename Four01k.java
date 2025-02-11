package financeManager;

import java.util.Random;

public class Four01k extends SavingsAccount{
	private double employerContributionRate;

	public Four01k(String firstName, String lastName, double income, String employer, int retirementAge, int currentAge,
			double monthlyContributions, double totalSaved, double employerContributionRate) {
		super(firstName, lastName, income, employer, retirementAge, currentAge, monthlyContributions, totalSaved);
		// TODO Auto-generated constructor stub
		
		Random rand = new Random();
		annualInterestRate = 0.07 + (0.03 * rand.nextDouble());
	}

	@Override
	public double estimatedSavings() {
		double r = annualInterestRate/12;
		int n = (retirementAge - currentAge) * 12;
		double totalMonthlyContributions = monthlyContributions + calculateEmployerContributions();
		
		double interestTotalSaved = totalSaved * (Math.pow((1 + r), n) - 1) / r;
		double interestMonthlyContributions = totalMonthlyContributions * (Math.pow((1 + r), n) - 1) / r;
		
		double estimatedSavings = interestTotalSaved + interestMonthlyContributions;
		
		return estimatedSavings;
	}

	@Override
	public void changeMonthlyContributions(double newMonthlyInvestment) {
		monthlyContributions = newMonthlyInvestment;
		
	}

	@Override
	public void changeIntialSaved(double newSaved) {
		totalSaved = newSaved;
	}

	public double calculateEmployerContributions() { 
		return (income * getEmployerContributionRate())/12;
	}
	
	public void setEmployerContributionRate(double newRate) {
		this.employerContributionRate = newRate;
	}
	
	public double getEmployerContributionRate() {
		return employerContributionRate;
	}
}
