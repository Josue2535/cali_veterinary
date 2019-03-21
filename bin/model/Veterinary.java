package model;
import java.util.ArrayList;

public class Veterinary{
	// Atributos
	
	public final static int HOS = 1;
	private String name;
	
	private ArrayList<Hospitalization> hospi;
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> client;
	
	//constructor
	
	public Veterinary(String theName){
		name = theName;
		hospi = new ArrayList<>();
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
	public ArrayList<Hospitalization> getHospi(){
		return hospi;
	}
	public ArrayList<ClinicHistory> getHistory(){
		return history;
	}
	public ArrayList<Client> getClient(){
		return client;
	}
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

 
}

