package financeManager;

import java.util.Collection;
import java.util.HashMap;

public class Expenses extends Income {
	private HashMap<String, Double> spending;
	
	public Expenses(String firstName, String lastName, double income, String employer) {
		super(firstName, lastName, income, employer);
		spending = new HashMap<String, Double>();
	}

	public void addPayble(String company, double amount) {
		spending.put(company, amount);
	}
	
	public void removePayble(String categoryToRemove) {
		spending.remove(categoryToRemove);
	}
	
	public double totalMonthlyExpenses() {
		Collection<Double> monthlyExpenses = spending.values();
		double sumMonthly = 0;
		for(Double el: monthlyExpenses) {
			sumMonthly += el;
		}
		
		return sumMonthly;
	}
}
