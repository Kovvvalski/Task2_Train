package creator;

import entity.Destination;
import entity.Train;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static main.Main.log;

public class TrainCreator {
  public ArrayList<Train> createTrainSet(String fromFile) {
    ArrayList<Train> out = new ArrayList<>();
    String[] rows = fromFile.split("\n");
    for (String row : rows) {
      String[] fields = row.split(" ");
      Destination destination;
      int number;
      int economy;
      int compartment;
      int lux;
      int year;
      int month;
      int day;
      int hour;
      int minute;
      try {
        destination = Destination.valueOf(fields[0]);
      } catch (IllegalArgumentException e) {
        log.log(Level.ERROR, "Cannot parse the destination: destination " + fields[0] + " is not defined");
        continue;
      }
      try {
        number = Integer.parseInt(fields[1]);
        economy = Integer.parseInt(fields[2]);
        compartment = Integer.parseInt(fields[3]);
        lux = Integer.parseInt(fields[4]);
        year = Integer.parseInt(fields[5]);
        month = Integer.parseInt(fields[6]);
        day = Integer.parseInt(fields[7]);
        hour = Integer.parseInt(fields[8]);
        minute = Integer.parseInt(String.valueOf(fields[9].charAt(0)) + String.valueOf(fields[9].charAt(1)));
      } catch (NumberFormatException e) {
        log.log(Level.ERROR, "Cannot parse the integer " + e.getMessage());
        continue;
      }

      Calendar departureTime = new GregorianCalendar(year, month, day, hour, minute);
      try {
        Train train = new Train(destination, number, economy, compartment, lux, departureTime);
        out.add(train);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return out;
  }
}
