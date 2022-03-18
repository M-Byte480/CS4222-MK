
public class Track implements Comparable<Track> {
    // Instance variables
    private String artist;
    private String title;
    private int year;
    private int duration;

    // 1st constructor
    public Track(String title, String artist) {
        this(title,artist,0,0);
    }

    // 2nd constructor
    public Track(String title, String artist,int year) {
        this(artist,title,year,0);
    }

    // 3nd constructor
    public Track(String title, String artist, int year, int duration) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public String toString() {
        // Getting seconds in minutes and seconds
        int minutes;
        int seconds;
        minutes = duration / 60;
        seconds = duration % 60;
        return String.format("<%S><%s><%4d><%02d:%02d>",this.title,this.artist,this.year,minutes,seconds);
    }

    public int compareTo(Track other) {
        return this.title.compareTo(other.title);
    }
}