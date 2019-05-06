package model;
import java.util.ArrayList;

public class Client{
	
	// Atributos
	private String name;
	private int id;
	private String address;
	private int phoneNumber;
	
	
	//Relaciones
	private ArrayList<Pet> pets;
	/**
	* Description: This is the constructor method.
	* @param The name of the client.
	* @param The client Id.
	* @param The client address.
	* @param The client phone.
	*/
	public Client(String theName, int theId, String theAddress, int thePhoneNumber){
		name = theName;
		id = theId;
		address = theAddress;
		phoneNumber = thePhoneNumber;
		pets = new ArrayList<>();
	}
	/**
	* Description: This method allows knowing the name of client to another class.
	* pre: The name of the client already exists. 
	* @return The name of client.
	*/
	public String getName(){
		return name;
	}
	/**
	* Description: This method allows changing the name of the client through another class.
	* pre: the name of the client already exists.
	* @param : The name you want to client. 
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Description: This method allows knowing the ID of client to another class .
	* pre: The Id of the client already exists. 
	* @return The ID of client.
	*/
	public int getId(){
		return id;
	}
	/**
	* Description: This method allows changing the ID of the client through another class.
	* pre: the ID of the client already exists.
	* @param : The ID you want to client. 
	*/
	public void setId(int id){
		this.id = id;
	}
	/**
	* Description: This method allows knowing the address of client to another class.
	* pre: The address of the client already exists. 
	* @return The address of client.
	*/
	public String getAddress(){
		return address;
	}
	/**
	* Description: This method allows changing the address of the client through another class.
	* pre: the address of the client already exists.
	* @param : The address you want to client. 
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**
	* Description: This method allows knowing the phone number of client to another class.
	* pre: The phone number of the client already exists. 
	* @return The phone number of client.
	*/
	public int getPhoneNumber(){
		return phoneNumber;
	}
	/**
	* Description: This method allows changing the phone number of the client through another class.
	* pre: the phone number of the client already exists.
	* @param : The phone number you want to client. 
	*/
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	/**
	* Description: This method allows to see another class the pet arrangement that the client has
	* pre: The pet arrangement that the client has been created.
	* @return The pet arrangement that the client has.
	*/
	public ArrayList<Pet> getPets(){
		return pets;
	}
	/**
	* Description: This method allows add the new pet to the client's pet arrangement.
	* pre: The pet arrangement that the client has been created.
	* @param The name of the pet.
	* @param The type of the pet.
	* @param The age of the pet.
	* @param The weight of the pet.
	* @param The height of the pet. 
	*/
	public void addPet(String nameM, String type, int age, double weight, double height){
		Pet pet = new Pet(nameM, type, age, weight, height);
		pets.add(pet);
	}
	/**
	* Description: This method allows to see another class the the number of pets a client has.
	* pre: The pet arrangement that the client has been created.
	* @return the number of pets a client has.
	*/
	public int petSize(){
		return pets.size();
	}
	/**
	* Description: This method allows to see another class access the pet in said position.
	* pre: The pet arrangement that the client has been created.
	* @param : The position in which the pet is found.
	* @return The pet that is in that position.
	*/
	public Pet positionOfThePet(int i){
		Pet pet = pets.get(i);
		return pet;
	}
	/**
	* Description: This method allows add a clinical history to a pet in a given position another class.
	* pre: The pet arrangement that the client has been created.
	* @param : The medical history of the pet.
	* @param : The position in which the pet is found.
	* @param : Current day.
	* @param : Current month.
	* @param : Current year.
	*/
	public void addHistory(ClinicHistory hist, int i, int day, int month, int year){
		pets.get(i).historyAdd(hist, day, month, year);
	}
	//---------------------------encontrar historia clinica----------------------------------------
	public ClinicHistory foundHistory(int i){
		return pets.get(i).foundHistory();
	}
	//--------------------------suma de costos por mascota--------------------------------------
	public double petsCost(int dayN, int monthN, int yearN){
		double sum = 0.0;
		for(int i = 0; i< petSize();i++){
			if("Car".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*15000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}
			}else if("Dog".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*15000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*25000;
				}
			}else if("Bird".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*25000;
				}
			}else if("Other".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*30000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*30000;
				}
			}


		}
		
		return sum;
	}
	public boolean stateHistory(int i){
		return pets.get(i).stateHistory();
	}
	//-------------------------mostrar mascotas hospitalizadas--------------------------
	public ArrayList<String> showPetsHospitalizad(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<pets.size();i++){
			if(stateHistory(i) != false){
				msg += "The name of the pet is " + pets.get(i).getName() + " is a"+ pets.get(i).getTypePet() +"\n";
				msg += pets.get(i).seeData();

				menssage.add(msg);
			}
		}
		
		return menssage;
	}
	//----------------------mostrar historia de una mascota-----------------------------
	public String seeDataAnimal(String name){
		String msg = "";
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				for(int k = 0; k<pets.get(i).seeDataAnimal().size(); k++ ){
				msg = pets.get(i).seeDataAnimal().get(k);
				}
			}
		}
		return msg;
	}
	//-------------------Costo de mascota hospitalizada----------------------------
	public double costPet(String name, int dayN, int monthN, int yearN){
		double cost = 0.0;
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				if("Car".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1( dayN,  monthN,  yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*15000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}
			}else if("Dog".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*15000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*25000;
				}
			}else if("Bird".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*25000;
				}
			}else if("Other".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*30000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*30000;
				}
			}
			cost += pets.get(i).petIncome();
			}
		}
		return cost;
	}
	//--------------------historias anteriores de la mascota-----------------------------
	public String seeLastDataAnimal(String name){
		String msg = "";
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				for(int k = 0; k<pets.get(i).seeLastDataAnimal().size(); k++)
				msg = pets.get(i).seeLastDataAnimal().get(k);
			}
		}
		return msg;
	}
	/**
	*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*pre: The client was created before.
	*post: The address and /or phone number of the client is updated.
	*@param The new address of the client. This param could be empty.
	*@param The new phone number of the client. This param could be empty.
	*/
	public void updateData(String address, int phoneNumber){
		
		if(!(address.equals(""))){
			
			setAddress(address);
		}
		if(phoneNumber != 0){
			
			setPhoneNumber(phoneNumber);
		}
	}

}