import java.util.*;

public class LinkedListChallenge {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isActive = true;
    private static LinkedList<Song> activePlaylist;

    public static void main(String[] args) {

        init();
        ListIterator<Song> playlistIterator = activePlaylist.listIterator();
        while (isActive) {
            menu(playlistIterator);
        }
        
    }

    static void init() {
        Album songsAboutJane = new Album("Songs about Jane", "Maroon 5");
        songsAboutJane.addSong(new Song("Harder to Breathe", "Maroon 5", 3.54));
        songsAboutJane.addSong(new Song("This Love", "Maroon 5", 2.36));
        songsAboutJane.printInfo();

        Album theWall = new Album("The Wall", "Pink Floyd");
        theWall.addSong("Another brick in the wall pt2", 3.40);
        theWall.addSong(new Song("Empty spaces", 5.21));
        theWall.printInfo();

        Playlist favorites = new Playlist("Favorites");
        
        for (Album ownedAlbum : Album.getOwnedAlbums()) {
            for (Song song : ownedAlbum.getTracklist()) {
                favorites.addSong(song);
            }
        }
        favorites.printTracklist();
        activePlaylist = new LinkedList<Song>(favorites.getTracklist());
    }

    static void menu(ListIterator iterator) {
        Song currentSong;
        String input = scanner.nextLine();
        switch (input) {
            case "0":
                System.out.println("Shutting down...");
                isActive = false;
                break;
            case "1":
                // previous track
                if (iterator.hasPrevious()) {
                    currentSong = iterator.previous();
                    System.out.println("Previous track: ");
                    System.out.printf("%s%n", currentSong.getTitle());
                }
                break;
            case "2":
                // next track
                if (iterator.hasNext()) {
                    currentSong = iterator.next();
                    System.out.println("Next track: ");
                    System.out.printf("%s%n", currentSong.getTitle());
                }
                break;
            case "3":
                // replay track
                System.out.println("Replaying track: ");
                break;
            case "4":
                // remove track from playlist
                System.out.println("Removed track from playlist: ");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

}

class Playlist {

    private final String name;
    private final ArrayList<Song> tracklist;

    public Playlist(String name) {
        this.name = name;
        this.tracklist = new ArrayList<Song>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Song> getTracklist() {
        return this.tracklist;
    }

    public void addSong(Song song) {
        if (hasSong(song)) {
            this.tracklist.add(song);
            System.out.printf("Song added in \"%s\" playlist%n", this.name);
        } else {
            System.out.println("You don't own this song");
        }
        
    }

    public boolean hasSong(Song song) {
        // search if song exists in tracklist (based on Song object)
        if (Album.getOwnedAlbums().size() >= 1) {
            for (Album ownedAlbum : Album.getOwnedAlbums()) {
                for (Song existingSong : ownedAlbum.getTracklist()) {
                    if (existingSong == song) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public void printTracklist() {
        System.out.println();
        for (Song song : this.tracklist) {
            System.out.printf("%s by %s%n", song.getTitle(), song.getArtist());
        }
    }

}

class Album {

    private static ArrayList<Album> ownedAlbums = new ArrayList<Album>();
    private final ArrayList<Song> tracklist;
    private final String title;
    private String artist;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.tracklist = new ArrayList<Song>();
        ownedAlbums.add(this);
    }

    public Album(String title) {
        this(title, "Unknown");
    }

    public ArrayList<Song> getTracklist() {
        return this.tracklist;
    }

    public void printInfo() {
        System.out.printf("%n\"%s\" by %s:%n", this.title, this.artist);
        int trackNo = 1;
        for (Song song : this.tracklist) {
            System.out.printf("    %d. %s%n", trackNo, song.getTitle());
            trackNo++;
        }
    }

    public void addSong(Song song) {
        // add a song to the tracklist if it (object) doesn't already exists in it
        if (hasSong(song)) {
            System.out.println("This song already exists in tracklist");
        } else {
            if (song.getArtist().equals("Unknown")) {
                song.setArtist(this.artist);
            }
            this.tracklist.add(song);
        }
    }

    public void addSong(String songTitle, double duration) {
        // add a song to the tracklist if its title is not already in it
        if (hasSong(songTitle)) {
            System.out.println("This song already exists in tracklist");
        } else {
            this.tracklist.add(new Song(songTitle, this.artist, duration));
        }
    }

    public boolean hasSong(Song song) {
        // search if song exists in tracklist (based on Song object)
        if (this.tracklist != null) {
            for (Song existingSong : this.tracklist) {
                if (existingSong == song) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean hasSong(String songTitle) {
        // search if song exists in tracklist (based on song title)
        if (this.tracklist != null) {
            for (Song existingSong : this.tracklist) {
                if (existingSong.getTitle() == songTitle) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static ArrayList<Album> getOwnedAlbums() {
        return ownedAlbums;
    }

}

class Song {

    private final String title;
    private String artist;
    private int duration;  // seconds

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        // convert duration to seconds
        int currentMin = ((int) duration);
        double currentSecs = duration - currentMin;
        this.duration = (int) (currentMin * 60 + currentSecs);
    }

    public Song(String title, double duration) {
        this(title, "Unknown", duration);
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getDuration() {
        return String.format("%d:%d", this.duration / 60, this.duration % 60);
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
