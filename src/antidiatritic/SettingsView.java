/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tomas.Hornak
 */
public class SettingsView extends JFrame{
    
    private static SettingsView instance;
    private static Tools tool;
    private static List<JCheckBox> symbolCheckBoxes;
    
    private static JPanel boxPanel;
    
    private SettingsView() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        boxPanel = new JPanel();
        
    }
}
