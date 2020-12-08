/*
Natan Woubie
Operating System
Project 2

Batch class: Class that performs the reading of a file and returning in to be 
            executed 

 */
package navenshell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Feven Gebrehiwot
 */
public class batchFile {
     String[] ram;//Creats a RAM attributes
    
    public batchFile(){
    ram = new String[30];//Default constructor and allocating a memory for 1000 String
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
