package ui;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;




public class Main{
	//Relations


	private Veterinary veterinary;


	//initializer

	private Scanner reader;

	public Main(){
		init();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args){
		Main m = new Main();
		m.menu();
		m.showMenu();
	}


	public void menu(){
		welcome();
	}



	public void welcome(){

    System.out.println(".............................................................................");
    System.out.println("--------------------           My Little Pet.            --------------------");
    System.out.println(".............................................................................");

	}



	public void showMenu(){

		int userInput=0;

		while(userInput <= 23){
			showOptions();
			userInput = reader.nextInt();
			reader.nextLine();


			if(userInput==1){

	    System.out.println("Client name:");
		String name = reader.nextLine();
		
		
		System.out.println("Client address: ");
		String address = reader.nextLine();


		System.out.println("Client  iD:");
		int id = reader.nextInt();


		System.out.println("Client  cell:");
		int phoneNumber = reader.nextInt();

		System.out.println("How many pets does the client have?:");
		int quantityPets = reader.nextInt();
		reader.nextLine();
		 for(int i = 0; i < quantityPets; i++){
  System.out.println("...........................................................................");

			System.out.println("Mascot "+(i+1)+":");


			System.out.println("Mascot name:");
			String nameM = reader.nextLine();


			System.out.println("Mascot age:");
			int age = reader.nextInt();
			reader.nextLine();



			System.out.println("Mascot weight:");
			double weight = reader.nextDouble();
			reader.nextLine();
			
			System.out.println("Mascot height:");
			double height = reader.nextDouble();
			reader.nextLine();

			System.out.println("Mascot type(1 for cat, 2 for dog, 3 for bird, 4 for others):");

			int mascotType = reader.nextInt();
			String type = "";
			if(mascotType == 1){
				type = "Cat";
			}else if(mascotType == 2){
				type = "Dog";
			}else if(mascotType == 3){
				type = "Bird";
			}else if(mascotType == 4){
				type = "Other";
			}else{
				System.out.println("Ingrese un tipo valido");
			}
			System.out.println(veterinary.addClient( name, id, address , phoneNumber, nameM, type, age, weight, height));







		}



		System.out.println("The client was added successfully");
	}





		else if(userInput==2){
			int error = 0;
		    while (error == 0){
			System.out.println("Enter the id of the pet owner");
			int id = reader.nextInt();
			System.out.println("Enter the name of the pet who wants to hospitalize");
			String nameM = reader.nextLine();


							boolean state = true;
							System.out.println("What symptoms does the pet have?");
							String symptom = reader.nextLine();
							System.out.println("What is the possible diagnosis of the pet?");
							String diagnostic = reader.nextLine();
							System.out.println("enter the current day");
							int day = reader.nextInt();
							System.out.println("enter the current month (please the number)");
							int month = reader.nextInt();
							System.out.println("enter the current year");
							int year = reader.nextInt();
							System.out.println("How many medicines does the animal need?");
							int medicines = reader.nextInt();
							System.out.println("Enter the name of medicine");
							String nameMedicine = reader.nextLine();
							System.out.println("Enter the quantity of medicine for dose (mlg)");
							double quantify = reader.nextDouble();
							System.out.println("Enter the price of medicine for mlg");
							double price = reader.nextDouble();
							System.out.println("Enter the frecuency with whom you drink medicine for hour");
							double frecuency = reader.nextDouble();
							System.out.println("Enter the quantity of dose");
							int doseGiven = reader.nextInt();
							
							System.out.println("Mascot name:");
			String nameMa = reader.nextLine();


			System.out.println("Mascot age:");
			int age = reader.nextInt();
			reader.nextLine();



			System.out.println("Mascot weight:");
			double weight = reader.nextDouble();
			reader.nextLine();
			
			System.out.println("Mascot height:");
			double height = reader.nextDouble();
			reader.nextLine();

			System.out.println("Mascot type(1 for cat, 2 for dog, 3 for bird, 4 for others):");

			int mascotType = reader.nextInt();
			String type = "";
			if(mascotType == 1){
				type = "Cat";
			}else if(mascotType == 2){
				type = "Dog";
			}else if(mascotType == 3){
				type = "Bird";
			}else if(mascotType == 4){
				type = "Other";
			}else{
				System.out.println("Ingrese un tipo valido");
			}
			Pet pet = new Pet(nameMa, type, age, weight, height);
			System.out.println(veterinary.createHistoryPet(id, nameM, symptom,diagnostic, state, day, month, year, nameMedicine, quantify, price, frecuency, doseGiven, pet));

			int option = reader.nextInt();
			error = 1;



			}





			}
			else if(userInput==3){
				System.out.println("Enter the id of the pet owner");
				int id = reader.nextInt();
				System.out.println("Enter the name of the pet who was discharge");
				String nameM = reader.nextLine();
				System.out.println("Enter the current day.");
				int day = reader.nextInt();
				System.out.println("Enter the current month (please the number)");
				int month = reader.nextInt();
				System.out.println("Enter the current year");
				int year = reader.nextInt();
				if(veterinary.closeHistory(id, nameM, day, month , year ) != false){
					System.out.println("The history of the mascot has been closed");
				}else{
					System.out.println("No active medical history or pet was found, please re-enter the data");
				}




			}
			else if(userInput==4){
				System.out.println("Please enter the current day");
				int dayN = reader.nextInt();
				System.out.println("Please enter the current month (in numbers)");
				int monthN = reader.nextInt();
				System.out.println("Please enter the current year");
				int yearN = reader.nextInt();
				System.out.println("The veterinary's income is" + " $" + veterinary.veterinaryIncome(dayN, monthN, yearN) + "$");





			}
			else if(userInput==5){
				System.out.println("Enter the id of the pet owner");
				int id = reader.nextInt();
				System.out.println("Enter the name of the pet you want to attach the story to");
				String nameM = reader.nextLine();
				System.out.println("the story is activated? \n" + "1. yes \n" + "2. not \n");
				int activated = reader.nextInt();
				boolean state = false;
				if(activated == 1){
				state = true;
				}else if(activated == 2){
					state = false;
				}

				System.out.println("What symptoms does the pet have?");
				String symptom = reader.nextLine();
				System.out.println("What is the possible diagnosis of the pet?");
				String diagnostic = reader.nextLine();
				System.out.println("enter the current day");
				int day = reader.nextInt();
				System.out.println("enter the current month (please the number)");
				int month = reader.nextInt();
				System.out.println("enter the current year");
				int year = reader.nextInt();
				System.out.println("How many medicines does the animal need?");
				int medicines = reader.nextInt();
				for(int e = 0; e<medicines; e++){
				System.out.println(veterinary.hospitalizePet(id, nameM));
				System.out.println("Enter the name of medicine");
				String nameMedicine = reader.nextLine();
				System.out.println("Enter the quantity of medicine for dose (mlg)");
				double quantify = reader.nextDouble();
				System.out.println("Enter the price of medicine for mlg");
				double price = reader.nextDouble();
				System.out.println("Enter the frecuency with whom you drink medicine for hour");
				double frecuency = reader.nextDouble();
				System.out.println("Enter the quantity of dose");
				int doseGiven = reader.nextInt();
				String nameMa = reader.nextLine();


			System.out.println("Mascot age:");
			int age = reader.nextInt();
			reader.nextLine();



			System.out.println("Mascot weight:");
			double weight = reader.nextDouble();
			reader.nextLine();
			
			System.out.println("Mascot height:");
			double height = reader.nextDouble();
			reader.nextLine();

			System.out.println("Mascot type(1 for cat, 2 for dog, 3 for bird, 4 for others):");

			int mascotType = reader.nextInt();
			String type = "";
			if(mascotType == 1){
				type = "Cat";
			}else if(mascotType == 2){
				type = "Dog";
			}else if(mascotType == 3){
				type = "Bird";
			}else if(mascotType == 4){
				type = "Other";
			}else{
				System.out.println("Ingrese un tipo valido");
			}
			Pet pet = new Pet(nameMa, type, age, weight, height);
				System.out.println(veterinary.createHistoryPet(id, nameM, symptom,diagnostic, state, day, month, year, nameMedicine, quantify, price, frecuency, doseGiven, pet));
				}






			}
			else if (userInput==6){
				System.out.println("Enter the name of pet");
				String nameM = reader.nextLine();
				if(veterinary.availabilityThePet(nameM)!= false){
					if(veterinary.petsRoom(nameM) != 0){
					System.out.println("The number of the petsRoom is " + veterinary.petsRoom(nameM));
					}else{
						System.out.println("the pet is not in any room");
					}
				}else{
					System.out.println("The pet is not hospitalized :)");
				}







			}
			else if(userInput==7){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println(veterinary.seeDataAnimal(name, nameM));




			}
			else if (userInput==8){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println("Please enter the current day");
				int dayN = reader.nextInt();
				System.out.println("Please enter the current month (in numbers)");
				int monthN = reader.nextInt();
				System.out.println("Please enter the current year");
				int yearN = reader.nextInt();
				System.out.println("The cost of hospitalization is" + veterinary.costPet(name, nameM, dayN, monthN, yearN) + "$");




			}
			else if (userInput==9){
				System.out.println("The stories of hospitalized pets are:");
				System.out.println(veterinary.showPetsHospitalizad());



			}
			else if (userInput==10){
				System.out.println("Enter the name of the pet ");
				String name = reader.nextLine();
				System.out.println(veterinary.dataWonderPet(name));




			}else if (userInput==11){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println("The history of previous hospitalizations are:");
				System.out.println(veterinary.seeLastDataAnimal( name, nameM));
				



			
			}else if (userInput==12){
				System.out.println("the income from services are: " + veterinary.getSerIncome());

			}else if (userInput==13){
				System.out.println("the total income of the veterinay is: " + veterinary.totalIncome());

			}else if (userInput==14){
				System.out.println("please enter the type of service for pet bath, G for pet bath at home, N for nail cutting, P for dental prophylaxis, V for vaccine) ");
				char type = reader.next().charAt(0);
				double cost = 0.0;
				if(type == 'S'){
					cost = 20000.0;
				}else if(type == 'G'){
					cost = 30000.0;
				}else if(type == 'N'){
					cost = 8000.0;
				}else if(type == 'P'){
					cost = 12000.0;
				}else if(type == 'V'){
					cost = 45000.0;
				}else{
					System.out.println("Please enter an appropriate type (the numbre)");
				}
				System.out.println("Please enter the day the service was performed (the numbre)");
				int day = reader.nextInt();
				System.out.println("please enter the month the service was performed (the numbre)");
				int month = reader.nextInt();
				System.out.println("please enter the year the service was performed (the numbre)");
				int year = reader.nextInt();
				Date d = new Date(day, month, year);
				System.out.println("please enter the customer's name");
				String nc = reader.nextLine();
				System.out.println("please enter the pet name");
				String np = reader.nextLine();
				Service s = new Service(type, cost, d, nc, np);
				

			}else if(userInput == 15){
				System.out.println("The average income from services is: " + veterinary.averageIncomePerServices());
			}else if(userInput == 16){
				System.out.println("jejejeje hola :3");
			}else if(userInput == 17){
				System.out.println("please enter the initial day ");
				int day1 = reader.nextInt();
				System.out.println("please enter the initial month ");
				int month1 = reader.nextInt();
				System.out.println("please enter the initial year ");
				int year1 = reader.nextInt();
				System.out.println("please enter the final day ");
				int day2 = reader.nextInt();
				System.out.println("please enter the final month ");
				int month2 = reader.nextInt();
				System.out.println("please enter the final year ");
				int year2 = reader.nextInt();
				Date date1 = new Date(day1, month1, year1);
				Date date2 = new Date(day2, month2, year2);
				System.out.println(veterinary.serviceReport(date1, date2));
			}else if(userInput == 18){
				System.out.println("please enter the name of the pet you want to know about the BMI");
				String name = reader.nextLine();
				System.out.println(veterinary.calculateBMI(name));
			}else if(userInput == 19){
				System.out.println("please enter the customer ID");
				int id = reader.nextInt();
				System.out.println("please enter the option you want to change from the client (1. phone, 2. adders, 3. all )");
				int num = reader.nextInt();
				if(num == 1){
					String address = "";
					System.out.println("enter the new client number");
					int phoneNumber = reader.nextInt();
					System.out.println(veterinary.change(id, address, phoneNumber));
				}else if(num == 2){
					int phoneNumber = 0;
					
					System.out.println("enter the new customer address ");
					
					String address = "";
					System.out.println(veterinary.change(id, address, phoneNumber));
				}else if(num == 3){
					System.out.println("enter the new client number");
					int phoneNumber = reader.nextInt();
					
					System.out.println("enter the new customer address  ");
					String address = "";
					
					System.out.println(veterinary.change(id, address, phoneNumber));
					
				}else{
					System.out.println("please enter a correct option");
				}
				
			}else if(userInput == 20){
				System.out.println("please enter the name of the pet you want to add the medicine");
				String name = reader.nextLine();
				
				System.out.println("Enter the name of the medicine");
				String n = reader.nextLine();
				
				System.out.println("Enter the amount of medicine");
				double q = reader.nextDouble();
				
				
				System.out.println("Enter the price of medicine");
				double p = reader.nextDouble();
				
				System.out.println("Enter the frequency in which the medicine is taken");
				double f = reader.nextDouble();
				
				System.out.println(veterinary.addMedicinePetHospitali( name,  n,  q,  p,  f ));
			}else if(userInput == 21){
				System.out.println("please enter the name of the pet you want add the possible diagnosis note");
				String name = reader.nextLine();
				
				System.out.println("please enter the diagnosis note");
				String nota = reader.nextLine();
				
				System.out.println(veterinary.hospitalizatedPetNotesDiagnostic(name, nota));
			}else if(userInput == 22){
				System.out.println("please enter the name of the pet you want add the new symptom");
				String name = reader.nextLine();
				
				System.out.println("please enter the new symptom");
				String nota = reader.nextLine();
				
				System.out.println(veterinary.hospitalizatedPetNotesSimtom(name, nota));
			}










		}




	}


public void showOptions(){
  System.out.println("---------------------------------------------------------------------------");
  System.out.println("PLEASE TYPE THE OPTION YOU WANT TO REVIEW.");
  System.out.println("                                                                          |");
  System.out.println("1.Register Client and Pet.\n ");
  System.out.println("                                                                          |");
  System.out.println("2.Hospitalize the pet.\n");
  System.out.println("                                                                          |");
  System.out.println("3.Close the clinical history ");
  System.out.println("                                                                          |");
  System.out.println("4.Know the veterinary income");
  System.out.println("                                                                          |");
  System.out.println("5.Append a clinical history");
  System.out.println("                                                                          |");
  System.out.println("6.Number of the pet's room");
  System.out.println("                                                                          |");
  System.out.println("7. See the clinical history of an animal");
  System.out.println("                                                                          |");
  System.out.println("8. Calculate the cost of a hospitalization");
  System.out.println("                                                                          |");
  System.out.println("9. See all historys hospitalization of the veterinary ");
  System.out.println("                                                                          |");
  System.out.println("10. give the contact of the owner of a hospitalized animal");
  System.out.println("                                                                          |");
  System.out.println("11. Previous clinical history of a pet");
  System.out.println("                                                                          |");
  System.out.println("12. Calculate service income ");
  System.out.println("                                                                          |");
  System.out.println("13. Calculate the total income of the veterinary ");
  System.out.println("                                                                          |");
  System.out.println("14. Add to the system new services provided by the veterinary ");
  System.out.println("                                                                          |");
  System.out.println("15. Average income for services ");
  System.out.println("                                                                          |");
  System.out.println("16. Average income of the veterinarian in a week.");
  System.out.println("                                                                          |");
  System.out.println("17. Report of services rendered given an initial date and a final date.");
  System.out.println("                                                                          |");
  System.out.println("18. Calculate the BMI of a pet.");
  System.out.println("                                                                          |");
  System.out.println("19. change a customer's address or phone number.");
  System.out.println("                                                                          |");
  System.out.println("20. Add a medicine to the hospitalized pet.");
  System.out.println("                                                                          |");
  System.out.println("21. Add a note of possible diagnosis to a hospitalized pet.");
  System.out.println("                                                                          |");
  System.out.println("22. Add a note of new symptoms to a hospitalized pet.");
  System.out.println("                                                                          |");
  System.out.println("23. Exit the program");
  System.out.println("---------------------------------------------------------------------------");


}
public void init(){
	
	
}

}






