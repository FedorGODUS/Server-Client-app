package lab.Commands.Utils.Creaters;

import lab.BasicClasses.Coordinates;
import lab.BasicClasses.Label;
import lab.BasicClasses.MusicBand;
import lab.BasicClasses.MusicGenre;
import lab.Commands.Utils.Readers.EnumReaders.GenreReader;
import lab.Commands.Utils.Readers.PrimitiveAndReferenceReaders.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Класс содержащий методы для создания группы и человека.
 */
public class ElementCreator {

    public MusicBand createMusicBand() {
        String name = StringReader.read("Введите имя группы: ", false);
        long x = PrimitiveLongReader.read("Введите X: ", 0, "MIN");
        long y = PrimitiveLongReader.read("Введите Y: ", 0, "MIN");
        int numberOfParticipants = PrimitiveIntReader.read("Введите количество участников: ", 0, "MIN");
        String description = StringReader.read("Введите описание: ", false);
        MusicGenre genre = GenreReader.read("Введите жанр:", false);
        int albumCount= PrimitiveIntReader.read("Введите количество альбомов:",0,"MIN");

        //private String name; //Поле не может быть null, Строка не может быть пустой
        //private Coordinates coordinates; //Поле не может быть null
        //private double x; //Значение поля должно быть больше -687
        //private Float y; //Поле не может быть null
        ///private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        //private int numberOfParticipants; //Значение поля должно быть больше 0
        //private String description; //Поле не может быть null
        //private Date establishmentDate; //Поле может быть null
        //private MusicGenre genre; //Поле не может быть null
        //private Album bestAlbum; //Поле может быть null
        //private String name; //Поле не может быть null, Строка не может быть пустой
        //private int tracks; //Значение поля должно быть больше 0
        //private Integer length; //Поле не может быть null, Значение поля должно быть больше 0
        //private int sales; //Значение поля должно быть больше 0

        return new MusicBand(0L , name, new Coordinates(x, y), LocalDateTime.now(), numberOfParticipants, description, genre, createLabel(),albumCount);
    }

    public Label createLabel() {
        int sales = PrimitiveIntReader.read("Введите количество продаж: ", 0, "MIN");
        return new Label(sales);
    }

    public MusicBand createScriptMusicBand(ArrayList<String> parameters) {
        if (validateArrayMusicBand(parameters)) {
            return new MusicBand(0L,parameters.get(0),
                    new Coordinates(Long.parseLong(parameters.get(1)), Long.parseLong(parameters.get(2))),
                    LocalDateTime.now(),
                    Integer.parseInt(parameters.get(3)),
                    parameters.get(4),
                    Enum.valueOf(MusicGenre.class, parameters.get(5)),
                    new Label(Integer.parseInt(parameters.get(6))),
                    Integer.parseInt(parameters.get(7)));
        } else { System.out.println("Один из параметров не соответствует требованиям."); }

        return null;
    }

    public Label createScriptLabel(ArrayList<String> parameters) {
        if (validateArrayLabel(parameters)) {
            return new Label(Integer.parseInt(parameters.get(0)));
        } else { System.out.println("Один из параметров не соответствует требованиям."); }

        return null;
    }

    private boolean validateArrayMusicBand(ArrayList<String> parameters) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return (!parameters.get(0).isEmpty()
                    && Long.parseLong(parameters.get(1)) > 0
                    && Long.parseLong(parameters.get(2)) > 0
                    && Integer.parseInt(parameters.get(3)) > 0
                    && !parameters.get(4).isEmpty()
                    && GenreReader.checkExist(parameters.get(5))
                    && Integer.parseInt(parameters.get(6)) > 0
                    && Integer.parseInt(parameters.get(7)) > 0);
        } catch (NumberFormatException ex) { return false; }
    }

    private boolean validateArrayLabel(ArrayList<String> parameters) {
        try {
            return (Integer.parseInt(parameters.get(0)) > 0);

        } catch (NumberFormatException ex) { return false; }
    }
}
