/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 *
 * @author Tomas.Hornak
 */
public class AntiDiatritic {
    
//    private static List<String> fileList = new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    /** Runs a sample program that shows dropped files */
    public static void main( String[] args ) {
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } catch(Exception e){  }
        
        EventQueue.invokeLater(()-> new MainView().setVisible(true));
        
//        new MainView().setVisible(true);
    }   // end main
    
    
   
}