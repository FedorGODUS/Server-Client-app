package lab.Commands.ConcreteCommands;


import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;

public class CountGreaterThanNumberOfParticipants extends Command {
    private static final long serialVersionUID = 33L;
    transient private CommandReceiver commandReceiver;

    public CountGreaterThanNumberOfParticipants (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public CountGreaterThanNumberOfParticipants() {}

    @Override
    protected Message execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде count_greater_than_number_of_participants.");
        }
        return commandReceiver.countGreaterThanNumberOfParticipants(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда count_greater_than_number_of_participants. Синтаксис: count_greater_than_number_of_participants – выводит количество элементов, значение поля numberOfParticipants которых больше заданного.");
    }
}
