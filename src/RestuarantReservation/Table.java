package RestuarantReservation;

import java.util.*;

public class Table {
	
	private int numSeats;
	private String ID;
	private boolean available;
	private String reserveTable;
	private static List<Table> listTable = new ArrayList<Table>();
	public Table(int numSeats, String ID, boolean available) {
		this.numSeats = numSeats;
		this.ID = ID;
		setOccupied(available) ;
	}

	public Table() {
		numSeats = 0;
		ID = "Null";
		available = true;
	}
	
	public boolean getOccupied() {

		return available;	
	}

	public void setOccupied(boolean busy) {
		
		this.available = busy;
	}
	public String getReserveTable() {
		return reserveTable;
	}

	public void setReserveTable(String reserveTable) {
		this.reserveTable = reserveTable;
	}
	
	public String toString() {
		
		if(available!=false) {
			 return (" "+ID+"\t\t"+numSeats+"\t\t\t'Free'");
		}else {
			return (" "+ID+"\t\t"+numSeats+"\t\t\t'Busy'");
		}
		
	}
	
	public String getID(){
		return this.ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
//		if(ID.isEmpty()||ID.equals(null)) {
//			System.out.println("ID can't Empty!");
//		}
//		listTable = new ArrayList<Table>();
//		for(int i = 0;i<listTable.size();i++) {
//			Table t = listTable.get(i);
//			if(t.ID.equals(ID)) {
//				System.out.print("This id"+ID+" have already");
//			}
//			else {
//				this.ID = ID;
//			}
//		}
//		
//		
	}
		
}
