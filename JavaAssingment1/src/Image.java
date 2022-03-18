import java.util.Arrays;

/**
 * Student ID: 21308128
 * Name: Milan Kovacs
 * JDK: 17.0.1
 */



// Create Image class
public class Image {
    // Declare instance variables for objects
    private int[][] pixels;
    private int width, height;
    private boolean testing;

    // Constructor
    public Image(int[][] pixels){
        this.testing = true;
        this.pixels = pixels;
        this.height = pixels.length;   // Nom. of Rows
        this.width = pixels[0].length; // Nom. of Columns
                                       // Easier for me to think in rows and columns rather than width and height.
    }
/**************    Methods:      ***************/

//    toString method:
    /**
     * This method converts the Array to string version
     * it only takes 2-Dimensional Array objects.
     */

    public String toString() {
        // Variable declarations
        int stringSpecifier;
        String temp;


        stringSpecifier = largestNum(pixels); // Find the largest value and have the number of digits white space in the formatting

        if(this.testing){
            temp = "";
            for (int[] i : pixels) {
                temp = temp + " ["; // Adds line seperator
                for (int j : i) {
                    // Concatenate the previous lines with space fillers (stringFormatter)
                    temp = temp + String.format("%" + stringSpecifier + "d", j) + ", ";
                }
                temp = temp + "]\n";
            }
            temp = temp.replace(", ]","]"); // Removes ',' at the end of each line
            temp = temp.substring(0, temp.length()-1) + "]\n"; // Adds ']' at the very end, before the \n
            temp = temp.replaceFirst(" ","["); // Adds '[' to the front
        }else{
            // Creates a line on top of the box, equivalent to the length of the width, the separator lines and the white spaces
            temp = "_" + "_".repeat((stringSpecifier + 1) * (pixels[0].length)) + "\n";

            // Iterate through the 2D arrays and start filling out the table constructor
            for (int[] i : pixels) {
                temp = temp + "│"; // Adds line seperator
                for (int j : i) {
                    temp = temp + String.format("%" + stringSpecifier + "d", j) + "│"; // Concatenate the previous lines with space fillers (stringFormatter)
                }
                temp = temp + "\n";
            }

            // Bottom row
            temp = temp + "‾".repeat((stringSpecifier + 1) * (pixels[0].length) + 1) + "\n";
        }
        return temp;
    }

    // Method to find the largest number
    public int largestNum(int[][] array){
        int max = array[0][0]; // We assume the largest is the first
        int digits = 0; // Counts the digits in the largest number

        for(int[] i:array){
            for(int j:i){
                if(j > max){
                    max = j;
                }
            }
        }

        // Digits counter
        while(max > 0){
            max = (int) (max / 10);
            digits++;
        }

        return digits;
    }

//    Flip Method:
    /**
     * It takes a boolean argument and it will determine if you want to flip the
     * table; Horizontally or Vertically.
     *
     * Solution Method: swap each element using a temporary variable
     */
    public void flip(boolean horizontal){

        // Branch out if the user is passing an empty picture
        if(this.width == 0 || this.height == 0){
            return;
        }

        // Variable declaration.
        int width = this.width; // Row.length
        int height = this.height; // array.length
        int originalHeight = height; // Store the value of height as a constant
        int originalWidth = width; // Store the value of width as a constant
        int row , column , temp;
        int[] arrayTemp;

        // The integer division is important, as it also handles uneven number of rows
        // We only have to do each swapping half the number of lines,
        // Because we swap two at the same time.
        if(horizontal){
            width = width / 2;
        }else {
            height = height / 2;
        }

        // Iterate through the 2D Array
        for(row = 0; row < height; row++) {
            for(column = 0; column < width; column++) {
                // Test what we are required to do:
                if(horizontal) {
                    // If you want to flip horizontally,
                    // it will store the variable, temporarily, replace the original with the far element in the row
                    // and replace the far element with the temp
                    // We are working from left to right and right to left, then down a row.
                    temp = this.pixels[row][column];
                    this.pixels[row][column] = this.pixels[row][originalWidth - (column + 1)];
                    this.pixels[row][originalWidth - (column + 1)] = temp;
                }else if(!horizontal && column == 0){ // Condition makes sure to run only once for each Row.
                    // This time, we are swapping rows, so we are
                    // storing the upper row and replace it with the bottom row.
                    // We are working our way down from the top and up from the bottom
                    arrayTemp = pixels[row];
                    this.pixels[row] = this.pixels[originalHeight - (row+1)];
                    this.pixels[originalHeight - (1+row)] = arrayTemp;
                }

            }
        }
    }

// Rotate Method:
    public void rotate(boolean clockwise){

        if(this.width == 0 || this.height == 0){
            return; // Branch out if the user is passing an empty picture
        }

        // We have to handle the fact that we can have different width against height.
        // We will create a new array where we swap the width and the height and then rotate based on the parameter

        // Declare variables:
        int width = this.width; // No. of Columns
        int height = this.height; // No. of Rows
        int[][] picture = this.pixels; // I am changing the reference name

        int[][] newImage = new int[width][height]; // Empty 2D array, where the rows and the columns have we swapped
        int row, column, changeInHeight, changeInWidth;

        // Counters to keep of tracking decrementing the elements we are changing.
        changeInHeight = 0;
        changeInWidth = 0;

        // Iterate through the 2D array
        // The logic is the following: We will populate our new 2D array.
        // We will go from left to right, top to down. So we start at [0][0] -- > [0][Last]
        // If we are going 'clockwise' we will go to [last][0] and that will go to [0][0]
        // This means, everything in first column, will be in row-0.
        // We have to decrement the row number as we are going accross our rows.
        // And if we are going anti-clockwise, we are inserting last column into row-0.

        // TLDR: As columns increase, we have to decrease rows/columns and reset it back to 0 for each row.
        for (row = 0; row < width; row++){
            for (column = 0; column < height; column++){
                if(clockwise){
                    newImage[row][column] = picture[(height - 1 + changeInHeight)][row];
                }else{
                    newImage[row][column] = picture[column][width - 1 + changeInWidth];
                }
                changeInHeight--;
            }
            changeInWidth--;
            changeInHeight = 0;
        }

        // Change the attributes of our instance Object
        this.width = height;
        this.height = width;
        this.pixels = newImage;
    }

}