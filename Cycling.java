// CLASS: Cycling
//
// Author: Jesse Shen, 7909192
//
// REMARKS: subclass of OnLand, a specific type of activity
//-----------------------------------------
public class Cycling extends OnLand {
    //Constant variable of class label
    final private String LABEL = "Cycling";

    //Constructor
    public Cycling(String[] data) {
        super(data);

        //add specific pace calculation to parent class
        addPace(getDistance() / (getDuration().toSeconds() / 3600.0));
    }

    //Getter
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
            return this.getDistance() == ((Cycling) data).getDistance() && this.getElevation() == ((Cycling) data).getElevation();
        }
        return false;
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:  calls super class printActivity, and prints pace with specific unit
    //------------------------------------------------------
    public void printActivity() {
        super.printActivity();

        //prints out instance pace
        String pace = "\taverage pace: %.2f";
        System.out.printf(pace, getPace());
        System.out.println("km/hr;");
    }
}
