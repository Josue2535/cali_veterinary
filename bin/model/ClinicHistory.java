package model;
import java.util.ArrayList;

public class ClinicHistory{
	//Atributos
	private String dateHospitalization;
	private boolean state;
	private String symptom;
	private String diagnostic;
	
	private ArrayList<Client> human;
	private ArrayList<Medicine> medicine;
	
	//constructosr
	public ClinicHistory(String theDateHospitalization, boolean theState, String theSymptom, String theDiagnostic){
		dateHospitalization = theDateHospitalization;
		state = theState;
		symptom = theSymptom;
		diagnostic = theDiagnostic;
		human = new ArrayList<>();
		medicine = new ArrayList<>();
	}
	//gets y sets
	public String getDateHospitalization(){
		return dateHospitalization;
	}
	public void setDateHospitalization(String dateHospitalization){
		this.dateHospitalization = dateHospitalization;
	}
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
}