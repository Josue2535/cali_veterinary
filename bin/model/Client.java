package model;
import java.util.ArrayList;

public class Client{
	
	// Atributos
	private String name;
	private int id;
	private String address;
	private int phoneNumber;
	
	public final static String C = "Cat";
	public final static String D = "Dog";
	public final static String B = "Bird";
	public final static String O = "Other";
	
	//Relaciones
	private ArrayList<Pet> pets;
	
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
	public int petSize(){
		return pets.size();
	}
	public Pet positionOfThePet(int i){
		Pet pet = pets.get(i);
		return pet;
	}
	public void addHistory(ClinicHistory hist, int i, int day, int month, int year){
		pets.get(i).historyAdd(hist, day, month, year);
	}
	//---------------------------encontrar historia clinica----------------------------------------
	public ClinicHistory foundHistory(int i){
		return pets.get(i).foundHistory();
	}
	//--------------------------suma de costos por mascota--------------------------------------
	public double petsCost(){
		double sum = 0.0;
		for(int i = 0; i<petSize(); i++){
			sum += pets.get(i).petIncome();
		}
		return sum;
	}
	
}