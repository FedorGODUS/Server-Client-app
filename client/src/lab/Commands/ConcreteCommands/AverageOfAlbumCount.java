package lab.Commands.ConcreteCommands;


import lab.Commands.Command;
import lab.Commands.CommandReceiver;
import lab.Commands.SerializedCommands.Message;

import java.io.IOException;


public class AverageOfAlbumCount extends Command {
    private static final long serialVersionUID = 33L;
    transient private CommandReceiver commandReceiver;

    public AverageOfAlbumCount (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public AverageOfAlbumCount() {}

    @Override
    protected Message execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде average_of_album_count.");
        }
        return commandReceiver.averageOfAlbumCount();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда average_of_album_count – показать средний показатель album_count");
    }
}
