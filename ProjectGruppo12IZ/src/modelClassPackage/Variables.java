/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a class containing a Map as attribute, in order to contain variables 
 * as keys and associated complex Number as values.
 * @author Cami
 */
public class Variables {
    private final Map<String,ComplexNumber> myVariables;
    
    /**
    * It inizialize the attribute myVariables, as an HashMap with
    * String as Keys and ComplexNumber as Values.
    * <p> <!-- -->
    * @see ComplexNumber
    */   
    public Variables(){
        this.myVariables = new HashMap<>();
    }

    /**
    * It returns the attribute myVariables
    * <p> <!-- -->
    * @return myVariable the map attribute, containing couples Key-Value
    * @see ComplexNumber
    */ 
    public Map<String, ComplexNumber> getMyVariables() {
        return myVariables;
    }
    
    /**
    * It returns the attribute myVariables
    * <p> <!-- -->
    * @return a string definition for the current object
    * 
    */ 
    @Override
    public String toString() {
        return "Variables{" + "myVariables=" + myVariables + '}';
    }
    
    
}