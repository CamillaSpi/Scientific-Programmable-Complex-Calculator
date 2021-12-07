/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;

/**
 *
 * @author Gruppo12
 */
public class SubtractToVariableCommand implements Command{

    private MyOperandCollection collector;
    private Variables vars;
    private String variables;
    private ComplexNumber oldValueVar;
    private ComplexNumber OperandFromStack;

    /**
     * This method creates an object that represents subtract to variable operation in order to execute and undo the command,
     * assert if collection is null or if vars is null or if variables is null
     * <p> <!-- -->
     * @param collector is the collection were subtracting is taken
     * @param vars is the collection were minuend is taken
     * @param variables is the var were execute the operation
     * @see MyOperandCollection
     */
    public SubtractToVariableCommand(MyOperandCollection collector, Variables vars, String variables) {
        assert collector != null;
        this.collector = collector;
        assert vars != null;
        this.vars = vars;
        assert variables != null;
        this.variables = variables;
        
        
    }
    
    /**
     * This method implements execute method for subtract to variable operation from Command interface
     * @return 
     */
    @Override
    public boolean execute() {
        ComplexNumber value = collector.last();
        if(value == null)
            return false;
        this.OperandFromStack = value;
        
        collector.remove();
        this.oldValueVar = vars.getValue(this.variables);
        
        return vars.subtractToVariable(this.variables, this.OperandFromStack);
        
    }

    /**
     * This method implements undo method for subtract to variable operation from Command interface
     */
    @Override
    public void undo() {
        vars.saveToVariable(this.variables, this.oldValueVar);
        collector.insert(this.OperandFromStack);
        
    }
    
}