/*
Natan Woubie
Operating System
Project 2

 */
package navenshell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author woubien28
 */
public class commandDic {
    Map<String, String> command;
    
    public commandDic(){
        command = new HashMap<String, String>();
        command.put("version", "vrz");
        command.put("history", "ht");
        command.put("directory", "dir");
        command.put("date", "dt");
        command.put("help", "help");
        command.put("exit", "exit");
        command.put("execute","exe");
        command.put("batch","bt");
        command.put("alias","al");
        
    }
    //Method that returns the value of the alias
    public String getAlias(){
        return command.get("alias");
    }
    //Method that returns the value of the version
    public String getVersion(){
        return command.get("version");
    }
    //Method that returns the value of the history
    public String getHistory(){
        return command.get("history");
    }
    //Method that returns the value of the directory
    public String getDirectory(){
        return command.get("directory");
    }
    //Method that returns the value of the date
    public String getDate(){
        return command.get("date");
    }
    //Method that returns the value of the help
    public String getHelp(){
        return command.get("help");
    }
    //Method that returns the value of the exit
    public String getExit(){
        return command.get("exit");
    }
    //Method that returns the value of the execute
    public String getExecute(){
        return command.get("execute");
    }
    //Method that returns the value of the batch
    public String getBatch(){
        return command.get("batch");
    }

    //Method that returns the value of the given key
     public String getValue(String key){
        return command.get(key);
    }
     //Method that inserts a given key and value into the dictionary
    public void insertCommand(String key, String value){
        command.put(key, value);
    }
    
    //Method that renames the value of given key
    public void rename(String key, String value){
        command.remove(key);
        command.put(key,value);
    }
}
