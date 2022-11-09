class BigCruise extends Cruise {
    private static final int loaderPer40Meter = 40;
    private static final int servePassengers = 50;

    BigCruise(String identifier, int arrivalTime, int lengthOfCruise, int numOfPassengers) {
        super(identifier, 
            arrivalTime, 
            (int)Math.ceil((double)lengthOfCruise / loaderPer40Meter), 
            (int)Math.ceil((double)numOfPassengers / servePassengers));
    }

}



