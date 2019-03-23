package model;
import java.util.ArrayList;

public class Client{
	
	// Atributos
	private String name;
	private int id;
	private String address;
	private int phoneNumber;
	
	public final static String GATO = "Gato";
	public final static String PERRO = "Perro";
	public final static String AVE = "Ave";
	
	//Relaciones
	public ArrayList<Pet> pets;
	
	public Client(String theName, int theId, String theAddress, int thePhoneNumber){
		name = theName;
		id = theId;
		address = theAddress;
		phoneNumber = thePhoneNumber;
		pets = new ArrayList<>();
	}
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Pet> getPets(){
		return pets;
	}
	// metodos 
	public void addPet(String nameM, String type, int age, double weight){
		Pet pet = new Pet(nameM, type, age, weight);
		pets.add(pet);
	}
	
}