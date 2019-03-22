package model;
import java.util.ArrayList;

public class Veterinary{
	// Atributos
	
	public final static int HOS = 1;
	public final static int ROOMS_MAX = 8;
	private String name;
	
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> client;
	private Room[] rooms;
	
	
	//constructor
	
	public Veterinary(String theName){
		name = theName;
		history = new ArrayList<>();
		client = new ArrayList<>();
		rooms = new Room[ROOMS_MAX];
	}
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<ClinicHistory> getHistory(){
		return history;
	}
	public ArrayList<Client> getClient(){
		return client;
	}
	public 
	//metodos
	//Agregar cliente y mascota
	public void addClient(String name, int id, String address , int phoneNumber, String nameM, String type, int age, double weight){
		Client customer = new Client(name, id, address, phoneNumber);
		client.add(customer);
		int u = 0;
		for(int i = 0; i < client.size(); i++){
			if(name == client.get(i).getName()){
				client.get(i).addPet(nameM, type, age, weight);
			}
		}
	}
	public String assignPet(Pet pet){
		String menssage = "";
		boolean bol = false;
		for(int i = 0; i < ROOMS_MAX && bol == false; i++){
			if(rooms[i] != null){
				rooms[i].setPet(pet);
				menssage = "La mascota ha sido agregada";
				bol = true;
			}
		}
		if(bol == false){
			menssage = "No se pudo agregar la mascota";
		}
		return menssage;
	}
	public boolean stateHistory(){
		boolean lu = false;
		
		return lu;
	}	

 
}

