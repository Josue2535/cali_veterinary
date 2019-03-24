package model;
import java.util.ArrayList;

public class Pet{
	// atributos
	private String name;
	private String typePet;
	private int age;
	private double weight;
	
	private ArrayList<ClinicHistory> historys;
	
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
	public void historyAdd(ClinicHistory hist,int day, int month, int year){
		historys.add(hist);
		for(int k = 0; k<historys.size();k++){
			if(historys.get(k)== hist){
				historys.get(k).dateAdd( day, month, year);
			}
		}
	}
	public ClinicHistory foundHistory(){
		ClinicHistory hist = null;
		for(int i =0; i<historys.size();i++){
			if(historys.get(i).getState() == true){
				hist = historys.get(i);
			}
		}
		return hist;
	}
	//-------------------------------------------------------ingresos por masconta-----------------------------------------------------------
	public double petIncome(){
		double sum = 0.0;
		for(int i = 0; i< historys.size(); i++){
			sum += historys.get(i).medicationCost();
		}
		return sum;
	}
}