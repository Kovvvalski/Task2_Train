package service.impl;

import entity.Destination;
import entity.Train;
import service.TrainService;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class TrainServiceImpl implements TrainService {
  public List<Train> findByDestination(List<Train> trains, Destination destination) {
    List<Train> found = new ArrayList<>();
    for (Train train : trains) {
      if (train.getDestination().equals(destination)) {
        found.add(train);
      }
    }
    return found;
  }

  public List<Train> findByDestinationAndDepartureHour(List<Train> trains, Destination destination, Calendar departureTime) {
    List<Train> found = new ArrayList<>();
    for (Train train : trains) {
      if (destination == train.getDestination() && departureTime.before(train.getCalendar())) {
        found.add(train);
      }
    }
    return found;
  }

  public List<Train> findByDestinationAndAllPlacesPresence(List<Train> trains, Destination destination) {
    List<Train> found = new ArrayList<>();
    for (Train train : trains) {
      if (train.getDestination().equals(destination) && train.getAllPlaces() != 0) {
        found.add(train);
      }
    }
    return found;
  }
}
