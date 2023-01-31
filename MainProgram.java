//-----------------------------------------
// NAME		: Jesse Shen
// STUDENT NUMBER	: 7909192
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Tremblay-Savard
// ASSIGNMENT	: assignment 1
//
// REMARKS: Given filename input, this program reads the file which should contain activities in a required format,
//          adds to a linked list (GenericList), then with given queries in a required format, runs the queries,
//          and prints out the results
//-----------------------------------------
import java.util.Objects;
import java.util.Scanner;


public class MainProgram {
    public static void main(String[] args) {
        final int COMMAND = 0;                                      //command index within given line from file

        ActivityList activityList = new ActivityList();            //creating a new activity list

        // printing intro message
        System.out.println("Welcome to the Comp 2150 Activity Tracker");
        System.out.print("Please enter the name of the file with your activities: ");

        //Scanner for reading user input of filename
        final Scanner stdin = new Scanner(System.in);
        String filename = stdin.nextLine();                         //reads filename from user input
        System.out.println("Going to read [" + filename + "]");

        //Scanner for reading file
        final Scanner fileIn = new Scanner(Objects.requireNonNull(MainProgram.class.getResourceAsStream(filename))); //run file
        String line;                                               //used for storing each line of the file


        // checks each line of the file, runs each command within provided file
        while (fileIn.hasNextLine()) {
            line = fileIn.nextLine();
            String[] lineItems = line.split(" ");           //splits each line into an array
            if (lineItems[COMMAND].equals("QUIT")) {              //QUIT command
                System.out.println("Good-Bye!");
                System.exit(0);
            } else if (lineItems[COMMAND].equals("QUERY")) {      //QUERY command
                Query.initQuery(activityList, lineItems);
            } else {                                              //ACTIVITY
                activityList.add(lineItems);
            }
        }
    }
}
