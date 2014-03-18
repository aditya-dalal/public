package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelectionSubset
{
    public static void main(String[] args)
    {
        List<Activity> activities = new ArrayList<Activity>();
        activities.add(new Activity(1,8,11));
        activities.add(new Activity(2,6,10));
        activities.add(new Activity(3,3,8));
        activities.add(new Activity(4,1,4));
        activities.add(new Activity(5,0,6));
        activities.add(new Activity(6,3,5));
        activities.add(new Activity(6,5,7));
        activities.add(new Activity(8,8,12));
        activities.add(new Activity(9,5,9));
        activities.add(new Activity(10,2,13));
        activities.add(new Activity(11,12,14));

        Collections.sort(activities);
        List<Activity> compatibleActivities = generateActivitySubset(activities);

        for(Activity activity : compatibleActivities)
        {
            System.out.println(activity.id + " : " + activity.start + " : " + activity.finish);
        }
    }

    private static List<Activity> generateActivitySubset(List<Activity> activities)
    {
        List<Activity> compatibleActivities = new ArrayList<Activity>();

        Activity currentActivity = activities.get(0);
        compatibleActivities.add(currentActivity);

        for(int i = 1; i < activities.size(); i++)
        {
            if(activities.get(i).start >= currentActivity.finish)
            {
                compatibleActivities.add(activities.get(i));
                currentActivity = activities.get(i);
            }
        }
        return compatibleActivities;
    }

}

class Activity implements Comparable<Activity>
{
    Integer start;
    Integer finish;
    int id;

    public Activity(int id, int startTime, int finishTime)
    {
        this.id = id;
        start = startTime;
        finish = finishTime;
    }

    public int compareTo(Activity activity)
    {
        return this.finish.compareTo(activity.finish);
    }
}