package com.assign;
import java.util.*;

public class Person {
	
	public String personName,personID;
	public int personAge;
	
	static ArrayList<Person> p = new ArrayList<Person>();
	
	public  Person(String name,int age,String id) {
		this.personName=name;
		this.personAge=age;
		this.personID= id;
	}
	
	public Person()
	{
		
	}
	
	public void createPerson(String name,int age,String id)
	{
		 p.add(new Person(name, age, id));
	}
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getPersonID() {
		return personID;
	}
	
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	
	public int getPersonAge() {
		return personAge;
	}
	
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	
	
	public String update(String name,int age, String id)
	{
		for(Person i : p)
		{
			if(id == i.getPersonID())
			{
				i.setPersonName(name);
				i.setPersonAge(age);
			}
			return "Successfully updated Person Details";
		}
		
		return "Id is not present in database!";
	}

	public String display()
	{	
		String result = "";
		for(Person i : p) {
			
			result +="Name :" +i.getPersonName() + " , Age:  "+ 
			i.getPersonAge()+" , Id: "+i.getPersonID() +" ; ";
			
		}
		return result;
	}

	public String deletebyid(String id)
	{
		
		for(Person i : p )
		{
			
			
			if(id == i.getPersonID())
			{ 
				
				System.out.println("selected id: "+i.getPersonID()+"entered id is"+id);
				p.remove(p); 
				return "deleted";
				
			}
		}
		return "ID not present in database !!";
	}	
	

}
