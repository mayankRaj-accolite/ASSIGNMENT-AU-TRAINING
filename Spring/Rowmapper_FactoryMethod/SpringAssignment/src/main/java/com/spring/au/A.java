package com.spring.au;

public class A {  
	
private static final A obj=new A();  

private A(){
	
}  

public static A getA(){  
    System.out.println("Factory method has been called !!");  
    return obj;  
}
}  
