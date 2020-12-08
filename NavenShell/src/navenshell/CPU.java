/*

Natan Woubie
Operating System
Project 2 Hardware
 * This is the CPU class which deals with:
 *      Assign a value to a register, the PC, or the A
        “look at” a value in a register, the PC, or the A
        Perform the fetch-execute cycle on a “tick” of the clock.
 */
package navenshell;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
/**


 */
public class CPU {
    private String ax,bx,cx,dx;
    private int pc,a;
    private RAM ram;
    
    public CPU(){
        pc = 0;
        ram = new RAM();
    }
    
    //Get register Ax
    public String getAx() {
        return ax;
    }
    //Sets register Ax
    public void setAx(String ax) {
        this.ax = ax;
    }
    //Get register Bx
    public String getBx() {
        return bx;
    }
        //Sets register bx
    public void setBx(String bx) {
        this.bx = bx;
    }
    //Get register Cx
    public String getCx() {
        return cx;
    }
        //Sets register cx
    public void setCx(String cx) {
        this.cx = cx;
    }
    //Get register Dx
    public String getDx() {
        return dx;
    }
        //Sets register dx
    public void setDx(String dx) {
        this.dx = dx;
    }
    //get PC
    public int getPc() {
        return pc;
    }
        //Sets register pc
    public void setPc(int pc) {
        this.pc = pc;
    }
    //get A
    public int getA() {
        return a;
    }
        //Sets register A
    public void setA(int a) {
        this.a = a;
    }
    //Mehtod to get the current state of the CPU
    public String currentState(){
        return "Current State " + "\n" +"ax: " + getAx()  +" bx: "+ getBx() +" cx: "+ getCx() +" dx: "+ 
                getDx() +'\n' + "PC " + getPc() + '\n' + "A " + getA();
    }
    
    
    
}

