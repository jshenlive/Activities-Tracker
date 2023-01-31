build: MainProgram.class

MainProgram.class: MainProgram.java
	javac MainProgram.java

run: MainProgram.class
	java MainProgram

clean:
	rm *.class
