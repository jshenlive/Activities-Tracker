// CLASS: Node
//
// Author: Jesse Shen, 7909192
//
// REMARKS: Node file, provide abstract data structure to link each activity,
//          contains printAllActivity, printAll, getData and getNext methods
//          calls printActivity from Activity class
//-----------------------------------------
public class Node {
    //Class variables
    private Activity data;      //Activity variable to be stored in list
    private Node next;          //pointer to next activity in list

    //Constructor
    public Node(Activity data, Node next) {
        this.data = data;
        this.next = next;
    }

    //Getters
    public Activity getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:    prints activities that matches the given activity type from current node to end of list
    // PARAMETERS: requires String of activity type,
    //             prints current and all subsequent nodes that matches the given activity type
    //------------------------------------------------------
    public void printAllActivity(String type) {
        if (data.getType().equals(type)) {
            data.printActivity();
        }
        if (next != null) {
            next.printAllActivity(type);
        }
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:    prints all activity data from current to end of list
    //------------------------------------------------------
    public void printAll() {
        data.printActivity();

        //recursively print until end of list
        if (next != null) {
            next.printAll();
        }
    }




}
