/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;
import edu.princeton.cs.introcs.*;
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
        
        int red;
        int green;
        int blue;
        
        int sum;
        
        Scanner scan = new Scanner(stateName);
        scan.nextLine();
        scan.nextLine();
        numCounties = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        
        for(int x = 0; x < numCounties; x++){
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            numPoints = scan.nextInt();
            scan.nextLine();
            
            pointAryX = new double[numPoints];
            pointAryY = new double[numPoints];
            
            for(int i = 0; i < numPoints; i++){
                pointAryX[i] = ((scan.nextDouble() + 124.731216)/ 1000);
                pointAryY[i] = ((scan.nextDouble() - 24.544102)/ 1000);
            }
            //255
            scan.nextLine();
            System.out.print("new line = ");
            System.out.println(scan.next());
            
            /*scan.next();
            red=scan.nextInt();
            scan.next();
            blue=scan.nextInt();
            scan.next();
            green=scan.nextInt();
            scan.nextLine();
            
            sum = red+blue+green;
            StdDraw.setPenColor((red/sum), (green/sum), (blue/sum));
            */
        }
        
    }
}
