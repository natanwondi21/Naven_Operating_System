/*
    Natan Woubie
    Naven OS/shell
    Exit processing class

 */
package navenshell;

public class close {
    private String checker;
    
    public close(){
        checker = "exit";
    }

    /**
     * @return the checker
     */
    public String getChecker() {
        return checker;
    }

    /**
     * @param checker the checker to set
     */
    public void setChecker(String checker) {
        this.checker = checker;
    }
    
}
