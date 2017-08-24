/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
/**
 *
 * @author Tomas.Hornak
 */
public class Tools {
    
//    private final Map<String, String> symbolMap;
    private final Set<SymbolChangeEntity> symbols;
    
    public Tools() {
        this(SymbolChangeMap.getSymbolMap());
    }
        
    public Tools(Map<String,String> symbolMap) {
        symbols = new HashSet<>();
        for(Map.Entry<String,String> entry : symbolMap.entrySet()) {
            symbols.add(new SymbolChangeEntity(entry.getKey(), entry.getValue()));
        }
        
        toUpperCase();
    }
    
    
//    
//    public Tools(BufferedReader bfr) throws IOException {
//        this.symbols = new HashMap<>();
//        String line;
//        while ((line = bfr.readLine()) != null) {
////            System.out.println(line);
//            String key = line.split(" ")[0];
//            String val = line.split(" ")[1];
//            symbols.put(key, val);
//        }
//        
//        toUpperCase();
//    }
    
    // TODO: move to symbolMap
    private void toUpperCase() {
        Set<SymbolChangeEntity> newUpperSymbols = new HashSet<>();
        for(SymbolChangeEntity entity : symbols) {
            String newKey = entity.getKey().toUpperCase();
            String newValue = entity.getValue().toUpperCase();
            newUpperSymbols.add(new SymbolChangeEntity(newKey, newValue));
        }
        symbols.addAll(newUpperSymbols);
    }
    
//    public Set<SymbolChangeEntity> getSymbolSet() {
//        return symbols;
//    }
    // Replace characters
    public String removeDiacritic(String oldString) {
//        String newString = oldString.replace('a', 'x');
//        symbolMap.toString;
        String newString = oldString;
        for(SymbolChangeEntity entity : symbols) {
            if(entity.isActive()) {
                newString = newString.replace(entity.getKey(), entity.getValue());
            }
        }
        
        return newString;
    }
    
    public File removeDiacritic(File oldFile, boolean overwrite) {
        InputStreamReader isr;// new InputStreamReader(is, "UTF-8");
        BufferedReader br = null;
        
        OutputStreamWriter osw;
        BufferedWriter bw = null;
        File newFile = null;
        
        try {
            newFile = new File(oldFile.getCanonicalPath() + ".noDiac");
            
            isr = new InputStreamReader(new FileInputStream(oldFile), "windows-1250");
            br = new BufferedReader(isr);
            System.out.println(oldFile.getCanonicalPath() + " opened.");
            
            osw = new OutputStreamWriter(new FileOutputStream(newFile), "windows-1250");
            bw = new BufferedWriter(osw);
            
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                bw.write(removeDiacritic(currentLine));
                bw.newLine();
            }
            System.out.println(oldFile.getCanonicalPath() + " converted OK.");
            
            if(br != null)
                br.close();
            if(bw != null)
                bw.close();
            
            if(overwrite) {
                String originalName = oldFile.getCanonicalPath();
                oldFile.delete();
                newFile.renameTo(new File(originalName));
            }
            
        } catch(IOException ioe) {
            ioe.printStackTrace();
            // osetrit vynimku
        } finally {
            try {
                if(br != null)
                    br.close();
                if(bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return newFile;
    }
}
