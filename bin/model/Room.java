package model;

public class Room{
	//Atributos
	private int number;
	private Pet pet;
	//constructor
	public Room(int theNumber, Pet thePet){
		number = theNumber;
		pet = thePet;
	}
	//gets y sets
	public int getNumber(){
		return number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public Pet getPet(){
		return pet;
	}
	public void setPet(Pet pet){
		this.pet = pet;
	}
}