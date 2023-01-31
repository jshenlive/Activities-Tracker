// CLASS: Walks
//
// Author: Jesse Shen, 7909192
//
// REMARKS: subclass of OnLand, a specific type of activity
//-----------------------------------------
public class Walks extends OnLand {
    //Constant variable of class label
    final private String LABEL = "Walks";

    public Walks(String[] data) {
        super(data);

        //add specific pace calculation to parent class
        addPace((getDuration().toSeconds() / 60.0) / getDistance());
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
            return this.getDistance() == ((Walks) data).getDistance() && this.getElevation() == ((Walks) data).getElevation();
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
        System.out.println("min/km;");
    }
}
