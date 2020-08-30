package lab.Commands.ConcreteCommands;


import lab.BasicClasses.MusicBand;
import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;

/**
 * Конкретная команда удаления объектов, меньше заданного.
 */
public class Head extends Command {
    private static final long serialVersionUID = 33L;

    @Override
    public String execute(Object argObject) throws IOException {
        CommandReceiver commandReceiver = new CommandReceiver();
        return commandReceiver.head();
    }
}
