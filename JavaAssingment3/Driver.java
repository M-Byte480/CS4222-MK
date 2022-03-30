public class Driver {
    public static void main(String[] args) {
       //String path = args[0];
        //int shortest = Integer.parseInt(args[1]);
        //int longest = Integer.parseInt(args[2]);

        Dictionary myDict = new Dictionary("C:\\Programming\\Java\\JavaAssignment3\\src\\WORDS.csv", 0, 0);
        //Dictionary myDict = new Dictionary(path, shortest, longest);

        System.out.println("Here is the list of word that you requested in Alphabetical grouping: ");
        System.out.println(myDict);
        System.out.println();
        System.out.println("Here is the list of words in a String Array format");
        System.out.println(myDict.getWords());
//*/
//**
        System.out.println(myDict);
        String[] listOfWords = "this, that, other, my, new, dog, pet, quince, raspberry, turkey, kerchief, you, your, proud, prawn, crawl, orange, apple, zebra, zoo, yogurt, nasty, sixty, nine, prom, quack, duck, monkey, rabbit, orange, more, orange, hungry, pawn, shop , rubber, roar, ribbit, robot, rackat, rocket, Doctor, Milan, Mulan, My, your, our, south, west, east, north, quake, sponge, bob, square,pants     , x-ray, xylophone, guitar, cello , lemon, violin, viola, vodka, tree, nuts, chestnut, lamp, shade, shadow, brown, green, purple, red, pink, blue, white, black, crane, water, aqua, steel, steal, metal, iron, gold, uranium, oxygen".split(",");
        for(String word : listOfWords){
            myDict.add(word);
            System.out.println(myDict.getWords());
        }
    //*/
    }
}
