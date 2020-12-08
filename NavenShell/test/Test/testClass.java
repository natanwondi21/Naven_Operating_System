/*
Natan Woubie
Operating System
Project 2
Prof Lonnie Bowe
versionTest: test class that tests the version class
 */
package Test;

import java.util.HashMap;
import navenshell.CPU;
import navenshell.DateTime;
import navenshell.Directory;
import navenshell.NavenOS;
import navenshell.PCB;
import navenshell.RAM;
import navenshell.close;
import navenshell.machine;
import navenshell.version;
import navenshell.commandDic;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author woubien28
 */
public class testClass {
    
    public testClass() {
        
        
    }
    //Test method to test the versionSet method in version class
    @Test
    public void versionSetTest(){
        version version = new version();
        version.setVersion("tester");
        String result = version.getVersion();
        if(!result.equals("tester")){
            fail(" Version set Method doesnt function");
        }
        
    }
    
    //Test methods for testing the RAM classs
        @Test
        //Test method that test assign value method in RAM
        public void assignValueTest(){
            RAM ram = new RAM();
            ram.assignValue("5", 0);
            String result = ram.getValue(0);
            if(!result.equals("5")){
                fail("RAM assignValue method is not funcioning");
            }
        }
        @Test
        //Test method that tests the array length in RAM 
        public void arrayLengthTest(){
            RAM ram = new RAM();
            ram.assignValue("1",0);
            int result = ram.arrayLength();
            if(result !=1000){
                fail("RAM arrayLength method not functioning");
            }

        }
        @Test
        //Test method that tests the getting a value at a specific location in the ram
        public void getValueTest(){
            RAM ram = new RAM();
            ram.assignValue("1",0);
            String result = ram.getValue(0);
            if(!result.equals("1")){
                fail("RAM getting value is not functioning");
            }
        }
    
    @Test 
    public void closeTest(){
        close closer = new close();
        String result = closer.getChecker();
        if(!result.equals("exit")){
            fail("The exit class(close.java) not working");
        }
    }
    @Test
    //Test methods that test the commandDic class
    
    public void getCommandTest(){
        commandDic command = new commandDic();
        String result = command.getVersion();
        if(!result.equals("vrz")){
            fail("The gets in commandDic class arent functioning");
        }
    }
    //Test method that tests the getValue in the commandDic class
    @Test
    public void getCommandValueTest(){
        commandDic command = new commandDic();
        String result = command.getValue("date");
        if(!result.equals("dt")){
            fail("The get vale in commandDic class isnt functioning");
        }
    }
    


    
}
