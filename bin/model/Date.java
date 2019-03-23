package model;
public class Date{
	//Atributos
	private int day;
	private int month;
	private int year;
	
	//constructor
	public Date(int theDay, int theMonth, int theYear){
		day = theDay;
		month = theMonth;
		year = theYear;
	}
	//Gets y sets
	public int getDay(){
		return day;
	}
	public void setDay(int day){
		this.day = day;
	}
	public int getMonth(){
		return month;
	}
	public void setMonth(){
		this.month=month;
	}
	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year = year;
	}
}