package com.lab_assignment_2.q5;
import java.util.ArrayList;
import com.lab_assignment_2.q4.SalariedEmployee;
import com.lab_assignment_2.q4.HourlyEmployee;
import com.lab_assignment_2.q4.CommissionEmployee;


class Invoice implements Payable{
	private int invoiceId;
	private String itemDescription;
	private int quantity;
	private double pricePerUnit;
	
    Invoice(int invoiceId, String itemDescription, int quantity, double pricePerUnit) {
        this.setInvoiceId(invoiceId);
        this.setItemDescription(itemDescription);
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
	}
    
    @Override
    public double getPayment(){
		return quantity * (int) pricePerUnit;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}


public class Q5 {
    public static void main(String[] args) {

        ArrayList<Payable> payments = new ArrayList<>();

        // Employees
        payments.add(new SalariedEmployee("Alice", 101, 900));
        payments.add(new HourlyEmployee("Bob", 102, 40, 25));
        payments.add(new CommissionEmployee("Charlie", 103, 12, 6000));

        // Invoices
        payments.add(new Invoice(201, "Office Chairs", 5, 120));
        payments.add(new Invoice(202, "Printer Ink", 10, 30));

        // Unified payment processing
        for (Payable p : payments) {
            System.out.println("Payment Amount: Rs" + p.getPayment());
        }
    }
}
