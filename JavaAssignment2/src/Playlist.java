// Name: Milan Kovacs
// ID: 21308128

import java.util.ArrayList;
import java.util.List;

public class Playlist{
    // Initialize instances
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

    // Getters and Setters
    public String getName(){ // Get name of the playlist
        return this.name;
    }
    public void setName(String name){ // Change name of the playlist
        this.name = name;
    }


    // Converts to String value to do comparison
    public String toString(){
        // StringBuilder to ease string Addition/Concatenation/Append
        StringBuilder trackPlaylist = new StringBuilder("Title: "  + this.name + "\n");

        // For each track, add its name to a new line
        for(Track i : this.playlist){
            trackPlaylist.append( i.toString() + "\n");
        }
        return trackPlaylist.toString();
    }

    // Add a Track where only the title and artist are known

    // The year and duration should be set to zero
    public void add(String title, String artist){
        this.playlist.add(new Track(title, artist));
    }

    // Add a Track where All the data is known
    public void add(String title, String artist, int year, int duration){
        this.playlist.add(new Track(title, artist, year, duration));
    }

    // Add a previously created instance of the Track class
    public void add(Track t){
        this.playlist.add(t);
    }

    // Remove the first track where the argument matches partially in the title. We want to user to be specific if they want a specific track to be removed
    public boolean remove(String title) {
        // Assume it hasn't been removed
        boolean hasItBeenRemoved = false;
        title = title.toLowerCase(); // Set the argument to lowercase so we Standardize the comparison


        for (int j = 0; j < playlist.size(); j++) {
            Track compare = playlist.get(j);
//            if ((compare.getTitle().toLowerCase()).equals(title)) { // I used this line until I sent the email about exact comparison or partial
            // If it contains the passed name, do the following:
            if(containsName(title, compare, true)){ // My own containsName method
                playlist.remove(j); // Remove track
                hasItBeenRemoved = true; // Return True
                break; // Break upon first occurance
            }
        }
        return hasItBeenRemoved;
    }

    //Show list: Prints it out on your screen if it is not empty
    public void showList(){
        if(this.playlist.size() == 0){
            System.out.println("The list is empty");
        } else {
            System.out.println(this); // this object. I was having difficulties with the method because I kept passing this.playlist as argument and returned ArrayList.toString()
        }
    }

    // Play everything, random or not?
    public void playAll(boolean random){
        if (!random){ // Not random, just play it and break
            System.out.println(this);
            return;
        }

        // Store the size of the playlist
        int size = playlist.size();

        // Initialize an arrayList where each element points to a track in the original playlist
        List<Integer> randomisedPlay = new ArrayList<>(size);
        int i = 0;
        Integer randomValue;

        // While i doesn't match the size of the original playlist
        while( i != size ){
            // Random Number
            randomValue = (int) (Math.random() * size);
            // Check if the random track is already used
            boolean contain = randomisedPlay.contains(randomValue);
            // If it doesn't contain, add it, else repeat
            if(!contain) {
                randomisedPlay.add(randomValue);
                i++;
            }
        }

        // Prints out the shuffled sequence
        for(i = 0; i < playlist.size(); i++){
            randomValue = randomisedPlay.get(i); // Points to the track
            System.out.println(playlist.get(randomValue));

        }
    }

    // Play all songs within the given year:
    public void playOnly(int year){
        // Points to the positions in the original arrayList
        List<Integer> pointers = new ArrayList<>();

        // Check for each track check year
        for(Track i : playlist){
            if (i.getYear() == year) {
                pointers.add(playlist.indexOf(i));
            }
        }

        // If the pointers arraylist is not empty: do the following, otherwise do nothing
        if(pointers.size() != 0){
            System.out.printf("Result to your search: \"%d\"\n" , year);
            // for each pointer, play the correlating track
            for (int i = 0; i < pointers.size(); i++) {
                Track getTrack = this.playlist.get(pointers.get(i));
                System.out.println(getTrack);
            }
        }
    }


    // Play all songs by the following artist, not case-sensitive. Also if the artist is a word within the artists' name
    public void playOnly(String artist) {
        // Points to the positions in the original arrayList
        List<Integer> pointers = new ArrayList<>();

        // For each track, check if the artist's name contains the passed argument
        for(Track i : playlist){
            if(containsName(artist, i, false)){
                pointers.add(playlist.indexOf(i));
            }
        }

        // If there is some tracks to be played, play it
        if(pointers.size() != 0){
            System.out.printf("Result to your search: \"%s\"\n" , artist);
            for(int i : pointers){
                System.out.println(playlist.get(i));
            }
        }
    }

    // My own method:
    // Pass the word, the track and True for title and False for Artist to be compared
    // It will check if the word exists within the passed track's title or artist
    private boolean containsName(String word, Track track, boolean title){
        // Standardizing the name
        String lowercaseName;
        if(title) {
            lowercaseName = track.getTitle().toLowerCase();
        }else {
            lowercaseName = track.getArtist().toLowerCase();
        }
        // Standardizing the word
        word = word.toLowerCase();

        // We use the split method to check if it exists within the given name. If the size of the array is greater than 1, it exists
        // The -1 is passed for limit, so if the word is at the beginning or the end and there would be an empty element, it keeps it in the array
        String[] temp = lowercaseName.split(word, -1);
        return temp.length > 1;
    }

    // Sort method which is not required but I wanted to sort the playlist
    public void sort(){
        this.playlist.sort(Track::compareTo);
    }
}
