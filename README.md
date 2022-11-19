# Software-Engineering-Group-9
Drawing app


Definition of Done: 

- The function has been completely implemented 
- The code has been reviewed by all members of the team 
- The product owner has accepted the implementation of the user story 
- The user story implementation meets ALL the acceptance criteria 
- The unit tests were written, executed and passed 
- Every acceptance criteria have at least a test case associated 
- Integration testing performed and compiles 

 

Coding convenction:

Java JDK 8 and Apache Netbeans have been chosen as the programming language and IDE respectively. The external libraries javafx and java.util are also used.
CamelCase style will be used for variable naming. 

 

Software architecture: 

The software architecture chosen for the development is the Model-View-Controller via JavaFX which uses the markup language FXML in combination with Java. 
The Model consists of the specific application of the domain object and will therefore contain the implementation of all methods of the drawing app. 
The View consists of the FXML file, created using JavaFXSceneBuilder and will define the GUI of the drawing app. 
The Controller is represented by the Java code that defines the behavior of the interface that interacts with the user. Therefore, it will receive the user's commands and based on them it will implement the interface changes. Contains all functions of the drawing app. 
For the Design, we thought to use the following patterns: Command pattern, Decorator pattern and Abstract Factory pattern.  
