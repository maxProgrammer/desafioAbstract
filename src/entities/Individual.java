package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {

		Double taxPaid = getAnualIncome();

		if (getAnualIncome() < 20000.00) {
			taxPaid *= 0.15;
			if (healthExpenditures > 0) {
				taxPaid -= healthExpenditures * 0.5;
			}
		} else {
			taxPaid *= 0.25;
			if (healthExpenditures > 0) {
				taxPaid -= healthExpenditures * 0.5;
			}
		}

		return taxPaid;
	}

}
