import java.util.Arrays;

class Player {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }
}

public class FantasyLeagueDraftStep {

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        Player[] finalPlayers = Arrays.copyOf(draftable, count);

        Arrays.sort(finalPlayers, (a, b) ->
            Double.compare(b.battingAverage, a.battingAverage)
        );

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {
            result = result + (i + 1) + ". " + finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}