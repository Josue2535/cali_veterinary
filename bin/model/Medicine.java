package model;

public class Medicine{
	//Atributos
	private String name;
	private double quantify;
	private double price;
	private double frecuency;
	
	//constructor
	public Medicine(String theName, double theQuantify, double thePrice, double theFrecuency){
		name = theName;
		quantify = theQuantify;
		price = thePrice;
		frecuency = theFrecuency;
	}
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public double getQuantify(){
		return quantify;
	}
	public void setQuantify(double quantify){
		this.quantify = quantify;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public double getFrecuency(){
		return frecuency;
	}
	public void setFrecuency(double frecuency){
		this.frecuency = frecuency;
	}
	//metodos
}