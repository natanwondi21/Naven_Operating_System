/*
Natan Woubie
Naven Shell
Diirectory class: concern about extracting file names from the Directory folder
 */
package navenshell;

import java.io.File;
public class Directory {
    
    public void Directory(){
        String directoryName = System.getProperty("user.dir");
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
}
