/*
 * Political Map Project
 * Name: Sid Chiang
 * Block: 6
 * 
 * Program Purpose: This program reads coordinates that formulate the USA. The
coordinates are read and mapped out onto a canvas. The canvas displays the whole country
as well as all the states and county lines. The map is then colored in with a combination of 
red (republican), green (other), and blue (democrat) depending on what each county voted in 
majority for. The colors are blended to show the intensity of one party over the other. 
My extra feature is that the map is able to track mouse clicks. When the user clicks on
a state then it isolates that state and displays the name and poll data of the state.
 *
 * Algorithm: The program has to first read in the files with the data. The data is then
scanned and processed to be mapped out. The canvas for the points is created and the points
are scalled to fit the canvas. The poll data is then scanned and interpreted into rgb 
values through a formula given by the project website. Depending on what year the user inputs,
the canvas is displayed with different poll data from that years election. 
The alogrithm for the extra feature uses a hashmap to outline the states borders as well
as multi-threading to both run the map and keep in track of the mouse click. 
Andriy helped me figure out how to set up a hashmap as well as how to utilize multi-threading
to accomplish two tasks at the same time ie. rendering the map as well as looking gor clicks on
the canvas at the same time.
 * 
 * Future/possible improvements: To imporve on this project I could have organized the code to
flow easier in the case that changes should need to be made in the future. The map could be
optimized to render faster. The user friendliness of the program could be better as it is rugged 
at the moment.
 *
 */
package map;
import edu.princeton.cs.introcs.*;
import java.util.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author 
 */
public class PoliticalMap {
    public static int year;
    public static String[] stateNameAry; //holds the names of the states
    public static void main(String[] args) throws Exception{
        //makes the canvas on which the points will be mapped onto
        StdDraw.setCanvasSize(1300,600);
        //creates an array that holds the names of the states
        stateNameAry = new String[51];
        
        //elements of the array for the states of the US
        stateNameAry[0] = "AK";
        stateNameAry[1] = "AL";
        stateNameAry[2] = "AR";
        stateNameAry[3] = "AZ";
        stateNameAry[4] = "CA";
        stateNameAry[5] = "CO";
        stateNameAry[6] = "CT";
        stateNameAry[7] = "DC";
        stateNameAry[8] = "DE";
        stateNameAry[9] = "FL";
        stateNameAry[10] = "GA";
        stateNameAry[11] = "HI";
        stateNameAry[12] = "IA";
        stateNameAry[13] = "ID";
        stateNameAry[14] = "IL";
        stateNameAry[15] = "IN";
        stateNameAry[16] = "KS";
        stateNameAry[17] = "KY";
        stateNameAry[18] = "LA";
        stateNameAry[19] = "MA";
        stateNameAry[20] = "MD";
        stateNameAry[21] = "ME";
        stateNameAry[22] = "MI";
        stateNameAry[23] = "MN";
        stateNameAry[24] = "MO";
        stateNameAry[25] = "MS";
        stateNameAry[26] = "MT";
        stateNameAry[27] = "NC";
        stateNameAry[28] = "ND";
        stateNameAry[29] = "NE";
        stateNameAry[30] = "NH";
        stateNameAry[31] = "NJ";
        stateNameAry[32] = "NM";
        stateNameAry[33] = "NV";
        stateNameAry[34] = "NY";
        stateNameAry[35] = "OH";
        stateNameAry[36] = "OK";
        stateNameAry[37] = "OR";
        stateNameAry[38] = "PA";
        stateNameAry[39] = "RI";
        stateNameAry[40] = "SC";
        stateNameAry[41] = "SD";
        stateNameAry[42] = "TN";
        stateNameAry[43] = "TX";
        stateNameAry[44] = "UT";
        stateNameAry[45] = "VA";
        stateNameAry[46] = "VT";
        stateNameAry[47] = "WA";
        stateNameAry[48] = "WI";
        stateNameAry[49] = "WV";
        stateNameAry[50] = "WY";
        
        //instantiating the StateClickListener in the main class
        StateClickListener listener = new StateClickListener();
        //creates a scanner
        Scanner scan = new Scanner(System.in);
        boolean isCorrect = false;
        
        //loop to select what year the user would like to see the poll data for
        while(isCorrect == false){ //start of while loop
            isCorrect = true;
            System.out.print("Enter the year that you want to see the data for (1960 - 2012): ");
            year = scan.nextInt();
        } //end of while loop
        
        //loop to get the data from the files
        for(int i = 1; i < 51; i++){ //start of for loop
            if(!(i == 11)){
                StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + year + ".txt").toURI()), false); 
            }
        }// end of for loop
        listener.start(); //starts the listener 
    }
}
