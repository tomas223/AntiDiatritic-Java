/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;

/**
 *
 * @author Tomas.Hornak
 */
public class SymbolChangeMap /* implements SymbolChangeMapInterface */{
    
//    private static Set<SymbolChangeEntity> symbolMap; 
    
//    @Override
    public static Map<String, String> getSymbolMap() {
        Map<String, String> symbolMap = new HashMap<>();
        
        symbolMap.put("č", "c");
        symbolMap.put("ě", "e");
        symbolMap.put("ď", "d");
        symbolMap.put("ľ", "l");
        symbolMap.put("š", "s");
        symbolMap.put("ť", "t");
        symbolMap.put("ň", "n");
        symbolMap.put("ž", "z");
        symbolMap.put("ř", "r");
        
        return symbolMap;
    }

}
