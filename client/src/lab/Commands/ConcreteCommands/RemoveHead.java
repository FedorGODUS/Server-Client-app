package lab.Commands.ConcreteCommands;

import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;


public class RemoveHead extends Command {
    private static final long serialVersionUID = 33L;
    transient private CommandReceiver commandReceiver;

    public RemoveHead (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public RemoveHead() {}

    @Override
    protected Message execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 0 && args.length<2){
            return commandReceiver.removeHead();
        }
        else { System.out.println("Некорректное количество аргументов. Для справки напишите help."); }
        return null;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_head - удаляет верхний элемент в коллекции. ");
    }
}
