package model;
import java.util.ArrayList;

public class ClinicHistory{
	//Atributos
	private boolean state;
	private String symptom;
	private String diagnostic;
	
	private ArrayList<Client> human;
	private ArrayList<Medicine> medicine;
	private ArrayList<Date> dateHospitalization;
	private ArrayList<Date> dateExit;
	//constructosr
	public ClinicHistory(String theDateHospitalization, boolean theState, String theSymptom, String theDiagnostic){
		
		state = theState;
		symptom = theSymptom;
		diagnostic = theDiagnostic;
		human = new ArrayList<>();
		medicine = new ArrayList<>();
		dateHospitalization = new ArrayList<>();
		dateExit = new ArrayList<>();
	}
	//gets y sets
	public boolean getState(){
		return state;
	}
	public void setState(boolean state){
		this.state = state;
	}
	public String getSymptom(){
		return symptom;
	}
	public void setSymptom(String symptom){
		this.symptom = symptom;
	}
	public String getDiagnostic(){
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}
	public ArrayList<Client> getHuman(){
		return human;
	}
	public ArrayList<Medicine> getMedicine(){
		return medicine;
	}
	public ArrayList<Date> getDateHospitalization(){
		return dateHospitalization;
	}
	public ArrayList<Date> getDateExit(){
		return dateExit;
	}
	//Metodos
	//-------------------------Añadir fecha de ingreso----------------------------------------------------------
	public void addDate(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateHospitalization.add(date);
	}
	//------------------------Añir fecha de salida---------------------------------------------------------------
	public void addDateExit(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateExit.add(date);
	}
}