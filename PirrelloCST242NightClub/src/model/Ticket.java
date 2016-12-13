package model;

public class Ticket implements InvoiceItem{
	private String clubName;
	private int price;
	private String purchaser;
	private String itemName;
	
	public Ticket(String clubName, int price, String purchaser){
		this.clubName = clubName;
		this.price = price;
		this.purchaser = purchaser;
		itemName = "Ticket";
	}

	@Override
	public String print() {
		return itemName + "\t" + clubName + "\t               " + purchaser + "\t       	    $" + price;
	}
}
