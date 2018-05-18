package RestuarantReservation;
import java.util.*;

	public class MainClass{
		
		public static void menu() {
				System.out.println("================================================================");
				System.out.println("================================================================");
				System.out.println("	========  (1)==New--Table		========");
				System.out.println("	========  (2)==List--of--Tables		========");
				System.out.println("	========  (3)==New--Food		========");
				System.out.println("	========  (4)==List--of--Foods		========");
				System.out.println("	========  (5)==Take--Reservation	========");
				System.out.println("	========  (6)==List--of--Reservations	========");
				System.out.println("	========  (7)==Take--Order		========");
				System.out.println("	========  (8)==List--of--Orders		========");
				System.out.println("	========  (9)==Update--Table--Free	========");
				System.out.println("	========  (10)==Exit--the--Program	========");
				System.out.println("================================================================");
				
				
		}
		
		private static List<Table> listTable = new ArrayList<Table>();
		private static List<Food> listFood = new ArrayList<Food>();
		private static List<Booking> listBooking = new ArrayList<Booking>();
		
		//		================= Create New Table=======================
		
		public static void createNewTable() {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("----------------------Create New Table----------------------");
			String ID;
			do {
				System.out.print("Enter your table No:  ");
				ID = input.nextLine();
				System.out.print("Enter number of seats:  ");
				while (!input.hasNextInt()) {
		            System.out.print("You must enter a valid number! Try again: ");
		            input.next();
			    }
				int numSeats = input.nextInt();
				
				System.out.print("Do you want to add more Table?[Y/N]:   ");
				input.nextLine().trim();
				Table table = new Table(numSeats,ID,true);
				listTable.add(table);
				
			 } while (input.nextLine().equalsIgnoreCase("y"));
		}
		
		
		//			================Show List Of Tables=================== 
		
		public static void listOfTables() {
			System.out.println("----------------------List Of Table----------------------");
			System.out.println("[No\t\tNumberOfSeats\t\tStatus]");
			for(Table showTable:listTable) {
//				if(showTable.getOccupied()==true){
//						System.out.println(showTable.toString());	
//				}
				System.out.println(showTable.toString());
			}
		}
		
		
		//		================= Create New Food=======================
		
		public static void createNewFood(){
			System.out.println("----------------------Create New Food Menu----------------------");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
				do {
					System.out.print("Enter your food code:  ");
					String ID = input.nextLine();
					System.out.print("Enter your food name:  ");
					String name = input.nextLine();
					System.out.print("Enter your food price:  ");
				    while (!input.hasNextDouble()) {
			              System.out.print("You must enter a valid number! Try again: ");
			              input.next();
			        }
					double price = input.nextDouble();
					System.out.print("Do you want to add more food ?[Y/N]:   ");
				    input.nextLine();
				    Food food = new Food(ID, name, price);
				    listFood.add(food);
				} while (input.nextLine().equalsIgnoreCase("y"));
				
					
		}
		
		//    ====================	List of Foods  =====================
		
		public static void listOfFoods() {
			System.out.println("---------------------- List of Food ----------------------");
			System.out.println("[Code\t\t\tName\t\t\tPrice]");
			for(Food showFood:listFood) {
					System.out.println(showFood.toString());	
			}
		}
		// =================Create Booking ===========================
		public static void createBooking(){
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			do {
				System.out.println("Enter Booking Id :");
				String ID = input.next();
				System.out.println("Enter Customer Name :");
				String customerName = input.next();
				System.out.println("Enter Contact No :");
				String customerNo = input.next();
				System.out.println("How many table you want to book? :");
				int n = input.nextInt();
				Table[] bookTable = new Table[n];
				List<Table>	reservedTable = new ArrayList<Table>();
				for (int i = 0; i < n; i++) {
					System.out.println("Enter table number you want to reserve :");
					bookTable[i] = new Table();
					String ta = input.next();
					if(bookTable[i].getOccupied()==false){
						System.out.println("This table already booked..\nPlease choose other table.");
					}else{
						bookTable[i].setReserveTable(ta);
						bookTable[i].setOccupied(false);
						bookTable[i].setID(ta);
						reservedTable.add(bookTable[i]);
						for(Table showTable:listTable) {
							if(showTable.getID().equals(ta)){
									showTable.setOccupied(false);	
							}
						}
						for(Booking showBooking:listBooking){
							if(showBooking.getReservedTable().get(i).equals(ta)){
								showBooking.getReservedTable().get(i).setOccupied(false);
							}
						}
//						System.out.println(reservedTable.get(i).getReserveTable());
					
					}
					
				}
				Booking b = new Booking(ID, reservedTable, customerName, customerNo);
				listBooking.add(b);
				
			}while (input.nextLine().equalsIgnoreCase("y"));
		}
		//===================List of Booking====================
		public static void listOfBooking(){
			System.out.println("---------------------- List of Booking ----------------------");
			System.out.println("[Code\t\tName\t\t\tContact\t\tTable\t\tStatus]");
			for (Booking showBooking : listBooking) {
					System.out.print(" "+showBooking.toString());
					for (int j = 0; j < showBooking.getReservedTable().size(); j++) {
						System.out.print(" #"+showBooking.getReservedTable().get(j).getReserveTable());
						if(showBooking.getReservedTable().get(j).getOccupied()==false){
							System.out.print(" Checked In");
						}else{
							System.out.print(" Checked Out");
						}
					}	
				System.out.print(" ]");
				}
		}
		//===================Update Table to Free==================================
		private static void updateTable() {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			System.out.println("Which Table ID do you want to change to Free : ");
			String up = input.next();
			for(Table showTable:listTable) {
				if(showTable.getOccupied()==false){
					if(showTable.getID().equals(up)){
						showTable.setOccupied(true);
					}
				}
			}
			for(Booking showBooking:listBooking){
				for (int j = 0; j < showBooking.getReservedTable().size(); j++) {
					if(showBooking.getReservedTable().get(j).getOccupied()==false){
						if(showBooking.getReservedTable().get(j).getID().equals(up)){
							showBooking.getReservedTable().get(j).setOccupied(true);
							System.out.println("This Table ID : "+showBooking.getReservedTable().get(j).getID()+ " Updated successfully");
						}
					}
				}
				
			}
			
		}
		//===================Main Function============================
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			
			try {
				do {
					menu();
					System.out.print("---------------------- Please--Input--Your--Choice : ");
				
					while (!input.hasNextInt()) {
			             System.out.print("You must enter a valid number! Try again: ");
			             input.next();
			       } 
					int choice;
					choice = input.nextInt();
			
					switch(choice) {
				
					case 1:	
						createNewTable();
						break;
					case 2:
						listOfTables();
						break;
					case 3:
						createNewFood();
						break;
					case 4:
						listOfFoods();
						break;
					case 5:
						createBooking();
						break;
					case 6:
						listOfBooking();
						break;
					case 7:
						break;
					case 8:
						break;
					case 9: 
						updateTable();
						break;
					case 10:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Number");                    
			                break;
					}
					
				
					System.out.print("\nDo you want to continue to menu form?[Y/N]");
					input.nextLine().trim();
				 } while (input.nextLine().equalsIgnoreCase("y"));
			
			}finally {
		          input.close();
		    }	
	}



}
