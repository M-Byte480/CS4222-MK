import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Playlist{

    private String name;
    private List<Track> playlist;


    // Two constructors:
    public Playlist(){
        this.name = "Untitled";
        this.playlist = new ArrayList<>();
    }
    public Playlist(String playListName){
        this.name = playListName;
        this.playlist = new ArrayList<>();
    }


    public String getName(){ // Get name of the playlist
        return this.name;
    }
    public void setName(String name){ // Change name of the playlist
        this.name = name;
    }


    // Converts to String value to do comparison
    public String toString(){
        StringBuilder trackPlaylist = new StringBuilder("Title: "  + this.name + "\n");
        for(Track i : playlist){
            trackPlaylist.append( i.toString() + "\n");
        }
        return trackPlaylist.toString();
    }

    // Add a Track where only the title and artist are known
    // The year and duration should be set to zero
    public void add(String title, String artist){
        this.playlist.add(new Track(title, artist));
    }

    // Add a Track where ALL of the data is known
    public void add(String title, String artist, int year, int duration){
        this.playlist.add(new Track(title, artist, year, duration));
    }

    // Add a previously created instance of the Track class
    public void add(Track t){
        this.playlist.add(t);
    }

    public boolean remove(String title) {
        boolean hasItBeenRemoved = false;
        title = title.toLowerCase();
        for (int j = 0; j < playlist.size(); j++) {
            Track compare = playlist.get(j);
            if ((compare.getTitle().toLowerCase()).equals(title)) {
                playlist.remove(j);
                hasItBeenRemoved = true;
                break;
            }
        }
        return hasItBeenRemoved;
    }

    //Show list
    public void showList(){
        if(this.playlist.size() == 0){
            System.out.println("The list is empty");
            return;
        }
        System.out.println(playlist.toString());
    }

    // Play everything, random or not?
    public void playAll(boolean random){
        if (!random){
            System.out.println(playlist.toString());
            return;
        }
        int size = playlist.size();
        List<Integer> randomisedPlay = new ArrayList<>(size);
        int i = 0;
        Integer randomValue;
        while( i != size ){
            randomValue = (int) (Math.random() * size);
            boolean contain = randomisedPlay.contains(randomValue);
            if(!contain) {
                randomisedPlay.add(randomValue);
                i++;
            }
        }
        System.out.println(randomisedPlay);

        for(i = 0; i < playlist.size(); i++){
            randomValue = randomisedPlay.get(i);
            System.out.println(playlist.get(randomValue));

        }
    }
    // Play all songs within the given year:
    public void playOnly(int year){
        List<Track> tracksYear = new ArrayList<>();
        for(Track i : playlist){
            if (i.getYear() == year) {
                tracksYear.add(i);
            }
        }
        if(tracksYear.size() != 0){
            System.out.println(tracksYear);
        }
    }
    // Play all songs by the following artist, not case-sensitive. Also if the artist is a word within the artists' name
    public void playOnly(String artist) {
        List<Integer> pointers = new ArrayList<>(0);
        for(Track i : playlist){
            if(containsName(artist, i)){
                pointers.add(playlist.indexOf(i));
            }
        }
        if(pointers.size() != 0){
            System.out.printf("Result to your search: \"%s\"\n" , artist);
            for(int i : pointers){
                System.out.println(playlist.get(i));
            }
        }
    }
    private boolean containsName(String word, Track track){
        String lowercaseName = track.getArtist().toLowerCase();
        word = word.toLowerCase();
        String[] temp = lowercaseName.split(word);
        return temp.length > 1;
    }


}
