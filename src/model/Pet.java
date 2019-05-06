package model;
import java.util.ArrayList;

public class Pet{
	// atributos
	private String name;
	private String typePet;
	private int age;
	private double weight;
	private double height;
	
	private ArrayList<ClinicHistory> historys;
	
	/**
	* Description: This is the constructor method.
	* @param The name of the pet.
	* @param The type of the pet.
	* @param The age of the pet.
	* @param The weight of the pet.
	* @param The height of the pet.
	*/
	public Pet(String theName, String theTypePet, int theAge, double theWeight, double height){
	name = theName;
	typePet = theTypePet;
	age = theAge;
	historys = new ArrayList<>();
	weight = theWeight;
	this.height = height;
	}
	
	/**
	* Description: This method allows knowing the name of the pet to another.
	* pre: The name of the pet already exists. 
	* @return The name of pet.
	*/
	public String getName(){
		return name;
	}
	/**
	* Description: This method allows changing the name of the pet through another class.
	* pre: the name of the pet already exists.
	* @param : The name you want to pet. 
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Description: This method allows to tell another class the type of the pet.
	* pre: The type of the pet already exists. 
	* @return The type of pet.
	*/
	public String getTypePet(){
		return typePet;
	}
	/**
	* Description: This method allows changing the type of the pet through another class.
	* pre: the type of the pet already exists.
	* @param : The type you want to pet. 
	*/
	public void setTypePet(String typePet){
		this.typePet = typePet;
	}
	/**
	* Description: This method allows to tell another class the age of the pet.
	* pre: The age of the pet already exists. 
	* @return The age of pet.
	*/
	public int getAge(){
		return age;
	}
	/**
	* Description: This method allows changing the age of the pet through another class.
	* pre: the age of the pet already exists.
	* @param : The age you want to pet. 
	*/
	public void setAge(int age){
		this.age = age;
	}
	/**
	* Description: This method allows to tell another class the weight of the pet.
	* pre: The weight of the pet already exists. 
	* @return The weight of pet.
	*/
	public double getWeight(){
		return weight;
	}
	/**
	* Description: This method allows changing the weight of the pet through another class.
	* pre: the weight of the pet already exists.
	* @param : The weight you want to pet. 
	*/
	public void setWeigth(double weight){
		this.weight = weight;
	}
	/**
	* Description: This method allows to tell another class the height of the pet.
	* pre: The height of the pet already exists. 
	* @return The height of pet.
	*/
	public double getHeight(){
		return height;
	}
	/**
	* Description: This method allows changing the height of the pet through another class.
	* pre: the height of the pet already exists.
	* @param : The height you want to pet. 
	*/
	public void setHeigth(double height){
		this.height = height;
	}
	/**
	* Description: This method allows to tell another class the list of arrangement of medical records of the pet.
	* pre: The height of the pet already exists. 
	* @return The height of pet.
	*/
	public ArrayList<ClinicHistory> getHistorys(){
		return historys;
	}
	/**
	* Description: This method allows adding a clinical history of the pet through another class.
	* pre: the the medical records of the pet already exists.
	* @param : The the medical records you want to pet. 
	* @param : The day of admission
	* @param : The month of admission
	* @param : The year of admission
	*/
	public void historyAdd(ClinicHistory hist,int day, int month, int year){
		historys.add(hist);
		for(int k = 0; k<historys.size();k++){
			if(historys.get(k)== hist){
				historys.get(k).dateAdd( day, month, year);
			}
		}
	}
	/**
	* Description: This method allows to tell another class the clinical history that is active of the pet.
	* pre: The history of the pet already exists. 
	* @return The clinical history is active of pet.
	*/
	public ClinicHistory foundHistory(){
		ClinicHistory hist = null;
		for(int i =0; i<historys.size();i++){
			if(historys.get(i).getState() == true){
				hist = historys.get(i);
			}
		}
		return hist;
	}
	/**
	* Description: This method allows to tell another class the pet income of medications.
	* pre: The history of the pet already exists. 
	* @return The pet income.
	*/
	public double petIncome(){
		double sum = 0.0;
		for(int i = 0; i< historys.size(); i++){
			sum += historys.get(i).medicationCost();
		}
		return sum;
	}
	/**
	* Description: This method allows to tell another class the days the pet was hospitalized until the current date.
	* pre: The history of the pet already exists. 
	* @param : Current day.
	* @param : Current month.
	* @param : Current year.
	* @return The number of days that the pet was hospitalized until the .
	*/
	public int dateOfPet(int dayN, int monthN, int yearN){
		int daysPet = 0;
		for(int i = 0; i< ClinicHistory.MAX_DATE; i++){
				int day2 =historys.get(i).getDateHospitalization1().getDay();
				int month2= historys.get(i).getDateHospitalization1().getMonth();
				int year2 = historys.get(i).getDateHospitalization1().getYear();
			if(historys.get(i).dateExit()!= null){
				int day1 =historys.get(i).dateExit().getDay();
				int month1= historys.get(i).dateExit().getMonth();
				int year1 = historys.get(i).dateExit().getYear();

				daysPet += 360*(year1-year2)+30*(month1-month2)+(day1-day2);
			}else{
				daysPet += 360*(year2-yearN)+30*(month2-monthN)+(day2-dayN);
			}
		}  
		return daysPet;
	}
	/**
	* Description: This method allows to tell another class the history of the pet is active.
	* pre: The history of the pet already exists. 
	* @return True if it is active and false if you do not.
	*/
	public boolean stateHistory(){
		boolean hist = false;
		for(int i =0; i<historys.size() && hist != true;i++){
			if(historys.get(i).getState() != false){
				hist = true;
			}
		}
		return hist;
	}
	/**
	* Description: This method allows to tell another class the clinical history of a pet.
	* pre: The history of the pet already exists. 
	* @return The clinical history of a pet.
	*/
	public String seeData(){
		String msg = "";
		for(int i = 0; i<historys.size();i++){
			if(historys.get(i).dateExit() == null){
				
				msg += "income on the date " + historys.get(i).getDateHospitalization1().getDay() + "/" + historys.get(i).getDateHospitalization1().getMonth() + "/" + historys.get(i).getDateHospitalization1().getYear()+"\n";  
				msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
				msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
				msg += "it was supplied: \n" + historys.get(i).nameMedicine();
				
				
				
			
			}
		}
		return msg;
		
	} 
	/**
	* Description: This method allows to tell another class all the clinical history of a pet.
	* pre: The history of the pet already exists. 
	* @return All the clinical history of a pet.
	*/
	public ArrayList<String> seeDataAnimal(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<historys.size();i++){
			
				
				msg += "income on the date " + historys.get(i).getDateHospitalization1().getDay() + "/" + historys.get(i).getDateHospitalization1().getMonth() + "/" + historys.get(i).getDateHospitalization1().getYear()+"\n"; 
				if(historys.get(i).dateExit()!= null){
					msg += "out on the date " + historys.get(i).dateExit().getDay() + "/" + historys.get(i).dateExit().getMonth() + "/" + historys.get(i).dateExit().getYear()+"\n"; 
				}
				msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
				if(historys.get(i).getState()!= false){
				msg += "the story is: \n" + " open \n";
				}else{
					msg += "the story is: \n" + " close \n";
				}
				msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
				msg += "it was supplied: \n" + historys.get(i).nameMedicine();
				
				menssage.add(msg);
				
			
			
		}
		return menssage;
	}
	/**
	* Description: This method allows to tell another class the days the pet was hospitalized until the current date.
	* pre: The history of the pet already exists. 
	* @param : Current day.
	* @param : Current month.
	* @param : Current year.
	* @return The number of days that the pet was hospitalized until the .
	*/
	public int dateOfPet1(int dayN, int monthN, int yearN){
		int daysPet = 0;
		for(int i = 0; i< ClinicHistory.MAX_DATE; i++){
				int day2 =historys.get(i).getDateHospitalization1().getDay();
				int month2= historys.get(i).getDateHospitalization1().getMonth();
				int year2 = historys.get(i).getDateHospitalization1().getYear();
			if(historys.get(i).dateExit()!= null){
				int day1 =historys.get(i).dateExit().getDay();
				int month1= historys.get(i).dateExit().getMonth();
				int year1 = historys.get(i).dateExit().getYear();

				daysPet += 360*(year1-year2)+30*(month1-month2)+(day1-day2);
			
			}
		}
		return daysPet;
	}		
	
	/**
	* Description: This method allows to tell another class the clinical history of a pet.
	* pre: The history of the pet already exists. 
	* @return The clinical history of a pet.
	*/
	public ArrayList<String> seeLastDataAnimal(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<historys.size();i++){
			
				if(historys.get(i).dateExit()!= null){
					if(historys.get(i).getState()!= true){
					msg += "income on the date " + historys.get(i).getDateHospitalization1().getDay() + "/" + historys.get(i).getDateHospitalization1().getMonth() + "/" + historys.get(i).getDateHospitalization1().getYear()+"\n"; 
				
					msg += "out on the date " + historys.get(i).dateExit().getDay() + "/" + historys.get(i).dateExit().getMonth() + "/" + historys.get(i).dateExit().getYear()+"\n"; 
				
					msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
				
				
					msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
					msg += "it was supplied: \n" + historys.get(i).nameMedicine();
					
					menssage.add(msg);
					}
				}
		
				
			
			
		}
		return menssage;
	}
	/*
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
	*/
	public double bmi(){
		double imc = 0.0;
		
		if(getHeight() == 0){
			imc = -1.0;
		}
		else{
			imc = weight/(height*height);
		}
		return imc;
	}

	
}