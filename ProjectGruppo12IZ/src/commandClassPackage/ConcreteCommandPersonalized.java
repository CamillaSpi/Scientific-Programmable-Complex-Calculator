/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.List;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Mattia
 */
public class ConcreteCommandPersonalized implements Command {

    private final MyOperandCollection collector;
    private List<Command> commands;
    private final String commandName;

    public ConcreteCommandPersonalized(MyOperandCollection collector, List<Command> commands, String commandName) {
        assert collector != null;
        this.collector = collector;
        assert commands != null;
        this.commands = commands;
        this.commandName = commandName;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean contains(String name) {
        for (Command myCommand : commands) {
            if (myCommand instanceof ConcreteCommandPersonalized) {
                if (name.equals(((ConcreteCommandPersonalized) myCommand).commandName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
