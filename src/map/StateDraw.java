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
    public static void drawState(File stateName) throws Exception{
        int numCounties;
        
        Scanner scan = new Scanner(stateName);
        scan.nextLine();
        scan.nextLine();
        numCounties = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        
        System.out.print("new line = ");
        System.out.println(scan.nextLine());
    }
    
    public static void colorState(String stateName, int year){
        
    }
}
