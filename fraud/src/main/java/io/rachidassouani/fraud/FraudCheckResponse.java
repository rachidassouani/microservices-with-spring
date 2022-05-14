package io.rachidassouani.fraud;

public class FraudCheckResponse {

    private boolean isFraudster;

    public FraudCheckResponse() {
    }

    public FraudCheckResponse(boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public boolean isFraudster() {
        return isFraudster;
    }

    public void setFraudster(boolean fraudster) {
        isFraudster = fraudster;
    }
}
