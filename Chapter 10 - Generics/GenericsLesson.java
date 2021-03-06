import java.util.*;


public class GenericsLesson {
    public static void main(String[] args) {
        FootballPlayer stef = new FootballPlayer("Stefanos Koutelis");
        FootballPlayer kleio = new FootballPlayer("Kleio Kouteli");
        FootballPlayer phaedra = new FootballPlayer("Phaedra Vasiliou");
        Team<FootballPlayer> family = new Team<>("FC Family");

        family.addPlayer(stef);
        family.addPlayer(kleio);
        family.addPlayer(phaedra);
        family.printTeam();

        Team<FootballPlayer> barcelona = new Team<>("FC Barcelona");
        barcelona.addPlayer(new FootballPlayer("Ronaldo"));
        barcelona.addPlayer(new FootballPlayer("Messi"));
        barcelona.addPlayer(new FootballPlayer("Kotsios"));
        barcelona.printTeam();

        family.matchResult(barcelona, 3, 2);
        barcelona.matchResult(family, 3, 2);
        barcelona.matchResult(family, 2, 2);
        barcelona.matchResult(family, 1, 4);


        family.printStats();
        barcelona.printStats();

        System.out.println(family.compareTo(barcelona));
    }
}


abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}


class BaseballPlayer extends Player {

    public BaseballPlayer(String name) {
        super(name);
    }
}


class FootballPlayer extends Player {

    public FootballPlayer(String name) {
        super(name);
    }
}


class SoccerPlayer extends Player {

    public SoccerPlayer(String name) {
        super(name);
    }
}


class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private ArrayList<T> players;
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesTied = 0;
    
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public boolean addPlayer(T player) {
        if (players.contains(player)) {
            System.out.println("Player already exists\n");
            return false;
        }
        this.players.add(player);
        System.out.println("New player '" + player.getName() + "' added\n");
        return true;
    }

    public void printStats() {
        System.out.println(getName() + " ranking: " + ranking());
        System.out.println("Games played: " + this.gamesPlayed);
        System.out.println("------------");
        System.out.println(" Won: " + this.gamesWon);
        System.out.println("Lost: " + this.gamesLost);
        System.out.println("Ties: " + this.gamesTied);
        System.out.println();
    }

    public int numPlayers() {
        return this.players.size();
    }

    public void printTeam() {
        System.out.println(this.name + ":");
        for (T player : this.players) {
            System.out.println("  * " + player.getName());
        }
    }

    public void matchResult(Team<T> oppTeam, int ourScore, int theirScore) {
        String message;
        gamesPlayed++;
        if (ourScore > theirScore) {
            gamesWon++;
            message = " beat ";
        } else if (ourScore < theirScore) {
            gamesLost++;
            message = " lost to ";
        } else {
            gamesTied++;
            message = " tied with ";
        }

        if (oppTeam != null) {
            System.out.println(getName() + message + oppTeam.getName());
            oppTeam.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return this.gamesWon * 2 + this.gamesTied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        }
        return 0;
    }
}
