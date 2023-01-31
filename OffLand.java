// CLASS: OffLand
//
// Author: Jesse Shen, 7909192
//
// REMARKS: Subclass of Activity, an abstract class for activities that are off land,
//          e.g. Swims, Rowing(yet to be implemented),...
//-----------------------------------------
public abstract class OffLand extends Activity {
    //class variables
    private double pace; //stores the pace of the activity

    //constructor
    public OffLand(String[] data) {
        super(data);
    }

    //setter
    public void addPace(double pace) {
        this.pace = pace;
    }

    //getter
    public double getPace() {
        return pace;
    }

    //------------------------------------------------------
    // isSame
    //
    // PURPOSE:    calls super class
    // PARAMETERS: an instance of Activity or any subclass, which is used to compare with this instance, does not alter any data
    // Returns: true for all matching instance variables, false otherwise
    //------------------------------------------------------
    public boolean isSame(Activity data) {
        return super.isSame(data);
    }

    public void printActivity() {
        super.printActivity();
    }

}
