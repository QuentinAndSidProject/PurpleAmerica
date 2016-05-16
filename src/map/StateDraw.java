/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public static void drawState(File stateName, File year) throws Exception{
        int numCounties;
        int numPoints;
        double[] pointAryX;
        double[] pointAryY;
        
        double red = 0.0;
        double green = 0.0;
        double blue = 0.0;
        
        double sum = 0.0;
        
        Scanner scan = new Scanner(stateName);
        Scanner pollScan = new Scanner(year);
        scan.nextLine();
        scan.nextLine();
        numCounties = scan.nextInt();
        String lastCounty = "";
        
        for(int x = 0; x < numCounties; x++){
            scan.nextLine();
            scan.nextLine();
            String nextCounty = scan.nextLine();
            scan.nextLine();
            numPoints = scan.nextInt();
            scan.nextLine();
            
            pointAryX = new double[numPoints];
            pointAryY = new double[numPoints];
            
            for(int i = 0; i < numPoints; i++){
                pointAryX[i] = (((scan.nextDouble() + 124.731216)/ 60) + .03);
                pointAryY[i] = (((scan.nextDouble() - 24.544102)/ 30) + .03);
            }
            
            if(!nextCounty.equals(lastCounty)){
                pollScan.nextLine();
                String poll = pollScan.next();
                //System.out.println(poll);
                while(poll.length() < 10){
                    poll = pollScan.next();
                }
                poll = poll.replaceAll(",", " ");       


                Scanner stringScan = new Scanner(poll);
                stringScan.next();

                red = stringScan.nextInt();
                blue = stringScan.nextInt();
                green = stringScan.nextInt();

                sum = red + blue + green;
                lastCounty = nextCounty;
            }
            
            StdDraw.setPenColor((int)(((red/sum) * 100) + 40), (int)(((green/sum) * 100) + 40), (int)(((blue/sum) * 100)) + 40); 
            StdDraw.filledPolygon(pointAryX, pointAryY);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.polygon(pointAryX, pointAryY);
        }
    }
}
