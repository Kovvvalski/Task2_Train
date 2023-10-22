package main;

import creator.TrainCreator;
import entity.Destination;
import entity.Train;
import exception.ReadFromFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import out.PrintTrains;
import reader.ReaderFromFile;
import service.TrainService;
import service.impl.TrainServiceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
  public static final Logger log = LogManager.getLogger();

  public static void main(String[] args) {
    log.log(Level.INFO,"Application started");
    Calendar current = new GregorianCalendar(2023, Calendar.OCTOBER, 18, 12, 13);
    PrintTrains printer = new PrintTrains();
    TrainService service = new TrainServiceImpl();
    List<Train> trains = null;
    try {
      TrainCreator trainCreator = new TrainCreator();
      ReaderFromFile reader = new ReaderFromFile();
      trains = trainCreator.createTrainSet((reader.readFromFile("C:/Users/Acer/Desktop/ITA/projects/Train/input/input.txt", StandardCharsets.UTF_8)));
    } catch (ReadFromFileException e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println("Input data");
    printer.printTrainSet(trains);
    System.out.println("Trains following to ORSHA");
    printer.printTrainSet(service.findByDestination(trains, Destination.ORSHA));
    System.out.println("Trains following to Minsk after " + current.getTime());
    printer.printTrainSet(service.findByDestinationAndDepartureHour(trains, Destination.MINSK, current));
    System.out.println("Trains following to HOMEL with places presence");
    printer.printTrainSet(service.findByDestinationAndAllPlacesPresence(trains, Destination.HOMEL));

  }
}
