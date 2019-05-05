package model;
import java.util.ArrayList;

public class Veterinary{
	// Atributos
	
	public final static int ROOMS_MAX = 8;
	private String name;
	private double income;
	private double serIncome;
	
	private Room[] rooms;
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> clients;
	private ArrayList<Service> services ;
	
	
	//constructor
	
	public Veterinary(String theName, double income, double serIncome){
		name = theName;
		this.income = income;
		this.serIncome = serIncome;
		rooms = new Room[ROOMS_MAX];
		history = new ArrayList<>();
		clients = new ArrayList<>();
		services = new ArrayList<Service>();
		
		
	}
	//gets y sets
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Room[] getRooms(){
		return rooms;
	}
	public void setRooms(Room[] rooms){
		this.rooms = rooms;
	}
	public ArrayList<ClinicHistory> getHistory(){
		return history;
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	public double getSerIncome(){
		return serIncome;
	}
	/**
	* Description: This method allows to access to the veterinary's total income by hospitalizations.
	* @return The total income by hospitalizations.
	*/
	public double getIncome(){
		
		return income ;
	}
	
	/**
	* Description: This method allows that other classes can change the income atribute of the veterinary.
	* post: The income atribute change it's value.
	*/
	public void setIncome(double income){
		
		this.income = income;
	}
	//metodos
	//------------------------Agregar cliente y mascota--------------------------------------------------------
	public String addClient(String name, int id, String address , int phoneNumber, String nameM, String type, int age, double weight, double height){
		String msg = "";
		Client customer = new Client(name, id, address, phoneNumber);
		clients.add(customer);
		int u = 0;
		for(int i = 0; i < clients.size(); i++){
			if(foundClient(id, i) != false){
				clients.get(i).addPet(nameM, type, age, weight, height);
			}else{
				msg = "The client wasn't finded, please enter the identifier again";
			}
		}
		return msg;
	}
	
	
	
	//------------------------------------buscar cliente---------------------------------------------------------------------------------------
	public boolean foundClient(int id, int i){
		boolean foundClient = false;
		
		if(id == clients.get(i).getId()){
			foundClient = true;
		}
		return foundClient;
	}
	
	
	
	
	//-----------------------------------buscar mascota---------------------------------------------------------------------------------------------
	public boolean foundPet(int i,int k, String name){
		boolean foundPet = false;
		if(name.equals(clients.get(i).positionOfThePet(k).getName())){
			foundPet = true;
		}
		return foundPet;
	}
	
	
	
	
	
	//-------------------------------------Ver si hay disponibilidad en los cuartos----------------------------------------------------------------------
	public boolean availabilityOfTheRoom(int room){
		boolean menssage = false;
		if(rooms[room].getPet() != null){
			menssage = false;
		}
		else{
			menssage = true;
		}
		return menssage;
	}
	
	
	
	
	//---------------------------Crear la historia de una mascota------------------------------------------------------------------
	public String createHistoryPet(int id, String nameM, String symptom, String diagnostic, boolean state, int day, int month, int year, String nameMedicine, double quantify, double price, double frecuency, int doseGiven, Pet pet){
		String menssage = "";
		ClinicHistory hist = new ClinicHistory(state, symptom, diagnostic, pet);
		for(int i = 0; i<clientSize();i++){
			if(clients.get(i).getId()==id){
				int k = i;
				for(int u = 0; u<petSize(i); u++){
					int w = u;
				if(foundPet(k , w, nameM)!= false){
					clients.get(i).addHistory(hist, u, day, month, year);
					clients.get(i).foundHistory(k).addMedication(nameMedicine, quantify, price, frecuency);
					menssage = "The clinical history has been created";
				}else{
					menssage = "Unable to create the clinical history";
				}
				}
			}else{
				menssage = "Unable to create the clinical history";
			}
		}
		return menssage;
	}
	//--------------------------------------cerrar la historia clinica----------------------------------------------------------------
	public boolean closeHistory(int id, String nameM, int day, int month, int year ){
		boolean close = false;
		for(int i = 0; i<clientSize(); i++){
			if(foundClient(id, i)!=false && close != true){
				for(int k = 0; k< petSize(i); k++)
					if(foundPet(i, k, nameM) != false && close != true){
						for(int e = 0; e < ROOMS_MAX; e++){
							if(clients.get(i).positionOfThePet(k) == rooms[e].getPet()){
								rooms[e].setPet(null);
								clients.get(i).foundHistory(k).addDateExit(day, month, year);
								clients.get(i).foundHistory(k).setState(false);
								close = true;
							}
						}
					}
			}
				
			
		}
		return close;
	}
	
	
	
	
	//-------------hospitalizar mascota------------------------------------------------------------------------------------------------
	public String hospitalizePet(int id,String nameM){
		String menssage = "";
		
		
		for(int i = 0; i<clients.size(); i++){
			if(foundClient(id, i) != false){
				for(int u = 0; u<petSize(i); u++){
					if(foundPet(i, u, nameM) !=false){
					
						for(int k = 0; k<ROOMS_MAX; k++){
							if(availabilityOfTheRoom(k) != false){
								String name = nameM;
								String type = clients.get(i).positionOfThePet(u).getTypePet();
								int age = clients.get(i).positionOfThePet(u).getAge();
								double weight = clients.get(i).positionOfThePet(u).getWeight();
								double height = clients.get(i).positionOfThePet(u).getHeight();
								Pet pet = new Pet(name, type, age, weight, height);
								rooms[k].setPet(pet);
							}else{
								menssage = "there are no rooms available.";
							}
						
						}
				}else{
						menssage = "the pet was not found";
					}
				}
			}else{
				menssage = "The client was not found";
			}
		}
		return menssage;
	}
	//---------------------------------------------------------------clients.size()&&pets.size()------------------------------------------------------
	public int clientSize(){
		return clients.size();
	}
	public int petSize(int i){
		return clients.get(i).petSize();
	}
	
	//--------------------------------------------------------------Ingresos totales de la veterinaria------------------------------------------------
	public double veterinaryIncome(int dayN, int yearN, int monthN){
		double sum = 0.0;
		for(int i = 0; i<clientSize();i++){
			sum += clients.get(i).petsCost(dayN, yearN, monthN);
		}
		return sum;
	}
	//------------------------------------------------Cuarto de la mascota---------------------------------------------------------------------------------------------
	public int petsRoom(String nameM){
		int number = 0;
		for(int i = 0; i<ROOMS_MAX;i ++){
			if(nameM.equals(rooms[i].getPet().getName())){
				number = i++;
			}
		}
		return number;
	}
	//------------------------------------------Saber si esta hospitalizada la mascota--------------------------------------------------------
	public boolean availabilityThePet(String nameM){
		boolean availability= false;
		for(int i = 0; i<clientSize()&&availability != true; i++){
			for(int k = 0; k<clients.get(i).petSize(); k++){
				if(foundPet(k, i, nameM)!=false){
					availability=clients.get(i).stateHistory(k);
				}
			}
		}
		return availability;
	}
	//---------------------------- historia clinica de las mascotas hospitalizadas----------------------------------------
	public String showPetsHospitalizad(){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			msg+= "----------------------------------------" + "\n";
			msg+= clients.get(i).showPetsHospitalizad();
		}
		return msg;
		
	}
	//-----------------------historia clinica de una mascota--------------------------------------------------------
	public String seeDataAnimal(String name,String nameM){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				if(clients.get(i).seeDataAnimal(name)!=null){
				msg = clients.get(i).seeDataAnimal(name);
				}
			}
		}
		return msg;
	}
	//----------------------costo de una hospitalizacion----------------------------------------------------------
	public double costPet(String name, String nameM,int dayN, int monthN, int yearN){
		double cost = 0.0;
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				cost += clients.get(i).costPet( name, dayN, monthN, yearN);
			}
		}
		return cost;
	}
	//--------------------Historias pasadas de una mascota-------------------
	public String seeLastDataAnimal(String name,String nameM){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				if(clients.get(i).seeLastDataAnimal(name)!=null){
				msg = clients.get(i).seeDataAnimal(name);
				}
			}
		}
		return msg;
	}
	//-----------------datos del dueño de la mascota hospitalizada----------------
	public String dataWonderPet(String name){
		String msg = "";
		for(int i = 0; i<ROOMS_MAX;i ++){
			if(name.equals(rooms[i].getPet().getName())){
				for(int k = 0; k<clients.size(); k++){
					for(int e = 0; e< clients.get(i).petSize(); e++){
						if(name.equals(clients.get(i).positionOfThePet(e).getName())){
							msg += "The name of the pet wonder is " + clients.get(i).getName() + "\n";
							msg += "The address of the pet wonder is " + clients.get(i).getAddress() + "\n";
							msg += "The phone of the pet wonder is " + clients.get(i).getPhoneNumber() + "\n";
						}
					}
				}
			}
		}
				
		return msg;
	}
	
	
	
	
	public void registerNewService(Service service){
		
		services.add(service);
		
		serIncome+= service.getCost();
	}
	
	public double totalIncome(){
		
		double totalIncome = income+serIncome;
		
		return totalIncome;
	}
	//promedio de ingresos por servicio
	public double averageIncomePerServices(){
		
		double average = 0;
		int count = 0;
		
		for(int i = 0; i < services.size(); i++){
			
			average+= services.get(i).getCost();
			count++;
		}
		
		if(count > 0){
			
			average/= ((double)count);
		}
		
		return average;
	}
	
	
	public boolean verifyWeek(Date date1, Date date2){
		
		boolean week = false;
		
		if(date1.getYear() == date2.getYear()){
			
			if(date1.getMonth() == date2.getMonth()){
				
				if((date2.getDay() - date1.getDay()) == 7){
				
					week = true;
				}
			}
			else if(date2.getMonth() == (date1.getMonth() + 1)) {
				
				if(date1.getDay() > 23){
					
					if(((date2.getDay() + 30) - (date1.getDay())) == 7){
						
						week = true;
					}
				}
			}
		}
		else if((date2.getYear()) == (date1.getYear() + 1)){
			
			if((date1.getMonth() == 12)&&(date2.getMonth() == 1)){
				
				if(date1.getDay() > 23){
					
					if(((date2.getDay() + 30) - (date1.getDay())) == 7){
						
						week = true;
					}
				}
			}
		}
		
		return week;
	}
	
	public String serviceReport(Date date1, Date date2){
		
		String rep = "";
		
		for(int i = 0; i < services.size(); i++){
			
			if(services.get(i).verifyDate(date1, date2) == true){
				
				rep +="/n"+services.get(i).report()+"/n" ;
			}
		}
		
		return rep;
	}	
	//Mostrar el cauculo de la masa
	public String calculateBMI(String name){
		String ms = "";
		for(int i = 0; i< history.size(); i++){
			ms += history.get(i).peti(name);
		}
		if(ms.equals("")){
			ms = "the name of the pet was not found";
		}
		return ms;
	}
	//cambiar direccion del ciente
	public String change(int id, String address, int phoneNumber){
		String ms = "";
		for(int i = 0; i<clients.size(); i++){
			if(id == clients.get(i).getId()){
				clients.get(i).updateData( address, phoneNumber);
				ms = "  ";
			}
		}
		if(ms.equals("")){
			ms = "no se encontro el cliente";
		}
	
		return ms;
	}
	
	// metodo para agregar medicina a mascota hospitalizada
	public String addMedicinePetHospitali(String name, String n, double q, double p, double f ){
		String m = "";
		return m;
	}
	// Metodo 21
	public String hospitalizatedPetNotesDiagnostic(String nombre, String nota){
		String m = "";
		return m;
	}
	// metodo 22
	public String hospitalizatedPetNotesSimtom(String nombre, String nota){
		String m = "";
		return m;
	}
	
	
	
 
}

