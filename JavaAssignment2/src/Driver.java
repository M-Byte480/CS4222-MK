// Name: Milan Kovacs
// ID: 21308128

public class Driver {
    public static void main(String[] args) {
        Playlist myFavouriteSongs = new Playlist("My Liked Songs");
        Track wakeUp = new Track("Test", "LiL YungMartimus", 2022, 420);
        Track myTrueLove = new Track("test", "LiL Bweyny", 2021, 9532);
        myFavouriteSongs.add(wakeUp);
        myFavouriteSongs.add(myTrueLove);

        // I have downloaded my Spotify data, and alternated
        // I have altered it to fit the specifications <title><artist><year><duration>
        myFavouriteSongs.add("Happy Days", "The CompSci Laeds", 2022, 500);
        myFavouriteSongs.add( "Black Catcher", "Vickeblanka", 2020, 7028 );
        myFavouriteSongs.add( "Dirndl Weed", "Sääftig", 2019, 9640 );
        myFavouriteSongs.add( "Determination", "Neku", 2019, 113269 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2020, 2250 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2019, 2250 );
        myFavouriteSongs.add( "Tokyovania - Undertronic Remix",  "SharaX",2020, 64899 );
        myFavouriteSongs.add( "Gas Gas Gas", "Alex Yarmak", 2020, 5669 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2019, 334193 );
        myFavouriteSongs.add("All Stars", "Smash Mouth");
       /**
        myFavouriteSongs.add( "End of the Universe", "Gooseworx", 2020, 35985 );
        myFavouriteSongs.add( "Roar of the Jungle Dragon",  "DM DOKURO",2020, 66891 );
        myFavouriteSongs.add( "Memed to Life", "Cyranek", 2018, 1163 );
        myFavouriteSongs.add( "Apropos - Remix", "SayMaxWell", 2020, 1034 );
        myFavouriteSongs.add( "Impostor", "SharaX", 2020, 168000 );
        myFavouriteSongs.add( "Wii Shop", "Neku", 2018, 15301 );
        myFavouriteSongs.add( "Your Contract Has Expired", "Pascal Michael Stiefel", 2020, 3867 );
        myFavouriteSongs.add( "Backstab", "Alex Yarmak", 2018, 2686 );
        myFavouriteSongs.add( "Blackhole Blitz", "Gooseworx", 2020, 1907 );
        */
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2018, 176248 );
        myFavouriteSongs.add( "I'm Blue - Undertronic Remix", "SharaX", 2020, 3927 );
        myFavouriteSongs.add( "Kitchen Without Gun    (Extended  )", "YouSeeKenny", 2020, 112093 );
        myFavouriteSongs.add( "Trip -innocent of D-", "Selphius", 2018, 89606 );
        myFavouriteSongs.add( "Determination", "Neku", 2020,  115862 );
        myFavouriteSongs.add( "To the Bone", "JT Music", 2006, 15509 );
        myFavouriteSongs.add( "Pharmacia_Tunes", "YungMartimus", 2020, 15509 );

        //** By removing one '/' you can easily comment and uncomment sections to test, just as this line.

        // Sort the playlist based on alphabetical order of title (compaterTo from Tracks)
        myFavouriteSongs.sort(); // You can comment this out to play it in order of adding it
        myFavouriteSongs.showList();
        //*/

        //** TEST 1: Remove a song
        // It should remove TEST by Yung Martimus
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("TEST"));
        myFavouriteSongs.showList();
        //*/

        //** TEST 2: remove another song
        // Should remove the other test by lil Bweny
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("test"));
        myFavouriteSongs.showList();
        //*/

        //** TEST 3: fails to remove due to not existing
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("test"));
        myFavouriteSongs.showList();
        //*/

        //** TEST 4: Fails to remove Tokyovania
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("Tockyovania"));
        myFavouriteSongs.showList();
        //*/

        //** TEST 5: Successfully removes Tokyovania and one of the Giant Enemy Spiders
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("vania"));
        System.out.println("Has the song been removed: " + myFavouriteSongs.remove("Giant"));
        myFavouriteSongs.showList();
        //*/

        //** TEST 6: Shuffle but doesn't alternate the original list
        System.out.println("Play NOT shuffled...");
        myFavouriteSongs.playAll(false);
        System.out.println("\n");
        System.out.println("Play shuffled...");
        myFavouriteSongs.playAll(true);
        System.out.println("\n");
        System.out.println("Play NOT shuffled (but notice the sequence)...");
        myFavouriteSongs.playAll(false);
        //*/



        //** TEST 8: Test the years
        myFavouriteSongs.playOnly(2006);
        System.out.println();
        myFavouriteSongs.playOnly(2019);
        System.out.println();
        //*/

        //** TEST 9: Test the artists
        myFavouriteSongs.playOnly("ae");
        System.out.println();
        myFavouriteSongs.playOnly("yarmak");
        System.out.println();
        myFavouriteSongs.playOnly("Academic"); // No result
        myFavouriteSongs.playOnly("x");
        System.out.println();
        myFavouriteSongs.playOnly("Yung");
        System.out.println();
        //*/

        //** Some details:
        System.out.println("You just listened to: " + myFavouriteSongs.getName());
        myFavouriteSongs.setName("Pharmacia_Playlist");
        System.out.println("The name has been updated to: " + myFavouriteSongs.getName());
        //*/
    }
}
