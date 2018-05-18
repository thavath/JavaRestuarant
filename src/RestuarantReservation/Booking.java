
package RestuarantReservation;

import java.util.ArrayList;
import java.util.List;
import RestuarantReservation.Table;

public class Booking {
	private String ID;
	private List<Table> reservedTable = new ArrayList<Table>();
	private String customerName;
	private String customerNo;
	
	public Booking() {
		
	}
	
	public Booking(String ID, List<Table> reservedTable, String customerName, String customerNo) {
		this.ID = ID;
		this.reservedTable = reservedTable;
		this.customerName = customerName;
		this.customerNo = customerNo;
	}
	
	public List<Table> getReservedTable() {
		return reservedTable;
	}
	
	public void setReservedTable(List<Table> reservedTable) {
		this.reservedTable = reservedTable;
	}
	
	public String toString() {
		return "\n[" + ID +  "\t\t " + customerName + "\t\t " + customerNo +"\t";
	}	
}