package model;
import java.util.ArrayList;

public class ClinicHistory{
	//Atributos
	private boolean state;
	private String symptom;
	private String diagnostic;
	public final static int MAX_DATE = 1;
	
	private ArrayList<Client> human;
	private ArrayList<Medicine> medicine;
	private Date[] dateHospitalization;
	private Date[] dateExit;
	//constructosr
	public ClinicHistory(boolean theState, String theSymptom, String theDiagnostic){
		
		state = theState;
		symptom = theSymptom;
		diagnostic = theDiagnostic;
		human = new ArrayList<>();
		medicine = new ArrayList<>();
		dateHospitalization = new Date[MAX_DATE];
		dateExit = new Date[MAX_DATE];
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
	public Date[] getDateHospitalization(){
		return dateHospitalization;
	}
	public void setDateHospitalization(Date[] dateHospitalization){
		this.dateHospitalization = dateHospitalization;
	}
	public Date[] getDateExit(){
		return dateExit;
	}
	public void setDateExit(Date[] dateExit){
		this.dateExit = dateExit;
	}
	//Metodos
	//-------------------------Añadir fecha de ingreso----------------------------------------------------------
	public void dateAdd(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateHospitalization[0]=date;
		
	}
	//------------------------Añir fecha de salida---------------------------------------------------------------
	public void addDateExit(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateExit[0] = date;
	}
	//---------------------------añadir medicamentos--------------------------------------------------------------
	public void addMedicine(String name, double quantify, double price, double frecuency, int doseGiven){
		Medicine medicines = new Medicine(name,quantify, price, frecuency, doseGiven);
		medicine.add(medicines);
	}
	//-------------------------costo de medicamentos--------------------------------------------------------------
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
	public void addMedication(Medicine medicines){
		
		medicine.add(medicines);
	}
	//----------------------------date exit---------------------------
	public Date dateExit(){
		return dateExit[0];
	}
	public Date dateHospitalization(){
		return dateHospitalization[0];
	}
	//---------------------nombre de la medicina----------------------
	public String nameMedicine(){
		String msg = "";
		for(int i = 0; i<medicine.size();i++){
			msg += "" + medicine.get(i).getName() + "\n";
		}
		return msg;
	}
	/**public int daysPet(int dayN, int monthN, int yearN, int i){
		int days = 0;
		if()
		
	}
	*/
}