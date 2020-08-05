import java.util.*;

public class InnerClassesChallenge {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isActive = true;
    private static LinkedList<Song> activePlaylist;
    private static boolean forward = true;
    private static Song currentSong;

    public static void main(String[] args) {

        activePlaylist = init();
        ListIterator<Song> playlistIterator = activePlaylist.listIterator();
        options();
        currentSong = playlistIterator.next();
        System.out.println("Currently playing track: ");
        System.out.printf("%s%n", currentSong.getTitle());
        while (isActive && activePlaylist.size() > 0) {
            menu(playlistIterator);
        }
        
    }

    static LinkedList<Song> init() {
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
        return new LinkedList<Song>(favorites.getTracklist());
    }

    static void options() {
        System.out.println("Menu options:");
        System.out.println("------------");
        System.out.println("   0 = Quit");
        System.out.println("   1 = Go to previous track");
        System.out.println("   2 = Replay track");
        System.out.println("   3 = Go to next track");
        System.out.println("   4 = Remove current track from playlist");
        System.out.println("   5 = View options");
    }

    static void menu(ListIterator<Song> iterator) {
        System.out.println("Press '5' to view MENU");
        String input = scanner.nextLine();
        switch (input) {
            case "0":
                System.out.println("Shutting down...");
                isActive = false;
                break;
            case "1":
                // previous track
                if (forward) {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    forward = false;
                }
                if (iterator.hasPrevious()) {
                    currentSong = iterator.previous();
                    System.out.println("Previous track: ");
                    System.out.printf("%s%n", currentSong.getTitle());
                } else {
                    System.out.println("Top of the playlist, now playing:");
                    currentSong = iterator.next();
                    System.out.printf("%s%n", currentSong.getTitle());
                    forward = true;
                }
                break;
            case "3":
                // next track
                if (!forward) {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    forward = true;
                }
                if (iterator.hasNext()) {
                    currentSong = iterator.next();
                    System.out.println("Next track: ");
                    System.out.printf("%s%n", currentSong.getTitle());
                } else {
                    System.out.println("End of the playlist");
                    // restart playlist
                    while (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    currentSong = iterator.next();
                    System.out.println("Replaying playlist from 1st track: ");
                    System.out.printf("%s%n", currentSong.getTitle());
                }
                break;
            case "2":
                // replay track
                if (forward) {
                    currentSong = iterator.previous();
                    forward = false;
                } else {
                    currentSong = iterator.next();
                    forward = true;
                }
                System.out.printf("Replaying track: %s%n", currentSong.getTitle());
                break;
            case "4":
                // remove track from playlist
                iterator.remove();
                System.out.println("Removed track from playlist: ");
                System.out.printf("%s%n", currentSong.getTitle());
                if (iterator.hasNext()) {
                    currentSong = iterator.next();
                    forward = true;
                } else if (iterator.hasPrevious()) {
                    currentSong = iterator.previous();
                    forward = false;
                } else {
                    System.out.println("No more songs in playlist. Shutting down...");
                    isActive = false;
                    break;
                }
                System.out.println("Top of the playlist, now playing:");
                System.out.printf("%s%n", currentSong.getTitle());
                break;
            case "5":
                // view menu options
                options();
                break;
            default:
                System.out.println("Invalid input");
        }
        for (int i = 0; i < 6; i++) {
            System.out.println();
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
    private final String title;
    private String artist;
    private TrackList songlist;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songlist = new TrackList();
        ownedAlbums.add(this);
    }

    public Album(String title) {
        this(title, "Unknown");
    }

    public void printInfo() {
        System.out.printf("%n\"%s\" by %s:%n", this.title, this.artist);
        int trackNo = 1;
        for (Song song : this.songlist.getTracklist()) {
            System.out.printf("    %d. %s%n", trackNo, song.getTitle());
            trackNo++;
        }
    }

    public static ArrayList<Album> getOwnedAlbums() {
        return ownedAlbums;
    }

    public ArrayList<Song> getTracklist() {
        return this.songlist.getTracklist();
    }

    public void addSong(Song song) {
        // add a song to the tracklist if it (object) doesn't already exists in it
        if (this.songlist.hasSong(song)) {
            System.out.println("This song already exists in tracklist");
        } else {
            if (song.getArtist().equals("Unknown")) {
                song.setArtist(this.artist);
            }
            this.songlist.add(song);
        }
    }

    public void addSong(String songTitle, double duration) {
        // add a song to the tracklist if its title is not already in it
        if (this.songlist.hasSong(songTitle)) {
            System.out.println("This song already exists in tracklist");
        } else {
            this.songlist.add(new Song(songTitle, this.artist, duration));
        }
    }

    private class TrackList {
        private final ArrayList<Song> tracklist;

        public TrackList() {
            this.tracklist = new ArrayList<Song>(); 
        }

        public ArrayList<Song> getTracklist() {
            return this.tracklist;
        }

        public void add(Song song) {
            this.tracklist.add(song);
        }

        public void add(String songTitle, String artist, double duration) {
            this.tracklist.add(new Song(songTitle, artist, duration));
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
