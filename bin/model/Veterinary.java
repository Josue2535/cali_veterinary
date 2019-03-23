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
			if(name.equals(clients.get(i).getName())){
				clients.get(i).addPet(nameM, type, age, weight);
			}
		}
	}
	//-------------------------------------Ver si hay disponibilidad en los cuartos----------------------------------------------------------------------
	public String availabilityOfTheRoom(int room){
		String menssage = "";
		if(rooms[room].getPet() != null){
			menssage = "Sin disponibilidad";
		}
		else{
			menssage = "Disponible";
		}
		return menssage;
	}
	//---------------------------Crear la historia de una mascota------------------------------------------------------------------
	public String createHistoryPet(int id, String nameM, String symptom, String diagnostic, boolean state, int day, int month, int year){
		String menssage = "";
		ClinicHistory hist = new ClinicHistory(state, symptom, diagnostic);
		for(int i = 0; i<clients.size();i++){
			if(clients.get(i).getId()==id){
				for(int u = 0; u<clients.get(i).pets.size(); u++)
				if(nameM.equals(clients.get(i).pets.get(u).getName())){
					clients.get(i).pets.get(u).historys.add(hist);
					clients.get(i).pets.get(u).historys.get(0).dateAdd(day, month, year);
					menssage = "Se ha creado la historia clinica";
				}
			}
		}
		return menssage;
	}
 
}

