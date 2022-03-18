/**
 * Student ID: 21308128
 * Name: Milan Kovacs
 * JDK: 17.0.1
 */

// IMPORTANT NOTE: Please turn on 'Unlimited Buffering' in the BlueJ Terminal Options

public class ImageDriver {
    public static void main(String[] args) {

        // Declare variables
        Image myPicture;
        Image selfie;
        int[][] mySelfie;
        String originalImage;
        String imageAfterOperation;
        String expectedResult;
        Image selfieCopy;
        double potentialScore = 0.0;
        Image converter;

        /** TEST ONE: **/
        myPicture = createImage(7,5);
        // Java automatically calls .toString method when an object is passed.
        System.out.println("Test 1: The original image ( 7 x 5 ): \n" + myPicture);

        // We will rotate it once clockwise
        myPicture.rotate(true);
        System.out.println("After once in the clockwise direction: \n" + myPicture);

        // We will do it again:
        myPicture.rotate(true);
        System.out.println("After another clockwise turn: \n" + myPicture);




        /*** TEST TWO ***/
        // We will test flips + 2 times rotating
        mySelfie = new int[][]{
                {0, 10, 20, 30, 40, 50},
                {1, 11, 21, 31, 41, 51},
                {2, 12, 22, 32, 42, 52},
                {3, 13, 23, 33, 43, 53},
                {4, 14, 24, 34, 44, 54},
                {5, 15, 25, 35, 45, 55}
        };
        // Create the image instance for the test
        selfie = new Image(mySelfie);
        // We will make a copy of it, stored in a different location
        int[][] mySelfieCopy = my2dArrayCopy(mySelfie);
        selfieCopy = new Image(mySelfieCopy);

        System.out.println("Test 2: We have two copies of the same array (First copy):");
        System.out.println("Source: " + mySelfie + " and the first element refence: " + mySelfie[0] + "\n" + selfie);
        System.out.println("We have two copies of the same array (Second copy):");
        System.out.println("Source: " + mySelfieCopy + " and the first element refence: " + mySelfieCopy[0] + "\n" + selfieCopy);
        // Horizontal Flip
        selfie.flip(true);

        System.out.println("After one horizontal flip (1st copy): \n" + selfie);
        // Vertical Flip
        selfie.flip(false);
        System.out.println("After one vertical flip (1st copy):\n" + selfie);

        System.out.println("Here is the 2nd copy:\n" + selfieCopy);
        // Anti-clockwise rotation
        selfieCopy.rotate(false);
        System.out.println("Now we will rotate the 2nd copy anti-clockwise: \n"+selfieCopy);
        // We rotate it anti-clockwise again
        selfieCopy.rotate(false);
        System.out.println("After a second anti-clockwise rotation (on the 2nd copy): \n" + selfieCopy);
        System.out.println("The two should appear identical (1st and 2nd): \n" + selfieCopy + "\n" + selfie);



        /*** TEST THREE ***/
        // Lets try some smaller/thinner arrays:
        Image myPixelatedImage = createImage(3, 8);

        System.out.println("Test 3: Here is an image, filled with increasing numbers, with odd number of width: \n" + myPixelatedImage);
        // Clockwise rotation
        myPixelatedImage.rotate(true);
        System.out.println("We have rotated it clockwise: \n" + myPixelatedImage);
        // Vertical Rotation
        myPixelatedImage.flip(false);
        System.out.println("We have flipped it vertically: \n" + myPixelatedImage);
        // Clockwise Rotation
        myPixelatedImage.rotate(true);
        System.out.println("We have rotated it clockwise: \n" + myPixelatedImage);
        // Horizontal Flip
        myPixelatedImage.flip(true);
        System.out.println("We have flipped it horizontally: \n" + myPixelatedImage);

        // Test 3.5
        myPixelatedImage = createImage(1,10);
        System.out.println("Here is a 1 pixel thick picture: \n" + myPixelatedImage);
        // Anti-clockwise: Now it should appear as "1d array" but it is really 2d containing 1 element.
        myPixelatedImage.rotate(false);
        System.out.println("Anti-Clockwise rotation:\n" + myPixelatedImage);
        // Now it should appear vertical again
        myPixelatedImage.rotate(false);
        System.out.println("Anti-clockwise rotation:\n" + myPixelatedImage);
        // Vertical Flip
        myPixelatedImage.flip(false);
        System.out.println("Vertical Flip:\n" + myPixelatedImage);
        // Horizontal flip
        myPixelatedImage.flip(true);
        System.out.println("Horizontal flip (it should stay the same):\n" + myPixelatedImage);


        System.out.println("The following are based on your Sample Driver Class:");
        // Test 4.
        // Test the flip horizontal feature.
        // Original Image
        int[][] theSelfie = {
                {0, 10, 20, 30, 40, 50},
                {1, 11, 21, 31, 41, 51},
                {2, 12, 22, 32, 42, 52},
                {3, 13, 23, 33, 43, 53},
                {4, 14, 24, 34, 44, 54},
                {5, 15, 25, 35, 45, 55}    };
        // Create the image instance for the test
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();
        // Use the flip horizontal operation method
        selfie.flip(true);
        imageAfterOperation = selfie.toString();

        // What the image should look like AFTER Flip Horizontal operation
        int[][] theResult =  { {50, 40, 30, 20, 10, 0},
                {51, 41, 31, 21, 11, 1},
                {52, 42, 32, 22, 12, 2},
                {53, 43, 33, 23, 13, 3},
                {54, 44, 34, 24, 14, 4},
                {55, 45, 35, 25, 15, 5}    };

        converter = new Image(theResult);
        expectedResult = converter.toString();

        // Report the results
        System.out.println("Test 4: 'flip Horizontal'") ;
        System.out.println("'==============='") ;
        System.out.println("Original Image        :\n" + originalImage);
        System.out.println("Image After Operation :\n" + imageAfterOperation);
        System.out.println("Expected Result       :\n" + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("4.5 marks -> 'flip Horizontal' works.\n") ;
            potentialScore = potentialScore + 4.5;
        }

        // Test 5.
        // Test the flip vertical feature.
        // Original Image
        // Create image instance for test
        theSelfie = new int[][] { { 0,  1,  2,  3,  4,  5,  6},
                {10, 11, 12, 13, 14, 15, 16},
                {20, 21, 22, 23, 24, 25, 26},
                {30, 31, 32, 33, 34, 35, 36},
                {40, 41, 42, 43, 44, 45, 46},
                {50, 51, 52, 53, 54, 55, 56}    };
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();

        // Use the flip vertical operation method
        selfie.flip(false);
        imageAfterOperation = selfie.toString();

        // What the image should look like AFTER Flip Vertical operation
        theResult = new int[][] { {50, 51, 52, 53, 54, 55, 56},
                {40, 41, 42, 43, 44, 45, 46},
                {30, 31, 32, 33, 34, 35, 36},
                {20, 21, 22, 23, 24, 25, 26},
                {10, 11, 12, 13, 14, 15, 16},
                { 0,  1,  2,  3,  4,  5,  6}    };
        converter = new Image(theResult);
        expectedResult = converter.toString();
        // Report the results
        System.out.println("Test 5: 'flip Vertical'") ;
        System.out.println("'============='") ;
        System.out.println("Original Image        :\n" + originalImage);
        System.out.println("Image After Operation :\n" + imageAfterOperation);
        System.out.println("Expected Result       :\n" + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("4.5 marks -> 'flip Vertical' works.\n") ;
            potentialScore = potentialScore + 4.5;
        }


        // Test 6.
        // Test the Rotate Clockwise feature.
        // Original Image
        theSelfie  = new int[][] { { 0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}    };
        // Create image instance for test
        selfie = new Image(theSelfie);
        originalImage = selfie.toString();

        // Use the Rotate Clockwise operation
        selfie.rotate(true);
        imageAfterOperation  = selfie.toString();

        // What the image should look like AFTER Rotate Clockwise operation
        theResult = new int[][] { {50, 40, 30, 20, 10, 0},
                {51, 41, 31, 21, 11, 1},
                {52, 42, 32, 22, 12, 2},
                {53, 43, 33, 23, 13, 3},
                {54, 44, 34, 24, 14, 4},
                {55, 45, 35, 25, 15, 5},
                {56, 46, 36, 26, 16, 6},
                {57, 47, 37, 27, 17, 7},
                {58, 48, 38, 28, 18, 8},
                {59, 49, 39, 29, 19, 9}    };
        converter = new Image(theResult);
        expectedResult = converter.toString();

        System.out.println("Test 6: 'rotate Clockwise'") ;
        System.out.println("'================'") ;
        System.out.println("Original Image        :\n" + originalImage);
        System.out.println("Image After Operation :\n" + imageAfterOperation);
        System.out.println("Expected Result       :\n" + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("6.5 marks -> 'rotate Clockwise' works.\n") ;
            potentialScore = potentialScore + 6.5;
        }

        // Test 7.
        // Test the rotate Anti-Clockwise feature.
        // Original Image
        theSelfie  = new int[][] { { 0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}    };

        // Create image instance for test
        selfie = new Image(theSelfie);

        // Use the Rotate Anti-Clockwise operation
        selfie.rotate(false);
        imageAfterOperation  = selfie.toString();

        // What the image should look like AFTER Rotate Anti-Clockwise operation
        theResult = new int[][] { {9, 19, 29, 39, 49, 59},
                {8, 18, 28, 38, 48, 58},
                {7, 17, 27, 37, 47, 57},
                {6, 16, 26, 36, 46, 56},
                {5, 15, 25, 35, 45, 55},
                {4, 14, 24, 34, 44, 54},
                {3, 13, 23, 33, 43, 53},
                {2, 12, 22, 32, 42, 52},
                {1, 11, 21, 31, 41, 51},
                {0, 10, 20, 30, 40, 50}    };
        converter = new Image(theResult);
        expectedResult = converter.toString();

        System.out.println("'rotate Anti-Clockwise'") ;
        System.out.println("'====================='") ;
        System.out.println("Original Image        :\n" + originalImage);
        System.out.println("Image After Operation :\n" + imageAfterOperation);
        System.out.println("Expected Result       :\n" + expectedResult);
        if(expectedResult.compareTo(imageAfterOperation) == 0) {
            System.out.println("6.5 marks -> 'rotate Anti-Clockwise' works.\n") ;
            potentialScore = potentialScore + 6.5;
        }

        System.out.printf("Potential Score (not including marks for testing ) is %4.1f out of 22.0\n", potentialScore);

    }

