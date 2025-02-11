package financeManager;

import java.util.Random;

/**
 * Creates a class that calculates savings based on monthly 
 * investments, a random interest rate, and an initial investment.
 * 
 * @author Maggie Mahoney 
 */
public class IRA extends SavingsAccount {
	private double estimatedSavings;
	
	public IRA(String firstName, String lastName, double income, String employer, int retirementAge, int currentAge,
			double monthlyContributions, double totalSaved) {
		super(firstName, lastName, income, employer, retirementAge, currentAge, monthlyContributions, totalSaved);

		maxContribution = (currentAge < 50) ? 6500 : 7500;
		if(monthlyContributions >= maxContribution) {
			monthlyContributions = maxContribution; 
		}
		
		Random rand = new Random();
		annualInterestRate = 0.07 + (0.03 * rand.nextDouble());	
	}	

	/**
	 * Calculates the savings based off of the amount of years
	 * until retirement, monthly investements, and an inital 
	 * amount saved. 
	 *
	 * The equation used 
	 * FV=P×((1+r)n−1​)/r+PMT×(r(1+r)n−1​)/r
	 * FV is final amount, P is inital investmennt, r is annual rate/12, n total num
	 * of months, and PMT is monthly investments. Equation was given by chatGPT.
	 */
	@Override
	public double estimatedSavings() {
		double r = annualInterestRate/12;
		int n = (retirementAge - currentAge) * 12;
		
		double interestTotalSaved = totalSaved * (Math.pow((1 + r), n) - 1) / r;
		double interestMonthlyContributions = monthlyContributions * (Math.pow((1 + r), n) - 1) / r;
		
		estimatedSavings = interestTotalSaved + interestMonthlyContributions;
		
		return estimatedSavings;
	}

	/**
	 * Changes the amount of money invested each month.
	 */
	@Override
	public void changeMonthlyContributions(double newMonthlyInvestment) {
		monthlyContributions = newMonthlyInvestment;
	}

	@Override
	public void changeIntialSaved(double newSaved) {
		totalSaved = newSaved;
	}

	
}
