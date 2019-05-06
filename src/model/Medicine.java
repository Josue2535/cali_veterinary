package model;

public class Medicine{
	//Atributos
	private String name;
	private double quantify;
	private double price;
	private double frecuency;
	
	
	/**
	* Description: This is the constructor method.
	* @param The name.
	* @param The quantify.
	* @param The price.
	* @param The frecuency.
	* @param The dose given.
	*/
	public Medicine(String theName, double theQuantify, double thePrice, double theFrecuency ){
		name = theName;
		quantify = theQuantify;
		price = thePrice;
		frecuency = theFrecuency;
		
	}
	/**
	* Description: This method allows that other <br> classes can access to the medicine name.
	* pre: The medicine was initialized before and it's status atribute isn't null. 
	* @return The name of the medicine.
	*/
	public String getName(){
		return name;
	}
	/**
	* Description: This method allows <br> changing the name of medicine.
	* pre:the name is not null.
	* post:the name was changed.
	* @param the name to which you <br> want to change.
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Description: This method allows that other <br> classes can access to the medicine quantify.
	* pre: The medicine was initialized before and it's status atribute isn't null. 
	* @return The quantify of the medicine.
	*/
	public double getQuantify(){
		return quantify;
	}
	/**
	* Description: This method allows <br> changing the quantify.
	* pre:the medicine is not null.
	* post:the quantify was changed.
	* @param the quantify to which you <br> want to change.
	*/
	public void setQuantify(double quantify){
		this.quantify = quantify;
	}
	/**
	* Description: This method allows that other <br> classes can access to the medicine price.
	* pre: The medicine was initialized before and it's status atribute isn't null. 
	* @return The price of the medicine.
	*/
	public double getPrice(){
		return price;
	}
	/**
	* Description: This method allows <br> changing the price.
	* pre:the price is not null.
	* post:the price was changed.
	* @param the price to which you <br> want to change.
	*/
	public void setPrice(double price){
		this.price = price;
	}
	/**
	* Description: This method allows that other <br> classes can access to frecuency of the medicine .
	* pre: The medicine was initialized before and it's status atribute isn't null. 
	* @return The frecuency of the medicine.
	*/
	public double getFrecuency(){
		return frecuency;
	}
	/**
	* Description: This method allows <br> changing the frecuency.
	* pre:the medicine is not null.
	* post:the frecuancy was changed.
	* @param the frecuency to which you <br> want to change.
	*/
	public void setFrecuency(double frecuency){
		this.frecuency = frecuency;
	}
	
	/**
	* Description: This method allows that other <br> classes can access to cost of medicine .
	* pre: The medicine was initialized before and it's status atribute isn't null. 
	* @return The cost of medicine.
	*/
	public double medicineCost(){
		return (quantify*price)*frecuency;
	}
}