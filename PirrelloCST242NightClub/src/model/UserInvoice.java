package model;

import java.util.ArrayList;

public class UserInvoice{
	ArrayList<InvoiceItem> list;
	public UserInvoice(){
		list = new ArrayList<InvoiceItem>();
	}
	public void add(InvoiceItem item){
		list.add(item);
	}
	public void remove(InvoiceItem i){
			list.remove(i);
	}
	public int getSize(){
		return list.size();
	}
	public InvoiceItem get(int i){
		return list.get(i);
	}
	public String printAll(){
		String completeInvoice = "Item:\t" + "Club Name:\t       " + "Username:\t    " + "Price:";
		for(int i = 0;i < list.size();i++){
			completeInvoice = completeInvoice + "\n" + list.get(i).print();
		}
		return completeInvoice;
	}

}
