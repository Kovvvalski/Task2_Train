package out;

import entity.Train;

import java.util.List;

public class PrintTrains {
  public void printTrainSet(List<Train> trains) {
    for (Train train : trains) {
      System.out.println(train.toString());
    }
  }
}
