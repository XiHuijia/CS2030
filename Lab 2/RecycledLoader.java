class RecycledLoader extends Loader {
    private static final int extraTime = 60;

    RecycledLoader(int identifier, Cruise cruise) {
        super(identifier, cruise);
    }

    @Override
    boolean canServe(Cruise anotherCruise) {
        return anotherCruise.getArrivalTime() >= this.getNextAvailableTime() + extraTime;
    }


    @Override
    RecycledLoader serve(Cruise anotherCruise) {
        if (this.canServe(anotherCruise)) {
            return new RecycledLoader(this.getIdentifier(), anotherCruise);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return String.format("Recycled Loader %s serving ", this.getIdentifier()) 
            + this.getCurrentCruise();   
    }

}
