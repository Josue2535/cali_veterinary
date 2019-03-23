package model;
import java.util.ArrayList;

public class Veterinary{
	// Atributos
	
	public final static int ROOMS_MAX = 8;
	private String name;
	
	private Room[] rooms;
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> client;
	
	
	//constructor
	
	public Veterinary(String theName){
		name = theName;
		rooms = new Room[ROOMS_MAX];
		history = new ArrayList<>();
		client = new ArrayList<>();
		
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
	public ArrayList<Client> getClient(){
		return client;
	}
	//metodos
	//------------------------Agregar cliente y mascota--------------------------------------------------------
	public void addClient(String name, int id, String address , int phoneNumber, String nameM, String type, int age, double weight){
		Client customer = new Client(name, id, address, phoneNumber);
		client.add(customer);
		int u = 0;
		for(int i = 0; i < client.size(); i++){
			if(name.equals(client.get(i).getName())){
				client.get(i).addPet(nameM, type, age, weight);
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
		Client client1 = null;
		for(int i = 0; i<client.size();i++){
			if(client.get(i).getId()==id){
				for(int u = 0; u<client.get(i).pet.size(); u++)
				if(nameM.equals(client.get(i).pet.get(u).getName())){
					client.get(i).pet.get(u).addHistory(history).dateAdd(day, month, year);
				}
			}
		}
		return menssage;
	}
 
}

