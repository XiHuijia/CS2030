class Booking {
    private final Driver driver;
    private final Request request;
    private final int hundred = 100;
    private final int finalFare;
    private final String finalChoice;

    Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
        int fareJustRide = new JustRide().computeFare(request);
        if (driver instanceof NormalCab) {            
            int fareTakeACab = new TakeACab().computeFare(request);
        
            if (fareJustRide < fareTakeACab) {           
                finalFare = fareJustRide;
                finalChoice = "JustRide";
            } else {
                finalFare = fareTakeACab;
                finalChoice = "TakeACab";            
            }
        } else {
            int fareShareARide = new ShareARide().computeFare(request);
            if (fareJustRide < fareShareARide) {           
                finalFare = fareJustRide;
                finalChoice = "JustRide";
            } else {
                finalFare = fareShareARide;
                finalChoice = "ShareARide";            
            }
        } 
    }


    Driver getDriver() {
        return this.driver;
    }

    Request getRequest() {
        return this.request;
    }

    int getFare() {
        return this.finalFare;
    }

    int compareTo(Booking anotherBooking) {       
        if (this.finalFare == anotherBooking.finalFare) {
            if (this.getDriver().getWaitingTime() < anotherBooking.getDriver().getWaitingTime()) {
                    return -1;
                } else if (this.getDriver().getWaitingTime() > anotherBooking.getDriver().getWaitingTime()) {
                    return 1;
                } else {
                    return 0;
                }   
        } else if (this.finalFare > anotherBooking.finalFare) {
            return 1;
        } else {
            return -1;
        }         
    }

    

    @Override
    public String toString() {
        int dollar = finalFare / hundred;
        int cent = finalFare % hundred;
        return String.format("$%s.%s using %s (%s)", dollar, cent, driver, finalChoice);
    }
}
