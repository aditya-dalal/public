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
        int x = 1, y = 1, z = 1, k = 3;

//        Map<List<Integer>, Integer> teamStrengthMap = getTeamStrengthMap(a, b, c, s);
//
//        List<List<List<Integer>>> groups = getGroupsWithValidTeams(teamStrengthMap);
//
//        Map<Integer, List<List<Integer>>> diffMapWithHighestStrength = getDiffMapWithHighestGroupStrength(teamStrengthMap, groups);
//
//        List<List<Integer>> result = getResultGroup(teamStrengthMap, diffMapWithHighestStrength);
//
//        printResult(teamStrengthMap, result);

        List<List<Integer>> teamCombinations = getTeamCombinations(x, y, z, k);

        Map<Integer, List<List<Integer>>> batCombinationsMap = getPlayerCombinations(a, x);
        Map<Integer, List<List<Integer>>> bowlCombinationsMap = getPlayerCombinations(b, y);
        Map<Integer, List<List<Integer>>> keeperCombinationsMap = getPlayerCombinations(c, z);

        List<Integer> first = teamCombinations.get(0);
        List<List<List<Integer>>> teams = new ArrayList<>();
        for(List<Integer> batsmen: batCombinationsMap.get(first.get(0))){
            for(List<Integer> bowlers: bowlCombinationsMap.get(first.get(1))){
                for(List<Integer> keepers: keeperCombinationsMap.get(first.get(2))){
                    List<List<Integer>> team = new ArrayList<>();
                    team.add(batsmen);
                    team.add(bowlers);
                    team.add(keepers);
                    teams.add(team);
                }
            }
        }

        List<List<List<List<Integer>>>> groups = new ArrayList<>();
        for(int i = 0; i < teams.size(); i++) {
            for(int j = i+1; j < teams.size(); j++) {
                if(areTeamsWithUniqueGroups(teams.get(i), teams.get(j))) {
                    List<List<List<Integer>>> temp = new ArrayList<>();
                    temp.add(teams.get(i));
                    temp.add(teams.get(j));
                    groups.add(temp);
                }
            }
        }

        List<List<List<Integer>>> validGroups = new ArrayList<>();
        for(List<List<List<Integer>>> group: groups) {
            List<List<Integer>> team1 = group.get(0);
            List<List<Integer>> team2 = group.get(1);
            List<Integer> newTeam1 = new ArrayList<>();
            List<Integer> newTeam2 = new ArrayList<>();
            for(int i = 0; i < team1.size(); i++){
                if(team1.get(i).size() == 1){
                    newTeam1.add(team1.get(i).get(0));
                    newTeam2.add(team2.get(i).get(0));
                }
                else if(areUniquePlayers(team1.get(i), team2.get(i))){
                    for(int j = 0; j < team1.get(i).size(); j++){
                        newTeam1.add(team1.get(i).get(j));
                        newTeam2.add(team2.get(i).get(j));
                    }
                }
            }
            if(newTeam1.size() >= team1.size()) {
                List<List<Integer>> validGroup = new ArrayList<>();
                validGroup.add(newTeam1);
                validGroup.add(newTeam2);
                validGroups.add(validGroup);
            }
        }

        Map<List<Integer>, Integer> teamStrengthMap = new LinkedHashMap<>();
        for(List<List<Integer>> group: validGroups){
            for(List<Integer> team: group){
                int teamStrength = 0;
                for(int player: team)
                    teamStrength += s[player];
                teamStrengthMap.put(team, teamStrength);
            }
        }

        Map<Integer, List<List<Integer>>> diffMapWithHighestStrength = getDiffMapWithHighestGroupStrength(teamStrengthMap, validGroups);

        List<List<Integer>> result = getResultGroup(teamStrengthMap, diffMapWithHighestStrength);

        printResult(teamStrengthMap, result);

    }

    private static boolean areUniquePlayers(List<Integer> playerList1, List<Integer> playerList2) {
        for(int player1: playerList1)
            for(int player2: playerList2)
                if(player1 == player2)
                    return false;
        return true;
    }

    private static boolean areTeamsWithUniqueGroups(List<List<Integer>> team1, List<List<Integer>> team2) {
        for(int i = 0; i < team1.size(); i++)
            if(team1.get(i) == team2.get(i))
                return false;
        return true;
    }

    private static Map<Integer, List<List<Integer>>> getPlayerCombinationMap(List<List<Integer>> playerCombinations, int max) {
        Map<Integer, List<List<Integer>>> playerCombinationsMap = new HashMap<>();
        for(List<Integer> list: playerCombinations) {
            int size = list.size();
            if(size > max)
                continue;
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(list);
            if(playerCombinationsMap.get(size) != null)
                temp.addAll(playerCombinationsMap.get(size));
            playerCombinationsMap.put(size, temp);
        }
        return playerCombinationsMap;
    }

    private static Map<Integer, List<List<Integer>>> getPlayerCombinations(int[] players, int max) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        for(int player : players){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> playerList : allCombinations) {
                List<Integer> list = new ArrayList<>(playerList);
                list.add(player);
                temp.add(list);
            }
            temp.add(Arrays.asList(player));
            allCombinations.addAll(temp);
        }
        return getPlayerCombinationMap(allCombinations, max);
    }

    private static List<List<Integer>> getTeamCombinations(int x, int y, int z, int k) {
        List<List<Integer>> teamCombinations = new ArrayList<>();
        int[] xArr = getArray(x);
        int[] yArr = getArray(y);
        int[] zArr = getArray(z);
        for (int i : xArr)
            for (int j : yArr)
                for (int l : zArr)
                    if (i + j + l == k)
                        teamCombinations.add(Arrays.asList(i, j, l));
        return teamCombinations;
    }

    private static int[] getArray(int max) {
        int[] arr = new int[max];
        for(int i = 0; i < max; i++)
            arr[i] = i+1;
        return arr;
    }

    private static List<List<Integer>> getResultGroup(Map<List<Integer>, Integer> teamStrengthMap, Map<Integer, List<List<Integer>>> strengthDiffMap) {
        Map.Entry<Integer, List<List<Integer>>> result = null;
        for(Map.Entry<Integer, List<List<Integer>>> diffEntry: strengthDiffMap.entrySet()) {
            int totalStrength = teamStrengthMap.get(diffEntry.getValue().get(0)) + teamStrengthMap.get(diffEntry.getValue().get(1));
            if(result != null){
                int currentStrength = teamStrengthMap.get(result.getValue().get(0)) + teamStrengthMap.get(result.getValue().get(1));
                if(currentStrength < totalStrength)
                    result = diffEntry;
                else if(currentStrength == totalStrength && diffEntry.getKey() < result.getKey())
                    result = diffEntry;
            }
            else
                result = diffEntry;
        }
        return result.getValue();
    }

    private static Map<Integer, List<List<Integer>>> getDiffMapWithHighestGroupStrength(Map<List<Integer>, Integer> teamStrengthMap, List<List<List<Integer>>> groups) {
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
