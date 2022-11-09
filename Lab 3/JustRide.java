class JustRide { 
    private final int pricePerKM = 22;
    private final int surcharge = 500;

    public int computeFare(Request request) {
        int fare;
        int time = request.getTime();
        if (time >= 600 && time <= 900) {
            fare = request.getDistance() * pricePerKM + surcharge;
        } else {
            fare = request.getDistance() * pricePerKM;
        }
        return fare;
    }

    @Override
    public String toString() {
    	return "JustRide";
    }
}
