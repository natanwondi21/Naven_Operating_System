/*
Natan Woubie
Operating System
Project 2

This is the RAM class which deals with:
*          Assigning a value to a specific RAM location
*          Look at a value in a specific location

 */
package navenshell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
This is the RAM class which deals with:
*          Assigning a value to a specific RAM location
*          Look at a value in a specific location
 */
public class RAM {
    String[] ram;//Creats a RAM attributes
    int processId;//An integer Attributes for the processID
    int location;//An integer Attributes for the location
           
    
    public RAM(){
    ram = new String[1000];//Default constructor and allocating a memory for 1000 String
    
}
    //A class method that assigns a value to a specific RAM location
    /*the assignValue method takes the value that is to be inserted and the
        location in the RAM that it is going to be inserted to
    */
    public void assignValue(String value, int location){
        ram[location]=value;
    }
    public int arrayLength(){
        return ram.length;
    }
    //A class method that gets the value at a specific RAM location
    public String getValue(int location){
        return ram[location];
    }
    //A method that prints out a specific number of the RAM location
    public void printSpecific(int range){
        for (int i = 0; i < range; i++) 
         System.out.println("Element at index " + i +  " : "+ ram[i]);
    }
    
    //A method that prints out all of the elements inside of the RAM
    public void printAll(){
        for (int i = 0; i < ram.length; i++) 
         System.out.println("Element at index " + i +  " : "+ ram[i]);
    }
   
    
}
    
    

