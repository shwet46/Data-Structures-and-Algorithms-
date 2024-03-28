import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activityselection {

    public static void main(String[] args) {

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // end time basis
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> short function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // here we are specifically sorting the column 2
                                                                        // with the help of lambda function

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // activitites select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();

    }

}
