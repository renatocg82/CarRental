package model.entities;

public class Invoice {
	
	protected Double basicPayment;
	protected Double tax;
	
	public Invoice() {
		
	}
	
	public Invoice (double basicPayment, double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {	
		return getBasicPayment() - getTax();	
	}
}
