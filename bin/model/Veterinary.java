package model;
import java.util.ArrayList;

public class Veterinary{
	// Atributos
	
	public final static int ROOMS_MAX = 8;
	private String name;
	
	private Room[] rooms;
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> clients;
	
	
	//constructor
	
	public Veterinary(String theName){
		name = theName;
		rooms = new Room[ROOMS_MAX];
		history = new ArrayList<>();
		clients = new ArrayList<>();
		
	}
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Room[] getRooms(){
		return rooms;
	}
	public void setRooms(Room[] rooms){
		this.rooms = rooms;
	}
	public ArrayList<ClinicHistory> getHistory(){
		return history;
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	//metodos
	//------------------------Agregar cliente y mascota--------------------------------------------------------
	public void addClient(String name, int id, String address , int phoneNumber, String nameM, String type, int age, double weight){
		Client customer = new Client(name, id, address, phoneNumber);
		clients.add(customer);
		int u = 0;
		for(int i = 0; i < clients.size(); i++){
			if(foundClient(id, i) != false){
				clients.get(i).addPet(nameM, type, age, weight);
			}
		}
	}
	
	
	
	//------------------------------------buscar cliente---------------------------------------------------------------------------------------
	public boolean foundClient(int id, int i){
		boolean foundClient = false;
		
		if(id == clients.get(i).getId()){
			foundClient = true;
		}
		return foundClient;
	}
	
	
	
	
	//-----------------------------------buscar mascota---------------------------------------------------------------------------------------------
	public boolean foundPet(int i,int k, String name){
		boolean foundPet = false;
		if(name.equals(clients.get(i).positionOfThePet(k).getName())){
			foundPet = true;
		}
		return foundPet;
	}
	
	
	
	
	
	//-------------------------------------Ver si hay disponibilidad en los cuartos----------------------------------------------------------------------
	public boolean availabilityOfTheRoom(int room){
		boolean menssage = false;
		if(rooms[room].getPet() != null){
			menssage = false;
		}
		else{
			menssage = true;
		}
		return menssage;
	}
	
	
	
	
	//---------------------------Crear la historia de una mascota------------------------------------------------------------------
	public String createHistoryPet(int id, String nameM, String symptom, String diagnostic, boolean state, int day, int month, int year, String nameMedicine, double quantify, double price, double frecuency, int doseGiven){
		String menssage = "";
		Medicine medicine = new Medicine(nameMedicine, quantify, price, frecuency, doseGiven);
		ClinicHistory hist = new ClinicHistory(state, symptom, diagnostic);
		for(int i = 0; i<clientSize();i++){
			if(clients.get(i).getId()==id){
				int k = i;
				for(int u = 0; u<petSize(i); u++){
					int w = u;
				if(foundPet(k , w, nameM)!= false){
					clients.get(i).addHistory(hist, u, day, month, year);
					clients.get(i).foundHistory(k).addMedication(medicine);
					menssage = "The clinical history has been created";
				}else{
					menssage = "Unable to create the clinical history";
				}
				}
			}else{
				menssage = "Unable to create the clinical history";
			}
		}
		return menssage;
	}
	//--------------------------------------cerrar la historia clinica----------------------------------------------------------------
	public boolean closeHistory(int id, String nameM, int day, int month, int year ){
		boolean close = false;
		for(int i = 0; i<clientSize(); i++){
			if(foundClient(id, i)!=false && close != true){
				for(int k = 0; k< petSize(i); k++)
					if(foundPet(i, k, nameM) != false && close != true){
						for(int e = 0; e < ROOMS_MAX; e++){
							if(clients.get(i).positionOfThePet(k) == rooms[e].getPet()){
								rooms[e].setPet(null);
								clients.get(i).foundHistory(k).addDateExit(day, month, year);
								clients.get(i).foundHistory(k).setState(false);
								close = true;
							}
						}
					}
			}
				
			
		}
		return close;
	}
	
	
	
	
	//-------------hospitalizar mascota------------------------------------------------------------------------------------------------
	public String hospitalizePet(int id,String nameM){
		String menssage = "";
		
		
		for(int i = 0; i<clients.size(); i++){
			if(foundClient(id, i) != false){
				for(int u = 0; u<petSize(i); u++){
					if(foundPet(i, u, nameM) !=false){
					
						for(int k = 0; k<ROOMS_MAX; k++){
							if(availabilityOfTheRoom(k) != false){
								String name = nameM;
								String type = clients.get(i).positionOfThePet(u).getTypePet();
								int age = clients.get(i).positionOfThePet(u).getAge();
								double weight = clients.get(i).positionOfThePet(u).getWeight();
								Pet pet = new Pet(name, type, age, weight);
								rooms[k].setPet(pet);
							}else{
								menssage = "there are no rooms available.";
							}
						
						}
				}else{
						menssage = "the pet was not found";
					}
				}
			}else{
				menssage = "The client was not found";
			}
		}
		return menssage;
	}
	//---------------------------------------------------------------clients.size()&&pets.size()------------------------------------------------------
	public int clientSize(){
		return clients.size();
	}
	public int petSize(int i){
		return clients.get(i).petSize();
	}
	
	//--------------------------------------------------------------Ingresos totales de la veterinaria------------------------------------------------
	public double veterinaryIncome(int dayN, int yearN, int monthN){
		double sum = 0.0;
		for(int i = 0; i<clientSize();i++){
			sum += clients.get(i).petsCost(dayN, yearN, monthN);
		}
		return sum;
	}
	//------------------------------------------------Cuarto de la mascota---------------------------------------------------------------------------------------------
	public int petsRoom(String nameM){
		int number = 0;
		for(int i = 0; i<ROOMS_MAX;i ++){
			if(nameM.equals(rooms[i].getPet().getName())){
				number = i++;
			}
		}
		return number;
	}
	//------------------------------------------Saber si esta hospitalizada la mascota--------------------------------------------------------
	public boolean availabilityThePet(String nameM){
		boolean availability= false;
		for(int i = 0; i<clientSize()&&availability != true; i++){
			for(int k = 0; k<clients.get(i).petSize(); k++){
				if(foundPet(k, i, nameM)!=false){
					availability=clients.get(i).stateHistory(k);
				}
			}
		}
		return availability;
	}
 
}

