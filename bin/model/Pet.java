package model;
import java.util.ArrayList;

public class Pet{
	// atributos
	private String name;
	private String typePet;
	private int age;
	private double weight;
	
	public ArrayList<ClinicHistory> historys;
	
	//Costructor
	public Pet(String theName, String theTypePet, int theAge, double theWeight){
	name = theName;
	typePet = theTypePet;
	age = theAge;
	historys = new ArrayList<>();
	weight = theWeight;
	}
	
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getTypePet(){
		return typePet;
	}
	public void setTypePet(String typePet){
		this.typePet = typePet;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public double getWeight(){
		return weight;
	}
	public void setWeigth(double weight){
		this.weight = weight;
	}
	public ArrayList<ClinicHistory> getHistorys(){
		return historys;
	}
	// metodos
	
}