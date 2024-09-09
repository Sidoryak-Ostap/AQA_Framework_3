#TASK 5
#3. Write a maven command for executing one of your tasks with arguments (number of elements).


mvn clean install exec:java -Dexec.mainClass="task_5.StreamTask" -Dexec.args="5"
