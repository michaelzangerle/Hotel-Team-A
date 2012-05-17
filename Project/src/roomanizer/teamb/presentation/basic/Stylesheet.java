/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Michael
 */
public class Stylesheet {
    private static Color gridBG = new Color(0xF0, 0xF0, 0xFF);
    private static Color buttonBG = new Color(0x2F, 0x8C, 0xAB);
    private static Color buttonFG = new Color(0xFC, 0xF5, 0xEB);
    private static Color activeButtonBG = new Color(0xFE, 0x49, 0x02);
    private static Color background = new Color(0xC9, 0xE2, 0xE9);
    private static Font standard = new Font("Verdana", Font.PLAIN, 12);
    private static Font big = new Font("Verdana", Font.PLAIN, 17);
    private static Font headline = new Font("Verdana", Font.BOLD, 16);
    
    /**
     * 
     * @return
     */
    public static Color getActiveButtonBG() {
        return activeButtonBG;
    }

    /**
     * 
     * @return
     */
    public static Color getBackground() {
        return background;
    }

    /**
     * 
     * @return
     */
    public static Color getButtonBG() {
        return buttonBG;
    }

    /**
     * 
     * @return
     */
    public static Color getButtonFG() {
        return buttonFG;
    }
    
    public static Color getGridBG(){
        return gridBG;
    }
        

    /**
     * 
     * @return
     */
    public static Font getStandard() {
        return standard;
    }

    /**
     * 
     * @return
     */
    public static Font getBig() {
        return big;
    }

    /**
     * 
     * @return
     */
    public static Font getHeadline() {
        return headline;
    }
    
    
}
