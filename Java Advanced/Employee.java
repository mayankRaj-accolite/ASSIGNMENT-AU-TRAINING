package com.au.collection.practice;
import java.util.*;

// Company class
class Company{
	int id;
	String name;
	Address address;
	static int no_company;
	
	Company(int id, String name, String add1, String add2, String add3)
	{
		this.id = id;
		this.name = name;
		this.address = new Address(add1, add2, add3);
		no_company++;
		
	}
	void printCompany()
	{
		System.out.println(this.id+" "+this.name+ " "+ this.address.Area
				+ " "+ this.address.City+ " " + this.address.State);
		 
		
	}
	void printCompanyKarnataka()
	{
		if(this.address.State == "Karnataka")
		{
			System.out.println(this.name+ "      "+ this.address.Area
				+ " "+ this.address.City+ " " + this.address.State);
		}
		 
		
	}
	
}

//Address class
class Address{
	String Area;
	String City;
	String State;
	
	Address(String a, String c, String s)
	{
		this.Area = a;
		this.City = c;
		this.State =s;
	}
	void printAddress()
	{
		System.out.println(this.Area +" "+this.City+" "+this.State );
	}
}

//Employee Details class
class Employee_Details
{
	String name;
	int id;
	int age;
	int companyId;
	
	Employee_Details(String name, int id, int age, int companyId)
	{
		this.name = name;
		this.id = id;
		this.age = age;
		this.companyId = companyId;
	}
	void printEmployee()
	{
		System.out.println(this.id+" "+this.name+ " "+ this.age +" "
				+this.companyId);
	}
}

//Sorting Employee by name
class SortbyName implements Comparator<Employee_Details> 
{ 
    public int compare(Employee_Details a, Employee_Details b) 
    { 
        return a.name.compareTo(b.name); 
    } 
} 

//Sorting Employee by Age
class SortbyAge implements Comparator<Employee_Details> 
{ 
    public int compare(Employee_Details a, Employee_Details b) 
    { 
        return a.age - b.age; 
    } 
} 

//Sorting Employee by id
class SortbyId implements Comparator<Employee_Details> 
{ 
    public int compare(Employee_Details a, Employee_Details b) 
    { 
        return a.id - b.id; 
    } 
} 


public class Employee {

	public static void main(String[] args) {
		
		List <Company> c = new ArrayList<Company>();
		c.add(new Company(1, "Google","ABC street", "Hyderabad", "Telangana" ));
		c.add(new Company(2, "Accolite","Cessna", "Bangalore", "Karnataka" ));
		c.add(new Company(3, "Cisco","Prestige Tech Park", "Bangalore", "Karnataka" ));
		c.add(new Company(4, "Infosys","Ring Road", "Mysore", "Karnataka" ));
		c.add(new Company(5, "Wipro","XYZ street", "Hyderabad", "Telangana" ));
		
		List <Employee_Details> e =new ArrayList<Employee_Details>();
		e.add(new Employee_Details("Mayank",1,21,2));
		e.add(new Employee_Details("Raj",2,20,2));
		e.add(new Employee_Details("Sawan",3,21,3));
		e.add(new Employee_Details("Sourav",4,23,1));
		e.add(new Employee_Details("Kumar",5,35,5));
		e.add(new Employee_Details("Niki",6,32,4));
		e.add(new Employee_Details("Rocky",7,23,2));
		
		
		System.out.println("Employees Sorted by their Name");
		System.out.println("Id  Name   Age  CompanyId   ");
		Collections.sort(e, new SortbyName()); 
		
		for(Employee_Details i:e)
		{
			i.printEmployee();
		}
		System.out.println("-------------");
		
		System.out.println("Employees Sorted by their Age");
		System.out.println("Id  Name   Age  CompanyId   ");
		Collections.sort(e, new SortbyAge()); 
		
		for(Employee_Details i:e)
		{
			i.printEmployee();
		}
		System.out.println("-------------");
		System.out.println("Employees Sorted by their Id");
		System.out.println("Id  Name   Age  CompanyId   ");
		Collections.sort(e, new SortbyId()); 
		
		for(Employee_Details i:e)
		{
			i.printEmployee();
		}
		System.out.println("-------------");
		System.out.println("Employees having age less than 30 years");
		System.out.println("Name   Age");
		for(Employee_Details i:e)
		{
			if(i.age < 30)
				System.out.println(i.name +"  " + i.age);
		}
		
		System.out.println("-------------");
		System.out.println("Companies in Karnataka");
		System.out.println("CompanyName   Address");
		
		for(Company i:c)
		{
			i.printCompanyKarnataka();
		}
	}
}
