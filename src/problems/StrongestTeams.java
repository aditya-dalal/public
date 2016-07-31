package problems;

import java.util.*;

/**
 * Created by aditya.dalal on 27/07/16.
 */
public class StrongestTeams {

    public static void main(String[] args) {
        int[] pl = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s = {1, 1, 3, 1, 1, 3, 2, 2, 3, 4};
        int[] a = {0, 1, 2};
        int[] b = {3, 4, 5};
        int[] c = {6, 7, 8, 9};
        int x = 2, y = 2, z = 2, k = 4;

        long start = System.currentTimeMillis();

        validateInput(a.length, b.length, c.length, x, y, z, k, s.length);

        Map<Integer, List<List<Integer>>> batsmanCombinationsMap = getPlayerCombinations(a, x);
        Map<Integer, List<List<Integer>>> bowlerCombinationsMap = getPlayerCombinations(b, y);
        Map<Integer, List<List<Integer>>> keeperCombinationsMap = getPlayerCombinations(c, z);
        Map<List<List<Integer>>, Integer> resultMap = new HashMap<>();

        List<List<Integer>> teamCombinations = getTeamCombinations(a, b, c, x, y, z, k);
        System.out.println(teamCombinations);

        for(List<Integer> teamCombination: teamCombinations) {

            List<List<List<Integer>>> teams = getTeams(batsmanCombinationsMap, bowlerCombinationsMap, keeperCombinationsMap, teamCombination);
            System.out.println(teams.size());

            List<List<List<Integer>>> validGroups = getGroups(teams, k);
            System.out.println(validGroups.size());

            Map<List<Integer>, Integer> teamStrengthMap = getTeamStrengthMap(s, validGroups);

            Map<Integer, List<List<Integer>>> diffMapWithHighestStrength = getDiffMapWithHighestGroupStrength(teamStrengthMap, validGroups);

            if(diffMapWithHighestStrength.size() != 0)
                resultMap.putAll(getResultGroup(teamStrengthMap, diffMapWithHighestStrength));
        }

        if(resultMap.size() == 0)
            System.out.println("No teams possible with given input");
        else {
            printResult(s, getResult(s, resultMap));
        }
        System.out.println(System.currentTimeMillis() - start);

    }

    private static void printResult(int[] s, List<List<Integer>> result) {
        int team1Strength = getTeamStrength(s, result.get(0));
        int team2Strength = getTeamStrength(s, result.get(1));
        System.out.println("Team1: " + result.get(0));
        System.out.println("Team2: " + result.get(1));
        System.out.println("Team1 Strength: " + getPlayerStrengthList(s, result.get(0)) + " = " + team1Strength);
        System.out.println("Team2 Strength: " + getPlayerStrengthList(s, result.get(1)) + " = " + team2Strength);
        System.out.println("Diff: " + Math.abs(team1Strength - team2Strength));
    }

    private static List<Integer> getPlayerStrengthList(int[] s, List<Integer> team) {
        List<Integer> strengths = new ArrayList<>();
        for(int player: team)
            strengths.add(s[player]);
        return strengths;
    }

    private static List<List<Integer>> getResult(int[] s, Map<List<List<Integer>>, Integer> resultMap) {
        Map.Entry<List<List<Integer>>, Integer> result = null;
        for(Map.Entry<List<List<Integer>>, Integer> resultEntry: resultMap.entrySet()){
            if(result == null) {
                result = resultEntry;
            }
            else if(getTeamStrength(s, resultEntry.getKey().get(0)) + getTeamStrength(s, resultEntry.getKey().get(1)) >
                    getTeamStrength(s, result.getKey().get(0)) + getTeamStrength(s, result.getKey().get(1))) {
                result = resultEntry;
            }
        }
        return result.getKey();
    }

    private static List<List<Integer>> getTeamCombinations(int[] a, int[] b, int[] c, int x, int y, int z, int k) {
        List<List<Integer>> teamCombinations = getTeamCombinations(x, y, z, k);
        return getValidTeamCombinations(a.length, b.length, c.length, teamCombinations);
    }

