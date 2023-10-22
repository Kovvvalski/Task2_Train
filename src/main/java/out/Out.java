package out;

import entity.Train;

import java.util.List;

public class Out {
    public static void printTrainSet(List<Train> trains){
        for(Train train : trains){
            System.out.println(train.toString());
        }
    }
}
