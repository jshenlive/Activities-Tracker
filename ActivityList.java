// CLASS: ActivityList
//
// Author: Jesse Shen, 7909192
//
// REMARKS: A linked list data structure which reads given data in string array, processes and prints in various format.
//
//-----------------------------------------
import java.time.Duration;
import java.time.LocalDate;

public class ActivityList {
    //Constant variables
    final private int ACTIVITY = 0;              // index for activity type of given command line

    private Node top;
    private Duration totalDuration;     // accumulation of each activity duration

    //Class constructor
    public ActivityList() {
        top = null;                     //creates an empty list
        totalDuration = Duration.ZERO;  //sets default total duration to zero
    }

    //------------------------------------------------------
    // add
    //
    // PURPOSE:    add a given data string array, will omit if added previously and prints the added activity
    // PARAMETERS: requires an string array of the data to be added to the list, data is sorted into matching subclass of activity and data is processed by calling processData method
    //------------------------------------------------------
    public void add(String[] lineItems) {
        System.out.print("Adding activity: ");

        //check given activity type, then initiate subclass accordingly
        if (lineItems[ACTIVITY].equals("CYCLING")) {
            Cycling data = new Cycling(lineItems);
            processData(data);
        }
        if (lineItems[ACTIVITY].equals("RUNNING")) {
            Runs data = new Runs(lineItems);
            processData(data);
        }
        if (lineItems[ACTIVITY].equals("WALKING")) {
            Walks data = new Walks(lineItems);
            processData(data);
        }
        if (lineItems[ACTIVITY].equals("SWIMMING")) {
            Swims data = new Swims(lineItems);
            processData(data);
        }
    }
    //------------------------------------------------------
    // processData
    //
    // PURPOSE:    check if current data is already included in the list, if not add to the front of the list, and prints the added activity
    // PARAMETERS: requires a type or subclass of Activity, will check with all instances in the instance list,
    //             calls: isDuplicate, insertFront, getType and printActivity method
    //------------------------------------------------------
    public void processData(Activity data) {
        //process data only if given data is not a duplicate
        if (!isDuplicate(data)) {
            insertFront(data);
            data.printActivity();
        } else {
            System.out.println("Same " + data.getType() + " activity has been added previously!");
        }
    }

    //------------------------------------------------------
    // addDuration
    //
    // PURPOSE:     adds given activity duration to total durations of the current list
    // PARAMETERS:  requires a type or subclass of Activity, calls plus and getDuration methods
    //------------------------------------------------------
    public void addDuration(Activity data) {
        totalDuration = totalDuration.plus(data.getDuration());
    }

    public void insertFront(Activity data) {
        top = new Node(data, top);
        addDuration(data);
    }


    //------------------------------------------------------
    // isDuplicate
    //
    // PURPOSE:
    // PARAMETERS:  requires a type or subclass of Activity, calls plus and getDuration methods
    // RETURNS: true if same activity is found (all parameters matching), false otherwise
    //------------------------------------------------------
    public boolean isDuplicate(Activity data) {
        //check every node in the list
        Node curr = top;
        while (curr != null) {
            if (curr.getData().isSame(data)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    //------------------------------------------------------
    // printTotalTime
    //
    // PURPOSE:    print total activity time and all the activities in the list
    //------------------------------------------------------
    public void printTotalTime() {
        //print header
        System.out.println("Querying total activity time:");
        printDuration(totalDuration);

        //recursively call whole list
        if (top != null) {
            top.printAll();
        }
        System.out.println();
    }

    //------------------------------------------------------
    // printDuration
    //
    // PURPOSE:    prints a given duration in a string format onto the console
    // PARAMETERS: requires a Duration type data, calls toHoursPart, toMinutesPart
    //------------------------------------------------------
    public void printDuration(Duration duration) {
        System.out.println(duration.toHoursPart() + " hours and " + duration.toMinutesPart() + " minutes.");
    }

    //------------------------------------------------------
    // myMethod
    //
    // PURPOSE:    prints out all activities that matches a given activity type
    // PARAMETERS: requires a String of activity type, calls printAllActivity in Node class
    //------------------------------------------------------
    public void printActivity(String activity) {
        //print header
        System.out.println(">>> Querying activities of type " + activity);
        System.out.println("==========Activities==========");

        //recursively call whole list
        if (top != null) {
            top.printAllActivity(activity);
        }

        System.out.println();
    }

    //------------------------------------------------------
    // printBetween
    //
    // PURPOSE:     prints out all activities between two dates (inclusive)
    // PARAMETERS:  requires two LocalDate variables, startDate and endDate
    //              creates a new list and includes any activities in current list and prints them to console
    //              calls getData, isEqual, isAfter, isBefore, insertFront, and getNext method
    //              checks if new list isZero, if not calls printTotalTime on new list
    //------------------------------------------------------
    public void printBetween(LocalDate startDate, LocalDate endDate) {
        ActivityList newList = new ActivityList();  //creates a temp list which includes all activities within given parameter

        //loop over whole list, checking each node's date with given parameter
        Node curr = top;
        while (curr != null) {
            Activity data = curr.getData();
            if (data.getDate().isEqual(startDate) || data.getDate().isEqual(endDate) || (data.getDate().isAfter(startDate) && data.getDate().isBefore(endDate))) {
                newList.insertFront(data);
            }
            curr = curr.getNext();
        }

        System.out.println("Querying activity time between " + startDate.toString() + " and " + endDate.toString() + ":");

        //print total activity durations within given parameter
        if (!newList.totalDuration.isZero()) {
            newList.printTotalTime();
        } else {
            System.out.println("No activities found between these dates.");
        }
    }
}