    private static List<List<Integer>> getTeamCombinations(int x, int y, int z, int k) {
        List<List<Integer>> teamCombinations = new ArrayList<>();
        int[] xArr = getArray(x);
        int[] yArr = getArray(y);
        int[] zArr = getArray(z);
        for (int i : xArr)
            for (int j : yArr)
                for (int l : zArr)
                    if (i + j + l == k )
                        teamCombinations.add(Arrays.asList(i, j, l));
        return teamCombinations;
    }

    private static List<List<Integer>> getValidTeamCombinations(int a, int b, int c, List<List<Integer>> teamCombinations) {
        List<List<Integer>> validTeamCombinations = new ArrayList<>();
        for(List<Integer> teamCombination: teamCombinations){
            if(a/teamCombination.get(0) <= 1 || b/teamCombination.get(1) <=1 || c/teamCombination.get(2) <= 1)
                continue;
            validTeamCombinations.add(teamCombination);
        }
        return validTeamCombinations;
    }

    private static Map<List<Integer>, Integer> getTeamStrengthMap(int[] s, List<List<List<Integer>>> validGroups) {
        Map<List<Integer>, Integer> teamStrengthMap = new HashMap<>();
        for (List<List<Integer>> group : validGroups) {
            for (List<Integer> team : group) {
                teamStrengthMap.put(team, getTeamStrength(s, team));
            }
        }
        return teamStrengthMap;
    }

    private static int getTeamStrength(int[] s, List<Integer> team) {
        int teamStrength = 0;
        for (int player : team)
            teamStrength += s[player];
        return teamStrength;
    }

    private static List<List<Integer>> getValidGroup(List<List<Integer>> team1, List<List<Integer>> team2, int k){
        List<Integer> newTeam1 = new ArrayList<>();
        List<Integer> newTeam2 = new ArrayList<>();
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i).size() == 1) {
                newTeam1.add(team1.get(i).get(0));
                newTeam2.add(team2.get(i).get(0));
            } else if (areUniquePlayers(team1.get(i), team2.get(i))) {
                for (int j = 0; j < team1.get(i).size(); j++) {
                    newTeam1.add(team1.get(i).get(j));
                    newTeam2.add(team2.get(i).get(j));
                }
            }
        }
        List<List<Integer>> group = null;
        if (newTeam1.size() == k) {
            group = new ArrayList<>();
            group.add(newTeam1);
            group.add(newTeam2);
        }
        return group;
    }

    private static List<List<List<Integer>>> getGroups(List<List<List<Integer>>> teams, int k) {
        List<List<List<Integer>>> groups = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                if (areTeamsWithUniqueGroups(teams.get(i), teams.get(j))) {
                    List<List<Integer>> group = getValidGroup(teams.get(i), teams.get(j), k);
                    if(group != null) {
                        groups.add(group);
                    }
                }
            }
        }
        return groups;
    }

    private static void validateInput(int a, int b, int c, int x, int y, int z, int k, int s) {
        if(a <= 1 || b <= 1 || c <= 1) {
            System.out.println("Two teams not possible with 0/1 batsman/bowler/keeper");
            System.exit(0);
        }
        else if(x < 1 || y < 1 || z < 1) {
            System.out.println("Each team should have at least 1 batsman, 1 bowler and 1 WK ");
            System.exit(0);
        }
        else if(k < 3){
            System.out.println("Cannot form a team with less than 3 players. Each team should have at least 1 batsman, 1 bowler and 1 WK ");
            System.exit(0);
        }
        else if(s < a+b+c){
            System.out.println("Strength not available for few players.");
            System.exit(0);
        }
    }

    private static List<List<List<Integer>>> getTeams(Map<Integer, List<List<Integer>>> batCombinationsMap, Map<Integer, List<List<Integer>>> bowlCombinationsMap, Map<Integer, List<List<Integer>>> keeperCombinationsMap, List<Integer> first) {
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
        return teams;
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

    private static int[] getArray(int max) {
        int[] arr = new int[max];
        for(int i = 0; i < max; i++)
            arr[i] = i+1;
        return arr;
    }

    private static Map<List<List<Integer>>, Integer> getResultGroup(Map<List<Integer>, Integer> teamStrengthMap, Map<Integer, List<List<Integer>>> strengthDiffMap) {
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
        Map<List<List<Integer>>, Integer> res = new HashMap<>();
        res.put(result.getValue(), result.getKey());
        return res;
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

}
