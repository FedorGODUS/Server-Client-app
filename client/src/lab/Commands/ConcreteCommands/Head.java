package lab.Commands.ConcreteCommands;


import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;


public class Head extends Command {
    private static final long serialVersionUID = 33L;
     transient private CommandReceiver commandReceiver;

    public Head(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public Head() {}

    @Override
    protected Message execute(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде head.");
        }
        return commandReceiver.head();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда head – показать верхний элемент из коллекции");
    }
}
