class ShareARide {
	private final int pricePerKM = 50;
	private final int surcharge = 500;

	public int computeFare(Request request) {
        int fare;
        int time = request.getTime();
        int pax = request.getPax();
        if (time >= 600 && time <= 900) {
            fare = (int)(request.getDistance() * pricePerKM + surcharge)/pax;
        } else {
            fare = (int)request.getDistance() * pricePerKM/pax;
        }
        return fare;
    }

    @Override
    public String toString() {
    	return "ShareARide";
    }
}