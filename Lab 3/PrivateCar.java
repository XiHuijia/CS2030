class PrivateCar extends Driver {
    PrivateCar(String license, int waitingTime) {
        super(license, waitingTime);
    }

    @Override
    public String toString() {
        return this.getLicense() + " (" + this.getWaitingTime() + " mins away) PrivateCar";
    }
}