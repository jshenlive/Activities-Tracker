// CLASS: Query
//
// Author: Jesse Shen, 7909192
//
// REMARKS: abstract class, contains accepted query commands and run each given command accordingly through initQuery method
//
//-----------------------------------------
import java.time.LocalDate;

public abstract class Query {
    //Constant variable for index of command line array
    final private static int QUERY_TYPE = 1;
    final private static int ACTIVITY_TYPE = 2;
    final private static int START_DATE = 2;
    final private static int END_DATE = 3;

    //------------------------------------------------------
    // initQuery
    //
    // PURPOSE:    tell me what it does!
    // PARAMETERS: calls from MainProgram to query user given command lines in array form
    //             executes each given command by calling given ActivityList print methods:
    //             printTotalTime, printActivity, printBetween
    //------------------------------------------------------
    public static void initQuery(ActivityList list, String[] query) {
        String activityType;    //for query activities by type
        LocalDate startDate;    //for query activities between two dates, start date
        LocalDate endDate;      //for query activities between two dates, end date

        //Check for each available Query and run each query accordingly
        if (query[QUERY_TYPE].equals("TOTAL_TIME")) {
            list.printTotalTime();
        }
        if (query[QUERY_TYPE].equals("ACTIVITY")) {
            activityType = query[ACTIVITY_TYPE];
            list.printActivity(activityType);
        }
        if (query[QUERY_TYPE].equals("BETWEEN")) {
            startDate = LocalDate.parse(query[START_DATE]);
            endDate = LocalDate.parse(query[END_DATE]);
            list.printBetween(startDate, endDate);
        }

    }
}
