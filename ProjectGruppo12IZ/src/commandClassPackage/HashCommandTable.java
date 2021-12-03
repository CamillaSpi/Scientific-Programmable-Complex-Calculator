/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class HashCommandTable{
    
    private final HashMap<String,ConcreteCommandPersonalized> concreteCommandHash;
    private final HashMap<String,String> basicCommandHash;
    private MyOperandCollection collector;

    public HashCommandTable(MyOperandCollection collector) {
        this.concreteCommandHash = new HashMap<>();
        this.basicCommandHash = new HashMap<>();
        basicCommandHash.put("+", "AddCommand");
        basicCommandHash.put("-", "SubtractCommand");
        basicCommandHash.put("*", "MultiplyCommand");
        basicCommandHash.put("/", "DivideCommand");
        basicCommandHash.put("sqrt", "SquareRootCommand");
        basicCommandHash.put("+-", "InvertSignCommand");
        basicCommandHash.put("drop", "DropCommand");
        basicCommandHash.put("dup", "DupCommand");
        basicCommandHash.put("swap", "SwapCommand");
        basicCommandHash.put("over", "OverCommand");
        basicCommandHash.put("clear", "ClearCommand");
        this.collector = collector;
    }
    
    public void setCollector(MyOperandCollection collector){
        this.collector = collector;
    }
    
    /**
     * It create a personalized Command starting from the string passed as the sequence of operations composing the definition.
     * The ConcreteCommandPersonalized Object is than added to the concreteCommandHash with the name passed.
     * If the passed name corresponding to an already existing user defined operation, the corresponding command will be updated.
     * @param sequenceDefinition the string containing the operation's name, defining the new User defined operation.
     * @param operationName the name for the user defined operation.
     * @return true if the personalizedCommand is correctly created otherwise false.
     * @see MyOperandCollection, ConcreteCommandPersonalized
     */
    public boolean createPersonalizedCommand(String sequenceDefinition, String operationName) {
        //if the name passed is equal to that of a basic operation, the operation personalized cannot be created.
        if(basicCommandHash.containsKey(operationName))
            return false;
        //Starting from the string passed all the operation's name are identified
        String[] stringOfCommands = sequenceDefinition.split(" ");
        Class<?> operation;
        Constructor<?> commandConstructor;
        Command newCommand;
        List<Command> commandList = new LinkedList<Command>();
        for(String stringCommand: stringOfCommands){
            //check if the string is one corrisponding to the basic operation
            if(basicCommandHash.containsKey(stringCommand)){
                try {
                operation = Class.forName("commandClassPackage." + this.basicCommandHash.get(stringCommand));
                commandConstructor = operation.getConstructor(MyOperandCollection.class);
                //create a new command corresponding to the operation
                newCommand = (Command) commandConstructor.newInstance(collector);
                //add this new command to the list of command
                commandList.add(newCommand);
                }catch (Exception ex){
                    return false;
                }
            }
            //check if the string is one corresponding to the user defined operation
            else if(concreteCommandHash.containsKey(stringCommand)){
                //add this command to the list of command
                commandList.add(concreteCommandHash.get(stringCommand));
            }
            else 
                return false;
        }
        //starting from the list creadet, create a new commandPersonalized object
        ConcreteCommandPersonalized personalizedCommand = new ConcreteCommandPersonalized(operationName,commandList);
        //add this new personalizedCommand to the hashMap containing all the user defined command
        concreteCommandHash.put(operationName, personalizedCommand);
        return true;
    }
    /**
    * It delete a personalized Command starting from the name.If the remove operation
    * return null, the elements is not contained in the hashmap, then false was returned, otherwise
    * the personalized command exists.Now we check if this command is inserted in other personalized commands
    * and if yes the personalized command is removed.
    * 
     * @param name
     * @return If the elements doesn't exist then false was returned otherwise true. 
    */
    public boolean delete(String name){
        if (name == null )
            return false;
        ConcreteCommandPersonalized toDelete = (ConcreteCommandPersonalized) concreteCommandHash.remove(name);
        if(toDelete == null)
            return false;
        // If i'm there the ConcreteCommandPersonalized exists, so maybe its was inserted in other list
        for(Map.Entry<String, ConcreteCommandPersonalized> maybeToDelete : concreteCommandHash.entrySet() ){
            if(maybeToDelete.getValue().contains(name)){
                concreteCommandHash.remove(maybeToDelete.getKey());
            }
        }
        return true;
    }
    
    /**
     * it returns the user defined command corresponding to the name passed, if it exists, otehrwise null
     * @param commandName the name of which obtain the corresponding user defined command.
     * @return the command if exists otherwise null.
     * @see ConcreteCommandPersonalized
     */
    public Command getUserCommand(String commandName){
        if(concreteCommandHash.containsKey(commandName))
            return concreteCommandHash.get(commandName);
        else 
            return null;
    }
    
}
