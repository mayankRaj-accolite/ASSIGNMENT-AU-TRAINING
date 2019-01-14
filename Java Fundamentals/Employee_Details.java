package com.au.accolite.practice;
import java.util.Scanner; 

//class containing main function

public class Employee_Details {
	
	//use of static block
	static {
		System.out.println("Welcome to Accolite !");
	}
	
	public static void main(String[] args) {
		
		int x=1;
		
		Developer dev1 = new Developer("Mayank",21,1,"Bangalore");
		Developer dev2 = new Developer("Raj",20,0,"Patna");
		Manager manag1 = new Manager("Kapil",35,5,"Delhi");
		Manager manag2 = new Manager("Rohit",38,7,"Mumbai");
		dev1.printDetails();
		System.out.println("");
		dev2.printDetails();
		System.out.println("");
		manag1.printDetails();
		System.out.println("");
		manag2.printDetails();
		
		while(x == 1)
		{
			System.out.println("Press 1: to add employee Details ");
			System.out.println("Press 2: to abort");
			
			@SuppressWarnings("resource")
			//Taking input from console
			Scanner in = new Scanner(System.in); 
			int a = in.nextInt(); 
			if(a == 2)
				x = 0;
			else {
				System.out.println("Enter Employee Details -> ");
				System.out.println("Name");
				System.out.println("Designation (Manager/Developer)");
				System.out.println("Address");
				System.out.println("Age");
				System.out.println("Experiance");
				
				
				@SuppressWarnings("resource")
				Scanner inp = new Scanner(System.in); 
				
				String Name = inp.nextLine(); 
				String Designation = inp.nextLine();
				String Address = inp.nextLine();
				
				int age = inp.nextInt(); 
				int Experiance = inp.nextInt();
				
		    System.out.println("Entered Designation " +Designation);
		    
			if(Experiance < 0 || Experiance > 70)
				{
					System.out.println("Invalid Details exp:(");
				}
			else if(Designation == "Developer")
				{
					Developer dev3 = new Developer(Name, age, Experiance, Address);
					System.out.println("The details of new added employee->");
					dev3.printDetails();
				}
			 else if(Designation == "Manager")
				{
					Manager manag3 = new Manager(Name, age, Experiance, Address);
					System.out.println("The details of new added employee->");
					manag3.printDetails();
				}
			 else
				{
					System.out.println("Invalid Details desig :(");
				}
			}
		     
			
		}
	}
	

}

//Employee class 

class Employee
{
	String name;
	int age;
	int experiance;
	double tsalary;
	String address;
	static int no_employee;
	
	Employee(String name, int age, int exp, String address )
	{
		this.name = name;
		this.age = age;
		this.experiance = exp;
		this.address = address;
		no_employee ++;
	}
	
}

//Developer class inheriting employee class

class Developer extends Employee
{
	double bsalary;
	String designation;
	Developer(String name, int age, int exp, String address)
	{
		//Use of super for calling parent class constructor
		super(name, age, exp, address);
		this.bsalary = 25000;
		this.designation = "developer";
		this.tsalary = this.bsalary + this.bsalary * this.experiance * 0.25;
	}
	
	void raise()
	{
		tsalary = tsalary + tsalary*0.25;
	}
	
	void printDetails()
	{
		System.out.println("The details of requested employee");
		System.out.println("Name = "+this.name );
		System.out.println("Age = "+this.age );
		System.out.println("Experiance = "+this.experiance );
		System.out.println("Address = "+this.address );
		System.out.println("Salary = "+this.tsalary );
		System.out.println("Designation = "+this.designation );
		
	}
	
}

//Manager class extending Employee class

class Manager extends Employee
{
	double bsalary;
	String designation;
	Manager(String name, int age, int exp, String address)
	{
		super(name, age, exp, address);
		this.bsalary = 35000;
		this.designation = "manager";
		this.tsalary = this.bsalary + this.bsalary * this.experiance * 0.25;
	}
	void raise()
	{
		this.tsalary = tsalary + tsalary*0.50;
	}
	
	void printDetails()
	{
		System.out.println("The details of requested employee");
		System.out.println("Name = "+this.name );
		System.out.println("Age = "+this.age );
		System.out.println("Experiance = "+this.experiance);
		System.out.println("Address = "+this.address );
		System.out.println("Salary = "+this.tsalary );
		System.out.println("Designation = "+this.designation );
		
	}
}


