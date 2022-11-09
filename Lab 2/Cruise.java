class Cruise {
    private final String identifier;
    private final int arrivalTime;
    private final int numOfLoader;
    private final int serviceTime;
    private static final int minsPerHour = 60;
    private static final int divisionHelper = 100;

    Cruise(String identifier, int arrivalTime, int numOfLoader, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.numOfLoader = numOfLoader;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return identifier + String.format("@%04d", arrivalTime);
    }

    int getArrivalTime() {
        int hour = this.arrivalTime / divisionHelper;
        int min = this.arrivalTime % divisionHelper;
        return hour * minsPerHour + min;

    }

    int getNumOfLoadersRequired() {
        return this.numOfLoader;
    }

    int getServiceCompletionTime() {
        return this.getArrivalTime() + this.serviceTime;
    }
}
