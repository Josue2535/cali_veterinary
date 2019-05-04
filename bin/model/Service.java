package model ;


public class Service{
	
	public final static char SHOWER = 'S';
	public final static char SHOWERTG = 'G';
	public final static char NAILS = 'N';
	public final static char PROFILAXIS = 'P';
	public final static char VACCINES = 'V';
	
	public final static double SCOST = 20000;
	public final static double STGCOST = 30000;
	public final static double NCOST = 8000;
	public final static double PCOST = 12000;
	public final static double VCOST = 45000;
	
	
	private char type ;
	private double cost ;
	private Date date;
	private String clientId ;
	private String petName;
	
	public Service(char type, double cost, Date date, String clientId, String petName){
		
		this.type = type ;
		this.cost = cost ;
		this.date = date ;
		this.clientId = clientId ;
		this.petName = petName ;
	}
	
	//Getters
	public char getType(){
		
		return type;
	}
	
	public double getCost(){
		
		switch(type){
			case SHOWER:
				cost = SCOST;
				break;
			case SHOWERTG:
				cost = STGCOST;
				break;
			case NAILS:
				cost = NCOST;
				break;
			case PROFILAXIS:
				cost = PCOST;
				break;
			case VACCINES:
				cost = VCOST;
				break;
		}
		return cost ;
	}
	
	public Date getDate(){
		
		return date;
	}
	
	public String getClientId(){
		
		return clientId;
	}
	
	public String getPetName(){
		
		return petName;
	}
	
	//Setter
	public void setType(char type){
		
		this.type = type;
	}
	
	public void setCost(double cost){
		
		this.cost = cost;
	}
	
	public void setDate(Date date){
		
		this.date = date;
	}
	
	public boolean verifyDate(Date date1, Date date2){
		
		boolean range = false;
		
		if((date.getYear() >= date1.getYear()) && (date.getYear() <= date2.getYear())){
			
			if(date1.getYear() == date2.getYear()){
				
				if(date1.getMonth() == date2.getMonth()){
					
					if(date.getMonth() == date1.getMonth()){
					
						if((date.getDay() >= date1.getDay()) &&(date.getDay() <= date2.getDay())){
							
							range = true;
						}
					}
				}
				else{
					
					if((date.getMonth() > date1.getMonth()) && (date.getMonth() < date2.getMonth())){
						
						range = true;
					}
					else if((date.getMonth() == date1.getMonth()) && (date.getDay() >= date1.getDay())){
						
						range = true;
					}
					else if((date.getMonth() == date2.getMonth()) && (date.getDay() <= date2.getDay())){
						
						range = true;
					}
				}
			}
			else{
				
				if((date.getYear() > date1.getYear())&&(date.getYear() < date2.getYear())){
					
					range = true;
				}
				else if(date.getYear() == date1.getYear()){
					
					if(date.getMonth() > date1.getMonth()){
						
						range = true;
					}
					else if(date.getMonth() == date1.getMonth()){
						
						if(date.getDay() >= date1.getDay()){
						
							range = true;
						}
					}
				}
				else if(date.getYear() == date2.getYear()){
					
					if(date.getMonth() < date2.getMonth()){
						
						range = true;
					}
					else if(date.getMonth() == date2.getMonth()){
						
						if(date.getDay() <= date2.getDay()){
						
							range = true;
						}
					}
				}

			}
		}
		
		return range;
	}
	
	public String report(){
		
		String msg = "";
		
		String serviName = "";
		
		switch(type){
			case SHOWER: 
				serviName = "Shower";
				break;
			case SHOWERTG:
				serviName = "Shower at home";
				break;
			case NAILS:
				serviName = "Nails";
				break;
			case PROFILAXIS:
				serviName = "Profilaxis";
				break;
			case VACCINES:
				serviName = "Vaccines";
				break;
		}
		
		msg = "Fecha: "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear()+"/n Service: "+serviName+"/n client's id: "+clientId+"/n Pet: "+petName+"/n Cost: "+getCost() ;
		
		return msg;
	}
	
}