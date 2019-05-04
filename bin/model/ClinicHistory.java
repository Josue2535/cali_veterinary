package model;
import java.util.ArrayList;

public class ClinicHistory{
	//Atributos
	private boolean state;
	private String symptom;
	private String diagnostic;
	public final static int MAX_DATE = 1;
	private Pet pet;
	
	private ArrayList<Medicine> medicine;
	private Date[] dateHospitalization;
	private Date[] dateExit;
	
	
	/**
	* Description: This is the constructor method.
	* @param The status of the medical history.
	* @param The presented symptoms.
	* @param The hospitalization date.
	* @param the date of departure.
	* @param The hospitalizated pet.
	* @param The the posible diagnosis.
	*/
	public ClinicHistory(boolean theState, String theSymptom, String theDiagnostic, Pet pet){
		
		state = theState;
		symptom = theSymptom;
		diagnostic = theDiagnostic;
		medicine = new ArrayList<>();
		dateHospitalization = new Date[MAX_DATE];
		dateExit = new Date[MAX_DATE];
		this.pet = pet;
	}
	
	
	/**
	* Description: This method allows that other <br> classes can access to the status of medical history.
	* pre: The medical history was initialized before and it's status atribute isn't null. 
	* @return The medical history's state.
	*/
	public boolean getState(){
		return state;
	}
	
	
	/**
	* Description: This method allows <br> changing the state of story.
	* pre:the state is not null.
	* post:the state was changed.
	* @param the state to which you <br> want to change the story
	*/
	public void setState(boolean state){
		this.state = state;
	}
	
	/**
	* Description: This method allows that other <br> classes can access the symptoms of the pet.
	* pre:the symptoms of the pet have <br> already been initialized. 
	* @return The symptoms of the pet.
	*/
	public String getSymptom(){
		return symptom;
	}
	
	
	/**
	* Description: This method allows <br> changing the symtom of the pet.
	* pre: The symptoms are not null.
	* post: the symtom was changed.
	* @param the symtom to which you <br> want to change the story
	*/
	public void setSymptom(String symptom){
		this.symptom = symptom;
	}
	
	
	/**
	* Description: This method allows that other <br> classes can access the possible diagnosis of the pet.
	* pre:the possible diagnosis of the pet have <br> already been initialized. 
	* @return The possible diagnosis of the pet.
	*/
	public String getDiagnostic(){
		return diagnostic;
	}
	
	
	/**
	* Description: This method allows <br> changing the symtom of the pet.
	* pre: The symptoms are not null.
	* post: the symtom was changed.
	* @param the possible diagnosis to which you <br> want to change the story.
	*/
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}
	
	
	
	/**
	* Description: This method allows that other <br> classes can access the medicine of the pet.
	* pre:the medicine of the pet have <br> already been initialized. 
	* @return The medicine of the pet.
	*/
	public ArrayList<Medicine> getMedicine(){
		return medicine;
	}
	
	/**
	* Description: This method allows that other <br> classes can access the date of hospitalization of the pet.
	* pre:the possible diagnosis of the pet have <br> already been initialized. 
	* @return The possible diagnosis of the pet.
	*/
	public Date[] getDateHospitalization(){
		return dateHospitalization;
	}
	
	/**
	* Description: This method allows <br> changing the date hospitalization	of the pet.
	* pre: The date hospitalizated are not null.
	* post: the date of hopitalization was changed.
	* @param the possible diagnosis to which you <br> want to change the story.
	*/
	public void setDateHospitalization(Date[] dateHospitalization){
		this.dateHospitalization = dateHospitalization;
	}
	
	
	/**
	* Description: This method allows that other <br> classes can access the date exit of the pet.
	* pre:the date exit of the pet have <br> already been initialized. 
	* @return The date exit of the pet.
	*/
	
	public Date[] getDateExit(){
		return dateExit;
	}
	
	
	
	/**
	* Description: This method allows <br> changing the date hospitalization	of the pet.
	* pre: The date hospitalizated are not null.
	* post: the date exit of hopitalization was changed.
	* @param the date exit to which you <br> want to change the story.
	*/
	
	public void setDateExit(Date[] dateExit){
		this.dateExit = dateExit;
	}
	
	
	/**
	* Description: This method allows <br> add the date exit of the pet.
	* post: the date exit is added.
	* @param the day of hospitalization.
	* @param the mont of hospitalization.
	* @param the year of hospitalization.
	*/
	public void dateAdd(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateHospitalization[0]=date;
		
	}
	/**
	* Description: This method allows <br> add the date hospitalization of the pet.
	* post: the date of hopitalization is added.
	* @param the day of exit.
	* @param the mont of the exit.
	* @param the year of the exit.
	*/
	public void addDateExit(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateExit[0] = date;
	}
	/**
	* Description: This method allows <br> add the medicine of the pet.
	* post: the medication is added.
	* @param the name of the medicine.
	* @param the quantify of the medicine.
	* @param the price of medicine.
	* @param the frecuancy of medicine.
	* @param the dose given of medicine.
	*/
	public void addMedicine(String name, double quantify, double price, double frecuency, int doseGiven){
		Medicine medicines = new Medicine(name,quantify, price, frecuency, doseGiven);
		medicine.add(medicines);
	}
	
	/**
	* Description: This method allows that other <br> classes can access the date exit of the pet.
	* pre:the medicine of the pet have <br> already been initialized. 
	* @return The medicine cost.
	*/
	public double medicationCost(){
		double sum = 0.0;
		for(int i = 0; i < medicine.size(); i++){
			double quantify = medicine.get(i).getQuantify();
			double price = medicine.get(i).getPrice();
			double doseGiven = medicine.get(i).getDoseGiven();
			
			
			
			sum += (quantify*price)*doseGiven;
		}
		return sum;
	}
	/**
	* Description: This method allows <br> add the medicine.
	* post: The medicine is added.
	* @param The madication to which you <br> want to add the story.
	*/
	
	public void addMedication(Medicine medicines){
		
		medicine.add(medicines);
	}
	/**
	* Description: This method allows <br> classes can access the date exit of the pet.
	* pre: The date exit are not null.
	* post: The frist date exit.
	* @return The frist date exit.
	*/
	public Date dateExit(){
		return dateExit[0];
	}
	/**
	* Description: This method allows <br> classes can access the date hospitalization of the pet.
	* pre: The date hospitalization are not null.
	* post: The frist date hopitalization.
	* @return The frist date hospitalization.
	*/
	public Date dateHospitalization(){
		return dateHospitalization[0];
	}
	/**
	* Description: This method allows <br> classes can access name of the medicine.
	* pre: The medicine are not null.
	* post: The name of the medicine.
	* @return The name of the medicine.
	*/
	public String nameMedicine(){
		String msg = "";
		for(int i = 0; i<medicine.size();i++){
			msg += "" + medicine.get(i).getName() + "\n";
		}
		return msg;
	}
	
}