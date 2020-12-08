/*
    Natan Woubie
    Operataing Systems
    Naven Operating System/Shell

    NavenShell- This is the main class which allows us to control and execute
                the given function through a command line type of environment 
    I have followed the academic dishonesty policy 
 */
package navenshell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;



public class NavenOS {

    public static void main(String[] args) {
        runner();
    }
    
    //Function that combines every command in one place and uses if/else 
        //statment to perform actions
      public static void runner(){
    
        startPage();
        String checker = " ";
        Scanner in = new Scanner(System.in);
        String asker = "_";
        System.out.println(asker);
        String userInput = in.nextLine();
        LinkedList<String> tracker = new LinkedList<String>();
        
        commandDic command = new commandDic();
       
        while(!checker.equalsIgnoreCase(command.getValue(userInput))){
            if(userInput.equals(command.getVersion())){
                version();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
                
            }
            else if(userInput.equalsIgnoreCase(command.getDate())){
                dateTime();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }

            else if(userInput.equalsIgnoreCase(command.getDirectory())){
                String directoryName = System.getProperty("user.dir");
                directoryList(directoryName);
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if (userInput.equalsIgnoreCase(command.getHistory())){
                tracker.add(userInput);
                System.out.println(tracker);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if (userInput.equalsIgnoreCase(command.getBatch())){
                batchFile();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if (userInput.equalsIgnoreCase(command.getExecute())){
                fetchExecute();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if(userInput.equalsIgnoreCase(command.getHelp())){
                help();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if(userInput.equalsIgnoreCase(command.getAlias())){
                alias();
                tracker.add(userInput);
                System.out.println(asker);
                userInput = in.nextLine();
            }
            else if (userInput.equalsIgnoreCase(command.getExit())){
                System.out.println("Are you sure?(Y/N)");
                String answer = in.nextLine();
                if(answer.equalsIgnoreCase("Y")){
                    checker = "exit";
                }
                else if(answer.equalsIgnoreCase("N")){
                    System.out.println(asker);
                    userInput = in.nextLine();
                }
            }
            else{
                System.out.println(userInput + " Command not recognized");
                System.out.println(asker);
                userInput = in.nextLine();
                
            }
        }
      }
    
    //Function that connects the main class to the machine class to perform
        //the fetch and execute 
    public static void fetchExecute(){
        machine execute = new machine();
        execute.fetchAndExecute();
    }
    
    
    /* Function that connects the main class with the batchFile class
    to perform the reading and executing of the commands from a file
    */
    public static void batchFile(){
        batchFile newBatch = new batchFile();
        System.out.println("File Name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        File inputFile = new File(fileName);
        Scanner inFile = null;
        int counter = 0;
        try{
            inFile = new Scanner(inputFile);
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found!");
            System.exit(0);
        }
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            newBatch.assignValue(line,counter);
            counter++;
        }
        inFile.close();
        int checker = 0;
        commandDic command = new commandDic();
        while(checker != newBatch.arrayLength()){
        if(newBatch.getValue(checker).equalsIgnoreCase(command.getVersion())){
                version();
                checker++;
            }
            else if(newBatch.getValue(checker).equalsIgnoreCase(command.getDate())){
                dateTime();
                checker++;
            }

            else if(newBatch.getValue(checker).equalsIgnoreCase(command.getDirectory())){
                String directoryName = System.getProperty("user.dir");
                directoryList(directoryName);
                checker++;
            }
           /*else if (newBatch.getValue(counter).equalsIgnoreCase(command.getHistory())){
                tracker.add(userInput);
                System.out.println(tracker);
                System.out.println(asker);
                userInput = in.nextLine();
bt            }*/
            else if (newBatch.getValue(checker).equalsIgnoreCase(command.getBatch())){
                batchFile();
                checker++;
            }
            else if (newBatch.getValue(checker).equalsIgnoreCase(command.getExecute())){
                fetchExecute();
                checker++;
            }
            else if(newBatch.getValue(checker).equalsIgnoreCase(command.getHelp())){
                help();
                checker++;
            }
            else if(newBatch.getValue(checker).equalsIgnoreCase(command.getAlias())){
                alias();
                checker++;
            }
            /*else if (newBatch.getValue(counter).equalsIgnoreCase(command.getExit())){
                System.out.println("Are you sure?(Y/N)");
                String answer = in.nextLine();
                if(answer.equalsIgnoreCase("Y")){
                    checker = "exit";
                }
                else if(answer.equalsIgnoreCase("N")){
                    System.out.println(asker);
                    userInput = in.nextLine();
                }
            }*/
        //newBatch.printAll();
        }
        runner();
    }
    
    //Function that connects the main class with the version class to perform 
    //the displaying of the version of the OS/Shell
    public static void version(){
        version vrz = new version();
        System.out.println("Version:- " + vrz.getVersion());
    }
    
    //Function that prints the start window of the OS/Shell
    public static void startPage(){
        String name = "Naven OS ";
        String rights = "All rights reserved. 2019 Naven Corp.";
        System.out.print(name);
        version();
        System.out.println(rights);
        
    }
    
    //Function that gets the systems date and time and displays it by connecting 
    //it with the dateTime class
    public static void dateTime(){
        DateTime time = new DateTime();
        System.out.println(time.toPrint());
    }
    
    //Function that prints out the files from a directory
    public static void directoryList(String directoryName){
        Directory dir = new Directory();
        dir.Directory();
        
    }
    /*
    Function that prints out a list of avalible commands with description and
    command syntax. 
    */
    public static void help(){
        System.out.println("Version(vrz): Display the software version number for your simulator");
        System.out.println("Date(dt): Display or set the date");
        System.out.println("Directory(dir): Print a list of all the files in the simulator’s directory.");
        System.out.println("History(ht): Display a history of all the commands a user used");
        System.out.println("Batch files(bt): Run commands from a batch file or script");
        System.out.println("Aliasing(al): Allow the user to map different command names (i.e. renaming Exit to Quit)");
        System.out.println("Exit(exit): Exit the simulator. You should ask the user if they are sure that they want to exit.");
        System.out.println("Help(help): Display help information for each command. Should be able to display a list of all commands");
        System.out.println("Execute(exe): Performs the fetch and execute by reading a file");

    }
    
    /*
    Function that connects the main class with alias class to perform the 
    remaining of a commands
    */
    public static void alias(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter function you want to rename: ");
        String function = in.nextLine();
        System.out.println("Enter the rename value: ");
        String value = in.nextLine();
        commandDic command = new commandDic();
        //command.insertCommand(function, value);
        //command.getValue(function);
        command.rename(function, value); 
        System.out.println("Command updated");
    }


    
}