     /******************************************************************************************
     * Here is additional methods to create an array of desired size (or random if you prefer) *
     ******************************************************************************************/
    // Creates an Image instance with random width (5 - 100) and height (5 - 100)
    public static Image createImage(){
        int width = (int) (Math.random() * 96 + 5);
        int height = (int) (Math.random() * 96 + 5);
        int filler = 0;
        int[][] size = new int[height][width];
        for(int i = 0; i < size.length; i++){
            for(int j = 0; j < size[0].length; j++){
                size[i][j] = filler;
                filler++;
            }
        }
        return new Image(size);
    }
    // Creates an Image instance with desired width and height
    public static Image createImage( int width, int height){
        int[][] size = new int[height][width];
        int filler = 0;
        for(int i = 0; i < size.length; i++){
            for(int j = 0; j < size[0].length; j++){
                size[i][j] = filler;
                filler++;
            }
        }
        return new Image(size);
    }
    // Copies the Array passed in the parameter
    public static int[][] my2dArrayCopy(int[][] arrayToCopy){
        int[][] copyToReturn = new int[arrayToCopy.length][arrayToCopy[0].length];

        for(int i = 0; i < arrayToCopy.length; i++){
            System.arraycopy(arrayToCopy[i], 0, copyToReturn[i], 0, copyToReturn[i].length);
        }
        return copyToReturn;
    }

    /**
     public static String stringDisplay(int[][] array){
     String valueHolder = "";
     for(int[] i: array){
     valueHolder = valueHolder + Arrays.toString(i) + "\n";
     }
     return valueHolder;
     }
     */
}