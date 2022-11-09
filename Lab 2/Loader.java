class Loader {
    private final int identifier;
    private final Cruise cruise;

    Loader(int identifier, Cruise cruise) {
        this.identifier = identifier;
        this.cruise = cruise;
    }

    int getIdentifier() {
        return this.identifier;
    }

    boolean canServe(Cruise anotherCruise) {
        return anotherCruise.getArrivalTime() >= this.getNextAvailableTime();
    }

    Loader serve(Cruise anotherCruise) {
        if (this.canServe(anotherCruise)) {
            return new Loader(this.getIdentifier(), anotherCruise);
        } else {
            return this;
        }
    }

    int getNextAvailableTime() {
        return this.cruise.getServiceCompletionTime();    
    }

    Cruise getCurrentCruise() {
        return this.cruise;
    }

    @Override
    public String toString() {
        return String.format("Loader %s serving ", identifier) + cruise;   
    }
}
