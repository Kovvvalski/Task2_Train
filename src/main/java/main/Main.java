package main;

import creator.Creator;
import entity.Destination;
import entity.Train;
import exception.ReadFromFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import out.Out;
import reader.ReaderFromFile;
import service.TrainService;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        Calendar current = new GregorianCalendar(2023, Calendar.OCTOBER, 18, 12, 13);
        List<Train> trains = null;
        try {
            Creator creator = new Creator();
            ReaderFromFile reader = new ReaderFromFile();
            trains = creator.createTrainSet((reader.readFromFile("C:/Users/Acer/Desktop/ITA/projects/Train/input/input.txt", StandardCharsets.UTF_8)));
        } catch (ReadFromFileException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Input data");
        Out.printTrainSet(trains);
        System.out.println("Trains following to ORSHA");
        Out.printTrainSet(TrainService.findByDestination(trains, Destination.ORSHA));
        System.out.println("Trains following to Minsk after " + current.getTime());
        Out.printTrainSet(TrainService.findByDestinationAndDepartureHour(trains, Destination.MINSK, current));
        System.out.println("Trains following to HOMEL with places presence");
        Out.printTrainSet(TrainService.findByDestinationAndAllPlacesPresence(trains, Destination.HOMEL));

    }
}
