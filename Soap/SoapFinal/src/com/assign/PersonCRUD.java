package com.assign;


public class PersonCRUD {
	
	
	
	public String create(String name,int age,String id) {

		Person obj=new Person();
		obj.createPerson(name,age,id);
		return "new person object is created !!";
		
	}

	public String Update(String name,int age,String id)
	{
		
	Person obj=new Person();
	return obj.update(name,age, id);
	}


	public String Display()
	{
		Person obj=new Person();
		return obj.display();
	}

	public String deleteById(String id)
	{
		Person obj=new Person();
		
		return 	obj.deletebyid(id);
		

	}

}
