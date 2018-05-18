package RestuarantReservation;

import java.util.ArrayList;
import java.util.List;

public class Reservation implements CRUD<Booking>{
	
	private List<Booking> reservationList = new ArrayList<Booking>();
	
	public List<Booking> getReservationList() {
		return reservationList;
	}
	

	public Reservation() {
		
	}

	public void setReservationList(List<Booking> reservationList) {
		this.reservationList = reservationList;
	}

	public Reservation(List<Booking> reservationList) {
		this.reservationList = reservationList;
	}

	public void create(Booking b) {
		reservationList.add(b);
	}

	public ArrayList<Booking> read() {
		return (ArrayList<Booking>) reservationList;
	}

	public void update(Booking b) {
		for (int i = 0; i < b.getReservedTable().size(); i++) {
			if(b.getReservedTable().get(i).getOccupied()==false){
				b.getReservedTable().get(i).setOccupied(true);
			}
		}
	}

	public void delete(Booking b) {
		b = null;
	}

	public String toString() {
		return " Reservation [ reservationList = " + reservationList + " ] ";
	}	
}
