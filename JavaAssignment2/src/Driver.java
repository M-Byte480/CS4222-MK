public class Driver {
    public static void main(String[] args) {
        Playlist myFavouriteSongs = new Playlist("My Liked Songs");
        Track wakeUp = new Track("Test", "LiL YoungMartimus", 2022, 420);
        Track myTrueLove = new Track("test", "LiL Bweyny", 2021, 9532);
        myFavouriteSongs.add("Happy Days", "The CompSci Laeds", 2022, 500);
        myFavouriteSongs.add(wakeUp);
        myFavouriteSongs.add(myTrueLove);
        myFavouriteSongs.add( "Black Catcher", "Vickeblanka", 2020, 7028 );
        myFavouriteSongs.add( "Dirndl Weed", "Sääftig", 2020, 9640 );
        myFavouriteSongs.add( "Determination", "Neku", 2020, 113269 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2020, 2250 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2020, 176248 );
        myFavouriteSongs.add( "Tokyovania - Undertronic Remix",  "SharaX",2020, 64899 );
        myFavouriteSongs.add( "Gas Gas Gas", "Alex Yarmak", 2020, 5669 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2020, 334193 );
        myFavouriteSongs.add( "End of the Universe", "Gooseworx", 2020, 35985 );
        myFavouriteSongs.add( "Roar of the Jungle Dragon",  "DM DOKURO",2020, 66891 );
        myFavouriteSongs.add( "Memed to Life", "Cyranek", 2020, 1163 );
        myFavouriteSongs.add( "Apropos - Remix", "SayMaxWell", 2020, 1034 );
        myFavouriteSongs.add( "Impostor", "SharaX", 2020, 168000 );
        myFavouriteSongs.add( "Wii Shop", "Neku", 2020, 15301 );
        myFavouriteSongs.add( "Your Contract Has Expired", "Pascal Michael Stiefel", 2020, 3867 );
        myFavouriteSongs.add( "Backstab", "Alex Yarmak", 2020, 2686 );
        myFavouriteSongs.add( "Blackhole Blitz", "Gooseworx", 2020, 1907 );
        myFavouriteSongs.add( "The Giant Enemy Spider", "Fluxoid", 2020, 176248 );
        myFavouriteSongs.add( "I'm Blue - Undertronic Remix", "SharaX", 2020, 3927 );
        myFavouriteSongs.add( "Kitchen Without Gun    (Extended  )", "YouSeeKenny", 2020, 112093 );
        myFavouriteSongs.add( "Trip -innocent of D-", "Selphius", 2020, 89606 );
        myFavouriteSongs.add( "Determination", "Neku", 2020,  115862 );
        myFavouriteSongs.add( "To the Bone", "JT Music", 2020, 15509 );



//        System.out.println(myFavouriteSongs);

//        System.out.println(myFavouriteSongs.remove("test"));
//        myFavouriteSongs.playOnly("lil");
//        System.out.println(myFavouriteSongs);
        myFavouriteSongs.playAll(true);
    }
}
