# Naven_Operating_System
# [1.Overview]

**1.1 System Overview**		

	NavenOS is a simple operating system, which allows a simple and quick user experience.NavenOS is programmed to create an easy interaction 
	between the user and programs the OS includes; furthermore flexible and easy to use. 

# [2. Description of Classes]
**NavenOS.java**

The NavenOS class contains the user interface and the user command functions, including the help function. NavenOS class runs the whole operating system and handles the function that needs to be implement using loops, recursion and if statements.

**CPU.java**

The CPU class contains 4 registers with names: ax, bx, cx, dx which are String data type, a program counter which is integer data type and is referred as PC and an accumulator location which is integer data type referred to as A. 

The CPU class also deals with the setting and getting of this register, PC and A as displayed in Figure(1.2)

Moreover the CPU can also display us the current state of the four register, PC and A as shown in Figure(1.3)

**RAM.java**

The RAM class deals with the creation of an array(Figure 1.4) and assigning values in to the array to a specific RAM location

**commandDic.java**

The commandDic class is the manipulation of the commands the operating system uses to perform tasks and operations. The commandDic uses Map and HashMap data structure for the storage and manipulation of the commands. 

The commandDic class deals:

      o	The storage of the given commands
      
      o	Renaming of a given command
      
      o	Adding a new command
      
      o	Returning commands
      
**DateTime.java**

The DateTime class deals with the extraction of the current date and time for display. Uses the Java.time.format.DateTimeFormatter and java.time.LocalDateTime; java packages to do the manipulation.

      o	Extraction of the current time and date
      
      o	Display the current time and date 
      
**Directory.java**

The Directory class deals with the extraction of the files in the current directory but using the java.io.File package from java. 

      o	Extraction of the files in the current directory
      
      o	Display of the files in the current directory 
      
**Version.java**

The version class deals with creation of the version, setting the version of the operating system, getting the value of the version and returning the version of the operating system. 

      o	Creation of version
      
      o	Setting the version
      
      o	Getting the version
      
      o	Returning the version
      
**Machine.java**

The machine class is the virtual machine for the OS manage. It creates a RAM and CPU objects and perform the reading and manipulation of the file. As well perform the “FetchAndExecute” from the read file. 

      o	Creation of the RAM and CPU objects
      o	Read a file and storage of data from file to RAM
      o	Manipulation of the file 
      o	Performing the FetchAndExecute
      
      
      
