/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tomas.Hornak
 */
public interface SymbolChangeMapInterface {

    public Map<String, String> getSymbolMap();
    
    public Set<SymbolChangeEntity> getSymbolSet();
}
