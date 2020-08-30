package lab.Commands.ConcreteCommands;


import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;
import java.io.Serializable;


public class AddIfMax extends Command implements Serializable {
    private static final long serialVersionUID = 33L;
    transient private CommandReceiver commandReceiver;

    public AddIfMax() {}

    public AddIfMax (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected Message execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде info.");
        }
        return commandReceiver.addIfMax();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда add_if_max - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }
}
