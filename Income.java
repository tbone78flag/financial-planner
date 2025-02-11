package financeManager;

import java.util.ArrayList;
import java.util.List;

/** 
 * Allows for the object to 
 */
public class Income extends Finances {
	protected String employer;
	private List<String> receivableCompany = new ArrayList<>();
	private List<Double> receivableIncome = new ArrayList<>();
	
	public Income(String firstName, String lastName, double income, String employer){
		super(firstName, lastName, income);
		this.employer = employer;
		
		receivableCompany.add(employer);
		receivableIncome.add(income);
	}
	
	public void addReceivable(String company, double income) {
		receivableCompany.add(company);
		receivableIncome.add(income);
	}
	
	public void removeReceivable(int where) {
		receivableCompany.remove(where);
		receivableIncome.remove(where);
	}
	
	public double netIncome() {
		return income * calculateTaxBracket();
	}
	
	
}
