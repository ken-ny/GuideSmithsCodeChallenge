This is a script application, therefore, it is expected to be run in a terminal.
For doing so, there are two options:

1. Open the proyect in an IDE and run App.java (the main class)
2. Execute the jar file. There is an already generated file in the main folder by the name of codeTest-1.0-MARS-jar-with-dependencies.jar so you can just execute it with "java -jar codeTest-1.0-MARS-jar-with-dependencies.jar"
However, if you wish to compile a new jar, you just have to run a mvn clean install in the source folder and a new jar file will appear in the target folder.
Once you have the jar, you just jve to execute it with "java -jar codeTest-1.0-MARS-jar-with-dependencies.jar".
The result of the app (a little report text about the data, the robots, etc) will be generated in the same folder the jar is in.
