class TakeACab {
    private final int pricePerKM = 33;
    private final int bookingFee = 200;

    public int computeFare(Request request) {
        return pricePerKM * request.getDistance() + bookingFee;
    }

    @Override
    public String toString() {
    	return "TakeACab";
    }
}
