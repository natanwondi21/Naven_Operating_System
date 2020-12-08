/*
Natan Woubie
Operating System
Project 2

Version Class: Concerns on Setting and Getting the version
 */
package navenshell;

public class version {
    private String version;
    
    //Default Contructor that sets the version by defualt
    public version(){
        version = "[NV-6439-10-85]";
    }

    //Gets the version
    public String getVersion() {
        return version;
    }

    //Sets the version, if its ever needed to be changed
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String toReturn() {
        return "Version " + getVersion();
     }
    
    
}
