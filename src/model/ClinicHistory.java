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
	public void addMedicine(String name, double quantify, double price, double frecuency){
		Medicine medicines = new Medicine(name,quantify, price, frecuency);
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
			double frecuancy = medicine.get(i).getFrecuency();
			
			
			
			sum += (quantify*price)*frecuancy;
		}
		return sum;
	}
	/*
	*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New medicines were added to the patient clinic story.
	*@param The medicine name. This param must be not null.
	*@param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
	*@param The medicine cost by each dose. This param could be empty.
	*@param The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/

	
	public String addMedication(String n, double q, double p, double f){
		String ms = "Se agrego la medicina del paciente";
		Medicine m = new Medicine(n, q, p, f);
		medicine.add(m);
		return ms;
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
	public Date getDateHospitalization1(){
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
	/**
	*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: A new symptom were added to the patient clinic story.
	*@param The new symptom presented. This param must be not null.
	*/

	public void newNote(String note){
		String ms = getSymptom() + note + "\n";
		setSymptom(ms);
	}
	/**
	*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New notes were added to the possible diagnostic in the patient clinic story.
	*@param The notes of possible diagnostic. This param must be not null.
	*/
	public void note(String note){
		String ms = getDiagnostic() + "\n nueva nota: \n" + "\n";
		setDiagnostic(ms);
	}
	
	
	/**
	* Description: This method allows <br> classes can access name of the medicine.
	* pre: The medicine are not null.
	* post: The name of the medicine.
	* @param : The first date you want to see
	* @return The name of the medicine.
	*/
	public boolean verifyDate(Date date1, Date date2){
		
		boolean range = false;
		
		if((getDateHospitalization1().getYear() >= date1.getYear()) && (getDateHospitalization1().getYear() <= date2.getYear())){
			
			if(date1.getYear() == date2.getYear()){
				
				if(date1.getMonth() == date2.getMonth()){
					
					if(getDateHospitalization1().getMonth() == date1.getMonth()){
					
						if((getDateHospitalization1().getDay() >= date1.getDay()) &&(getDateHospitalization1().getDay() <= date2.getDay())){
							
							range = true;
						}
					}
				}
				else{
					
					if((getDateHospitalization1().getMonth() > date1.getMonth()) && (getDateHospitalization1().getMonth() < date2.getMonth())){
						
						range = true;
					}
					else if((getDateHospitalization1().getMonth() == date1.getMonth()) && (getDateHospitalization1().getDay() >= date1.getDay())){
						
						range = true;
					}
					else if((getDateHospitalization1().getMonth() == date2.getMonth()) && (getDateHospitalization1().getDay() <= date2.getDay())){
						
						range = true;
					}
				}
			}
			else{
				
				if((getDateHospitalization1().getYear() > date1.getYear())&&(getDateHospitalization1().getYear() < date2.getYear())){
					
					range = true;
				}
				else if(getDateHospitalization1().getYear() == date1.getYear()){
					
					if(getDateHospitalization1().getMonth() > date1.getMonth()){
						
						range = true;
					}
					else if(getDateHospitalization1().getMonth() == date1.getMonth()){
						
						if(getDateHospitalization1().getDay() >= date1.getDay()){
						
							range = true;
						}
					}
				}
				else if(getDateHospitalization1().getYear() == date2.getYear()){
					
					if(getDateHospitalization1().getMonth() < date2.getMonth()){
						
						range = true;
					}
					else if(getDateHospitalization1().getMonth() == date2.getMonth()){
						
						if(getDateHospitalization1().getDay() <= date2.getDay()){
						
							range = true;
						}
					}
				}

			}
		}
		
		return range;
	}
	/**
	* Description: This method allows to see another class the pet that is in the room.
	* pre: The macota is already created.
	* @return The pet that is in the room.
	*/
	public Pet getPet(){
		
		return pet ;
	}
	/**
	* Description: This method allows to see another class the BMI of the pet in case it is.
	* pre: The macota is already created.
	* @param : The name of the pet that the BMI wants to know about.
	* @return The BMI in case the name of the pet coincides.
	*/
	public String peti(String name){
		String ms = "";
		if(name.equals(pet.getName())){
			ms += "The BMI of the mascot is: " + pet.bmi();
		}
		return ms;
	}
	
}