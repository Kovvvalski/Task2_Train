package service;

import entity.Destination;
import entity.Train;

import java.util.Calendar;
import java.util.List;

public interface TrainService {
  List<Train> findByDestination(List<Train>trains, Destination destination);
  List<Train> findByDestinationAndDepartureHour(List<Train>trains, Destination destination, Calendar departureTime);
  List<Train> findByDestinationAndAllPlacesPresence(List<Train> trains, Destination destination);
}
