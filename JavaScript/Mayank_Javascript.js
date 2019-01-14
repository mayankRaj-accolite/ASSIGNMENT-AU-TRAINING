//Employee function for creating new object

function employee(firstName, lastName, id, gender, designation, age, eyecolor, salary)
{
  
	this.firstName = firstName;
  this.lastName = lastName;
  this.id = id;
  this.gender = gender;
  this.designation = designation;
  this.age = age;
  this.eyecolor = eyecolor;
  this.salary = salary;
  
}

//using prototype for adding new property

employee.prototype.name = function()
{
  return this.firstName + " " + this.lastName;
}

//Function for Displaying details of employee

function display()
{
  console.log("The details of the " + this.designation +" are follows");
  console.log("Name -> " + this.name());
  console.log("Id -> " + this.id);
  console.log("Designation -> " + this.designation);
  console.log("gender -> " + this.gender);
  console.log("age -> " + this.age);
  console.log("eyecolor -> " + this.eyecolor);
  console.log("salary -> " + this.salary);
  
}

//creating employee objects

var manager= new employee("Mayank", "Raj", "1", "M", "Manager", "20", "Blue", "50000");
var hr = new employee("Alexa", "Siri", "2", "F", "HR", "25", "Black", "55000");

//printing details of employees

display.call(hr);
display.call(manager);







