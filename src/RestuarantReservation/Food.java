package RestuarantReservation;


public class Food {
	
	private String ID;
	private String name;
	private double price;
	
	public Food() {
		ID = "unknow";
		name = "unknow";
		price = 0.0;
	}
	public Food(String ID, String name, double price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
	}
	
	
	public String toString() {
		
		return  " "+ID+"\t\t\t"+name+"\t\t\t"+price;
	}
	
	
}
