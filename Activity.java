// CLASS: Activity
//
// Author: Jesse Shen, 7909192
//
// REMARKS: Main abstract class for all activities. Each of activities should include type, name, location, data and duration.
//          These parameters are accompanied by getters and included in isSame() and printActivities() methods.
//          Each type of activities should have getPace() and getLabel() methods
//-----------------------------------------
import java.time.Duration;
import java.time.LocalDate;

public abstract class Activity {
    // Constant variables for index of given command line array
    final private int TYPE = 0;
    final private int NAME = 1;
    final private int LOCATION = 2;
    final private int DATE = 3;
    final private int DURATION = 4;

    //Instance variables
    private String type;
    private String name;
    private String location;
    private LocalDate date;
    private Duration duration;


    //------------------------------------------------------
    // Activity
    //
    // PURPOSE:    Class Constructor
    // PARAMETERS: a String array contains the string values for a given activity data, which is stored/parsed into instance variables
    //------------------------------------------------------
    public Activity(String[] data) {
        //initialize data values
        this.type = data[TYPE];
        this.name = data[NAME];
        this.location = data[LOCATION];
        this.date = LocalDate.parse(data[DATE]);
        this.duration = Duration.parse(data[DURATION]);
    }

    //Getters Methods
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public Duration getDuration() {
        return duration;
    }
    public String getLocation() {
        return location;
    }
    public LocalDate getDate() {
        return date;
    }

    //------------------------------------------------------
    // isSame
    //
    // PURPOSE:  compares this instance with another given instance, compares all instances variables
    // PARAMETERS: an instance of Activity or any subclass, which is used to compare with this instance, does not alter any data
    // Returns: true for all matching instance variables, false otherwise
    //------------------------------------------------------
    public boolean isSame(Activity data) {
        return type.equals(data.getType()) && name.equals(data.getName()) && location.equals(data.getLocation()) && date.isEqual(data.getDate()) && duration.equals(data.getDuration());
    }

    //------------------------------------------------------
    // printActivity
    //
    // PURPOSE:  prints all instance variables onto the console
    //------------------------------------------------------
    public void printActivity() {
        //print headers: date, label, name, location
        String header = "[" + getDate().toString() + "] " + getLabel() + ": " + getName() + " at " + getLocation();
        System.out.println(header);
        //print duration
        String duration = "\tduration: " + getDuration().toHoursPart() + " hour(s) and " + getDuration().toMinutesPart() + " minute(s);";
        System.out.println(duration);
    }

    //Abstract methods
    public abstract double getPace();
    public abstract String getLabel();
}
