/*
 * Political Map Project
 * Name: Sid Chiang
 * Block: 6
 * 
 * Class Purpose: This class holds the methods to collect the USA data, interpret it, 
scale it, and then plot it out onto the canvas. It scans through the coords and dislplays the
states as well as the counties of the US. The class also scales the coords so that it 
fits optimally onto the canvas. This class also reads through the poll data for the 
election years and uses a formula to convert it into rgb valuse. The rgb values are
then colored onto the counties to represent the domanint political party through the 
intensity of one color over the other. 
 *
 */
package map;
import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
/**
 *
 * @author hcps-davidsoqs
 */

public class StateDraw {
        //global variables for the color of the states
        public static double red = 0.0;
        public static double green = 0.0;
        public static double blue = 0.0;

    public static void drawState(File stateName, File year, boolean scale) throws Exception{
        StdDraw.show(0); //makes the drawing appear state by state so the whole image loads faster
        int numCounties;
        int numPoints;
        //double arrays that hold the coords for the map
        double[] pointAryX;
        double[] pointAryY;
        
        double sum = 0.0;
        
        Scanner scan = new Scanner(stateName); //instantiating a new scanner
        Scanner pollScan = new Scanner(year); //instantiating a new scanner
        scan.nextLine(); //reading through the data
        scan.nextLine();
        numCounties = scan.nextInt();
        String lastCounty = "";
        StdDraw.setPenColor(Color.blue);

        //loop to scan through the data for the states
        for(int x = 0; x < numCounties; x++){ //start of for loop
            scan.nextLine();
            scan.nextLine();
            String nextCounty = scan.nextLine();
            scan.nextLine();
            numPoints = scan.nextInt();
            scan.nextLine();
            
            pointAryX = new double[numPoints];
            pointAryY = new double[numPoints];
            
            double xshift = 0;
            double yshift = 0;
            if(scale==true){
                
                for (int i = 0; i < numPoints; i++) { //start of for loop
                    double xcoord = scan.nextDouble();
                    double ycoord = scan.nextDouble();
                    if(i==0){
                        xshift = xcoord-.5; //shift to diplay in middle
                        yshift = ycoord-.5; //same
                    }
                    
                    pointAryX[i] = (((xcoord + 124.731216) / 60) + .03) - xshift;
                    pointAryY[i] = (((ycoord - 24.544102) / 30) + .03) - yshift;
                } //end of for loop
            }else{
                for (int i = 0; i < numPoints; i++) { //start of for loop
                    pointAryX[i] = (((scan.nextDouble() + 124.731216) / 60) + .03);
                    pointAryY[i] = (((scan.nextDouble() - 24.544102) / 30) + .03);
                } //end of for loop
            }
            if(!nextCounty.equals(lastCounty)){
                pollScan.nextLine();
                String poll = pollScan.next();
                while(poll.length() < 10){ //start of while loop
                    poll = pollScan.next();
                } //end of while loop
                poll = poll.replaceAll(",", " "); // replaces all the commas in the data to a space so that the scanner can read through them
                

                Scanner stringScan = new Scanner(poll); //instantiating a new scanner
                stringScan.next();
                //giving poll data to the variables
                red = stringScan.nextInt();
                blue = stringScan.nextInt();
                green = stringScan.nextInt();
                //making a sum for the purple america formula
                sum = red + blue + green;
                lastCounty = nextCounty;
            }
            //methods to draw the states, counties, and color the mape in
            StdDraw.setPenColor((int)(((red/sum) * 100) + 40), (int)(((green/sum) * 100) + 40), (int)(((blue/sum) * 100)) + 40); 
            StdDraw.filledPolygon(pointAryX, pointAryY);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.polygon(pointAryX, pointAryY);
         
            
            
        } //end of for loop
        StdDraw.show(0); //makes the drawing appear state by state so the whole image loads faster
    }
}
