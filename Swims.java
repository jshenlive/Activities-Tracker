// CLASS: Swims
//
// Author: Jesse Shen, 7909192
//
// REMARKS: subclass of OffLand, a specific type of activity
//-----------------------------------------
public class Swims extends OffLand {
    //Constant variable of class label
    final private String LABEL = "Swims";
    //Constant variables of index of given command line array
    final private int LAPS = 5;
    final private int LAP_LENGTH = 6;

    //Instance variables
    private int laps;
    private int lapLength;

    //Constructor
    public Swims(String[] data) {
        super(data);

        //initialize given data values to instance
        this.laps = Integer.parseInt(data[LAPS]);
        this.lapLength = Integer.parseInt(data[LAP_LENGTH]);

        //add specific pace calculation to parent class
        addPace((getDuration().toSeconds() / 60.0) / (getDistance()));
    }

    //Getter
    public int getLaps() {
        return laps;
    }
    public int getLapLength() {
        return lapLength;
    }
    public double getDistance() {
        return (double) getLaps() * getLapLength() / 1000;
    }
    public String getLabel() {
        return LABEL;
    }

    //------------------------------------------------------
    // isSame
    //
    // PURPOSE:  compares this instance with another given instance, compares all instances variables
    // PARAMETERS: an instance of Activity or any subclass, which is used to compare with this instance,
    //             calls and checks with super class of same name, does not alter any data
    // Returns: true for all matching instance variables, false otherwise
    //------------------------------------------------------
    public boolean isSame(Activity data) {
        if (super.isSame(data)) {
            return this.getLaps() == ((Swims) data).getLaps() && this.getLapLength() == ((Swims) data).getLapLength();
        }
        return false;
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:  calls super class printActivity, and prints all instance variables and pace with specific unit
    //------------------------------------------------------
    public void printActivity() {
        super.printActivity();

        //prints out instance variable laps and laplength
        String laps = "\tlaps: " + getLaps() + ";";
        String lapLength = "\tlap length: " + getLapLength() + "m;";
        System.out.println(laps);
        System.out.println(lapLength);

        //prints out instance pace
        String pace = "\taverage pace: %.2f";
        System.out.printf(pace, getPace());
        System.out.println("min/km;");
    }
}

