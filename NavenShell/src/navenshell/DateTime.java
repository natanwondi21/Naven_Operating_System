/*
 Natan Woubie
 Naven Shell
    DateTime class: concerns about getting setting and extracting the current time.
 */
package navenshell;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class DateTime {
    DateTimeFormatter dtf;
    LocalDateTime now;
    public DateTime(){
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        now = LocalDateTime.now();
    }
    public String toPrint(){
        return dtf.format(now);
    }
    
}
