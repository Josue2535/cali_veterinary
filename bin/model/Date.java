package model;
public class Date{
	//Atributos
	private int day;
	private int month;
	private int year;
	
	/**
	* Description: This is the constructor method.
	* @param The day.
	* @param The month.
	* @param The year.
	*/
	public Date(int theDay, int theMonth, int theYear){
		day = theDay;
		month = theMonth;
		year = theYear;
	}
	
	
	/**
	* Description: This method allows that other <br> classes can access to the day.
	* pre: The date was initialized before and it's status atribute isn't null. 
	* @return The day.
	*/
	public int getDay(){
		return day;
	}
	/**
	* Description: This method allows <br> changing the day.
	* pre:the day is not null.
	* post:the day was changed.
	* @param the day to which you <br> want to change.
	*/
	public void setDay(int day){
		this.day = day;
	}
	/**
	* Description: This method allows that other <br> classes can access to the month.
	* pre: The date was initialized before and it's status atribute isn't null. 
	* @return The month.
	*/
	public int getMonth(){
		return month;
	}
	/**
	* Description: This method allows <br> changing the month.
	* pre:the month is not null.
	* post:the month was changed.
	* @param the month to which you <br> want to change.
	*/
	public void setMonth(){
		this.month=month;
	}
	/**
	* Description: This method allows that other <br> classes can access to the year.
	* pre: The date was initialized before and it's status atribute isn't null. 
	* @return The year.
	*/
	public int getYear(){
		return year;
	}
	/**
	* Description: This method allows <br> changing the year.
	* pre:the year is not null.
	* post:the year	was changed.
	* @param the year to which you <br> want to change.
	*/
	public void setYear(int year){
		this.year = year;
	}
}