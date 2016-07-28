package problems;

import java.util.*;

/**
 * Created by aditya.dalal on 27/07/16.
 */
public class StrongestTeams {

    public static void main(String[] args) {
        int[] pl = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a = {0, 1, 2};
        int[] b = {3, 4, 5};
        int[] c = {6, 7, 8, 9};
        int[] s = {1, 1, 3, 1, 1, 3, 2, 2, 3, 4};

        Map<List<Integer>, Integer> teamStrengthMap = getTeamStrengthMap(a, b, c, s);

        List<List<List<Integer>>> groups = getGroupsWithValidTeams(teamStrengthMap);

        Map<Integer, List<List<Integer>>> strengthDiffMap = getStrengthDiffMap(teamStrengthMap, groups);

        List<List<Integer>> result = getResultGroup(teamStrengthMap, strengthDiffMap);

        printResult(teamStrengthMap, result);
    }

    private static List<List<Integer>> getResultGroup(Map<List<Integer>, Integer> teamStrengthMap, Map<Integer, List<List<Integer>>> strengthDiffMap) {
        List<List<Integer>> result = null;
        for(Map.Entry<Integer, List<List<Integer>>> diffEntry: strengthDiffMap.entrySet()) {
            int totalStrength = teamStrengthMap.get(diffEntry.getValue().get(0)) + teamStrengthMap.get(diffEntry.getValue().get(1));
            if(result != null){
                int currentStrength = teamStrengthMap.get(result.get(0)) + teamStrengthMap.get(result.get(1));
                if(currentStrength < totalStrength)
                    result = diffEntry.getValue();
            }
            else
                result = diffEntry.getValue();
        }
        return result;
    }

    private static Map<Integer, List<List<Integer>>> getStrengthDiffMap(Map<List<Integer>, Integer> teamStrengthMap, List<List<List<Integer>>> groups) {
        Map<Integer, List<List<Integer>>> strengthDiffMap = new HashMap<>();
        for(List<List<Integer>> group: groups) {
            int team1 = teamStrengthMap.get(group.get(0));
            int team2 = teamStrengthMap.get(group.get(1));
            int diff = Math.abs(team1 - team2);
            if(strengthDiffMap.get(diff) != null){
                List<List<Integer>> teams = strengthDiffMap.get(diff);
                if((teamStrengthMap.get(teams.get(0)) + teamStrengthMap.get(teams.get(1))) < (team1 + team2))
                    strengthDiffMap.put(diff, group);
            }
            else
                strengthDiffMap.put(diff, group);
        }
        return strengthDiffMap;
    }

    private static List<List<List<Integer>>> getGroupsWithValidTeams(Map<List<Integer>, Integer> teamStrengthMap) {
        List<List<Integer>> teamList = new ArrayList<>(teamStrengthMap.keySet());
        List<List<List<Integer>>> groups = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = i + 1; j < teamList.size(); j++) {
                if(areTeamsWithUniquePlayers(teamList.get(i), teamList.get(j))) {
                    List<List<Integer>> temp = new ArrayList<>();
                    temp.add(teamList.get(i));
                    temp.add(teamList.get(j));
                    groups.add(temp);
                }
            }
        }
        return groups;
    }

    private static Map<List<Integer>, Integer> getTeamStrengthMap(int[] batsmen, int[] bowlers, int[] keepers, int[] strength) {
        Map<List<Integer>, Integer> teamStrengthMap = new LinkedHashMap<>();
        for (int i : batsmen) {
            for (int j : bowlers) {
                for (int k : keepers) {
                    List<Integer> team = new ArrayList<>();
                    team.add(i);
                    team.add(j);
                    team.add(k);
                    teamStrengthMap.put(team, strength[i] + strength[j] + strength[k]);
                }
            }
        } return teamStrengthMap;
    }

    private static void printResult(Map<List<Integer>, Integer> teamStrengthMap, List<List<Integer>> result) {
        System.out.println("T1 = " + result.get(0));
        System.out.println("T2 = " + result.get(1));
        System.out.println("S1 = " + teamStrengthMap.get(result.get(0)));
        System.out.println("S2 = " + teamStrengthMap.get(result.get(1)));
        System.out.println("D = " + Math.abs(teamStrengthMap.get(result.get(1)) - teamStrengthMap.get(result.get(0))));
    }

    private static boolean areTeamsWithUniquePlayers(List<Integer> team1, List<Integer> team2) {
        for(int i = 0; i < team1.size(); i++)
            if(team1.get(i) == team2.get(i))
                return false;
        return true;
    }

}
