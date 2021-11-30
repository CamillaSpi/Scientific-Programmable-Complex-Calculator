/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gruppo 12 IZ
 */
public class VariablesTest {
    
    public VariablesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth equal to 0.
     */
    @Test
    public void testCheckRangeLowerLength() {
        System.out.println("checkRange with length less than one");
        String s = "";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth greater than one.
     */
    @Test
    public void testCheckRangeHigherLength() {
        System.out.println("checkRange with length greater than one");
        String s = "prova";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth greater than one.
     */
    @Test
    public void testCheckRangeCorrectLength() {
        System.out.println("checkRange with correct length");
        String s = "a";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length but out of range.
     */
    @Test
    public void testCheckRangeOut1() {
        System.out.println("checkRange with correct length");
        String s = "1";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length but out of range.
     */
    @Test
    public void testCheckRangeOut2() {
        System.out.println("checkRange with correct length");
        String s = "}";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length and in the correct range.
     */
    @Test
    public void testCheckRangeCorrect1() {
        System.out.println("checkRange with correct length");
        String s = "z";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length and in the correct range.
     */
    @Test
    public void testCheckRangeCorrect2() {
        System.out.println("checkRange with correct length");
        String s = "l";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Variables instance = new Variables();
        ComplexNumber a = new ComplexNumber("-3.5", "8.9");
        ComplexNumber b = new ComplexNumber("5.3", "-9.8");
        instance.saveToVariable("a", a);
        instance.saveToVariable("b", b);
        String expResult = "(a, " + a.toString() + "), (b, " + b.toString() + ")" ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }


    /**
     * Test of getValue method, of class Variables, analyzing the case with a key not contained in the Map.
     */
    @Test
    public void testGetValueNotContainedKey() {
        System.out.println("getValue with a not contained key");
        String key = "a";
        Variables instance = new Variables();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getValue(key);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getValue method, of class Variables, analyzing the case with a contained key in the Map.
     */
    @Test
    public void testGetValueContainedKey() {
        System.out.println("getValue with a contained key");
        String key = "a";
        Variables instance = new Variables();
        ComplexNumber value = new ComplexNumber("-4","3");
        instance.getMyVariables().put(key, value);
        ComplexNumber expResult = value;
        ComplexNumber result = instance.getValue(key);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of SaveToVariables method, of class Variables, with correct entry.
     */
    @Test
    public void testSaveToVariablesCorrectNumber() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        System.out.println(instance.toString());
        assertEquals(a, instance.getMyVariables().get("a"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with wrong null CompplexNumber as entry.
     */
    @Test
    public void testSaveToVariablesNullNumber() {
        System.out.println("insert a complex Number equal to null");
        ComplexNumber a = null;
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        assertEquals(null, instance.getMyVariables().get("a"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with wrong key as entry.
     */
    
    @Test
    public void testSaveToVariablesWrongKey() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("8", a);
        assertEquals(null, instance.getMyVariables().get("8"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with replace the value in a setted variable.
     */
    
    @Test
    public void testSaveToVariablesReplace() {
        System.out.println("setValue with the replacement of the value");
        String key = "b";
        ComplexNumber newValue = new ComplexNumber("-3.4", "0.9");
        ComplexNumber oldValue = new ComplexNumber("4.3", "-6.5");
        Variables instance = new Variables();
        instance.saveToVariable(key, oldValue);
        instance.saveToVariable(key, newValue);
        ComplexNumber retValue = instance.getMyVariables().get(key);
        assertEquals(retValue, newValue); 
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable correctly written and initialized.
     */
    @Test
    public void testSaveFromVariableCorrectVariable() {
        System.out.println("save from a variable correctly written and initialized");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("c", a);
        assertEquals(a, instance.saveFromVariable("c"));
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable not correctly written.
     */
    @Test
    public void testSaveFromVariableNotCorrectlyWrittenVariable() {
        System.out.println("save from a variable not correctly written");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("8", a);
        assertEquals(null, instance.saveFromVariable("8"));
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable not correctly initialized.
     */
    @Test
    public void testSaveFromVariableNotInitializedVariable() {
        System.out.println("save from a variable not correctly initialized");
        Variables instance = new Variables();
        assertEquals(null, instance.saveFromVariable("c"));
    }
}
