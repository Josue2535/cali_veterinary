package model;

public class Hospitalization{
	//Atributos
		
	public final static int ROOMS_MAX = 8;
	private Room[] rooms;
	//constructor
	public Hospitalization(){
		rooms = new Room[ROOMS_MAX];
	}
	//metodos
}