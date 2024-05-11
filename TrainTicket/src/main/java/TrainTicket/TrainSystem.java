package TrainTicket;

import java.util.HashMap;
import java.util.Map;

public class TrainSystem {

    public static HashMap<Integer, Train> trainList;

    public TrainSystem() {
        trainList = new HashMap<>();
    }

    public static Train isValid(int trainNumber) {
        if (trainList.containsKey(trainNumber)) {
            return trainList.get(trainNumber);
        }
        return null;
    }

    public static void displayTrainList() {
        if (trainList.isEmpty()) {
            System.out.println("list is empty");
        } else {
            for (Map.Entry<Integer, Train> m : trainList.entrySet()) {
                m.getValue().displayTrain();
            }
        }
    }
}
