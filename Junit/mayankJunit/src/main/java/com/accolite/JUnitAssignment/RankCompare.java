package com.accolite.JUnitAssignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class RankCompare implements Comparator<StudentDetails>{
		
	
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date date1;
		Date date2;
	    public int compare(StudentDetails s1, StudentDetails s2) {
	        if(s1.getPercentage() < s2.getPercentage()){
	            return 1;
	        } 
	        else if(s1.getPercentage() > s2.getPercentage())
	        {
	            return -1;
	        }
	        else
	        {
	        	try {
					date1 = format.parse(s1.getDob());
				} catch (ParseException e) {
					e.printStackTrace();
				}
	        	try {
					date2 = format.parse(s2.getDob());
				} catch (ParseException e) {
					e.printStackTrace();
				} 
	        	if(date1.compareTo(date2)<0) 
	   			  return -1; 
	   		  else return 1;
	        	
	        }
	}
}


