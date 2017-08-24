/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Tomas.Hornak
 */
public class MainView extends JFrame {
    
//    private static final MainView INSTANCE;
    private List<File> filesList = new ArrayList<File>();
//    private FileDrop droppedFiles;
    private static Tools tool = new Tools();
    
    private JPanel inputPanel;
    private JTextArea inputTextArea;
    
    private JPanel actionPanel;
    private JButton okButton;
    private JButton clearButton;
    private JCheckBox overwriteCheckBox;

    public MainView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
//        tool = new Tools();
        //setBounds( 100, 100, 300, 400 );
        
        // Input Panel
        inputPanel = new JPanel();
        inputTextArea = new JTextArea(5, 20);
        inputTextArea.setEditable(false);
        inputPanel.add(inputTextArea);
        
        // Action Panel
        actionPanel = new JPanel(new FlowLayout());
        // okButton
        okButton = new JButton("Remove diacritics");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processFiles();
            }
        });
        // clearButton
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });
        // Overwrite checkBox
        overwriteCheckBox = new JCheckBox("Overwrite ", false);
        actionPanel.add(okButton);
        actionPanel.add(clearButton);
        actionPanel.add(overwriteCheckBox);
        
        // Settings area
        

        new FileDrop(System.out, inputTextArea, new FileDrop.Listener() {
            @Override
            public void filesDropped(File[] files) {
                for(int i = 0; i < files.length; i++) {
                    filesList.add(files[i]);
                }
                inputTextArea.setText("");
                writeReadyFiles();
            }
        });
        
        add(inputPanel);
        add(actionPanel);
        
//        FileDrop fd;
        
        pack();
        setTitle("AntiDiacritic");
//        setVisible(true);
    };
    
//    public static MainView getInstance() {
////        if(INSTANCE == null) {
////            INSTANCE = new MainView();
////        }
//        return INSTANCE;
//    }
    
    public void processFiles() {
        
        inputTextArea.setText("");
        File newFile;
        for(File file : filesList) {
            newFile = tool.removeDiacritic(file, overwriteCheckBox.isSelected());
            inputTextArea.append("==> " + file.getName() + " processed.\n");
        }
        filesList.clear();
    }
    
    public void clearAll() {
        filesList.clear();
        inputTextArea.setText("");
    }
    
    public void writeReadyFiles() {
        for(File file : filesList) {
            inputTextArea.append(file.getName() + " is ready.\n");
        }
    }
    
    
}
