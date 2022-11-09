Booking findBestBooking(Request request, Driver[] drivers) {
    Driver currentDriver = drivers[0];
    Booking finalBooking = new Booking(currentDriver, request);

	for (int i = 1; i < drivers.length; i++) {
        currentDriver = drivers[i];
        Booking currentBooking = new Booking(currentDriver, request);
        if (currentBooking.compareTo(finalBooking) < 0) {
        	finalBooking = currentBooking;
        }
	}
	return finalBooking;
}


