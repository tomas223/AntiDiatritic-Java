/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antidiatritic;

import java.util.Objects;

/**
 *
 * @author Tomas.Hornak
 */
public class SymbolChangeEntity {
    
    private boolean activeFlag;
    
    private String key;
    
    private String value;
    
    public SymbolChangeEntity(String key, String value, boolean activeFlag) {
        this.key = key;
        this.value = value;
        this.activeFlag = activeFlag;
    }
    
    public SymbolChangeEntity(String key, String value) {
        this(key, value, true);
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public boolean isActive() {
        return activeFlag;
    }

    public void setActive(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * (result + getKey().hashCode());
        result = 31 * (result + getValue().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SymbolChangeEntity other = (SymbolChangeEntity) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Symbol. Old: " + key + ". New: " + value
                + ". Active: " + (activeFlag ? "true" : "false");
    }
}
