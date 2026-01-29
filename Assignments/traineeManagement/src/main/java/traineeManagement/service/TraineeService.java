package traineeManagement.service;
import traineeManagement.dao.TraineeDao;
import traineeManagement.dto.Trainee;



public class TraineeService {

    private TraineeDao traineeDao;

    public TraineeService(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }
    
    public void addTrainee(Trainee trainee) {
        if (trainee.getPercentage() < 0) {
            throw new IllegalArgumentException("Percanetage cannot be negative");
        }
        traineeDao.addTrainee(trainee);
        System.out.println("Trainee added successfully");
    }


    public Trainee findTraineeById(int traineeId) {
        if (traineeId <= 0) {
            throw new IllegalArgumentException("Invalid Trainee ID");
        }
        return traineeDao.findTraineeById(traineeId);
    }


}
