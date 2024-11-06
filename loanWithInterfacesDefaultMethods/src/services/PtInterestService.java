package services;

public class PtInterestService implements InterestService {

    private double interestRate;

    public PtInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
