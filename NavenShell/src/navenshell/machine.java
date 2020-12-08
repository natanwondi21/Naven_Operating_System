/*
Natan Woubie
Operating Systems

Machine class: Class that links the Ram and the CPU class to perform the reading
                of a file and perform the fetch and execute
 */
package navenshell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Natan Woubie
 */
public class machine {
    CPU cpu;
    RAM ram;
    
    public machine(){
        cpu = new CPU();
        ram = new RAM();
    }
    //Method that reads a file and insert the commands into the ram
    public void readFile(){
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
            ram.assignValue(line,counter);
            counter++;
        }
        inFile.close();
    }
    //method that performs the fetch and Execute 
    public void fetchAndExecute(){
        readFile();
        //ram.printAll();
        System.out.println("Fetch and Execute");
        final String REGEX = "\\s*(\\s|=>|,)\\s*";
        while(true){
            //System.out.println("Inside loop, i is" + i);
            final String input = ram.getValue(cpu.getPc());
            int pc = cpu.getPc();
            final Pattern p = Pattern.compile(REGEX);
            final String[] items = p.split(input);

            //if else statement for the set command

            if(items[0].equals("set")){
                //System.out.println("I found set");
                if(items[2].equals("ax")){
                    cpu.setAx(items[1]);
                    System.out.println(cpu.currentState());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[2].equals("bx")){
                    cpu.setBx(items[1]);
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[2].equals("cx")){
                    cpu.setCx(items[1]);
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[2].equals("dx")){
                    cpu.setDx(items[1]);System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[2].equals("PC")){
                    cpu.setPc(Integer.parseInt(items[1]));
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[2].equals("A")){
                    cpu.setA(Integer.parseInt(items[1]));
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
            }
            //If else statement for the out command
            else if(items[0].equals("out")){
                //System.out.println("I found out");
                if(items[1].equals("ax")){
                    System.out.println(cpu.getAx());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[1].equals("bx")){
                    System.out.println(cpu.getBx());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[1].equals("cx")){
                    System.out.println(cpu.getCx());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[1].equals("dx")){
                    System.out.println(cpu.getDx());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[1].equals("PC")){
                    System.out.println(cpu.getPc());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
                else if(items[1].equals("A")){
                    System.out.println(cpu.getA());
                    System.out.println(cpu.currentState());
                    pc++;
                    cpu.setPc(pc);
                }
        }
            
            //Function that performs the mov function
            else if(items[0].equals("mov")){
                if(items[1].equals("ax")){
                    if(items[2].equals("bx")){
                        cpu.setBx(cpu.getAx());
                        System.out.println(cpu.currentState());
                        pc++;
                        cpu.setPc(pc);
                    }
                    else if(items[2].equals("cx")){
                        cpu.setCx(cpu.getAx());
                        System.out.println(cpu.currentState());
                        pc++;
                        cpu.setPc(pc);
                    }
                    else if(items[2].equals("dx")){
                        cpu.setDx(cpu.getAx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("PC")){
                        cpu.setPc(Integer.parseInt(cpu.getAx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("A")){
                        cpu.setA(Integer.parseInt(cpu.getAx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
                else if(items[1].equals("bx")){
                    if(items[2].equals("ax")){
                        cpu.setAx(cpu.getBx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("cx")){
                        cpu.setCx(cpu.getBx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("dx")){
                        cpu.setDx(cpu.getBx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("PC")){
                        cpu.setPc(Integer.parseInt(cpu.getBx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("A")){
                        cpu.setA(Integer.parseInt(cpu.getBx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
                else if(items[1].equals("cx")){
                    if(items[2].equals("bx")){
                        cpu.setBx(cpu.getCx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("ax")){
                        cpu.setAx(cpu.getCx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("dx")){
                        cpu.setDx(cpu.getCx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("PC")){
                        cpu.setPc(Integer.parseInt(cpu.getCx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("A")){
                        cpu.setA(Integer.parseInt(cpu.getCx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
                else if(items[1].equals("dx")){
                    if(items[2].equals("bx")){
                        cpu.setBx(cpu.getDx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("cx")){
                        cpu.setCx(cpu.getDx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("ax")){
                        cpu.setAx(cpu.getDx());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("PC")){
                        cpu.setPc(Integer.parseInt(cpu.getDx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("A")){
                        cpu.setA(Integer.parseInt(cpu.getDx()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
                else if(items[1].equals("PC")){
                    if(items[2].equals("bx")){
                        cpu.setBx(Integer.toString(cpu.getPc()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("cx")){
                        cpu.setCx(Integer.toString(cpu.getPc()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("dx")){
                        cpu.setDx(Integer.toString(cpu.getPc()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("ax")){
                        cpu.setAx(Integer.toString(cpu.getPc()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("A")){
                        cpu.setA(cpu.getPc());
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
                else if(items[1].equals("A")){
                    if(items[2].equals("bx")){
                        cpu.setBx(Integer.toString(cpu.getA()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("cx")){
                        cpu.setCx(Integer.toString(cpu.getA()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("dx")){
                        cpu.setDx(Integer.toString(cpu.getA()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("ax")){
                        cpu.setDx(Integer.toString(cpu.getA()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                    else if(items[2].equals("PC")){
                        cpu.setPc((cpu.getA()));
                        System.out.println(cpu.currentState());
                        pc++;
                    cpu.setPc(pc);
                    }
                }
            }
            
            
            
            
            
            else if(items[0].equals("jmp")){
                cpu.setPc(cpu.getA());
                System.out.println(cpu.currentState());
            }
            
            
            else if(items[0].equals("jgt")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())>0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            
            
            else if(items[0].equals("jeq")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())==0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            
            else if(items[0].equals("jge")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())>=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            
            else if(items[0].equals("jlt")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())<0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            
            else if(items[0].equals("jne")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())!=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            
            else if(items[0].equals("jle")){
                if(items[1].equals("ax")){
                    if(Integer.parseInt(cpu.getAx())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("bx")){
                    if(Integer.parseInt(cpu.getBx())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("cx")){
                    if(Integer.parseInt(cpu.getCx())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("dx")){
                    if(Integer.parseInt(cpu.getDx())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("A")){
                    if((cpu.getA())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
                else if(items[1].equals("PC")){
                    if((cpu.getPc())<=0){
                        cpu.setPc(cpu.getA());
                        System.out.println(cpu.currentState());
                    }
                    
                }
            }
            else if(items[0].equals("END")){
                break;
            }
                                
        }
    }
    
}
