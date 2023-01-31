// CLASS: OnLand
//
// Author: Jesse Shen, 7909192
//
// REMARKS: Subclass of Activity, an abstract class for activities that are on land,
//          e.g. Walks, Runs, Cycling,...
//-----------------------------------------
public abstract class OnLand extends Activity {
    //Constant variables for index of given command line array
    final private int DISTANCE = 5;
    final private int ELEVATION = 6;

    //Instance variables
    private int distance;
    private int elevation;
    private double pace;

    //Constructor
    public OnLand(String[] data) {
        super(data);
        this.distance = Integer.parseInt(data[DISTANCE]);
        this.elevation = Integer.parseInt(data[ELEVATION]);
    }

    //Setter
    public void addPace(double pace) {
        this.pace = pace;
    }

    //Getters
    public double getDistance() {
        return distance;
    }
    public int getElevation() {
        return elevation;
    }
    public double getPace() {
        return pace;
    }

    //------------------------------------------------------
    // isSame
    //
    // PURPOSE:    pass current activity data to call super class isSame method
    // PARAMETER:  requires Activity class or subclass data variable
    public boolean isSame(Activity data) {
        return super.isSame(data);
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:    calls super class printActivity method,
    //             prints additional OnLand specific details: distance and elevation
    public void printActivity() {
        super.printActivity();

        //print distance
        String distance = "\tdistance: " + (int) getDistance() + "km;";
        System.out.println(distance);

        //print elevation
        String elevation = "\telev: " + getElevation() + "m;";
        System.out.println(elevation);
    }

}
