package model;

public class Room{
	//Atributos
	private int number;
	private Pet pet;
	/**
	* Description: This is the constructor method.
	* @param The room number.
	* @param The pet that is in the room.
	*/
	public Room(int theNumber, Pet thePet){
		number = theNumber;
		pet = thePet;
	}
	/**
	* Description: This method allows you to see the room number to another class.
	* pre: the number of the room was already created.
	* @return The room number.
	*/
	public int getNumber(){
		return number;
	}
	/**
	* Description: This method allows another class to change the room number.
	* pre: the number of the room was already created.
	* @param : The number to which you want to change the room. 
	*/
	public void setNumber(int number){
		this.number = number;
	}
	/**
	* Description: This method allows to see another class the pet that is in the room.
	* pre: The macota is already created.
	* @return The pet that is in the room.
	*/
	public Pet getPet(){
		return pet;
	}
	/**
	* Description: The method allows another class to change the pet.
	* pre: The macota is already created.
	* @param : The new mascot. 
	*/
	public void setPet(Pet pet){
		this.pet = pet;
	}
}