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
	public String createHistoryPet(int id, String nameM, String symptom, String diagnostic, boolean state, int day, int month, int year){
		String menssage = "";
		ClinicHistory hist = new ClinicHistory(state, symptom, diagnostic);
		for(int i = 0; i<clientSize();i++){
			if(clients.get(i).getId()==id){
				int k = i;
				for(int u = 0; u<petSize(i); u++){
					int w = u;
				if(foundPet(k , w, nameM)!= false){
					clients.get(i).addHistory(hist, u, day, month, year);
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
 
}

